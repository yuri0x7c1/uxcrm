package org.apache.ofbiz.accounting.payment.service.base;

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
import org.apache.ofbiz.accounting.payment.BillingAccountTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.party.agreement.TermType;
import org.apache.ofbiz.accounting.payment.BillingAccount;
import org.apache.ofbiz.accounting.payment.BillingAccountTermAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BillingAccountTermBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BillingAccountTermBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BillingAccountTerms
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BillingAccountTerm.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BillingAccountTerms
	 */
	public List<BillingAccountTerm> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BillingAccountTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BillingAccountTerm.NAME);
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
				entityList = BillingAccountTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BillingAccountTerm
	 */
	public Optional<BillingAccountTerm> findOne(Object billingAccountTermId) {
		List<BillingAccountTerm> entityList = null;
		In in = new In();
		in.setEntityName(BillingAccountTerm.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("billingAccountTermId",
						EntityOperator.EQUALS, billingAccountTermId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccountTerm.fromValues(out.getListIt()
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
	 * Get uom
	 */
	public Optional<Uom> getUom(BillingAccountTerm billingAccountTerm) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						billingAccountTerm.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get term type
	 */
	public Optional<TermType> getTermType(BillingAccountTerm billingAccountTerm) {
		List<TermType> entityList = null;
		In in = new In();
		in.setEntityName(TermType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("termTypeId", EntityOperator.EQUALS,
						billingAccountTerm.getTermTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TermType.fromValues(out.getListIt()
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
	 * Get billing account
	 */
	public Optional<BillingAccount> getBillingAccount(
			BillingAccountTerm billingAccountTerm) {
		List<BillingAccount> entityList = null;
		In in = new In();
		in.setEntityName(BillingAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("billingAccountId",
						EntityOperator.EQUALS, billingAccountTerm
								.getBillingAccountId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccount.fromValues(out.getListIt()
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
	 * Get billing account term attrs
	 */
	public List<BillingAccountTermAttr> getBillingAccountTermAttrs(
			BillingAccountTerm billingAccountTerm, Integer start,
			Integer number, List<String> orderBy) {
		List<BillingAccountTermAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BillingAccountTermAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("billingAccountTermId",
						EntityOperator.EQUALS, billingAccountTerm
								.getBillingAccountTermId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccountTermAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}