package org.apache.ofbiz.product.product.service.base;

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
import org.apache.ofbiz.product.product.GoodIdentificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.GoodIdentification;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GoodIdentificationTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GoodIdentificationTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GoodIdentificationTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GoodIdentificationType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GoodIdentificationTypes
	 */
	public List<GoodIdentificationType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GoodIdentificationType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GoodIdentificationType.NAME);
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
				entityList = GoodIdentificationType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GoodIdentificationType
	 */
	public Optional<GoodIdentificationType> findOne(
			Object goodIdentificationTypeId) {
		List<GoodIdentificationType> entityList = null;
		In in = new In();
		in.setEntityName(GoodIdentificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("goodIdentificationTypeId",
						EntityOperator.EQUALS, goodIdentificationTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GoodIdentificationType.fromValues(out.getListIt()
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
	 * Get parent good identification type
	 */
	public Optional<GoodIdentificationType> getParentGoodIdentificationType(
			GoodIdentificationType goodIdentificationType) {
		List<GoodIdentificationType> entityList = null;
		In in = new In();
		in.setEntityName(GoodIdentificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("goodIdentificationTypeId",
						EntityOperator.EQUALS, goodIdentificationType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GoodIdentificationType.fromValues(out.getListIt()
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
	 * Get good identifications
	 */
	public List<GoodIdentification> getGoodIdentifications(
			GoodIdentificationType goodIdentificationType, Integer start,
			Integer number, List<String> orderBy) {
		List<GoodIdentification> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GoodIdentification.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("goodIdentificationTypeId",
						EntityOperator.EQUALS, goodIdentificationType
								.getGoodIdentificationTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GoodIdentification.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child good identification types
	 */
	public List<GoodIdentificationType> getChildGoodIdentificationTypes(
			GoodIdentificationType goodIdentificationType, Integer start,
			Integer number, List<String> orderBy) {
		List<GoodIdentificationType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GoodIdentificationType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						goodIdentificationType.getGoodIdentificationTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GoodIdentificationType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}