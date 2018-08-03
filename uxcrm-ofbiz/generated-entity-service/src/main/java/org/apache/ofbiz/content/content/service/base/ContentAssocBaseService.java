package org.apache.ofbiz.content.content.service.base;

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
import org.apache.ofbiz.content.content.ContentAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentAssocType;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.content.content.ContentAssocPredicate;
import org.apache.ofbiz.common.datasource.DataSource;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentAssocBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentAssocs
	 */
	public List<ContentAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContentAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
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
				entityList = ContentAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentAssoc
	 */
	public Optional<ContentAssoc> findOne(Object contentId, Object contentIdTo,
			Object contentAssocTypeId, Object fromDate) {
		List<ContentAssoc> entityList = null;
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("contentIdTo", EntityOperator.EQUALS,
						contentIdTo), new EntityExpr("contentAssocTypeId",
						EntityOperator.EQUALS, contentAssocTypeId),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssoc.fromValues(out.getListIt()
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
	 * Get from content
	 */
	public Optional<Content> getFromContent(ContentAssoc contentAssoc) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentAssoc.getContentId())), EntityOperator.AND));
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
	 * Get to content
	 */
	public Optional<Content> getToContent(ContentAssoc contentAssoc) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentAssoc.getContentIdTo())), EntityOperator.AND));
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
	 * Get content assoc type
	 */
	public Optional<ContentAssocType> getContentAssocType(
			ContentAssoc contentAssoc) {
		List<ContentAssocType> entityList = null;
		In in = new In();
		in.setEntityName(ContentAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentAssocTypeId",
						EntityOperator.EQUALS, contentAssoc
								.getContentAssocTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocType.fromValues(out.getListIt()
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
	 * Get created by user login
	 */
	public Optional<UserLogin> getCreatedByUserLogin(ContentAssoc contentAssoc) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						contentAssoc.getCreatedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get last modified by user login
	 */
	public Optional<UserLogin> getLastModifiedByUserLogin(
			ContentAssoc contentAssoc) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						contentAssoc.getLastModifiedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get content assoc predicate
	 */
	public Optional<ContentAssocPredicate> getContentAssocPredicate(
			ContentAssoc contentAssoc) {
		List<ContentAssocPredicate> entityList = null;
		In in = new In();
		in.setEntityName(ContentAssocPredicate.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentAssocPredicateId",
						EntityOperator.EQUALS, contentAssoc
								.getContentAssocPredicateId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocPredicate.fromValues(out.getListIt()
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
	 * Get data source
	 */
	public Optional<DataSource> getDataSource(ContentAssoc contentAssoc) {
		List<DataSource> entityList = null;
		In in = new In();
		in.setEntityName(DataSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataSourceId", EntityOperator.EQUALS,
						contentAssoc.getDataSourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataSource.fromValues(out.getListIt()
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