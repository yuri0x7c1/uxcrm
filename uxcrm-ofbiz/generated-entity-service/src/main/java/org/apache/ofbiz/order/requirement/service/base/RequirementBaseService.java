package org.apache.ofbiz.order.requirement.service.base;

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
import org.apache.ofbiz.order.requirement.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.requirement.RequirementType;
import org.apache.ofbiz.order.requirement.RequirementTypeAttr;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.workeffort.workeffort.Deliverable;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.order.requirement.DesiredFeature;
import org.apache.ofbiz.order.requirement.OrderRequirementCommitment;
import org.apache.ofbiz.order.requirement.RequirementAttribute;
import org.apache.ofbiz.order.requirement.RequirementBudgetAllocation;
import org.apache.ofbiz.order.requirement.RequirementCustRequest;
import org.apache.ofbiz.order.requirement.RequirementRole;
import org.apache.ofbiz.order.requirement.RequirementStatus;
import org.apache.ofbiz.order.requirement.WorkRequirementFulfillment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RequirementBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RequirementBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Requirements
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Requirement.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Requirements
	 */
	public List<Requirement> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Requirement> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Requirement.NAME);
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
				entityList = Requirement.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Requirement
	 */
	public Optional<Requirement> findOne(Object requirementId) {
		List<Requirement> entityList = null;
		In in = new In();
		in.setEntityName(Requirement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Requirement.fromValues(out.getListIt()
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
	 * Get requirement type
	 */
	public Optional<RequirementType> getRequirementType(Requirement requirement) {
		List<RequirementType> entityList = null;
		In in = new In();
		in.setEntityName(RequirementType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementTypeId",
						EntityOperator.EQUALS, requirement
								.getRequirementTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementType.fromValues(out.getListIt()
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
	 * Get requirement type attrs
	 */
	public List<RequirementTypeAttr> getRequirementTypeAttrs(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementTypeId",
						EntityOperator.EQUALS, requirement
								.getRequirementTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility
	 */
	public Optional<Facility> getFacility(Requirement requirement) {
		List<Facility> entityList = null;
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						requirement.getFacilityId())), EntityOperator.AND));
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
	 * Get deliverable
	 */
	public Optional<Deliverable> getDeliverable(Requirement requirement) {
		List<Deliverable> entityList = null;
		In in = new In();
		in.setEntityName(Deliverable.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("deliverableId", EntityOperator.EQUALS,
						requirement.getDeliverableId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Deliverable.fromValues(out.getListIt()
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
	 * Get fixed asset
	 */
	public Optional<FixedAsset> getFixedAsset(Requirement requirement) {
		List<FixedAsset> entityList = null;
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						requirement.getFixedAssetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
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
	public Optional<Product> getProduct(Requirement requirement) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						requirement.getProductId())), EntityOperator.AND));
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(Requirement requirement) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						requirement.getStatusId())), EntityOperator.AND));
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
	 * Get desired features
	 */
	public List<DesiredFeature> getDesiredFeatures(Requirement requirement,
			Integer start, Integer number, List<String> orderBy) {
		List<DesiredFeature> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DesiredFeature.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DesiredFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order requirement commitments
	 */
	public List<OrderRequirementCommitment> getOrderRequirementCommitments(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderRequirementCommitment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderRequirementCommitment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderRequirementCommitment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement attributes
	 */
	public List<RequirementAttribute> getRequirementAttributes(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement budget allocations
	 */
	public List<RequirementBudgetAllocation> getRequirementBudgetAllocations(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementBudgetAllocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementBudgetAllocation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementBudgetAllocation.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement cust requests
	 */
	public List<RequirementCustRequest> getRequirementCustRequests(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementCustRequest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementCustRequest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementCustRequest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement roles
	 */
	public List<RequirementRole> getRequirementRoles(Requirement requirement,
			Integer start, Integer number, List<String> orderBy) {
		List<RequirementRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement statuses
	 */
	public List<RequirementStatus> getRequirementStatuses(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work requirement fulfillments
	 */
	public List<WorkRequirementFulfillment> getWorkRequirementFulfillments(
			Requirement requirement, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkRequirementFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkRequirementFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirement.getRequirementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkRequirementFulfillment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}