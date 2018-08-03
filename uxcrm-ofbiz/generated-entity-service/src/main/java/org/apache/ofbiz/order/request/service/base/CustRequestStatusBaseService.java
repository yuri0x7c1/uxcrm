package org.apache.ofbiz.order.request.service.base;

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
import org.apache.ofbiz.order.request.CustRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.order.request.CustRequest;
import org.apache.ofbiz.order.request.CustRequestItem;
import org.apache.ofbiz.security.login.UserLogin;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CustRequestStatusBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CustRequestStatusBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CustRequestStatuses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CustRequestStatus.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CustRequestStatuses
	 */
	public List<CustRequestStatus> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CustRequestStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestStatus.NAME);
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
				entityList = CustRequestStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CustRequestStatus
	 */
	public Optional<CustRequestStatus> findOne(Object custRequestStatusId) {
		List<CustRequestStatus> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestStatus.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestStatusId",
						EntityOperator.EQUALS, custRequestStatusId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestStatus.fromValues(out.getListIt()
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
	public Optional<StatusItem> getStatusItem(
			CustRequestStatus custRequestStatus) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						custRequestStatus.getStatusId())), EntityOperator.AND));
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
	 * Get cust request
	 */
	public Optional<CustRequest> getCustRequest(
			CustRequestStatus custRequestStatus) {
		List<CustRequest> entityList = null;
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequestStatus.getCustRequestId())),
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
			CustRequestStatus custRequestStatus) {
		List<CustRequestItem> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequestStatus.getCustRequestId()), new EntityExpr(
						"custRequestItemSeqId", EntityOperator.EQUALS,
						custRequestStatus.getCustRequestItemSeqId())),
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
	 * Get change by user login
	 */
	public Optional<UserLogin> getChangeByUserLogin(
			CustRequestStatus custRequestStatus) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						custRequestStatus.getChangeByUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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