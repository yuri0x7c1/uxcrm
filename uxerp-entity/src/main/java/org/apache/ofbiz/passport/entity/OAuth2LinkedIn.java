package org.apache.ofbiz.passport.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * O Auth 2 Linked In
 */
public class OAuth2LinkedIn implements Serializable {

	public static final long serialVersionUID = 6315423331070850048L;
	public static final String NAME = "OAuth2LinkedIn";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Api Key
	 */
	@Getter
	@Setter
	private String apiKey;
	/**
	 * Secret Key
	 */
	@Getter
	@Setter
	private String secretKey;
	/**
	 * Live Return Url
	 */
	@Getter
	@Setter
	private String liveReturnUrl;
	/**
	 * Test Return Url
	 */
	@Getter
	@Setter
	private String testReturnUrl;
	/**
	 * Local Redirect Uri
	 */
	@Getter
	@Setter
	private String localRedirectUri;
	/**
	 * Icon Url
	 */
	@Getter
	@Setter
	private String iconUrl;
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

	public enum Fields {
		productStoreId, apiKey, secretKey, liveReturnUrl, testReturnUrl, localRedirectUri, iconUrl, fromDate, thruDate
	}

	public OAuth2LinkedIn(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		apiKey = (String) value.get(Fields.apiKey.name());
		secretKey = (String) value.get(Fields.secretKey.name());
		liveReturnUrl = (String) value.get(Fields.liveReturnUrl.name());
		testReturnUrl = (String) value.get(Fields.testReturnUrl.name());
		localRedirectUri = (String) value.get(Fields.localRedirectUri.name());
		iconUrl = (String) value.get(Fields.iconUrl.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static OAuth2LinkedIn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OAuth2LinkedIn(value);
	}

	public static List<OAuth2LinkedIn> fromValues(List<GenericValue> values) {
		List<OAuth2LinkedIn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OAuth2LinkedIn(value));
		}
		return entities;
	}
}