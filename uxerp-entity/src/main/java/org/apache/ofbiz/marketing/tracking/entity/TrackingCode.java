package org.apache.ofbiz.marketing.tracking.entity;

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
public class TrackingCode implements Serializable {

	public static final long serialVersionUID = 1651835424656179200L;
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

	public enum Fields {
		trackingCodeId, trackingCodeTypeId, marketingCampaignId, redirectUrl, overrideLogo, overrideCss, prodCatalogId, comments, description, trackableLifetime, billableLifetime, fromDate, thruDate, groupId, subgroupId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public TrackingCode(GenericValue value) {
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		trackingCodeTypeId = (String) value.get(Fields.trackingCodeTypeId
				.name());
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		redirectUrl = (String) value.get(Fields.redirectUrl.name());
		overrideLogo = (String) value.get(Fields.overrideLogo.name());
		overrideCss = (String) value.get(Fields.overrideCss.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		comments = (String) value.get(Fields.comments.name());
		description = (String) value.get(Fields.description.name());
		trackableLifetime = (Long) value.get(Fields.trackableLifetime.name());
		billableLifetime = (Long) value.get(Fields.billableLifetime.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		groupId = (String) value.get(Fields.groupId.name());
		subgroupId = (String) value.get(Fields.subgroupId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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