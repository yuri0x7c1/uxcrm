package org.apache.ofbiz.marketing.tracking;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code
 */
@FieldNameConstants
public class TrackingCode implements Serializable {

	public static final long serialVersionUID = 5612981637307703296L;
	public static final String NAME = "TrackingCode";
	/**
	 * Tracking Code Id
	 */
	@Getter
	@Setter
	private String trackingCodeId;
	/**
	 * Tracking Code Type Id
	 */
	@Getter
	@Setter
	private String trackingCodeTypeId;
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Redirect Url
	 */
	@Getter
	@Setter
	private String redirectUrl;
	/**
	 * Override Logo
	 */
	@Getter
	@Setter
	private String overrideLogo;
	/**
	 * Override Css
	 */
	@Getter
	@Setter
	private String overrideCss;
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Trackable Lifetime
	 */
	@Getter
	@Setter
	private Long trackableLifetime;
	/**
	 * Billable Lifetime
	 */
	@Getter
	@Setter
	private Long billableLifetime;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Subgroup Id
	 */
	@Getter
	@Setter
	private String subgroupId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public TrackingCode(GenericValue value) {
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		trackingCodeTypeId = (String) value.get(FIELD_TRACKING_CODE_TYPE_ID);
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		redirectUrl = (String) value.get(FIELD_REDIRECT_URL);
		overrideLogo = (String) value.get(FIELD_OVERRIDE_LOGO);
		overrideCss = (String) value.get(FIELD_OVERRIDE_CSS);
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		description = (String) value.get(FIELD_DESCRIPTION);
		trackableLifetime = (Long) value.get(FIELD_TRACKABLE_LIFETIME);
		billableLifetime = (Long) value.get(FIELD_BILLABLE_LIFETIME);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		groupId = (String) value.get(FIELD_GROUP_ID);
		subgroupId = (String) value.get(FIELD_SUBGROUP_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TrackingCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCode(value);
	}

	public static List<TrackingCode> fromValues(List<GenericValue> values) {
		List<TrackingCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCode(value));
		}
		return entities;
	}
}