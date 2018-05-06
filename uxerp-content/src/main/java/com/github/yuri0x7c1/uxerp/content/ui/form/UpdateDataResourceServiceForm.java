package com.github.yuri0x7c1.uxerp.content.ui.form;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.data.entity.DataResource;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringComponent
public class UpdateDataResourceServiceForm extends AbstractForm<DataResource> {

	MTextField dataResourceTypeId = new MTextField();

	MTextField dataTemplateTypeId = new MTextField();
	MTextField dataSourceId = new MTextField();
	MTextField statusId = new MTextField();
	MTextField dataResourceName = new MTextField();


	MTextField localeString = new MTextField();


	MTextField mimeTypeId = new MTextField();


	MTextField characterSetId = new MTextField();


	MTextField objectInfoField = new MTextField();


	MTextField surveyId = new MTextField();


	MTextField surveyResponseId = new MTextField();


	MTextField relatedDetailId = new MTextField();


	MTextField isPublic = new MTextField();

	MTextField dataResourceId = new MTextField("dataResourceId");

	public UpdateDataResourceServiceForm() {
		super(DataResource.class);
	}

	@PostConstruct
	private void init() {

	}

	@Override
	public void setEntity(DataResource entity) {
		log.debug("set entity : {}", entity);
		super.setEntity(entity);
	}

	@Override
    protected Component createContent() {
        return new MVerticalLayout(
            new MFormLayout(
        		dataResourceTypeId,
        		dataTemplateTypeId,
        		dataSourceId,
        		statusId,
        		dataResourceName,
        		localeString,
        		mimeTypeId,
        		characterSetId,
        		objectInfoField,
        		surveyId,
        		surveyResponseId,
        		relatedDetailId,
        		isPublic,
        		dataResourceId
            ).withWidth(""),
            getToolbar()
        ).withWidth("");
	}
}