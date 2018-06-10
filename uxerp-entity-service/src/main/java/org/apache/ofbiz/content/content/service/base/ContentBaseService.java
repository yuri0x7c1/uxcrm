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
import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import org.apache.ofbiz.content.content.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.ContentType;
import org.apache.ofbiz.content.data.DataResource;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.common.method.CustomMethod;
import org.apache.ofbiz.content.data.MimeType;
import org.apache.ofbiz.content.data.CharacterSet;
import org.apache.ofbiz.content.content.ContentTypeAttr;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.product.feature.ProductFeatureDataResource;
import org.apache.ofbiz.common.datasource.DataSource;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewFrom;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewTo;
import org.apache.ofbiz.party.agreement.AgreementContent;
import org.apache.ofbiz.party.communication.CommEventContentAssoc;
import org.apache.ofbiz.content.content.ContentApproval;
import org.apache.ofbiz.content.content.ContentAssoc;
import org.apache.ofbiz.content.content.ContentAttribute;
import org.apache.ofbiz.content.content.ContentKeyword;
import org.apache.ofbiz.content.content.ContentMetaData;
import org.apache.ofbiz.content.content.ContentPurpose;
import org.apache.ofbiz.content.content.ContentRevision;
import org.apache.ofbiz.content.content.ContentRole;
import org.apache.ofbiz.order.request.CustRequestContent;
import org.apache.ofbiz.product.facility.FacilityContent;
import org.apache.ofbiz.accounting.invoice.InvoiceContent;
import org.apache.ofbiz.order.order.OrderContent;
import org.apache.ofbiz.party.party.PartyContent;
import org.apache.ofbiz.humanres.ability.PartyResume;
import org.apache.ofbiz.accounting.payment.PaymentContent;
import org.apache.ofbiz.common.portal.PortalPage;
import org.apache.ofbiz.product.config.ProdConfItemContent;
import org.apache.ofbiz.product.category.ProductCategoryContent;
import org.apache.ofbiz.product.product.ProductContent;
import org.apache.ofbiz.product.promo.ProductPromoContent;
import org.apache.ofbiz.webapp.visit.ServerHit;
import org.apache.ofbiz.webapp.visit.ServerHitBin;
import org.apache.ofbiz.product.subscription.SubscriptionResource;
import org.apache.ofbiz.content.survey.SurveyResponseAnswer;
import org.apache.ofbiz.webapp.website.WebPage;
import org.apache.ofbiz.content.website.WebSiteContent;
import org.apache.ofbiz.content.website.WebSitePathAlias;
import org.apache.ofbiz.content.website.WebSitePublishPoint;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortContent;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Contents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Content.NAME);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Contents
	 */
	public List<Content> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Content> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Content
	 */
	public Content findOne(Object contentId) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentId)), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get content type
	 */
	public ContentType getContentType(Content content) {
		List<ContentType> entityList = null;
		In in = new In();
		in.setEntityName(ContentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentTypeId", EntityOperator.EQUALS,
						content.getContentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentType.fromValues(out.getListIt()
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
	 * Get data resource
	 */
	public DataResource getDataResource(Content content) {
		List<DataResource> entityList = null;
		In in = new In();
		in.setEntityName(DataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						content.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
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
	 * Get template data resource
	 */
	public DataResource getTemplateDataResource(Content content) {
		List<DataResource> entityList = null;
		In in = new In();
		in.setEntityName(DataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						content.getTemplateDataResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
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
	 * Get status item
	 */
	public StatusItem getStatusItem(Content content) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						content.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get privilege enumeration
	 */
	public Enumeration getPrivilegeEnumeration(Content content) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS, content
						.getPrivilegeEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	 * Get custom method
	 */
	public CustomMethod getCustomMethod(Content content) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						content.getCustomMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethod.fromValues(out.getListIt()
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
	 * Get mime type
	 */
	public MimeType getMimeType(Content content) {
		List<MimeType> entityList = null;
		In in = new In();
		in.setEntityName(MimeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("mimeTypeId", EntityOperator.EQUALS,
						content.getMimeTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MimeType.fromValues(out.getListIt()
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
	 * Get character set
	 */
	public CharacterSet getCharacterSet(Content content) {
		List<CharacterSet> entityList = null;
		In in = new In();
		in.setEntityName(CharacterSet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("characterSetId", EntityOperator.EQUALS,
						content.getCharacterSetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CharacterSet.fromValues(out.getListIt()
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
	 * Get content type attrs
	 */
	public List<ContentTypeAttr> getContentTypeAttrs(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentTypeAttr> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentTypeAttr.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentTypeId", EntityOperator.EQUALS,
						content.getContentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by user login
	 */
	public UserLogin getCreatedByUserLogin(Content content) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						content.getCreatedByUserLogin())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get last modified by user login
	 */
	public UserLogin getLastModifiedByUserLogin(Content content) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						content.getLastModifiedByUserLogin())),
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get product feature data resources
	 */
	public List<ProductFeatureDataResource> getProductFeatureDataResources(
			Content content, Integer start, Integer number, List<String> orderBy) {
		List<ProductFeatureDataResource> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductFeatureDataResource.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						content.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureDataResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data source
	 */
	public DataSource getDataSource(Content content) {
		List<DataSource> entityList = null;
		In in = new In();
		in.setEntityName(DataSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataSourceId", EntityOperator.EQUALS,
						content.getDataSourceId())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get decorator content
	 */
	public Content getDecoratorContent(Content content) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getDecoratorContentId())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get owner content
	 */
	public Content getOwnerContent(Content content) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getOwnerContentId())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get instance of content
	 */
	public Content getInstanceOfContent(Content content) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getInstanceOfContentId())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get content assoc data resource view froms
	 */
	public List<ContentAssocDataResourceViewFrom> getContentAssocDataResourceViewFroms(
			Content content, Integer start, Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewFrom> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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
			Content content, Integer start, Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewTo> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewTo.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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
	 * Get agreement contents
	 */
	public List<AgreementContent> getAgreementContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(AgreementContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from comm event content assocs
	 */
	public List<CommEventContentAssoc> getFromCommEventContentAssocs(
			Content content, Integer start, Integer number, List<String> orderBy) {
		List<CommEventContentAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CommEventContentAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommEventContentAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content approvals
	 */
	public List<ContentApproval> getContentApprovals(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentApproval> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentApproval.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentApproval.fromValues(out.getListIt()
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
	public List<ContentAssoc> getFromContentAssocs(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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
	public List<ContentAssoc> getToContentAssocs(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdTo", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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
	 * Get content attributes
	 */
	public List<ContentAttribute> getContentAttributes(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAttribute> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentAttribute.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content keywords
	 */
	public List<ContentKeyword> getContentKeywords(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentKeyword> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentKeyword.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentKeyword.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content meta datas
	 */
	public List<ContentMetaData> getContentMetaDatas(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentMetaData> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentMetaData.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentMetaData.fromValues(out.getListIt()
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
	public List<ContentPurpose> getContentPurposes(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentPurpose> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentPurpose.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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
	 * Get content revisions
	 */
	public List<ContentRevision> getContentRevisions(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentRevision> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentRevision.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRevision.fromValues(out.getListIt()
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
	public List<ContentRole> getContentRoles(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<ContentRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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

	/**
	 * Get cust request contents
	 */
	public List<CustRequestContent> getCustRequestContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CustRequestContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility contents
	 */
	public List<FacilityContent> getFacilityContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<FacilityContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FacilityContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice contents
	 */
	public List<InvoiceContent> getInvoiceContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order contents
	 */
	public List<OrderContent> getOrderContents(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(OrderContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party contents
	 */
	public List<PartyContent> getPartyContents(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party resumes
	 */
	public List<PartyResume> getPartyResumes(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyResume> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyResume.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyResume.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment contents
	 */
	public List<PaymentContent> getPaymentContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<PaymentContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PaymentContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get portal pages
	 */
	public List<PortalPage> getPortalPages(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<PortalPage> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("helpContentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get prod conf item contents
	 */
	public List<ProdConfItemContent> getProdConfItemContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ProdConfItemContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProdConfItemContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdConfItemContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category contents
	 */
	public List<ProductCategoryContent> getProductCategoryContents(
			Content content, Integer start, Integer number, List<String> orderBy) {
		List<ProductCategoryContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductCategoryContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product contents
	 */
	public List<ProductContent> getProductContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promo contents
	 */
	public List<ProductPromoContent> getProductPromoContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductPromoContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductPromoContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get server hits
	 */
	public List<ServerHit> getServerHits(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<ServerHit> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ServerHit.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("internalContentId",
						EntityOperator.EQUALS, content.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ServerHit.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get server hit bins
	 */
	public List<ServerHitBin> getServerHitBins(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<ServerHitBin> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ServerHitBin.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("internalContentId",
						EntityOperator.EQUALS, content.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ServerHitBin.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get subscription resources
	 */
	public List<SubscriptionResource> getSubscriptionResources(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<SubscriptionResource> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SubscriptionResource.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionResource.fromValues(out.getListIt()
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
	public List<SurveyResponseAnswer> getSurveyResponseAnswers(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<SurveyResponseAnswer> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SurveyResponseAnswer.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
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

	/**
	 * Get web pages
	 */
	public List<WebPage> getWebPages(Content content, Integer start,
			Integer number, List<String> orderBy) {
		List<WebPage> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WebPage.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebPage.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site contents
	 */
	public List<WebSiteContent> getWebSiteContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSiteContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WebSiteContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site path aliases
	 */
	public List<WebSitePathAlias> getWebSitePathAliases(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSitePathAlias> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WebSitePathAlias.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSitePathAlias.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site publish point
	 */
	public WebSitePublishPoint getWebSitePublishPoint(Content content) {
		List<WebSitePublishPoint> entityList = null;
		In in = new In();
		in.setEntityName(WebSitePublishPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSitePublishPoint.fromValues(out.getListIt()
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
	 * Get work effort contents
	 */
	public List<WorkEffortContent> getWorkEffortContents(Content content,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffortContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WorkEffortContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						content.getContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}