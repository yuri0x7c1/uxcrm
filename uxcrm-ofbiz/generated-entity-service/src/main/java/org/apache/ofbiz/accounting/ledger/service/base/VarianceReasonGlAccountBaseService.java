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
import org.apache.ofbiz.accounting.ledger.VarianceReasonGlAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.inventory.VarianceReason;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.ledger.GlAccount;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class VarianceReasonGlAccountBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public VarianceReasonGlAccountBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count VarianceReasonGlAccounts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(VarianceReasonGlAccount.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find VarianceReasonGlAccounts
	 */
	public List<VarianceReasonGlAccount> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<VarianceReasonGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VarianceReasonGlAccount.NAME);
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
				entityList = VarianceReasonGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one VarianceReasonGlAccount
	 */
	public Optional<VarianceReasonGlAccount> findOne(Object varianceReasonId,
			Object organizationPartyId) {
		List<VarianceReasonGlAccount> entityList = null;
		In in = new In();
		in.setEntityName(VarianceReasonGlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("varianceReasonId", EntityOperator.EQUALS,
						varianceReasonId), new EntityExpr(
						"organizationPartyId", EntityOperator.EQUALS,
						organizationPartyId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VarianceReasonGlAccount.fromValues(out.getListIt()
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
	 * Get variance reason
	 */
	public Optional<VarianceReason> getVarianceReason(
			VarianceReasonGlAccount varianceReasonGlAccount) {
		List<VarianceReason> entityList = null;
		In in = new In();
		in.setEntityName(VarianceReason.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("varianceReasonId",
						EntityOperator.EQUALS, varianceReasonGlAccount
								.getVarianceReasonId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VarianceReason.fromValues(out.getListIt()
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
	 * Get organization party
	 */
	public Optional<Party> getOrganizationParty(
			VarianceReasonGlAccount varianceReasonGlAccount) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						varianceReasonGlAccount.getOrganizationPartyId())),
				EntityOperator.AND));
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
	 * Get gl account
	 */
	public Optional<GlAccount> getGlAccount(
			VarianceReasonGlAccount varianceReasonGlAccount) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						varianceReasonGlAccount.getGlAccountId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccount.fromValues(out.getListIt()
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