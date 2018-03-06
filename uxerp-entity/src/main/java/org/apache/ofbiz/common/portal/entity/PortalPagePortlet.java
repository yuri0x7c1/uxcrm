package org.apache.ofbiz.common.portal.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page Portlet
 */
public class PortalPagePortlet implements Serializable {

	public static final long serialVersionUID = 6744720910595020800L;
	public static final String NAME = "PortalPagePortlet";
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
	 * Column Seq Id
	 */
	@Getter
	@Setter
	private String columnSeqId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		portalPageId, portalPortletId, portletSeqId, columnSeqId, sequenceNum
	}

	public PortalPagePortlet(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		columnSeqId = (String) value.get(Fields.columnSeqId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static PortalPagePortlet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPagePortlet(value);
	}

	public static List<PortalPagePortlet> fromValues(List<GenericValue> values) {
		List<PortalPagePortlet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPagePortlet(value));
		}
		return entities;
	}
}