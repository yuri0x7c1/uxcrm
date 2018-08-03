package org.apache.ofbiz.marketing.segment.service.base;

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
import org.apache.ofbiz.marketing.segment.SegmentGroupViewRelatedParties;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SegmentGroupViewRelatedPartiesBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SegmentGroupViewRelatedPartiesBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SegmentGroupViewRelatedPartieses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SegmentGroupViewRelatedParties.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SegmentGroupViewRelatedPartieses
	 */
	public List<SegmentGroupViewRelatedParties> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<SegmentGroupViewRelatedParties> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroupViewRelatedParties.NAME);
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
				entityList = SegmentGroupViewRelatedParties.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SegmentGroupViewRelatedParties
	 */
	public Optional<SegmentGroupViewRelatedParties> findOne(
			Object sgrRoleTypeId, Object sgrSegmentGroupId, Object sgrPartyId,
			Object sgrToRoleTypeId, Object sgrToSegmentGroupId,
			Object sgrToPartyId, Object prSgrRoleTypeIdTo,
			Object prSgrPartyIdFrom, Object prSgrRoleTypeIdFrom,
			Object prSgrFromDate, Object prSgrPartyIdTo,
			Object sgcPartyClassificationGroupId, Object sgcSegmentGroupId,
			Object pcFromDate, Object pcPartyClassificationGroupId,
			Object pcPartyId, Object prPcRoleTypeIdTo, Object prPcPartyIdFrom,
			Object prPcRoleTypeIdFrom, Object prPcFromDate, Object prPcPartyIdTo) {
		List<SegmentGroupViewRelatedParties> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroupViewRelatedParties.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("sgrRoleTypeId", EntityOperator.EQUALS,
						sgrRoleTypeId), new EntityExpr("sgrSegmentGroupId",
						EntityOperator.EQUALS, sgrSegmentGroupId),
						new EntityExpr("sgrPartyId", EntityOperator.EQUALS,
								sgrPartyId), new EntityExpr("sgrToRoleTypeId",
								EntityOperator.EQUALS, sgrToRoleTypeId),
						new EntityExpr("sgrToSegmentGroupId",
								EntityOperator.EQUALS, sgrToSegmentGroupId),
						new EntityExpr("sgrToPartyId", EntityOperator.EQUALS,
								sgrToPartyId), new EntityExpr(
								"prSgrRoleTypeIdTo", EntityOperator.EQUALS,
								prSgrRoleTypeIdTo), new EntityExpr(
								"prSgrPartyIdFrom", EntityOperator.EQUALS,
								prSgrPartyIdFrom), new EntityExpr(
								"prSgrRoleTypeIdFrom", EntityOperator.EQUALS,
								prSgrRoleTypeIdFrom), new EntityExpr(
								"prSgrFromDate", EntityOperator.EQUALS,
								prSgrFromDate), new EntityExpr(
								"prSgrPartyIdTo", EntityOperator.EQUALS,
								prSgrPartyIdTo), new EntityExpr(
								"sgcPartyClassificationGroupId",
								EntityOperator.EQUALS,
								sgcPartyClassificationGroupId), new EntityExpr(
								"sgcSegmentGroupId", EntityOperator.EQUALS,
								sgcSegmentGroupId),
						new EntityExpr("pcFromDate", EntityOperator.EQUALS,
								pcFromDate), new EntityExpr(
								"pcPartyClassificationGroupId",
								EntityOperator.EQUALS,
								pcPartyClassificationGroupId), new EntityExpr(
								"pcPartyId", EntityOperator.EQUALS, pcPartyId),
						new EntityExpr("prPcRoleTypeIdTo",
								EntityOperator.EQUALS, prPcRoleTypeIdTo),
						new EntityExpr("prPcPartyIdFrom",
								EntityOperator.EQUALS, prPcPartyIdFrom),
						new EntityExpr("prPcRoleTypeIdFrom",
								EntityOperator.EQUALS, prPcRoleTypeIdFrom),
						new EntityExpr("prPcFromDate", EntityOperator.EQUALS,
								prPcFromDate), new EntityExpr("prPcPartyIdTo",
								EntityOperator.EQUALS, prPcPartyIdTo)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupViewRelatedParties.fromValues(out
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
}