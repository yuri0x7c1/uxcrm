package org.apache.ofbiz.party.party;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyBaseService {

	@Autowired
	private ExecuteFindService executeFindService;

	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setNoConditionFind(conditions == null ? FindUtil.Y : FindUtil.N);
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	public List<Party> find(Integer start, Integer number, List<String> orderBy,
			EntityConditionList conditions) {
		List<Party> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setOrderByList(orderBy);
		in.setNoConditionFind(conditions == null ? FindUtil.Y : FindUtil.N);
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				return Party.fromValues(out.getListIt().getPartialList(start, number));
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	public Party findOne(String partyId) {
		List<Party> entityList = null;

		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(
			new EntityConditionList<>(
				Arrays.asList(new EntityExpr("partyId", EntityOperator.EQUALS, partyId)),
				EntityOperator.AND
			)
		);

		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party.fromValues(out.getListIt().getCompleteList());
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}

		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}

		return null;
	}
}