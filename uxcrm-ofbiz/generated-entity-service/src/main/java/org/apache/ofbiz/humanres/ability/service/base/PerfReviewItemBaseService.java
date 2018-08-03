package org.apache.ofbiz.humanres.ability.service.base;

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
import org.apache.ofbiz.humanres.ability.PerfReviewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.ability.PerfReview;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.humanres.ability.PerfRatingType;
import org.apache.ofbiz.humanres.ability.PerfReviewItemType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PerfReviewItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PerfReviewItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PerfReviewItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PerfReviewItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PerfReviewItems
	 */
	public List<PerfReviewItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PerfReviewItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReviewItem.NAME);
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
				entityList = PerfReviewItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PerfReviewItem
	 */
	public Optional<PerfReviewItem> findOne(Object employeePartyId,
			Object employeeRoleTypeId, Object perfReviewId,
			Object perfReviewItemSeqId) {
		List<PerfReviewItem> entityList = null;
		In in = new In();
		in.setEntityName(PerfReviewItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("employeePartyId", EntityOperator.EQUALS,
						employeePartyId), new EntityExpr("employeeRoleTypeId",
						EntityOperator.EQUALS, employeeRoleTypeId),
				new EntityExpr("perfReviewId", EntityOperator.EQUALS,
						perfReviewId), new EntityExpr("perfReviewItemSeqId",
						EntityOperator.EQUALS, perfReviewItemSeqId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItem.fromValues(out.getListIt()
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
	 * Get perf review
	 */
	public Optional<PerfReview> getPerfReview(PerfReviewItem perfReviewItem) {
		List<PerfReview> entityList = null;
		In in = new In();
		in.setEntityName(PerfReview.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("employeePartyId", EntityOperator.EQUALS,
						perfReviewItem.getEmployeePartyId()), new EntityExpr(
						"employeeRoleTypeId", EntityOperator.EQUALS,
						perfReviewItem.getEmployeeRoleTypeId()),
				new EntityExpr("perfReviewId", EntityOperator.EQUALS,
						perfReviewItem.getPerfReviewId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReview.fromValues(out.getListIt()
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
	 * Get employee party
	 */
	public Optional<Party> getEmployeeParty(PerfReviewItem perfReviewItem) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						perfReviewItem.getEmployeePartyId())),
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
	 * Get employee party role
	 */
	public Optional<PartyRole> getEmployeePartyRole(
			PerfReviewItem perfReviewItem) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, perfReviewItem
						.getEmployeePartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						perfReviewItem.getEmployeeRoleTypeId())),
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
	 * Get perf rating type
	 */
	public Optional<PerfRatingType> getPerfRatingType(
			PerfReviewItem perfReviewItem) {
		List<PerfRatingType> entityList = null;
		In in = new In();
		in.setEntityName(PerfRatingType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("perfRatingTypeId",
						EntityOperator.EQUALS, perfReviewItem
								.getPerfRatingTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfRatingType.fromValues(out.getListIt()
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
	 * Get perf review item type
	 */
	public Optional<PerfReviewItemType> getPerfReviewItemType(
			PerfReviewItem perfReviewItem) {
		List<PerfReviewItemType> entityList = null;
		In in = new In();
		in.setEntityName(PerfReviewItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("perfReviewItemTypeId",
						EntityOperator.EQUALS, perfReviewItem
								.getPerfReviewItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItemType.fromValues(out.getListIt()
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