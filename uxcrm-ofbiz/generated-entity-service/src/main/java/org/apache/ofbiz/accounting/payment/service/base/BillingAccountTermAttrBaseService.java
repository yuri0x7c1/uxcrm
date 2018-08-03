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
import org.apache.ofbiz.accounting.payment.BillingAccountTermAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.BillingAccountTerm;
import org.apache.ofbiz.party.agreement.TermTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BillingAccountTermAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BillingAccountTermAttrBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BillingAccountTermAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BillingAccountTermAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BillingAccountTermAttrs
	 */
	public List<BillingAccountTermAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one BillingAccountTermAttr
	 */
	public Optional<BillingAccountTermAttr> findOne(
			Object billingAccountTermId, Object attrName) {
		List<BillingAccountTermAttr> entityList = null;
		In in = new In();
		in.setEntityName(BillingAccountTermAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("billingAccountTermId", EntityOperator.EQUALS,
						billingAccountTermId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccountTermAttr.fromValues(out.getListIt()
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
	 * Get billing account term
	 */
	public Optional<BillingAccountTerm> getBillingAccountTerm(
			BillingAccountTermAttr billingAccountTermAttr) {
		List<BillingAccountTerm> entityList = null;
		In in = new In();
		in.setEntityName(BillingAccountTerm.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("billingAccountTermId",
						EntityOperator.EQUALS, billingAccountTermAttr
								.getBillingAccountTermId())),
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
	 * Get term type attrs
	 */
	public List<TermTypeAttr> getTermTypeAttrs(
			BillingAccountTermAttr billingAccountTermAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<TermTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TermTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						billingAccountTermAttr.getAttrName())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TermTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}