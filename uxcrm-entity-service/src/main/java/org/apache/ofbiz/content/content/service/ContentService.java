package org.apache.ofbiz.content.content.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentAssoc;
import org.apache.ofbiz.content.content.service.base.ContentBaseService;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ContentService extends ContentBaseService {
	private ContentAssocService contentAssocService;

	@Autowired
	public ContentService(ExecuteFindService executeFindService, ContentAssocService contentAssocService) {
		super(executeFindService);
		this.contentAssocService = contentAssocService;
	}

	public List<Content> getSubContents(Content content) {
		List<ContentAssoc> contentAssociations = contentAssocService.find(
			0, 100, null,
			new EntityConditionList<EntityCondition>(
					Arrays.asList(new EntityExpr(ContentAssoc.Fields.contentId, EntityOperator.EQUALS, content.getContentId())),
					EntityOperator.AND
			)
		);
		log.debug("!!!content associations: {}", contentAssociations);

		List<Content> subContents = new ArrayList<>();
		for (ContentAssoc contentAssoc : contentAssociations) {
		    Content toContent = contentAssocService.getToContent(contentAssoc);
		    subContents.add(toContent);
		}
		log.debug("!!! sub contents {}", subContents);

		return subContents;
	}
}
