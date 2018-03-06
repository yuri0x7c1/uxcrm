package org.apache.ofbiz.common.portal.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page
 */
public class PortalPage implements Serializable {

	public static final long serialVersionUID = 144019908147258368L;
	public static final String NAME = "PortalPage";
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

	public enum Fields {
		portalPageId, portalPageName, description, ownerUserLoginId, originalPortalPageId, parentPortalPageId, sequenceNum, securityGroupId
	}

	public PortalPage(GenericValue value) {
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
	}

	public static PortalPage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPage(value);
	}

	public static List<PortalPage> fromValues(List<GenericValue> values) {
		List<PortalPage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPage(value));
		}
		return entities;
	}
}