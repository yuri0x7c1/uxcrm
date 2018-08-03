package org.apache.ofbiz.product.product.service.base;

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
import org.apache.ofbiz.product.product.ProductVirtualAndVariantInfo;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductVirtualAndVariantInfoBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductVirtualAndVariantInfoBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductVirtualAndVariantInfoes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductVirtualAndVariantInfo.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductVirtualAndVariantInfoes
	 */
	public List<ProductVirtualAndVariantInfo> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ProductVirtualAndVariantInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductVirtualAndVariantInfo.NAME);
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
				entityList = ProductVirtualAndVariantInfo.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductVirtualAndVariantInfo
	 */
	public Optional<ProductVirtualAndVariantInfo> findOne(Object productId,
			Object productAssocTypeId, Object fromDate,
			Object variantProductId, Object variantFeatureApplFromDate,
			Object productFeatureId, Object variantPriceTypeId,
			Object variantCurrencyUomId, Object variantProductStoreGroupId,
			Object variantPriceFromDate) {
		List<ProductVirtualAndVariantInfo> entityList = null;
		In in = new In();
		in.setEntityName(ProductVirtualAndVariantInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("productAssocTypeId", EntityOperator.EQUALS,
						productAssocTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"variantProductId", EntityOperator.EQUALS,
						variantProductId), new EntityExpr(
						"variantFeatureApplFromDate", EntityOperator.EQUALS,
						variantFeatureApplFromDate), new EntityExpr(
						"productFeatureId", EntityOperator.EQUALS,
						productFeatureId), new EntityExpr("variantPriceTypeId",
						EntityOperator.EQUALS, variantPriceTypeId),
				new EntityExpr("variantCurrencyUomId", EntityOperator.EQUALS,
						variantCurrencyUomId), new EntityExpr(
						"variantProductStoreGroupId", EntityOperator.EQUALS,
						variantProductStoreGroupId), new EntityExpr(
						"variantPriceFromDate", EntityOperator.EQUALS,
						variantPriceFromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductVirtualAndVariantInfo.fromValues(out
						.getListIt().getCompleteList());
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