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
import org.apache.ofbiz.accounting.ledger.GlAccountTypeDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlAccountType;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.ledger.GlAccount;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GlAccountTypeDefaultBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GlAccountTypeDefaultBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GlAccountTypeDefaults
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GlAccountTypeDefault.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GlAccountTypeDefaults
	 */
	public List<GlAccountTypeDefault> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GlAccountTypeDefault> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountTypeDefault.NAME);
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
				entityList = GlAccountTypeDefault.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GlAccountTypeDefault
	 */
	public Optional<GlAccountTypeDefault> findOne(Object glAccountTypeId,
			Object organizationPartyId) {
		List<GlAccountTypeDefault> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountTypeDefault.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("glAccountTypeId", EntityOperator.EQUALS,
						glAccountTypeId), new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, organizationPartyId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountTypeDefault.fromValues(out.getListIt()
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
	 * Get gl account type
	 */
	public Optional<GlAccountType> getGlAccountType(
			GlAccountTypeDefault glAccountTypeDefault) {
		List<GlAccountType> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountTypeId",
						EntityOperator.EQUALS, glAccountTypeDefault
								.getGlAccountTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountType.fromValues(out.getListIt()
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
			GlAccountTypeDefault glAccountTypeDefault) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						glAccountTypeDefault.getOrganizationPartyId())),
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
			GlAccountTypeDefault glAccountTypeDefault) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccountTypeDefault.getGlAccountId())),
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