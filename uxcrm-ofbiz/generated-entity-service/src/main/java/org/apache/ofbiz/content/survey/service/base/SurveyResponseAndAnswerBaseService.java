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
import org.apache.ofbiz.content.survey.SurveyResponseAndAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.survey.Survey;
import org.apache.ofbiz.content.survey.SurveyQuestion;
import org.apache.ofbiz.content.survey.SurveyQuestionOption;
import org.apache.ofbiz.content.survey.SurveyResponse;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.survey.SurveyMultiRespColumn;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SurveyResponseAndAnswerBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SurveyResponseAndAnswerBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SurveyResponseAndAnswers
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SurveyResponseAndAnswer.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SurveyResponseAndAnswers
	 */
	public List<SurveyResponseAndAnswer> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SurveyResponseAndAnswer> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyResponseAndAnswer.NAME);
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
				entityList = SurveyResponseAndAnswer.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SurveyResponseAndAnswer
	 */
	public Optional<SurveyResponseAndAnswer> findOne(Object surveyResponseId,
			Object surveyQuestionId, Object surveyMultiRespColId) {
		List<SurveyResponseAndAnswer> entityList = null;
		In in = new In();
		in.setEntityName(SurveyResponseAndAnswer.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyResponseId", EntityOperator.EQUALS,
						surveyResponseId), new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyQuestionId),
				new EntityExpr("surveyMultiRespColId", EntityOperator.EQUALS,
						surveyMultiRespColId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponseAndAnswer.fromValues(out.getListIt()
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
	public Optional<Survey> getSurvey(
			SurveyResponseAndAnswer surveyResponseAndAnswer) {
		List<Survey> entityList = null;
		In in = new In();
		in.setEntityName(Survey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getSurveyId())),
				EntityOperator.AND));
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
			SurveyResponseAndAnswer surveyResponseAndAnswer) {
		List<SurveyQuestion> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestion.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyResponseAndAnswer
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
	 * Get survey question option
	 */
	public Optional<SurveyQuestionOption> getSurveyQuestionOption(
			SurveyResponseAndAnswer surveyResponseAndAnswer) {
		List<SurveyQuestionOption> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyQuestionId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getSurveyQuestionId()),
				new EntityExpr("surveyOptionSeqId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getSurveyOptionSeqId())),
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
	 * Get survey response
	 */
	public Optional<SurveyResponse> getSurveyResponse(
			SurveyResponseAndAnswer surveyResponseAndAnswer) {
		List<SurveyResponse> entityList = null;
		In in = new In();
		in.setEntityName(SurveyResponse.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyResponseId",
						EntityOperator.EQUALS, surveyResponseAndAnswer
								.getSurveyResponseId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponse.fromValues(out.getListIt()
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
	 * Get content
	 */
	public Optional<Content> getContent(
			SurveyResponseAndAnswer surveyResponseAndAnswer) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt()
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
			SurveyResponseAndAnswer surveyResponseAndAnswer) {
		List<SurveyMultiRespColumn> entityList = null;
		In in = new In();
		in.setEntityName(SurveyMultiRespColumn.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getSurveyId()), new EntityExpr(
						"surveyMultiRespId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getSurveyMultiRespId()),
				new EntityExpr("surveyMultiRespColId", EntityOperator.EQUALS,
						surveyResponseAndAnswer.getSurveyMultiRespColId())),
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