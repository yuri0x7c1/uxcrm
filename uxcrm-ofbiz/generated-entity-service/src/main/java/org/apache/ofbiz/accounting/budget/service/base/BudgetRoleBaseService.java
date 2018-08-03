package org.apache.ofbiz.accounting.budget.service.base;

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
import org.apache.ofbiz.accounting.budget.BudgetRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.Budget;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.PartyRole;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetRoleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetRoleBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetRoles
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetRole.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetRoles
	 */
	public List<BudgetRole> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BudgetRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetRole.NAME);
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
				entityList = BudgetRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BudgetRole
	 */
	public Optional<BudgetRole> findOne(Object budgetId, Object partyId,
			Object roleTypeId) {
		List<BudgetRole> entityList = null;
		In in = new In();
		in.setEntityName(BudgetRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budgetId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS, roleTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetRole.fromValues(out.getListIt()
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
	 * Get budget
	 */
	public Optional<Budget> getBudget(BudgetRole budgetRole) {
		List<Budget> entityList = null;
		In in = new In();
		in.setEntityName(Budget.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budgetRole.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Budget.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(BudgetRole budgetRole) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						budgetRole.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get party role
	 */
	public Optional<PartyRole> getPartyRole(BudgetRole budgetRole) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, budgetRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, budgetRole.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
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