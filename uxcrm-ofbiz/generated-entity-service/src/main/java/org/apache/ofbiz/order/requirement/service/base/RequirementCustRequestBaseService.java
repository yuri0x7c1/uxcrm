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
import org.apache.ofbiz.order.requirement.RequirementCustRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.request.CustRequest;
import org.apache.ofbiz.order.request.CustRequestItem;
import org.apache.ofbiz.order.requirement.Requirement;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RequirementCustRequestBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RequirementCustRequestBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RequirementCustRequests
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RequirementCustRequest.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RequirementCustRequests
	 */
	public List<RequirementCustRequest> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one RequirementCustRequest
	 */
	public Optional<RequirementCustRequest> findOne(Object custRequestId,
			Object custRequestItemSeqId, Object requirementId) {
		List<RequirementCustRequest> entityList = null;
		In in = new In();
		in.setEntityName(RequirementCustRequest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequestId), new EntityExpr("custRequestItemSeqId",
						EntityOperator.EQUALS, custRequestItemSeqId),
				new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementCustRequest.fromValues(out.getListIt()
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
	 * Get cust request
	 */
	public Optional<CustRequest> getCustRequest(
			RequirementCustRequest requirementCustRequest) {
		List<CustRequest> entityList = null;
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						requirementCustRequest.getCustRequestId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequest.fromValues(out.getListIt()
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
	 * Get cust request item
	 */
	public Optional<CustRequestItem> getCustRequestItem(
			RequirementCustRequest requirementCustRequest) {
		List<CustRequestItem> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("custRequestId", EntityOperator.EQUALS,
						requirementCustRequest.getCustRequestId()),
				new EntityExpr("custRequestItemSeqId", EntityOperator.EQUALS,
						requirementCustRequest.getCustRequestItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestItem.fromValues(out.getListIt()
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
	 * Get requirement
	 */
	public Optional<Requirement> getRequirement(
			RequirementCustRequest requirementCustRequest) {
		List<Requirement> entityList = null;
		In in = new In();
		in.setEntityName(Requirement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementCustRequest.getRequirementId())),
				EntityOperator.AND));
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
}