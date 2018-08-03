package org.apache.ofbiz.content.survey.service.base;

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
import org.apache.ofbiz.content.survey.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.data.DataResource;
import org.apache.ofbiz.product.store.ProductStoreFinActSetting;
import org.apache.ofbiz.product.store.ProductStoreSurveyAppl;
import org.apache.ofbiz.content.survey.SurveyMultiResp;
import org.apache.ofbiz.content.survey.SurveyPage;
import org.apache.ofbiz.content.survey.SurveyQuestionAppl;
import org.apache.ofbiz.content.survey.SurveyResponse;
import org.apache.ofbiz.content.survey.SurveyTrigger;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortSurveyAppl;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SurveyBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SurveyBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Surveys
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Survey.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Surveys
	 */
	public List<Survey> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Survey> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Survey.NAME);
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
				entityList = Survey.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Survey
	 */
	public Optional<Survey> findOne(Object surveyId) {
		List<Survey> entityList = null;
		In in = new In();
		in.setEntityName(Survey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Survey.fromValues(out.getListIt()
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
	 * Get data resources
	 */
	public List<DataResource> getDataResources(Survey survey, Integer start,
			Integer number, List<String> orderBy) {
		List<DataResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store fin act settings
	 */
	public List<ProductStoreFinActSetting> getProductStoreFinActSettings(
			Survey survey, Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreFinActSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreFinActSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("purchaseSurveyId",
						EntityOperator.EQUALS, survey.getSurveyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreFinActSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store survey appls
	 */
	public List<ProductStoreSurveyAppl> getProductStoreSurveyAppls(
			Survey survey, Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreSurveyAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreSurveyAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreSurveyAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey multi resps
	 */
	public List<SurveyMultiResp> getSurveyMultiResps(Survey survey,
			Integer start, Integer number, List<String> orderBy) {
		List<SurveyMultiResp> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyMultiResp.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyMultiResp.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey pages
	 */
	public List<SurveyPage> getSurveyPages(Survey survey, Integer start,
			Integer number, List<String> orderBy) {
		List<SurveyPage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyPage.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyPage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey question appls
	 */
	public List<SurveyQuestionAppl> getSurveyQuestionAppls(Survey survey,
			Integer start, Integer number, List<String> orderBy) {
		List<SurveyQuestionAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyQuestionAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey responses
	 */
	public List<SurveyResponse> getSurveyResponses(Survey survey,
			Integer start, Integer number, List<String> orderBy) {
		List<SurveyResponse> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyResponse.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey triggers
	 */
	public List<SurveyTrigger> getSurveyTriggers(Survey survey, Integer start,
			Integer number, List<String> orderBy) {
		List<SurveyTrigger> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyTrigger.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyTrigger.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort survey appls
	 */
	public List<WorkEffortSurveyAppl> getWorkEffortSurveyAppls(Survey survey,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffortSurveyAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortSurveyAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						survey.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortSurveyAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}