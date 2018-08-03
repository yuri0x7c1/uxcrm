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
import org.apache.ofbiz.order.shoppinglist.ShoppingListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.shoppinglist.ShoppingList;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.order.shoppinglist.ShoppingListItemSurvey;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShoppingListItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShoppingListItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShoppingListItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShoppingListItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShoppingListItems
	 */
	public List<ShoppingListItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShoppingListItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingListItem.NAME);
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
				entityList = ShoppingListItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShoppingListItem
	 */
	public Optional<ShoppingListItem> findOne(Object shoppingListId,
			Object shoppingListItemSeqId) {
		List<ShoppingListItem> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingListItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListId), new EntityExpr(
						"shoppingListItemSeqId", EntityOperator.EQUALS,
						shoppingListItemSeqId)), EntityOperator.AND));
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
	 * Get shopping list
	 */
	public Optional<ShoppingList> getShoppingList(
			ShoppingListItem shoppingListItem) {
		List<ShoppingList> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListItem.getShoppingListId())),
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
	 * Get product
	 */
	public Optional<Product> getProduct(ShoppingListItem shoppingListItem) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						shoppingListItem.getProductId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
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
	 * Get shopping list item surveys
	 */
	public List<ShoppingListItemSurvey> getShoppingListItemSurveys(
			ShoppingListItem shoppingListItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListItem.getShoppingListId()), new EntityExpr(
						"shoppingListItemSeqId", EntityOperator.EQUALS,
						shoppingListItem.getShoppingListItemSeqId())),
				EntityOperator.AND));
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
}