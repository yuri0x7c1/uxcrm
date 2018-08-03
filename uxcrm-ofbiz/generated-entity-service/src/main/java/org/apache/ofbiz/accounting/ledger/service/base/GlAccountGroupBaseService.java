package org.apache.ofbiz.accounting.ledger.service.base;

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
import org.apache.ofbiz.accounting.ledger.GlAccountGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlAccountGroupType;
import org.apache.ofbiz.accounting.ledger.GlAccountGroupMember;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GlAccountGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GlAccountGroupBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GlAccountGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GlAccountGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GlAccountGroups
	 */
	public List<GlAccountGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GlAccountGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountGroup.NAME);
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
				entityList = GlAccountGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GlAccountGroup
	 */
	public Optional<GlAccountGroup> findOne(Object glAccountGroupId) {
		List<GlAccountGroup> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountGroupId",
						EntityOperator.EQUALS, glAccountGroupId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountGroup.fromValues(out.getListIt()
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
	 * Get gl account group type
	 */
	public Optional<GlAccountGroupType> getGlAccountGroupType(
			GlAccountGroup glAccountGroup) {
		List<GlAccountGroupType> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountGroupType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountGroupTypeId",
						EntityOperator.EQUALS, glAccountGroup
								.getGlAccountGroupTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountGroupType.fromValues(out.getListIt()
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
	 * Get gl account group members
	 */
	public List<GlAccountGroupMember> getGlAccountGroupMembers(
			GlAccountGroup glAccountGroup, Integer start, Integer number,
			List<String> orderBy) {
		List<GlAccountGroupMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountGroupMember.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountGroupId",
						EntityOperator.EQUALS, glAccountGroup
								.getGlAccountGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountGroupMember.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}