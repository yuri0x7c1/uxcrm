package org.apache.ofbiz.party.agreement.service.base;

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
import org.apache.ofbiz.party.agreement.AgreementEmploymentAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.employment.Employment;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AgreementEmploymentApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AgreementEmploymentApplBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AgreementEmploymentAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AgreementEmploymentAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AgreementEmploymentAppls
	 */
	public List<AgreementEmploymentAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AgreementEmploymentAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementEmploymentAppl.NAME);
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
				entityList = AgreementEmploymentAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AgreementEmploymentAppl
	 */
	public Optional<AgreementEmploymentAppl> findOne(Object agreementId,
			Object agreementItemSeqId, Object partyIdTo, Object partyIdFrom,
			Object roleTypeIdTo, Object roleTypeIdFrom, Object fromDate) {
		List<AgreementEmploymentAppl> entityList = null;
		In in = new In();
		in.setEntityName(AgreementEmploymentAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementId), new EntityExpr("agreementItemSeqId",
						EntityOperator.EQUALS, agreementItemSeqId),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyIdTo),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						partyIdFrom), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, roleTypeIdTo),
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleTypeIdFrom), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementEmploymentAppl.fromValues(out.getListIt()
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
	 * Get employment
	 */
	public Optional<Employment> getEmployment(
			AgreementEmploymentAppl agreementEmploymentAppl) {
		List<Employment> entityList = null;
		In in = new In();
		in.setEntityName(Employment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						agreementEmploymentAppl.getRoleTypeIdFrom()),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						agreementEmploymentAppl.getRoleTypeIdTo()),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						agreementEmploymentAppl.getPartyIdFrom()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						agreementEmploymentAppl.getPartyIdTo()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						agreementEmploymentAppl.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Employment.fromValues(out.getListIt()
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
	 * Get agreements
	 */
	public List<Agreement> getAgreements(
			AgreementEmploymentAppl agreementEmploymentAppl, Integer start,
			Integer number, List<String> orderBy) {
		List<Agreement> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Agreement.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						agreementEmploymentAppl.getAgreementId()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						agreementEmploymentAppl.getAgreementId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Agreement.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement item
	 */
	public Optional<AgreementItem> getAgreementItem(
			AgreementEmploymentAppl agreementEmploymentAppl) {
		List<AgreementItem> entityList = null;
		In in = new In();
		in.setEntityName(AgreementItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementEmploymentAppl.getAgreementId()),
				new EntityExpr("agreementItemSeqId", EntityOperator.EQUALS,
						agreementEmploymentAppl.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementItem.fromValues(out.getListIt()
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