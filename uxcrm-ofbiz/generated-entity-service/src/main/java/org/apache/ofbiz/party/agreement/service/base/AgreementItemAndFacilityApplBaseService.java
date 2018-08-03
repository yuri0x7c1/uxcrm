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
import org.apache.ofbiz.party.agreement.AgreementItemAndFacilityAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.agreement.Agreement;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AgreementItemAndFacilityApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AgreementItemAndFacilityApplBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AgreementItemAndFacilityAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AgreementItemAndFacilityAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AgreementItemAndFacilityAppls
	 */
	public List<AgreementItemAndFacilityAppl> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<AgreementItemAndFacilityAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementItemAndFacilityAppl.NAME);
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
				entityList = AgreementItemAndFacilityAppl.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AgreementItemAndFacilityAppl
	 */
	public Optional<AgreementItemAndFacilityAppl> findOne(Object agreementId,
			Object agreementItemSeqId, Object facilityId) {
		List<AgreementItemAndFacilityAppl> entityList = null;
		In in = new In();
		in.setEntityName(AgreementItemAndFacilityAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementId), new EntityExpr("agreementItemSeqId",
						EntityOperator.EQUALS, agreementItemSeqId),
						new EntityExpr("facilityId", EntityOperator.EQUALS,
								facilityId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementItemAndFacilityAppl.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get agreement
	 */
	public Optional<Agreement> getAgreement(
			AgreementItemAndFacilityAppl agreementItemAndFacilityAppl) {
		List<Agreement> entityList = null;
		In in = new In();
		in.setEntityName(Agreement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItemAndFacilityAppl.getAgreementId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Agreement.fromValues(out.getListIt()
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