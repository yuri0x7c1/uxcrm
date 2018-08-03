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
import org.apache.ofbiz.entity.test.TestingNodeAndMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.test.TestingNodeMember;
import org.apache.ofbiz.entity.test.TestingNode;
import org.apache.ofbiz.entity.test.Testing;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TestingNodeAndMemberBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TestingNodeAndMemberBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TestingNodeAndMembers
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TestingNodeAndMember.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TestingNodeAndMembers
	 */
	public List<TestingNodeAndMember> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TestingNodeAndMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TestingNodeAndMember.NAME);
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
				entityList = TestingNodeAndMember.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TestingNodeAndMember
	 */
	public Optional<TestingNodeAndMember> findOne(Object testingNodeId,
			Object fromDate, Object testingId) {
		List<TestingNodeAndMember> entityList = null;
		In in = new In();
		in.setEntityName(TestingNodeAndMember.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("testingNodeId", EntityOperator.EQUALS,
						testingNodeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"testingId", EntityOperator.EQUALS, testingId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingNodeAndMember.fromValues(out.getListIt()
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
	 * Get testing node member
	 */
	public Optional<TestingNodeMember> getTestingNodeMember(
			TestingNodeAndMember testingNodeAndMember) {
		List<TestingNodeMember> entityList = null;
		In in = new In();
		in.setEntityName(TestingNodeMember.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("testingNodeId", EntityOperator.EQUALS,
						testingNodeAndMember.getTestingNodeId()),
				new EntityExpr("testingId", EntityOperator.EQUALS,
						testingNodeAndMember.getTestingId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						testingNodeAndMember.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingNodeMember.fromValues(out.getListIt()
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
	 * Get testing node
	 */
	public Optional<TestingNode> getTestingNode(
			TestingNodeAndMember testingNodeAndMember) {
		List<TestingNode> entityList = null;
		In in = new In();
		in.setEntityName(TestingNode.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("testingNodeId", EntityOperator.EQUALS,
						testingNodeAndMember.getTestingNodeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingNode.fromValues(out.getListIt()
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
	public Optional<Testing> getTesting(
			TestingNodeAndMember testingNodeAndMember) {
		List<Testing> entityList = null;
		In in = new In();
		in.setEntityName(Testing.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("testingId", EntityOperator.EQUALS,
						testingNodeAndMember.getTestingId())),
				EntityOperator.AND));
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