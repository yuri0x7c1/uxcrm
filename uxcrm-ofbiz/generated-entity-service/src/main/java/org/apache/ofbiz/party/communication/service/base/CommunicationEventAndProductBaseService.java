package org.apache.ofbiz.party.communication.service.base;

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
import org.apache.ofbiz.party.communication.CommunicationEventAndProduct;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CommunicationEventAndProductBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CommunicationEventAndProductBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CommunicationEventAndProducts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CommunicationEventAndProduct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CommunicationEventAndProducts
	 */
	public List<CommunicationEventAndProduct> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<CommunicationEventAndProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEventAndProduct.NAME);
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
				entityList = CommunicationEventAndProduct.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CommunicationEventAndProduct
	 */
	public Optional<CommunicationEventAndProduct> findOne(Object productId,
			Object communicationEventId) {
		List<CommunicationEventAndProduct> entityList = null;
		In in = new In();
		in.setEntityName(CommunicationEventAndProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("communicationEventId", EntityOperator.EQUALS,
						communicationEventId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventAndProduct.fromValues(out
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