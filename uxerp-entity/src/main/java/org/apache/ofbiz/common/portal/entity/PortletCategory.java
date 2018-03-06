package org.apache.ofbiz.common.portal.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portlet Category
 */
public class PortletCategory implements Serializable {

	public static final long serialVersionUID = 188519374458762240L;
	public static final String NAME = "PortletCategory";
	/**
	 * Portlet Category Id
	 */
	@Getter
	@Setter
	private String portletCategoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		portletCategoryId, description
	}

	public PortletCategory(GenericValue value) {
		portletCategoryId = (String) value.get(Fields.portletCategoryId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PortletCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortletCategory(value);
	}

	public static List<PortletCategory> fromValues(List<GenericValue> values) {
		List<PortletCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortletCategory(value));
		}
		return entities;
	}
}