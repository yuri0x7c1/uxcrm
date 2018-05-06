package com.github.yuri0x7c1.uxerp.content.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ofbiz.common.service.PerformFindItemService;
import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.content.content.entity.Content;
import org.apache.ofbiz.content.content.entity.ContentAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.github.yuri0x7c1.uxerp.common.find.util.InputFieldBuilder;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Slf4j
@Component
public class ContentService {
    private final PerformFindListService performFindListService;

    private final PerformFindItemService performFindItemService;

    private final ContentBaseService contentBaseService;

    private final ContentAssocBaseService contentAssocBaseService;

    @Autowired
    public ContentService(PerformFindListService performFindListService, PerformFindItemService performFindItemService,
            ContentBaseService contentBaseService,
            ContentAssocBaseService contentAssocBaseService) {
        super();
        this.performFindListService = performFindListService;
        this.performFindItemService = performFindItemService;
        this.contentBaseService = contentBaseService;
        this.contentAssocBaseService = contentAssocBaseService;
    }

    public List<Content> getSubContents(Content content) {
        // get content associations
        List<ContentAssoc> contentAssociations = contentAssocBaseService.find(
                null, null, null,
                new InputFieldBuilder()
                    .addInputField(ContentAssoc.Fields.contentId.name(), FindUtil.OPTION_EQUALS, false, content.getContentId())
                    .build()
        );
        log.debug("!!!content associations: {}", contentAssociations);


        List<Content> subContents = new ArrayList<>();
        for (ContentAssoc contentAssoc : contentAssociations) {
            Content toContent = contentAssocBaseService.getToContent(contentAssoc);
            subContents.add(toContent);
        }
        log.debug("!!! sub contents {}", subContents);

        return subContents;
    }

}
