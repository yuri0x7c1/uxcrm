package org.apache.ofbiz.security.securitygroup.service.base;

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
import org.apache.ofbiz.security.securitygroup.UserLoginSecurityGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.security.securitygroup.SecurityGroup;
import org.apache.ofbiz.security.securitygroup.SecurityGroupPermission;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class UserLoginSecurityGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public UserLoginSecurityGroupBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count UserLoginSecurityGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(UserLoginSecurityGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find UserLoginSecurityGroups
	 */
	public List<UserLoginSecurityGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<UserLoginSecurityGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserLoginSecurityGroup.NAME);
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
				entityList = UserLoginSecurityGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one UserLoginSecurityGroup
	 */
	public Optional<UserLoginSecurityGroup> findOne(Object userLoginId,
			Object groupId, Object fromDate) {
		List<UserLoginSecurityGroup> entityList = null;
		In in = new In();
		in.setEntityName(UserLoginSecurityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLoginId), new EntityExpr("groupId",
						EntityOperator.EQUALS, groupId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLoginSecurityGroup.fromValues(out.getListIt()
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
	 * Get user login
	 */
	public Optional<UserLogin> getUserLogin(
			UserLoginSecurityGroup userLoginSecurityGroup) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLoginSecurityGroup.getUserLoginId())),
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

	/**
	 * Get security group
	 */
	public Optional<SecurityGroup> getSecurityGroup(
			UserLoginSecurityGroup userLoginSecurityGroup) {
		List<SecurityGroup> entityList = null;
		In in = new In();
		in.setEntityName(SecurityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						userLoginSecurityGroup.getGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SecurityGroup.fromValues(out.getListIt()
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
	 * Get security group permissions
	 */
	public List<SecurityGroupPermission> getSecurityGroupPermissions(
			UserLoginSecurityGroup userLoginSecurityGroup, Integer start,
			Integer number, List<String> orderBy) {
		List<SecurityGroupPermission> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SecurityGroupPermission.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						userLoginSecurityGroup.getGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SecurityGroupPermission.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}