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
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaintMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.apache.ofbiz.product.product.ProductMeterType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FixedAssetMaintMeterBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FixedAssetMaintMeterBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FixedAssetMaintMeters
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FixedAssetMaintMeter.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FixedAssetMaintMeters
	 */
	public List<FixedAssetMaintMeter> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FixedAssetMaintMeter> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaintMeter.NAME);
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
				entityList = FixedAssetMaintMeter.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FixedAssetMaintMeter
	 */
	public Optional<FixedAssetMaintMeter> findOne(Object fixedAssetId,
			Object maintHistSeqId, Object productMeterTypeId) {
		List<FixedAssetMaintMeter> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaintMeter.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetId), new EntityExpr("maintHistSeqId",
						EntityOperator.EQUALS, maintHistSeqId), new EntityExpr(
						"productMeterTypeId", EntityOperator.EQUALS,
						productMeterTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaintMeter.fromValues(out.getListIt()
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
			FixedAssetMaintMeter fixedAssetMaintMeter) {
		List<FixedAssetMaint> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaintMeter.getFixedAssetId()),
				new EntityExpr("maintHistSeqId", EntityOperator.EQUALS,
						fixedAssetMaintMeter.getMaintHistSeqId())),
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
			FixedAssetMaintMeter fixedAssetMaintMeter) {
		List<ProductMeterType> entityList = null;
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, fixedAssetMaintMeter
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