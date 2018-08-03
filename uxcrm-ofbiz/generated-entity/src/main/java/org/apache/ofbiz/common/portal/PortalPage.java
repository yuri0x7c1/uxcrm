package org.apache.ofbiz.common.portal;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page
 */
public class PortalPage implements Serializable {

	public static final long serialVersionUID = 3686943321263643648L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;
	/**
	 * Help Content Id
	 */
	@Getter
	@Setter
	private String helpContentId;

	public enum Fields {
		portalPageId, portalPageName, description, ownerUserLoginId, originalPortalPageId, parentPortalPageId, sequenceNum, securityGroupId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, helpContentId
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		helpContentId = (String) value.get(Fields.helpContentId.name());
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