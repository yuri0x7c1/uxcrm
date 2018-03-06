package org.apache.ofbiz.common.portal.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portlet Attribute
 */
public class PortletAttribute implements Serializable {

	public static final long serialVersionUID = 7209567288570126336L;
	public static final String NAME = "PortletAttribute";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Portlet Seq Id
	 */
	@Getter
	@Setter
	private String portletSeqId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
	/**
	 * Attr Type
	 */
	@Getter
	@Setter
	private String attrType;

	public enum Fields {
		portalPageId, portalPortletId, portletSeqId, attrName, attrValue, attrDescription, attrType
	}

	public PortletAttribute(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		attrType = (String) value.get(Fields.attrType.name());
	}

	public static PortletAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortletAttribute(value);
	}

	public static List<PortletAttribute> fromValues(List<GenericValue> values) {
		List<PortletAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortletAttribute(value));
		}
		return entities;
	}
}