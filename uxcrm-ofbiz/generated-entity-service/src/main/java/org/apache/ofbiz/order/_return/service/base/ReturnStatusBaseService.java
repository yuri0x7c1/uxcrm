package org.apache.ofbiz.order._return.service.base;

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
import org.apache.ofbiz.order._return.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.order._return.ReturnHeader;
import org.apache.ofbiz.order._return.ReturnItem;
import org.apache.ofbiz.security.login.UserLogin;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ReturnStatusBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ReturnStatusBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ReturnStatuses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ReturnStatus.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ReturnStatuses
	 */
	public List<ReturnStatus> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ReturnStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnStatus.NAME);
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
				entityList = ReturnStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ReturnStatus
	 */
	public Optional<ReturnStatus> findOne(Object returnStatusId) {
		List<ReturnStatus> entityList = null;
		In in = new In();
		in.setEntityName(ReturnStatus.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnStatusId", EntityOperator.EQUALS,
						returnStatusId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnStatus.fromValues(out.getListIt()
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
	public Optional<StatusItem> getStatusItem(ReturnStatus returnStatus) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						returnStatus.getStatusId())), EntityOperator.AND));
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
	 * Get return header
	 */
	public Optional<ReturnHeader> getReturnHeader(ReturnStatus returnStatus) {
		List<ReturnHeader> entityList = null;
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnId", EntityOperator.EQUALS,
						returnStatus.getReturnId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnHeader.fromValues(out.getListIt()
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
	 * Get return item
	 */
	public Optional<ReturnItem> getReturnItem(ReturnStatus returnStatus) {
		List<ReturnItem> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("returnId", EntityOperator.EQUALS, returnStatus
						.getReturnId()),
				new EntityExpr("returnItemSeqId", EntityOperator.EQUALS,
						returnStatus.getReturnItemSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItem.fromValues(out.getListIt()
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
	public Optional<UserLogin> getChangeByUserLogin(ReturnStatus returnStatus) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						returnStatus.getChangeByUserLoginId())),
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