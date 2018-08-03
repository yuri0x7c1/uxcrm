package org.apache.ofbiz.order.shoppinglist.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.order.shoppinglist.ShoppingListItemSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.shoppinglist.ShoppingList;
import org.apache.ofbiz.order.shoppinglist.ShoppingListItem;
import org.apache.ofbiz.content.survey.SurveyResponse;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShoppingListItemSurveyBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShoppingListItemSurveyBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShoppingListItemSurveys
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShoppingListItemSurvey.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShoppingListItemSurveys
	 */
	public List<ShoppingListItemSurvey> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShoppingListItemSurvey> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingListItemSurvey.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListItemSurvey.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShoppingListItemSurvey
	 */
	public Optional<ShoppingListItemSurvey> findOne(Object shoppingListId,
			Object shoppingListItemSeqId, Object surveyResponseId) {
		List<ShoppingListItemSurvey> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingListItemSurvey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListId), new EntityExpr(
						"shoppingListItemSeqId", EntityOperator.EQUALS,
						shoppingListItemSeqId), new EntityExpr(
						"surveyResponseId", EntityOperator.EQUALS,
						surveyResponseId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListItemSurvey.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get shopping list
	 */
	public Optional<ShoppingList> getShoppingList(
			ShoppingListItemSurvey shoppingListItemSurvey) {
		List<ShoppingList> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListItemSurvey.getShoppingListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get shopping list item
	 */
	public Optional<ShoppingListItem> getShoppingListItem(
			ShoppingListItemSurvey shoppingListItemSurvey) {
		List<ShoppingListItem> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingListItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListItemSurvey.getShoppingListId()),
				new EntityExpr("shoppingListItemSeqId", EntityOperator.EQUALS,
						shoppingListItemSurvey.getShoppingListItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListItem.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get survey response
	 */
	public Optional<SurveyResponse> getSurveyResponse(
			ShoppingListItemSurvey shoppingListItemSurvey) {
		List<SurveyResponse> entityList = null;
		In in = new In();
		in.setEntityName(SurveyResponse.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyResponseId",
						EntityOperator.EQUALS, shoppingListItemSurvey
								.getSurveyResponseId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponse.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}
}