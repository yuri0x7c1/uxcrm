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
import org.apache.ofbiz.security.securitygroup.SecurityGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyRelationship;
import org.apache.ofbiz.common.portal.PortalPage;
import org.apache.ofbiz.security.securitygroup.ProtectedView;
import org.apache.ofbiz.security.securitygroup.SecurityGroupPermission;
import org.apache.ofbiz.security.securitygroup.UserLoginSecurityGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SecurityGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SecurityGroupBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SecurityGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SecurityGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SecurityGroups
	 */
	public List<SecurityGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SecurityGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SecurityGroup.NAME);
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
				entityList = SecurityGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SecurityGroup
	 */
	public Optional<SecurityGroup> findOne(Object groupId) {
		List<SecurityGroup> entityList = null;
		In in = new In();
		in.setEntityName(SecurityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						groupId)), EntityOperator.AND));
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
	 * Get party relationships
	 */
	public List<PartyRelationship> getPartyRelationships(
			SecurityGroup securityGroup, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyRelationship> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("securityGroupId",
						EntityOperator.EQUALS, securityGroup.getGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationship.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get portal pages
	 */
	public List<PortalPage> getPortalPages(SecurityGroup securityGroup,
			Integer start, Integer number, List<String> orderBy) {
		List<PortalPage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("securityGroupId",
						EntityOperator.EQUALS, securityGroup.getGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get protected views
	 */
	public List<ProtectedView> getProtectedViews(SecurityGroup securityGroup,
			Integer start, Integer number, List<String> orderBy) {
		List<ProtectedView> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProtectedView.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						securityGroup.getGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProtectedView.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get security group permissions
	 */
	public List<SecurityGroupPermission> getSecurityGroupPermissions(
			SecurityGroup securityGroup, Integer start, Integer number,
			List<String> orderBy) {
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
						securityGroup.getGroupId())), EntityOperator.AND));
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
	 * Get user login security groups
	 */
	public List<UserLoginSecurityGroup> getUserLoginSecurityGroups(
			SecurityGroup securityGroup, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						securityGroup.getGroupId())), EntityOperator.AND));
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
}