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
import org.apache.ofbiz.content.survey.SurveyQuestionAndAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.survey.SurveyQuestionCategory;
import org.apache.ofbiz.content.survey.SurveyQuestionType;
import org.apache.ofbiz.content.survey.Survey;
import org.apache.ofbiz.content.survey.SurveyQuestionOption;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.content.survey.SurveyPage;
import org.apache.ofbiz.content.survey.SurveyMultiResp;
import org.apache.ofbiz.content.survey.SurveyMultiRespColumn;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SurveyQuestionAndApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SurveyQuestionAndApplBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SurveyQuestionAndAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SurveyQuestionAndAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SurveyQuestionAndAppls
	 */
	public List<SurveyQuestionAndAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SurveyQuestionAndAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyQuestionAndAppl.NAME);
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
				entityList = SurveyQuestionAndAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SurveyQuestionAndAppl
	 */
	public Optional<SurveyQuestionAndAppl> findOne(Object surveyQuestionId,
			Object surveyId, Object fromDate) {
		List<SurveyQuestionAndAppl> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionAndAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyQuestionId", EntityOperator.EQUALS,
						surveyQuestionId), new EntityExpr("surveyId",
						EntityOperator.EQUALS, surveyId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyQuestionAndAppl.fromValues(out.getListIt()
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
			SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<SurveyQuestionCategory> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionCategoryId",
						EntityOperator.EQUALS, surveyQuestionAndAppl
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
	 * Get survey question type
	 */
	public Optional<SurveyQuestionType> getSurveyQuestionType(
			SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<SurveyQuestionType> entityList = null;
		In in = new In();
		in.setEntityName(SurveyQuestionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyQuestionTypeId",
						EntityOperator.EQUALS, surveyQuestionAndAppl
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
	 * Get survey
	 */
	public Optional<Survey> getSurvey(
			SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<Survey> entityList = null;
		In in = new In();
		in.setEntityName(Survey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyId())),
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
	 * Get survey question options
	 */
	public List<SurveyQuestionOption> getSurveyQuestionOptions(
			SurveyQuestionAndAppl surveyQuestionAndAppl, Integer start,
			Integer number, List<String> orderBy) {
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
						EntityOperator.EQUALS, surveyQuestionAndAppl
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
	 * Get enumerations
	 */
	public List<Enumeration> getEnumerations(
			SurveyQuestionAndAppl surveyQuestionAndAppl, Integer start,
			Integer number, List<String> orderBy) {
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
						surveyQuestionAndAppl.getEnumTypeId())),
				EntityOperator.AND));
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
	 * Get geo
	 */
	public Optional<Geo> getGeo(SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getGeoId())), EntityOperator.AND));
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
	 * Get survey page
	 */
	public Optional<SurveyPage> getSurveyPage(
			SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<SurveyPage> entityList = null;
		In in = new In();
		in.setEntityName(SurveyPage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyId()), new EntityExpr(
						"surveyPageSeqId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyPageSeqId())),
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
			SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<SurveyMultiResp> entityList = null;
		In in = new In();
		in.setEntityName(SurveyMultiResp.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyId()), new EntityExpr(
						"surveyMultiRespId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyMultiRespId())),
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
			SurveyQuestionAndAppl surveyQuestionAndAppl) {
		List<SurveyMultiRespColumn> entityList = null;
		In in = new In();
		in.setEntityName(SurveyMultiRespColumn.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyId()), new EntityExpr(
						"surveyMultiRespId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyMultiRespId()),
				new EntityExpr("surveyMultiRespColId", EntityOperator.EQUALS,
						surveyQuestionAndAppl.getSurveyMultiRespColId())),
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