package org.apache.ofbiz.marketing.contact.service.base;

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
import org.apache.ofbiz.marketing.contact.WebSiteContactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.marketing.contact.ContactList;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WebSiteContactListBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WebSiteContactListBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WebSiteContactLists
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WebSiteContactList.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WebSiteContactLists
	 */
	public List<WebSiteContactList> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WebSiteContactList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSiteContactList.NAME);
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
				entityList = WebSiteContactList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WebSiteContactList
	 */
	public Optional<WebSiteContactList> findOne(Object webSiteId,
			Object contactListId, Object fromDate) {
		List<WebSiteContactList> entityList = null;
		In in = new In();
		in.setEntityName(WebSiteContactList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("webSiteId", EntityOperator.EQUALS, webSiteId),
				new EntityExpr("contactListId", EntityOperator.EQUALS,
						contactListId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteContactList.fromValues(out.getListIt()
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
	 * Get web site
	 */
	public Optional<WebSite> getWebSite(WebSiteContactList webSiteContactList) {
		List<WebSite> entityList = null;
		In in = new In();
		in.setEntityName(WebSite.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSiteContactList.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSite.fromValues(out.getListIt()
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
	 * Get contact list
	 */
	public Optional<ContactList> getContactList(
			WebSiteContactList webSiteContactList) {
		List<ContactList> entityList = null;
		In in = new In();
		in.setEntityName(ContactList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactListId", EntityOperator.EQUALS,
						webSiteContactList.getContactListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactList.fromValues(out.getListIt()
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