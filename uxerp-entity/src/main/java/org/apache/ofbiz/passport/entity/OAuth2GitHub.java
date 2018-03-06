package org.apache.ofbiz.passport.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * O Auth 2 Git Hub
 */
public class OAuth2GitHub implements Serializable {

	public static final long serialVersionUID = 897493995331787776L;
	public static final String NAME = "OAuth2GitHub";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Client Id
	 */
	@Getter
	@Setter
	private String clientId;
	/**
	 * Client Secret
	 */
	@Getter
	@Setter
	private String clientSecret;
	/**
	 * Return Url
	 */
	@Getter
	@Setter
	private String returnUrl;
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
		productStoreId, clientId, clientSecret, returnUrl, localRedirectUri, iconUrl, fromDate, thruDate
	}

	public OAuth2GitHub(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		clientId = (String) value.get(Fields.clientId.name());
		clientSecret = (String) value.get(Fields.clientSecret.name());
		returnUrl = (String) value.get(Fields.returnUrl.name());
		localRedirectUri = (String) value.get(Fields.localRedirectUri.name());
		iconUrl = (String) value.get(Fields.iconUrl.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static OAuth2GitHub fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OAuth2GitHub(value);
	}

	public static List<OAuth2GitHub> fromValues(List<GenericValue> values) {
		List<OAuth2GitHub> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OAuth2GitHub(value));
		}
		return entities;
	}
}