package com.github.yuri0x7c1.uxerp.common.ui.component.search;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.layouts.MFormLayout;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class CommonSearchForm<T> extends MFormLayout {

	protected final List<AbstractSearchField> searchFields = new ArrayList<>();

	protected final MButton searchButton = new MButton("Search")
			.withStyleName(ValoTheme.BUTTON_PRIMARY);

	public CommonSearchForm(Class<T> beanType, I18N i18n, String... fieldNames)  {

		setMargin(false);

		try {
			for (String fieldName : fieldNames) {
				Field field = beanType.getDeclaredField(fieldName);
				if ((String.class).equals(field.getType())) {
					AbstractSearchField f = new TextSearchField(fieldName);
					searchFields.add(f);
					addComponent(f);
				}
			}
			addComponent(searchButton);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readInputFields(Map<String, Object> inputFields) {
		for (AbstractSearchField searchField : searchFields) {
			inputFields.put(searchField.getOptionKey(), searchField.getOptionValue());
			inputFields.put(searchField.getIgnoreCaseKey(), searchField.getIgnoreCaseValue());
			inputFields.put(searchField.getValueKey(), searchField.getValueValue());
		}
	}

	public CommonSearchForm<T> addClickListener(ClickListener listener) {
		searchButton.addClickListener(listener);
		return this;
	}
}
