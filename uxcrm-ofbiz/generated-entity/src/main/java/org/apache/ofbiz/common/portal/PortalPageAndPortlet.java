package org.apache.ofbiz.common.portal;

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

	public static final long serialVersionUID = 8081251985075668992L;
	public static final String NAME = "PortalPageAndPortlet";
	/**
	 * Portlet Sequence Num
	 */
	@Getter
	@Setter
	private Long portletSequenceNum;
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
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
	 * Help Content Id
	 */
	@Getter
	@Setter
	private String helpContentId;
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
	 * Security Group Id
	 */
	@Getter
	@Setter
	private String securityGroupId;
	/**
	 * Portal Page Name
	 */
	@Getter
	@Setter
	private String portalPageName;
	/**
	 * Portlet Seq Id
	 */
	@Getter
	@Setter
	private String portletSeqId;
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Column Seq Id
	 */
	@Getter
	@Setter
	private String columnSeqId;

	public enum Fields {
		portletSequenceNum, portalPageId, originalPortalPageId, parentPortalPageId, sequenceNum, helpContentId, description, ownerUserLoginId, securityGroupId, portalPageName, portletSeqId, portalPortletId, columnSeqId
	}

	public PortalPageAndPortlet(GenericValue value) {
		portletSequenceNum = (Long) value.get(Fields.portletSequenceNum.name());
		portalPageId = (String) value.get(Fields.portalPageId.name());
		originalPortalPageId = (String) value.get(Fields.originalPortalPageId
				.name());
		parentPortalPageId = (String) value.get(Fields.parentPortalPageId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		helpContentId = (String) value.get(Fields.helpContentId.name());
		description = (String) value.get(Fields.description.name());
		ownerUserLoginId = (String) value.get(Fields.ownerUserLoginId.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		portalPageName = (String) value.get(Fields.portalPageName.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
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