package org.apache.ofbiz.product.feature.service.base;

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
import org.apache.ofbiz.product.feature.ProductFeatureApplType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.feature.ProductFeatureAppl;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureApplTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureApplTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureApplTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureApplTypes
	 */
	public List<ProductFeatureApplType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductFeatureApplType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
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
				entityList = ProductFeatureApplType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFeatureApplType
	 */
	public Optional<ProductFeatureApplType> findOne(
			Object productFeatureApplTypeId) {
		List<ProductFeatureApplType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureApplTypeId",
						EntityOperator.EQUALS, productFeatureApplTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureApplType.fromValues(out.getListIt()
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
	 * Get parent product feature appl type
	 */
	public Optional<ProductFeatureApplType> getParentProductFeatureApplType(
			ProductFeatureApplType productFeatureApplType) {
		List<ProductFeatureApplType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureApplTypeId",
						EntityOperator.EQUALS, productFeatureApplType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureApplType.fromValues(out.getListIt()
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
	 * Get product feature appls
	 */
	public List<ProductFeatureAppl> getProductFeatureAppls(
			ProductFeatureApplType productFeatureApplType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeatureAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureApplTypeId",
						EntityOperator.EQUALS, productFeatureApplType
								.getProductFeatureApplTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child product feature appl types
	 */
	public List<ProductFeatureApplType> getChildProductFeatureApplTypes(
			ProductFeatureApplType productFeatureApplType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeatureApplType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						productFeatureApplType.getProductFeatureApplTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureApplType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}