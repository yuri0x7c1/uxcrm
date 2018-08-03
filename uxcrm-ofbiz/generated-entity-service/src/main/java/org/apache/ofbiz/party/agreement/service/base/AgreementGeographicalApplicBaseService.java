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
import org.apache.ofbiz.party.agreement.AgreementGeographicalApplic;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementItem;
import org.apache.ofbiz.common.geo.Geo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AgreementGeographicalApplicBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AgreementGeographicalApplicBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AgreementGeographicalApplics
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AgreementGeographicalApplic.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AgreementGeographicalApplics
	 */
	public List<AgreementGeographicalApplic> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<AgreementGeographicalApplic> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementGeographicalApplic.NAME);
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
				entityList = AgreementGeographicalApplic.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AgreementGeographicalApplic
	 */
	public Optional<AgreementGeographicalApplic> findOne(Object agreementId,
			Object agreementItemSeqId, Object geoId) {
		List<AgreementGeographicalApplic> entityList = null;
		In in = new In();
		in.setEntityName(AgreementGeographicalApplic.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementId), new EntityExpr("agreementItemSeqId",
						EntityOperator.EQUALS, agreementItemSeqId),
				new EntityExpr("geoId", EntityOperator.EQUALS, geoId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementGeographicalApplic.fromValues(out
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
			AgreementGeographicalApplic agreementGeographicalApplic) {
		List<Agreement> entityList = null;
		In in = new In();
		in.setEntityName(Agreement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementGeographicalApplic.getAgreementId())),
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

	/**
	 * Get agreement item
	 */
	public Optional<AgreementItem> getAgreementItem(
			AgreementGeographicalApplic agreementGeographicalApplic) {
		List<AgreementItem> entityList = null;
		In in = new In();
		in.setEntityName(AgreementItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementGeographicalApplic.getAgreementId()),
				new EntityExpr("agreementItemSeqId", EntityOperator.EQUALS,
						agreementGeographicalApplic.getAgreementItemSeqId())),
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

	/**
	 * Get geo
	 */
	public Optional<Geo> getGeo(
			AgreementGeographicalApplic agreementGeographicalApplic) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						agreementGeographicalApplic.getGeoId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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