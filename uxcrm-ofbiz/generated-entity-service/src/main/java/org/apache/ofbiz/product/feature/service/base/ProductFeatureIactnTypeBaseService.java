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
import org.apache.ofbiz.product.feature.ProductFeatureIactnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.feature.ProductFeatureIactn;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureIactnTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureIactnTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureIactnTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureIactnType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureIactnTypes
	 */
	public List<ProductFeatureIactnType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductFeatureIactnType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureIactnType.NAME);
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
				entityList = ProductFeatureIactnType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFeatureIactnType
	 */
	public Optional<ProductFeatureIactnType> findOne(
			Object productFeatureIactnTypeId) {
		List<ProductFeatureIactnType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureIactnType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureIactnTypeId",
						EntityOperator.EQUALS, productFeatureIactnTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureIactnType.fromValues(out.getListIt()
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
	 * Get parent product feature iactn type
	 */
	public Optional<ProductFeatureIactnType> getParentProductFeatureIactnType(
			ProductFeatureIactnType productFeatureIactnType) {
		List<ProductFeatureIactnType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureIactnType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureIactnTypeId",
						EntityOperator.EQUALS, productFeatureIactnType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureIactnType.fromValues(out.getListIt()
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
	 * Get product feature iactns
	 */
	public List<ProductFeatureIactn> getProductFeatureIactns(
			ProductFeatureIactnType productFeatureIactnType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeatureIactn> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureIactn.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureIactnTypeId",
						EntityOperator.EQUALS, productFeatureIactnType
								.getProductFeatureIactnTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureIactn.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child product feature iactn types
	 */
	public List<ProductFeatureIactnType> getChildProductFeatureIactnTypes(
			ProductFeatureIactnType productFeatureIactnType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeatureIactnType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureIactnType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("parentTypeId",
						EntityOperator.EQUALS, productFeatureIactnType
								.getProductFeatureIactnTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureIactnType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}