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
import org.apache.ofbiz.content.survey.SurveyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.survey.Survey;
import org.apache.ofbiz.content.survey.SurveyQuestionAppl;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SurveyPageBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SurveyPageBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SurveyPages
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SurveyPage.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SurveyPages
	 */
	public List<SurveyPage> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one SurveyPage
	 */
	public Optional<SurveyPage> findOne(Object surveyId, Object surveyPageSeqId) {
		List<SurveyPage> entityList = null;
		In in = new In();
		in.setEntityName(SurveyPage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("surveyId", EntityOperator.EQUALS, surveyId),
				new EntityExpr("surveyPageSeqId", EntityOperator.EQUALS,
						surveyPageSeqId)), EntityOperator.AND));
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
	 * Get survey
	 */
	public Optional<Survey> getSurvey(SurveyPage surveyPage) {
		List<Survey> entityList = null;
		In in = new In();
		in.setEntityName(Survey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						surveyPage.getSurveyId())), EntityOperator.AND));
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
	 * Get survey question appls
	 */
	public List<SurveyQuestionAppl> getSurveyQuestionAppls(
			SurveyPage surveyPage, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("surveyId", EntityOperator.EQUALS,
								surveyPage.getSurveyId()),
						new EntityExpr("surveyPageSeqId",
								EntityOperator.EQUALS, surveyPage
										.getSurveyPageSeqId())),
				EntityOperator.AND));
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
}