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
import org.apache.ofbiz.content.survey.SurveyQuestionAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.survey.Survey;
import org.apache.ofbiz.content.survey.SurveyQuestion;
import org.apache.ofbiz.content.survey.SurveyQuestionOption;
import org.apache.ofbiz.content.survey.SurveyPage;
import org.apache.ofbiz.content.survey.SurveyMultiResp;
import org.apache.ofbiz.content.survey.SurveyMultiRespColumn;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SurveyQuestionApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SurveyQuestionApplBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SurveyQuestionAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SurveyQuestionAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SurveyQuestionAppls
	 */
	public List<SurveyQuestionAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one SurveyQuestionAppl
	 */
	public Optional<SurveyQuestionAppl> findOne(Object surveyId,
			Object surveyQuestionId, Object fromDate) {
		List<SurveyQuestionAppl> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS, surveyId),
				new EntityExpr("surveyQuestionId", EntityOperator.EQUALS,
						surveyQuestionId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionAppl.fromValues(out.getListIt()
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
	 * Get survey
	 */
	public Optional<Survey> getSurvey(SurveyQuestionAppl surveyQuestionAppl) {
		List<Survey> entityList = null;
		In in = new In();
		in.setEntityName(Survey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyId())), EntityOperator.AND));
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
	 * Get survey question
	 */
	public Optional<SurveyQuestion> getSurveyQuestion(
			SurveyQuestionAppl surveyQuestionAppl) {
		List<SurveyQuestion> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestion.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyQuestionAppl
								.getSurveyQuestionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestion.fromValues(out.getListIt()
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
	 * Get with survey question option
	 */
	public Optional<SurveyQuestionOption> getWithSurveyQuestionOption(
			SurveyQuestionAppl surveyQuestionAppl) {
		List<SurveyQuestionOption> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyQuestionId", EntityOperator.EQUALS,
						surveyQuestionAppl.getWithSurveyQuestionId()),
				new EntityExpr("surveyOptionSeqId", EntityOperator.EQUALS,
						surveyQuestionAppl.getWithSurveyOptionSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionOption.fromValues(out.getListIt()
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
	 * Get survey page
	 */
	public Optional<SurveyPage> getSurveyPage(
			SurveyQuestionAppl surveyQuestionAppl) {
		List<SurveyPage> entityList = null;
		In in = new In();
		in.setEntityName(SurveyPage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyId()), new EntityExpr(
						"surveyPageSeqId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyPageSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyPage.fromValues(out.getListIt()
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
	 * Get survey multi resp
	 */
	public Optional<SurveyMultiResp> getSurveyMultiResp(
			SurveyQuestionAppl surveyQuestionAppl) {
		List<SurveyMultiResp> entityList = null;
		In in = new In();
		in.setEntityName(SurveyMultiResp.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyId()), new EntityExpr(
						"surveyMultiRespId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyMultiRespId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyMultiResp.fromValues(out.getListIt()
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
	 * Get survey multi resp column
	 */
	public Optional<SurveyMultiRespColumn> getSurveyMultiRespColumn(
			SurveyQuestionAppl surveyQuestionAppl) {
		List<SurveyMultiRespColumn> entityList = null;
		In in = new In();
		in.setEntityName(SurveyMultiRespColumn.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyId()), new EntityExpr(
						"surveyMultiRespId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyMultiRespId()),
				new EntityExpr("surveyMultiRespColId", EntityOperator.EQUALS,
						surveyQuestionAppl.getSurveyMultiRespColId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyMultiRespColumn.fromValues(out.getListIt()
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