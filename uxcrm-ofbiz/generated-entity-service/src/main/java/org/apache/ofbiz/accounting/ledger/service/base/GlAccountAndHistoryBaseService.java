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
import org.apache.ofbiz.accounting.ledger.GlAccountAndHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlAccount;
import org.apache.ofbiz.accounting.ledger.GlAccountClass;
import org.apache.ofbiz.accounting.ledger.GlAccountHistory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GlAccountAndHistoryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GlAccountAndHistoryBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GlAccountAndHistories
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GlAccountAndHistory.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GlAccountAndHistories
	 */
	public List<GlAccountAndHistory> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GlAccountAndHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountAndHistory.NAME);
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
				entityList = GlAccountAndHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GlAccountAndHistory
	 */
	public Optional<GlAccountAndHistory> findOne(Object glAccountClassId,
			Object glAccountId, Object organizationPartyId,
			Object customTimePeriodId) {
		List<GlAccountAndHistory> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountAndHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("glAccountClassId", EntityOperator.EQUALS,
						glAccountClassId), new EntityExpr("glAccountId",
						EntityOperator.EQUALS, glAccountId), new EntityExpr(
						"organizationPartyId", EntityOperator.EQUALS,
						organizationPartyId), new EntityExpr(
						"customTimePeriodId", EntityOperator.EQUALS,
						customTimePeriodId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountAndHistory.fromValues(out.getListIt()
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
	 * Get gl account
	 */
	public Optional<GlAccount> getGlAccount(
			GlAccountAndHistory glAccountAndHistory) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccountAndHistory.getGlAccountId())),
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

	/**
	 * Get gl account class
	 */
	public Optional<GlAccountClass> getGlAccountClass(
			GlAccountAndHistory glAccountAndHistory) {
		List<GlAccountClass> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountClass.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountClassId",
						EntityOperator.EQUALS, glAccountAndHistory
								.getGlAccountClassId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountClass.fromValues(out.getListIt()
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
	 * Get gl account history
	 */
	public Optional<GlAccountHistory> getGlAccountHistory(
			GlAccountAndHistory glAccountAndHistory) {
		List<GlAccountHistory> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccountAndHistory.getGlAccountId()), new EntityExpr(
						"organizationPartyId", EntityOperator.EQUALS,
						glAccountAndHistory.getOrganizationPartyId()),
				new EntityExpr("customTimePeriodId", EntityOperator.EQUALS,
						glAccountAndHistory.getCustomTimePeriodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountHistory.fromValues(out.getListIt()
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