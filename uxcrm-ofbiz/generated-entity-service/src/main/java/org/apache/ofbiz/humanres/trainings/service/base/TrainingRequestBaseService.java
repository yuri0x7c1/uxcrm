package org.apache.ofbiz.humanres.trainings.service.base;

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
import org.apache.ofbiz.humanres.trainings.TrainingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.ability.PersonTraining;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TrainingRequestBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TrainingRequestBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TrainingRequests
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TrainingRequest.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TrainingRequests
	 */
	public List<TrainingRequest> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TrainingRequest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrainingRequest.NAME);
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
				entityList = TrainingRequest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TrainingRequest
	 */
	public Optional<TrainingRequest> findOne(Object trainingRequestId) {
		List<TrainingRequest> entityList = null;
		In in = new In();
		in.setEntityName(TrainingRequest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("trainingRequestId",
						EntityOperator.EQUALS, trainingRequestId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrainingRequest.fromValues(out.getListIt()
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
	 * Get person trainings
	 */
	public List<PersonTraining> getPersonTrainings(
			TrainingRequest trainingRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<PersonTraining> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PersonTraining.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("trainingRequestId",
						EntityOperator.EQUALS, trainingRequest
								.getTrainingRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PersonTraining.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}