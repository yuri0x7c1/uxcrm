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
import org.apache.ofbiz.entity.test.TestingNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.test.TestingNodeMember;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TestingNodeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TestingNodeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TestingNodes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TestingNode.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TestingNodes
	 */
	public List<TestingNode> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TestingNode> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TestingNode.NAME);
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
				entityList = TestingNode.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TestingNode
	 */
	public Optional<TestingNode> findOne(Object testingNodeId) {
		List<TestingNode> entityList = null;
		In in = new In();
		in.setEntityName(TestingNode.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("testingNodeId", EntityOperator.EQUALS,
						testingNodeId)), EntityOperator.AND));
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
	 * Get primary parent testing node
	 */
	public Optional<TestingNode> getPrimaryParentTestingNode(
			TestingNode testingNode) {
		List<TestingNode> entityList = null;
		In in = new In();
		in.setEntityName(TestingNode.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("testingNodeId", EntityOperator.EQUALS,
						testingNode.getPrimaryParentNodeId())),
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
	 * Get primary child testing nodes
	 */
	public List<TestingNode> getPrimaryChildTestingNodes(
			TestingNode testingNode, Integer start, Integer number,
			List<String> orderBy) {
		List<TestingNode> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TestingNode.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("primaryParentNodeId",
						EntityOperator.EQUALS, testingNode.getTestingNodeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingNode.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get testing node members
	 */
	public List<TestingNodeMember> getTestingNodeMembers(
			TestingNode testingNode, Integer start, Integer number,
			List<String> orderBy) {
		List<TestingNodeMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TestingNodeMember.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("testingNodeId", EntityOperator.EQUALS,
						testingNode.getTestingNodeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingNodeMember.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}