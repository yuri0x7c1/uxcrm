package org.apache.ofbiz.accounting.ledger.service.base;

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
import org.apache.ofbiz.accounting.ledger.AcctgTransEntryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AcctgTransEntryTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AcctgTransEntryTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AcctgTransEntryTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AcctgTransEntryType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AcctgTransEntryTypes
	 */
	public List<AcctgTransEntryType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AcctgTransEntryType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransEntryType.NAME);
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
				entityList = AcctgTransEntryType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AcctgTransEntryType
	 */
	public Optional<AcctgTransEntryType> findOne(Object acctgTransEntryTypeId) {
		List<AcctgTransEntryType> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransEntryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("acctgTransEntryTypeId",
						EntityOperator.EQUALS, acctgTransEntryTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntryType.fromValues(out.getListIt()
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
	 * Get parent acctg trans entry type
	 */
	public Optional<AcctgTransEntryType> getParentAcctgTransEntryType(
			AcctgTransEntryType acctgTransEntryType) {
		List<AcctgTransEntryType> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransEntryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("acctgTransEntryTypeId",
						EntityOperator.EQUALS, acctgTransEntryType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntryType.fromValues(out.getListIt()
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
	 * Get acctg trans entries
	 */
	public List<AcctgTransEntry> getAcctgTransEntries(
			AcctgTransEntryType acctgTransEntryType, Integer start,
			Integer number, List<String> orderBy) {
		List<AcctgTransEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransEntry.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("acctgTransEntryTypeId",
						EntityOperator.EQUALS, acctgTransEntryType
								.getAcctgTransEntryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child acctg trans entry types
	 */
	public List<AcctgTransEntryType> getChildAcctgTransEntryTypes(
			AcctgTransEntryType acctgTransEntryType, Integer start,
			Integer number, List<String> orderBy) {
		List<AcctgTransEntryType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransEntryType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						acctgTransEntryType.getAcctgTransEntryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntryType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}