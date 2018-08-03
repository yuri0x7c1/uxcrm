package org.apache.ofbiz.product.config.service.base;

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
import org.apache.ofbiz.product.config.ProdConfItemContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.config.ProductConfigItem;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.product.config.ProdConfItemContentType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProdConfItemContentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProdConfItemContentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProdConfItemContents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProdConfItemContent.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProdConfItemContents
	 */
	public List<ProdConfItemContent> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProdConfItemContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdConfItemContent.NAME);
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
				entityList = ProdConfItemContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProdConfItemContent
	 */
	public Optional<ProdConfItemContent> findOne(Object configItemId,
			Object contentId, Object confItemContentTypeId, Object fromDate) {
		List<ProdConfItemContent> entityList = null;
		In in = new In();
		in.setEntityName(ProdConfItemContent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configItemId), new EntityExpr("contentId",
						EntityOperator.EQUALS, contentId), new EntityExpr(
						"confItemContentTypeId", EntityOperator.EQUALS,
						confItemContentTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdConfItemContent.fromValues(out.getListIt()
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
	 * Get product config item
	 */
	public Optional<ProductConfigItem> getProductConfigItem(
			ProdConfItemContent prodConfItemContent) {
		List<ProductConfigItem> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						prodConfItemContent.getConfigItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigItem.fromValues(out.getListIt()
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
	 * Get content
	 */
	public Optional<Content> getContent(ProdConfItemContent prodConfItemContent) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						prodConfItemContent.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt()
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
	 * Get prod conf item content type
	 */
	public Optional<ProdConfItemContentType> getProdConfItemContentType(
			ProdConfItemContent prodConfItemContent) {
		List<ProdConfItemContentType> entityList = null;
		In in = new In();
		in.setEntityName(ProdConfItemContentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("confItemContentTypeId",
						EntityOperator.EQUALS, prodConfItemContent
								.getConfItemContentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdConfItemContentType.fromValues(out.getListIt()
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