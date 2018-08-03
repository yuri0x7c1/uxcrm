package org.apache.ofbiz.party.communication.service.base;

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
import org.apache.ofbiz.party.communication.CommEventContentDataResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.data.ElectronicText;
import org.apache.ofbiz.party.communication.CommunicationEvent;
import org.apache.ofbiz.content.data.ImageDataResource;
import org.apache.ofbiz.content.data.OtherDataResource;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewFrom;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewTo;
import org.apache.ofbiz.content.content.ContentAssoc;
import org.apache.ofbiz.content.content.ContentPurpose;
import org.apache.ofbiz.content.content.ContentRole;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CommEventContentDataResourceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CommEventContentDataResourceBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CommEventContentDataResources
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CommEventContentDataResource.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CommEventContentDataResources
	 */
	public List<CommEventContentDataResource> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<CommEventContentDataResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommEventContentDataResource.NAME);
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
				entityList = CommEventContentDataResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CommEventContentDataResource
	 */
	public Optional<CommEventContentDataResource> findOne(Object fromDate,
			Object contentId, Object communicationEventId,
			Object drDataResourceId) {
		List<CommEventContentDataResource> entityList = null;
		In in = new In();
		in.setEntityName(CommEventContentDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate),
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("communicationEventId", EntityOperator.EQUALS,
						communicationEventId), new EntityExpr(
						"drDataResourceId", EntityOperator.EQUALS,
						drDataResourceId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommEventContentDataResource.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get electronic text
	 */
	public Optional<ElectronicText> getElectronicText(
			CommEventContentDataResource commEventContentDataResource) {
		List<ElectronicText> entityList = null;
		In in = new In();
		in.setEntityName(ElectronicText.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						commEventContentDataResource.getDataResourceId())),
				EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get communication event
	 */
	public Optional<CommunicationEvent> getCommunicationEvent(
			CommEventContentDataResource commEventContentDataResource) {
		List<CommunicationEvent> entityList = null;
		In in = new In();
		in.setEntityName(CommunicationEvent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("communicationEventId",
						EntityOperator.EQUALS, commEventContentDataResource
								.getCommunicationEventId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEvent.fromValues(out.getListIt()
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
	 * Get image data resource
	 */
	public Optional<ImageDataResource> getImageDataResource(
			CommEventContentDataResource commEventContentDataResource) {
		List<ImageDataResource> entityList = null;
		In in = new In();
		in.setEntityName(ImageDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						commEventContentDataResource.getDataResourceId())),
				EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get other data resource
	 */
	public Optional<OtherDataResource> getOtherDataResource(
			CommEventContentDataResource commEventContentDataResource) {
		List<OtherDataResource> entityList = null;
		In in = new In();
		in.setEntityName(OtherDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						commEventContentDataResource.getDataResourceId())),
				EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get content assoc data resource view froms
	 */
	public List<ContentAssocDataResourceViewFrom> getContentAssocDataResourceViewFroms(
			CommEventContentDataResource commEventContentDataResource,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewFrom> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						commEventContentDataResource.getContentId())),
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
			CommEventContentDataResource commEventContentDataResource,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewTo> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewTo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						commEventContentDataResource.getContentId())),
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
	 * Get from content assocs
	 */
	public List<ContentAssoc> getFromContentAssocs(
			CommEventContentDataResource commEventContentDataResource,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						commEventContentDataResource.getContentId())),
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
			CommEventContentDataResource commEventContentDataResource,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdTo", EntityOperator.EQUALS,
						commEventContentDataResource.getContentId())),
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
	 * Get content purposes
	 */
	public List<ContentPurpose> getContentPurposes(
			CommEventContentDataResource commEventContentDataResource,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentPurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentPurpose.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						commEventContentDataResource.getContentId())),
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
	 * Get content roles
	 */
	public List<ContentRole> getContentRoles(
			CommEventContentDataResource commEventContentDataResource,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						commEventContentDataResource.getContentId())),
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