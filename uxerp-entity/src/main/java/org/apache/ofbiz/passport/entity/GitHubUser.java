package org.apache.ofbiz.passport.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Git Hub User
 */
public class GitHubUser implements Serializable {

	public static final long serialVersionUID = 1186364039714609152L;
	public static final String NAME = "GitHubUser";
	/**
	 * Git Hub User Id
	 */
	@Getter
	@Setter
	private String gitHubUserId;
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
	 * Token Type
	 */
	@Getter
	@Setter
	private String tokenType;
	/**
	 * Access Token
	 */
	@Getter
	@Setter
	private String accessToken;

	public enum Fields {
		gitHubUserId, productStoreId, envPrefix, tokenType, accessToken
	}

	public GitHubUser(GenericValue value) {
		gitHubUserId = (String) value.get(Fields.gitHubUserId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		envPrefix = (String) value.get(Fields.envPrefix.name());
		tokenType = (String) value.get(Fields.tokenType.name());
		accessToken = (String) value.get(Fields.accessToken.name());
	}

	public static GitHubUser fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GitHubUser(value);
	}

	public static List<GitHubUser> fromValues(List<GenericValue> values) {
		List<GitHubUser> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GitHubUser(value));
		}
		return entities;
	}
}