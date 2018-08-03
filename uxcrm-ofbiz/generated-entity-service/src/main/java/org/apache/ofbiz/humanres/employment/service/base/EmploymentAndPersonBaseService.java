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
import org.apache.ofbiz.humanres.employment.EmploymentAndPerson;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmploymentAndPersonBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmploymentAndPersonBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmploymentAndPersons
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmploymentAndPerson.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmploymentAndPersons
	 */
	public List<EmploymentAndPerson> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmploymentAndPerson> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmploymentAndPerson.NAME);
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
				entityList = EmploymentAndPerson.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmploymentAndPerson
	 */
	public Optional<EmploymentAndPerson> findOne(Object roleTypeIdTo,
			Object fromDate, Object partyIdFrom, Object partyIdTo,
			Object roleTypeIdFrom, Object partyId) {
		List<EmploymentAndPerson> entityList = null;
		In in = new In();
		in.setEntityName(EmploymentAndPerson.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						roleTypeIdTo), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"partyIdFrom", EntityOperator.EQUALS, partyIdFrom),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyIdTo),
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleTypeIdFrom), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentAndPerson.fromValues(out.getListIt()
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