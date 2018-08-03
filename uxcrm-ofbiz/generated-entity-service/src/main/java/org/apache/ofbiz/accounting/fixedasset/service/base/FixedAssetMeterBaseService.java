package org.apache.ofbiz.accounting.fixedasset.service.base;

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
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.apache.ofbiz.product.product.ProductMeterType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FixedAssetMeterBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FixedAssetMeterBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FixedAssetMeters
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FixedAssetMeter.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FixedAssetMeters
	 */
	public List<FixedAssetMeter> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FixedAssetMeter> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMeter.NAME);
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
				entityList = FixedAssetMeter.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FixedAssetMeter
	 */
	public Optional<FixedAssetMeter> findOne(Object fixedAssetId,
			Object productMeterTypeId, Object readingDate) {
		List<FixedAssetMeter> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMeter.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetId), new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, productMeterTypeId),
				new EntityExpr("readingDate", EntityOperator.EQUALS,
						readingDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMeter.fromValues(out.getListIt()
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
	 * Get fixed asset maint
	 */
	public Optional<FixedAssetMaint> getFixedAssetMaint(
			FixedAssetMeter fixedAssetMeter) {
		List<FixedAssetMaint> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMeter.getFixedAssetId()), new EntityExpr(
						"maintHistSeqId", EntityOperator.EQUALS,
						fixedAssetMeter.getMaintHistSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaint.fromValues(out.getListIt()
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
	 * Get product meter type
	 */
	public Optional<ProductMeterType> getProductMeterType(
			FixedAssetMeter fixedAssetMeter) {
		List<ProductMeterType> entityList = null;
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, fixedAssetMeter
								.getProductMeterTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMeterType.fromValues(out.getListIt()
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