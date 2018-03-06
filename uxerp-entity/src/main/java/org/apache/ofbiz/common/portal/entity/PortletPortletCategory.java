package org.apache.ofbiz.common.portal.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portlet Portlet Category
 */
public class PortletPortletCategory implements Serializable {

	public static final long serialVersionUID = 6001095917598998528L;
	public static final String NAME = "PortletPortletCategory";
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Portlet Category Id
	 */
	@Getter
	@Setter
	private String portletCategoryId;

	public enum Fields {
		portalPortletId, portletCategoryId
	}

	public PortletPortletCategory(GenericValue value) {
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletCategoryId = (String) value.get(Fields.portletCategoryId.name());
	}

	public static PortletPortletCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortletPortletCategory(value);
	}

	public static List<PortletPortletCategory> fromValues(
			List<GenericValue> values) {
		List<PortletPortletCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortletPortletCategory(value));
		}
		return entities;
	}
}