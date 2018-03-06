package com.github.yuri0x7c1.uxerp.common.ui.component.search;

import org.vaadin.viritin.fields.MTextField;

import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;

public class TextSearchField extends AbstractSearchField {

	public TextSearchField(String fieldName) {
		super(fieldName);
	}

	@Override
	protected Component createValueField() {
		return new MTextField().withStyleName(ValoTheme.TEXTFIELD_TINY);
	}

	@Override
	public String getValueValue() {
		return ((MTextField) valueField).getValue();
	}

}
