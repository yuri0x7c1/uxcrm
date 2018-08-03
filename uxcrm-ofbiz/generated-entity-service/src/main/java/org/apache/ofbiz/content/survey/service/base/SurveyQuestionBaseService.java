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
import org.apache.ofbiz.content.survey.SurveyQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.survey.SurveyQuestionType;
import org.apache.ofbiz.content.survey.SurveyQuestionCategory;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.content.survey.SurveyQuestionAppl;
import org.apache.ofbiz.content.survey.SurveyQuestionOption;
import org.apache.ofbiz.content.survey.SurveyResponseAnswer;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SurveyQuestionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SurveyQuestionBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SurveyQuestions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SurveyQuestion.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SurveyQuestions
	 */
	public List<SurveyQuestion> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SurveyQuestion> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyQuestion.NAME);
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
				entityList = SurveyQuestion.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SurveyQuestion
	 */
	public Optional<SurveyQuestion> findOne(Object surveyQuestionId) {
		List<SurveyQuestion> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestion.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyQuestionId)),
				EntityOperator.AND));
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
	 * Get survey question type
	 */
	public Optional<SurveyQuestionType> getSurveyQuestionType(
			SurveyQuestion surveyQuestion) {
		List<SurveyQuestionType> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionTypeId",
						EntityOperator.EQUALS, surveyQuestion
								.getSurveyQuestionTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionType.fromValues(out.getListIt()
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
	 * Get survey question category
	 */
	public Optional<SurveyQuestionCategory> getSurveyQuestionCategory(
			SurveyQuestion surveyQuestion) {
		List<SurveyQuestionCategory> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionCategoryId",
						EntityOperator.EQUALS, surveyQuestion
								.getSurveyQuestionCategoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionCategory.fromValues(out.getListIt()
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
	 * Get geo
	 */
	public Optional<Geo> getGeo(SurveyQuestion surveyQuestion) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						surveyQuestion.getGeoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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
	 * Get enumerations
	 */
	public List<Enumeration> getEnumerations(SurveyQuestion surveyQuestion,
			Integer start, Integer number, List<String> orderBy) {
		List<Enumeration> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumTypeId", EntityOperator.EQUALS,
						surveyQuestion.getEnumTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	public List<SurveyQuestionAppl> getSurveyQuestionAppls(
			SurveyQuestion surveyQuestion, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyQuestion
								.getSurveyQuestionId())), EntityOperator.AND));
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
	 * Get survey question options
	 */
	public List<SurveyQuestionOption> getSurveyQuestionOptions(
			SurveyQuestion surveyQuestion, Integer start, Integer number,
			List<String> orderBy) {
		List<SurveyQuestionOption> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyQuestionOption.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyQuestion
								.getSurveyQuestionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionOption.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey response answers
	 */
	public List<SurveyResponseAnswer> getSurveyResponseAnswers(
			SurveyQuestion surveyQuestion, Integer start, Integer number,
			List<String> orderBy) {
		List<SurveyResponseAnswer> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyResponseAnswer.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionId",
						EntityOperator.EQUALS, surveyQuestion
								.getSurveyQuestionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponseAnswer.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}