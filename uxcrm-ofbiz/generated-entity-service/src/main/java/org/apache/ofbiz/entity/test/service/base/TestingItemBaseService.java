package org.apache.ofbiz.entity.test.service.base;

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
import org.apache.ofbiz.entity.test.TestingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.test.Testing;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TestingItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TestingItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TestingItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TestingItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TestingItems
	 */
	public List<TestingItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TestingItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TestingItem.NAME);
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
				entityList = TestingItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TestingItem
	 */
	public Optional<TestingItem> findOne(Object testingId, Object testingSeqId) {
		List<TestingItem> entityList = null;
		In in = new In();
		in.setEntityName(TestingItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("testingId", EntityOperator.EQUALS, testingId),
				new EntityExpr("testingSeqId", EntityOperator.EQUALS,
						testingSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingItem.fromValues(out.getListIt()
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
	 * Get testing
	 */
	public Optional<Testing> getTesting(TestingItem testingItem) {
		List<Testing> entityList = null;
		In in = new In();
		in.setEntityName(Testing.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("testingId", EntityOperator.EQUALS,
						testingItem.getTestingId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Testing.fromValues(out.getListIt()
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