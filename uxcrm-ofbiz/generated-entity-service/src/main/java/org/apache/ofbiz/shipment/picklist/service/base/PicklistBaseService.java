package org.apache.ofbiz.shipment.picklist.service.base;

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
import org.apache.ofbiz.shipment.picklist.Picklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.shipment.shipment.ShipmentMethodType;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.common.status.StatusValidChangeToDetail;
import org.apache.ofbiz.shipment.picklist.PicklistBin;
import org.apache.ofbiz.shipment.picklist.PicklistRole;
import org.apache.ofbiz.shipment.picklist.PicklistStatusHistory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PicklistBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PicklistBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Picklists
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Picklist.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Picklists
	 */
	public List<Picklist> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Picklist> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Picklist.NAME);
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
				entityList = Picklist.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Picklist
	 */
	public Optional<Picklist> findOne(Object picklistId) {
		List<Picklist> entityList = null;
		In in = new In();
		in.setEntityName(Picklist.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("picklistId", EntityOperator.EQUALS,
						picklistId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Picklist.fromValues(out.getListIt()
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
	 * Get facility
	 */
	public Optional<Facility> getFacility(Picklist picklist) {
		List<Facility> entityList = null;
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						picklist.getFacilityId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
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
	 * Get shipment method type
	 */
	public Optional<ShipmentMethodType> getShipmentMethodType(Picklist picklist) {
		List<ShipmentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentMethodTypeId",
						EntityOperator.EQUALS, picklist
								.getShipmentMethodTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentMethodType.fromValues(out.getListIt()
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(Picklist picklist) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						picklist.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get status valid change to details
	 */
	public List<StatusValidChangeToDetail> getStatusValidChangeToDetails(
			Picklist picklist, Integer start, Integer number,
			List<String> orderBy) {
		List<StatusValidChangeToDetail> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(StatusValidChangeToDetail.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						picklist.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusValidChangeToDetail.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get picklist bins
	 */
	public List<PicklistBin> getPicklistBins(Picklist picklist, Integer start,
			Integer number, List<String> orderBy) {
		List<PicklistBin> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistBin.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("picklistId", EntityOperator.EQUALS,
						picklist.getPicklistId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistBin.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get picklist roles
	 */
	public List<PicklistRole> getPicklistRoles(Picklist picklist,
			Integer start, Integer number, List<String> orderBy) {
		List<PicklistRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("picklistId", EntityOperator.EQUALS,
						picklist.getPicklistId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get picklist status histories
	 */
	public List<PicklistStatusHistory> getPicklistStatusHistories(
			Picklist picklist, Integer start, Integer number,
			List<String> orderBy) {
		List<PicklistStatusHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistStatusHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("picklistId", EntityOperator.EQUALS,
						picklist.getPicklistId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistStatusHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}