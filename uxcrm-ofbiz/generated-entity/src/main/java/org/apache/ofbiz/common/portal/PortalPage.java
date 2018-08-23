package org.apache.ofbiz.common.portal;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PortalPage implements Serializable {

	public static final long serialVersionUID = 3881170186881098752L;
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

	public PortalPage(GenericValue value) {
		portalPageId = (String) value.get(FIELD_PORTAL_PAGE_ID);
		portalPageName = (String) value.get(FIELD_PORTAL_PAGE_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		ownerUserLoginId = (String) value.get(FIELD_OWNER_USER_LOGIN_ID);
		originalPortalPageId = (String) value
				.get(FIELD_ORIGINAL_PORTAL_PAGE_ID);
		parentPortalPageId = (String) value.get(FIELD_PARENT_PORTAL_PAGE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		securityGroupId = (String) value.get(FIELD_SECURITY_GROUP_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		helpContentId = (String) value.get(FIELD_HELP_CONTENT_ID);
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