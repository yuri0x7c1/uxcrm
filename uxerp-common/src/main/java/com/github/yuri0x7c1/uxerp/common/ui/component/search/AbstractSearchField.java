package com.github.yuri0x7c1.uxerp.common.ui.component.search;

import org.vaadin.viritin.fields.EnumSelect;
import org.vaadin.viritin.fields.MCheckBox;
import org.vaadin.viritin.label.MLabel;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

import lombok.Getter;

public abstract class AbstractSearchField extends HorizontalLayout {
	@Getter
	protected final String fieldName;

	protected final MLabel label = new MLabel();
	protected final EnumSelect<SearchFieldOption> optionField = new EnumSelect<>(SearchFieldOption.class)
			.withStyleName(ValoTheme.COMBOBOX_TINY);
	protected final Component valueField;
	protected final MCheckBox ignoreCaseField = new MCheckBox("Ignore Case")
			.withEnabled(true)
			.withStyleName(ValoTheme.LABEL_TINY);

	public AbstractSearchField(String fieldName) {
		this.fieldName = fieldName;

		label.setCaption(fieldName);

		optionField.setEmptySelectionAllowed(false);
		optionField.setSelectedItem(SearchFieldOption.CONTAINS);
		valueField = createValueField();

		addComponent(label);
		addComponent(optionField);
		addComponent(valueField);
		addComponent(ignoreCaseField);
	}

	protected abstract Component createValueField();

	public String getOptionKey() {
		return FindUtil.getFieldOptionKey(fieldName) ;
	}

	public String getOptionValue() {
		return optionField.getValue().getOptionName();
	}

	public String getIgnoreCaseKey() {
		return FindUtil.getFieldIgnoreCaseKey(fieldName);
	}

	public String getIgnoreCaseValue() {
		return ignoreCaseField.getValue() ? FindUtil.Y : FindUtil.N;
	}

	public String getValueKey() {
		return fieldName;
	}

	public abstract String getValueValue();
}
