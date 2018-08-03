package org.apache.ofbiz.humanres.position.service.base;

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
import org.apache.ofbiz.humanres.position.EmplPositionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPosition;
import org.apache.ofbiz.humanres.position.EmplPositionTypeClass;
import org.apache.ofbiz.humanres.position.EmplPositionTypeRate;
import org.apache.ofbiz.humanres.position.OldEmplPositionTypeRate;
import org.apache.ofbiz.accounting.rate.RateAmount;
import org.apache.ofbiz.humanres.position.ValidResponsibility;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplPositionTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplPositionTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplPositionTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplPositionTypes
	 */
	public List<EmplPositionType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmplPositionType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
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
				entityList = EmplPositionType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmplPositionType
	 */
	public Optional<EmplPositionType> findOne(Object emplPositionTypeId) {
		List<EmplPositionType> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionType.fromValues(out.getListIt()
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
	 * Get parent empl position type
	 */
	public Optional<EmplPositionType> getParentEmplPositionType(
			EmplPositionType emplPositionType) {
		List<EmplPositionType> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionType.fromValues(out.getListIt()
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
	 * Get empl positions
	 */
	public List<EmplPosition> getEmplPositions(
			EmplPositionType emplPositionType, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPosition> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPosition.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child empl position types
	 */
	public List<EmplPositionType> getChildEmplPositionTypes(
			EmplPositionType emplPositionType, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						emplPositionType.getEmplPositionTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get empl position type classes
	 */
	public List<EmplPositionTypeClass> getEmplPositionTypeClasses(
			EmplPositionType emplPositionType, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionTypeClass> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionTypeClass.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionTypeClass.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get empl position type rates
	 */
	public List<EmplPositionTypeRate> getEmplPositionTypeRates(
			EmplPositionType emplPositionType, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionTypeRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionTypeRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionTypeRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old empl position type rates
	 */
	public List<OldEmplPositionTypeRate> getOldEmplPositionTypeRates(
			EmplPositionType emplPositionType, Integer start, Integer number,
			List<String> orderBy) {
		List<OldEmplPositionTypeRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldEmplPositionTypeRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldEmplPositionTypeRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get rate amounts
	 */
	public List<RateAmount> getRateAmounts(EmplPositionType emplPositionType,
			Integer start, Integer number, List<String> orderBy) {
		List<RateAmount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RateAmount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateAmount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get valid responsibilities
	 */
	public List<ValidResponsibility> getValidResponsibilities(
			EmplPositionType emplPositionType, Integer start, Integer number,
			List<String> orderBy) {
		List<ValidResponsibility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ValidResponsibility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPositionType
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ValidResponsibility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}