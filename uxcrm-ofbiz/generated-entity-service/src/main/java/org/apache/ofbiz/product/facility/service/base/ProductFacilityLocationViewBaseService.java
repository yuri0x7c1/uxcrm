package org.apache.ofbiz.product.facility.service.base;

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
import org.apache.ofbiz.product.facility.ProductFacilityLocationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.product.facility.ProductFacilityLocation;
import org.apache.ofbiz.product.inventory.InventoryItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFacilityLocationViewBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFacilityLocationViewBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFacilityLocationViews
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFacilityLocationView.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFacilityLocationViews
	 */
	public List<ProductFacilityLocationView> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ProductFacilityLocationView> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFacilityLocationView.NAME);
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
				entityList = ProductFacilityLocationView.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFacilityLocationView
	 */
	public Optional<ProductFacilityLocationView> findOne(Object facilityId,
			Object productId, Object locationSeqId) {
		List<ProductFacilityLocationView> entityList = null;
		In in = new In();
		in.setEntityName(ProductFacilityLocationView.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("facilityId",
						EntityOperator.EQUALS, facilityId), new EntityExpr(
						"productId", EntityOperator.EQUALS, productId),
						new EntityExpr("locationSeqId", EntityOperator.EQUALS,
								locationSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFacilityLocationView.fromValues(out
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

	/**
	 * Get facility location
	 */
	public Optional<FacilityLocation> getFacilityLocation(
			ProductFacilityLocationView productFacilityLocationView) {
		List<FacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						productFacilityLocationView.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						productFacilityLocationView.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocation.fromValues(out.getListIt()
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
	 * Get product facility location
	 */
	public Optional<ProductFacilityLocation> getProductFacilityLocation(
			ProductFacilityLocationView productFacilityLocationView) {
		List<ProductFacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(ProductFacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS,
						productFacilityLocationView.getProductId()),
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						productFacilityLocationView.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						productFacilityLocationView.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFacilityLocation.fromValues(out.getListIt()
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
	 * Get inventory items
	 */
	public List<InventoryItem> getInventoryItems(
			ProductFacilityLocationView productFacilityLocationView,
			Integer start, Integer number, List<String> orderBy) {
		List<InventoryItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS,
						productFacilityLocationView.getProductId()),
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						productFacilityLocationView.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						productFacilityLocationView.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}