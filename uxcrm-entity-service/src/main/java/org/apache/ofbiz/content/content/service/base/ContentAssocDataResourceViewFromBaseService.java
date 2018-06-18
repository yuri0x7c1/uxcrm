package org.apache.ofbiz.content.content.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.common.find.util.FindUtil;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.data.ElectronicText;
import org.apache.ofbiz.content.data.ImageDataResource;
import org.apache.ofbiz.content.data.OtherDataResource;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewTo;
import org.apache.ofbiz.content.content.ContentPurpose;
import org.apache.ofbiz.content.content.ContentAssoc;
import org.apache.ofbiz.content.content.ContentRole;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentAssocDataResourceViewFromBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentAssocDataResourceViewFromBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentAssocDataResourceViewFroms
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentAssocDataResourceViewFroms
	 */
	public List<ContentAssocDataResourceViewFrom> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ContentAssocDataResourceViewFrom> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocDataResourceViewFrom.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentAssocDataResourceViewFrom
	 */
	public ContentAssocDataResourceViewFrom findOne(Object contentIdStart,
			Object contentId, Object caContentIdTo, Object caContentId,
			Object caFromDate, Object caContentAssocTypeId,
			Object drDataResourceId) {
		List<ContentAssocDataResourceViewFrom> entityList = null;
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						contentIdStart), new EntityExpr("contentId",
						EntityOperator.EQUALS, contentId), new EntityExpr(
						"caContentIdTo", EntityOperator.EQUALS, caContentIdTo),
				new EntityExpr("caContentId", EntityOperator.EQUALS,
						caContentId), new EntityExpr("caFromDate",
						EntityOperator.EQUALS, caFromDate), new EntityExpr(
						"caContentAssocTypeId", EntityOperator.EQUALS,
						caContentAssocTypeId), new EntityExpr(
						"drDataResourceId", EntityOperator.EQUALS,
						drDataResourceId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocDataResourceViewFrom.fromValues(out
						.getListIt().getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get electronic text
	 */
	public ElectronicText getElectronicText(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom) {
		List<ElectronicText> entityList = null;
		In in = new In();
		in.setEntityName(ElectronicText.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("dataResourceId",
						EntityOperator.EQUALS, contentAssocDataResourceViewFrom
								.getDrDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ElectronicText.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get image data resource
	 */
	public ImageDataResource getImageDataResource(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom) {
		List<ImageDataResource> entityList = null;
		In in = new In();
		in.setEntityName(ImageDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("dataResourceId",
						EntityOperator.EQUALS, contentAssocDataResourceViewFrom
								.getDrDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ImageDataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get other data resource
	 */
	public OtherDataResource getOtherDataResource(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom) {
		List<OtherDataResource> entityList = null;
		In in = new In();
		in.setEntityName(OtherDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("dataResourceId",
						EntityOperator.EQUALS, contentAssocDataResourceViewFrom
								.getDrDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OtherDataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get content assoc data resource view froms
	 */
	public List<ContentAssocDataResourceViewFrom> getContentAssocDataResourceViewFroms(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewFrom> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						contentAssocDataResourceViewFrom.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocDataResourceViewFrom.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content assoc data resource view toes
	 */
	public List<ContentAssocDataResourceViewTo> getContentAssocDataResourceViewToes(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewTo> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewTo.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						contentAssocDataResourceViewFrom.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocDataResourceViewTo.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content purposes
	 */
	public List<ContentPurpose> getContentPurposes(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentPurpose> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentPurpose.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentAssocDataResourceViewFrom.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentPurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from content assocs
	 */
	public List<ContentAssoc> getFromContentAssocs(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentAssocDataResourceViewFrom.getContentId())),
				EntityOperator.AND));
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
	 * Get to content assocs
	 */
	public List<ContentAssoc> getToContentAssocs(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdTo", EntityOperator.EQUALS,
						contentAssocDataResourceViewFrom.getContentId())),
				EntityOperator.AND));
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
	 * Get content roles
	 */
	public List<ContentRole> getContentRoles(
			ContentAssocDataResourceViewFrom contentAssocDataResourceViewFrom,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentAssocDataResourceViewFrom.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}