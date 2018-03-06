package org.apache.ofbiz.passport.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Linked In User
 */
public class LinkedInUser implements Serializable {

	public static final long serialVersionUID = 2453032644546591744L;
	public static final String NAME = "LinkedInUser";
	/**
	 * Linked In User Id
	 */
	@Getter
	@Setter
	private String linkedInUserId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Env Prefix
	 */
	@Getter
	@Setter
	private String envPrefix;
	/**
	 * Access Token
	 */
	@Getter
	@Setter
	private String accessToken;

	public enum Fields {
		linkedInUserId, productStoreId, envPrefix, accessToken
	}

	public LinkedInUser(GenericValue value) {
		linkedInUserId = (String) value.get(Fields.linkedInUserId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		envPrefix = (String) value.get(Fields.envPrefix.name());
		accessToken = (String) value.get(Fields.accessToken.name());
	}

	public static LinkedInUser fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new LinkedInUser(value);
	}

	public static List<LinkedInUser> fromValues(List<GenericValue> values) {
		List<LinkedInUser> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new LinkedInUser(value));
		}
		return entities;
	}
}