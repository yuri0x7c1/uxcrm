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
import org.apache.ofbiz.security.securitygroup.SecurityGroupPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.security.securitygroup.SecurityGroup;
import org.apache.ofbiz.security.securitygroup.SecurityPermission;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SecurityGroupPermissionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SecurityGroupPermissionBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SecurityGroupPermissions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SecurityGroupPermission.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SecurityGroupPermissions
	 */
	public List<SecurityGroupPermission> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one SecurityGroupPermission
	 */
	public Optional<SecurityGroupPermission> findOne(Object groupId,
			Object permissionId) {
		List<SecurityGroupPermission> entityList = null;
		In in = new In();
		in.setEntityName(SecurityGroupPermission.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("groupId", EntityOperator.EQUALS, groupId),
				new EntityExpr("permissionId", EntityOperator.EQUALS,
						permissionId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SecurityGroupPermission.fromValues(out.getListIt()
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
			SecurityGroupPermission securityGroupPermission) {
		List<SecurityGroup> entityList = null;
		In in = new In();
		in.setEntityName(SecurityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						securityGroupPermission.getGroupId())),
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
	 * Get security permission
	 */
	public Optional<SecurityPermission> getSecurityPermission(
			SecurityGroupPermission securityGroupPermission) {
		List<SecurityPermission> entityList = null;
		In in = new In();
		in.setEntityName(SecurityPermission.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("permissionId", EntityOperator.EQUALS,
						securityGroupPermission.getPermissionId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SecurityPermission.fromValues(out.getListIt()
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