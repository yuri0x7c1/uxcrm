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
import org.apache.ofbiz.product.product.ProductMeterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaintMeter;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMeter;
import org.apache.ofbiz.product.product.ProductMaint;
import org.apache.ofbiz.product.product.ProductMeter;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductMeterTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductMeterTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductMeterTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductMeterTypes
	 */
	public List<ProductMeterType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductMeterType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
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
				entityList = ProductMeterType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductMeterType
	 */
	public Optional<ProductMeterType> findOne(Object productMeterTypeId) {
		List<ProductMeterType> entityList = null;
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, productMeterTypeId)),
				EntityOperator.AND));
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

	/**
	 * Get default uom
	 */
	public Optional<Uom> getDefaultUom(ProductMeterType productMeterType) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						productMeterType.getDefaultUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get interval fixed asset maints
	 */
	public List<FixedAssetMaint> getIntervalFixedAssetMaints(
			ProductMeterType productMeterType, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetMaint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("intervalMeterTypeId",
						EntityOperator.EQUALS, productMeterType
								.getProductMeterTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset maint meters
	 */
	public List<FixedAssetMaintMeter> getFixedAssetMaintMeters(
			ProductMeterType productMeterType, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, productMeterType
								.getProductMeterTypeId())), EntityOperator.AND));
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
	 * Get fixed asset meters
	 */
	public List<FixedAssetMeter> getFixedAssetMeters(
			ProductMeterType productMeterType, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, productMeterType
								.getProductMeterTypeId())), EntityOperator.AND));
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
	 * Get interval product maints
	 */
	public List<ProductMaint> getIntervalProductMaints(
			ProductMeterType productMeterType, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductMaint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductMaint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("intervalMeterTypeId",
						EntityOperator.EQUALS, productMeterType
								.getProductMeterTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMaint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product meters
	 */
	public List<ProductMeter> getProductMeters(
			ProductMeterType productMeterType, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductMeter> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductMeter.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, productMeterType
								.getProductMeterTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMeter.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}