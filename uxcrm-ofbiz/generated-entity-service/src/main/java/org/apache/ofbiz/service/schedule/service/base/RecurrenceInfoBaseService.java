package org.apache.ofbiz.service.schedule.service.base;

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
import org.apache.ofbiz.service.schedule.RecurrenceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.service.schedule.RecurrenceRule;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.service.schedule.JobSandbox;
import org.apache.ofbiz.product.product.ProductAssoc;
import org.apache.ofbiz.order.shoppinglist.ShoppingList;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RecurrenceInfoBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RecurrenceInfoBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RecurrenceInfoes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RecurrenceInfoes
	 */
	public List<RecurrenceInfo> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<RecurrenceInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
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
				entityList = RecurrenceInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one RecurrenceInfo
	 */
	public Optional<RecurrenceInfo> findOne(Object recurrenceInfoId) {
		List<RecurrenceInfo> entityList = null;
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, recurrenceInfoId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceInfo.fromValues(out.getListIt()
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
	 * Get recurrence rule
	 */
	public Optional<RecurrenceRule> getRecurrenceRule(
			RecurrenceInfo recurrenceInfo) {
		List<RecurrenceRule> entityList = null;
		In in = new In();
		in.setEntityName(RecurrenceRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceRuleId",
						EntityOperator.EQUALS, recurrenceInfo
								.getRecurrenceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceRule.fromValues(out.getListIt()
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
	 * Get exception recurrence rule
	 */
	public Optional<RecurrenceRule> getExceptionRecurrenceRule(
			RecurrenceInfo recurrenceInfo) {
		List<RecurrenceRule> entityList = null;
		In in = new In();
		in.setEntityName(RecurrenceRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceRuleId",
						EntityOperator.EQUALS, recurrenceInfo
								.getExceptionRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceRule.fromValues(out.getListIt()
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
	 * Get invoices
	 */
	public List<Invoice> getInvoices(RecurrenceInfo recurrenceInfo,
			Integer start, Integer number, List<String> orderBy) {
		List<Invoice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Invoice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, recurrenceInfo
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Invoice.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get job sandboxes
	 */
	public List<JobSandbox> getJobSandboxes(RecurrenceInfo recurrenceInfo,
			Integer start, Integer number, List<String> orderBy) {
		List<JobSandbox> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobSandbox.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, recurrenceInfo
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobSandbox.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product assocs
	 */
	public List<ProductAssoc> getProductAssocs(RecurrenceInfo recurrenceInfo,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, recurrenceInfo
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping lists
	 */
	public List<ShoppingList> getShoppingLists(RecurrenceInfo recurrenceInfo,
			Integer start, Integer number, List<String> orderBy) {
		List<ShoppingList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, recurrenceInfo
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work efforts
	 */
	public List<WorkEffort> getWorkEfforts(RecurrenceInfo recurrenceInfo,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, recurrenceInfo
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}