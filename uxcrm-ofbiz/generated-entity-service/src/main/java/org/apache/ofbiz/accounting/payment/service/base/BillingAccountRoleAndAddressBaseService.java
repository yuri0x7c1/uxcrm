package org.apache.ofbiz.accounting.payment.service.base;

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
import org.apache.ofbiz.accounting.payment.BillingAccountRoleAndAddress;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BillingAccountRoleAndAddressBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BillingAccountRoleAndAddressBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BillingAccountRoleAndAddresses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BillingAccountRoleAndAddress.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BillingAccountRoleAndAddresses
	 */
	public List<BillingAccountRoleAndAddress> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<BillingAccountRoleAndAddress> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BillingAccountRoleAndAddress.NAME);
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
				entityList = BillingAccountRoleAndAddress.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BillingAccountRoleAndAddress
	 */
	public Optional<BillingAccountRoleAndAddress> findOne(Object pcmFromDate,
			Object fromDate, Object roleTypeId, Object billingAccountId,
			Object partyId, Object contactMechId) {
		List<BillingAccountRoleAndAddress> entityList = null;
		In in = new In();
		in.setEntityName(BillingAccountRoleAndAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("pcmFromDate",
						EntityOperator.EQUALS, pcmFromDate), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate),
						new EntityExpr("roleTypeId", EntityOperator.EQUALS,
								roleTypeId), new EntityExpr("billingAccountId",
								EntityOperator.EQUALS, billingAccountId),
						new EntityExpr("partyId", EntityOperator.EQUALS,
								partyId), new EntityExpr("contactMechId",
								EntityOperator.EQUALS, contactMechId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccountRoleAndAddress.fromValues(out
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