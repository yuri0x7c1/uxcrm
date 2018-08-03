package org.apache.ofbiz.humanres.employment.service.base;

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
import org.apache.ofbiz.humanres.employment.Employment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.humanres.employment.TerminationReason;
import org.apache.ofbiz.humanres.employment.TerminationType;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementEmploymentAppl;
import org.apache.ofbiz.humanres.employment.PayHistory;
import org.apache.ofbiz.humanres.employment.UnemploymentClaim;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmploymentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmploymentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Employments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Employment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Employments
	 */
	public List<Employment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Employment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Employment.NAME);
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
				entityList = Employment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Employment
	 */
	public Optional<Employment> findOne(Object roleTypeIdFrom,
			Object roleTypeIdTo, Object partyIdFrom, Object partyIdTo,
			Object fromDate) {
		List<Employment> entityList = null;
		In in = new In();
		in.setEntityName(Employment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleTypeIdFrom), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, roleTypeIdTo), new EntityExpr(
						"partyIdFrom", EntityOperator.EQUALS, partyIdFrom),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyIdTo),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
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
	 * Get to party
	 */
	public Optional<Party> getToParty(Employment employment) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						employment.getPartyIdTo())), EntityOperator.AND));
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
	 * Get to party role
	 */
	public Optional<PartyRole> getToPartyRole(Employment employment) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, employment
						.getPartyIdTo()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, employment.getRoleTypeIdTo())),
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

	/**
	 * Get from party
	 */
	public Optional<Party> getFromParty(Employment employment) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						employment.getPartyIdFrom())), EntityOperator.AND));
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
	 * Get from party role
	 */
	public Optional<PartyRole> getFromPartyRole(Employment employment) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						employment.getPartyIdFrom()),
						new EntityExpr("roleTypeId", EntityOperator.EQUALS,
								employment.getRoleTypeIdFrom())),
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

	/**
	 * Get termination reason
	 */
	public Optional<TerminationReason> getTerminationReason(
			Employment employment) {
		List<TerminationReason> entityList = null;
		In in = new In();
		in.setEntityName(TerminationReason.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("terminationReasonId",
						EntityOperator.EQUALS, employment
								.getTerminationReasonId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TerminationReason.fromValues(out.getListIt()
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
	 * Get termination type
	 */
	public Optional<TerminationType> getTerminationType(Employment employment) {
		List<TerminationType> entityList = null;
		In in = new In();
		in.setEntityName(TerminationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("terminationTypeId",
						EntityOperator.EQUALS, employment
								.getTerminationTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TerminationType.fromValues(out.getListIt()
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
	public List<Agreement> getAgreements(Employment employment, Integer start,
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
				new EntityExpr("agreementId", EntityOperator.EQUALS, employment
						.getPartyIdTo()), new EntityExpr("agreementId",
						EntityOperator.EQUALS, employment.getPartyIdFrom())),
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
	 * Get agreement employment appls
	 */
	public List<AgreementEmploymentAppl> getAgreementEmploymentAppls(
			Employment employment, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						employment.getRoleTypeIdFrom()),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						employment.getRoleTypeIdTo()),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, employment
						.getPartyIdFrom()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, employment
						.getPartyIdTo()),
				new EntityExpr("fromDate", EntityOperator.EQUALS, employment
						.getFromDate())), EntityOperator.AND));
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
	 * Get pay history
	 */
	public Optional<PayHistory> getPayHistory(Employment employment) {
		List<PayHistory> entityList = null;
		In in = new In();
		in.setEntityName(PayHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						employment.getRoleTypeIdFrom()),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						employment.getRoleTypeIdTo()),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, employment
						.getPartyIdFrom()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, employment
						.getPartyIdTo()),
				new EntityExpr("fromDate", EntityOperator.EQUALS, employment
						.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PayHistory.fromValues(out.getListIt()
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
	 * Get unemployment claims
	 */
	public List<UnemploymentClaim> getUnemploymentClaims(Employment employment,
			Integer start, Integer number, List<String> orderBy) {
		List<UnemploymentClaim> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UnemploymentClaim.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						employment.getRoleTypeIdFrom()),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						employment.getRoleTypeIdTo()),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, employment
						.getPartyIdFrom()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, employment
						.getPartyIdTo()),
				new EntityExpr("fromDate", EntityOperator.EQUALS, employment
						.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UnemploymentClaim.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}