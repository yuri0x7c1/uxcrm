package org.apache.ofbiz.common.portal.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page And Portlet
 */
public class PortalPageAndPortlet implements Serializable {

	public static final long serialVersionUID = 3379215348995675136L;
	public static final String NAME = "PortalPageAndPortlet";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Portal Page Name
	 */
	@Getter
	@Setter
	private String portalPageName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Owner User Login Id
	 */
	@Getter
	@Setter
	private String ownerUserLoginId;
	/**
	 * Original Portal Page Id
	 */
	@Getter
	@Setter
	private String originalPortalPageId;
	/**
	 * Parent Portal Page Id
	 */
	@Getter
	@Setter
	private String parentPortalPageId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Security Group Id
	 */
	@Getter
	@Setter
	private String securityGroupId;
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

	public enum Fields {
		portalPageId, portalPageName, description, ownerUserLoginId, originalPortalPageId, parentPortalPageId, sequenceNum, securityGroupId, portalPortletId, portletSeqId, columnSeqId
	}

	public PortalPageAndPortlet(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		portalPageName = (String) value.get(Fields.portalPageName.name());
		description = (String) value.get(Fields.description.name());
		ownerUserLoginId = (String) value.get(Fields.ownerUserLoginId.name());
		originalPortalPageId = (String) value.get(Fields.originalPortalPageId
				.name());
		parentPortalPageId = (String) value.get(Fields.parentPortalPageId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		columnSeqId = (String) value.get(Fields.columnSeqId.name());
	}

	public static PortalPageAndPortlet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPageAndPortlet(value);
	}

	public static List<PortalPageAndPortlet> fromValues(
			List<GenericValue> values) {
		List<PortalPageAndPortlet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPageAndPortlet(value));
		}
		return entities;
	}
}