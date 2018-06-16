package org.apache.ofbiz.security.securitygroup;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login And Protected View
 */
public class UserLoginAndProtectedView implements Serializable {

	public static final long serialVersionUID = 7240174354497414144L;
	public static final String NAME = "UserLoginAndProtectedView";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * View Name Id
	 */
	@Getter
	@Setter
	private String viewNameId;
	/**
	 * Max Hits Duration
	 */
	@Getter
	@Setter
	private Long maxHitsDuration;
	/**
	 * Tarpit Duration
	 */
	@Getter
	@Setter
	private Long tarpitDuration;
	/**
	 * Max Hits
	 */
	@Getter
	@Setter
	private Long maxHits;

	public enum Fields {
		userLoginId, fromDate, groupId, thruDate, viewNameId, maxHitsDuration, tarpitDuration, maxHits
	}

	public UserLoginAndProtectedView(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		groupId = (String) value.get(Fields.groupId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		viewNameId = (String) value.get(Fields.viewNameId.name());
		maxHitsDuration = (Long) value.get(Fields.maxHitsDuration.name());
		tarpitDuration = (Long) value.get(Fields.tarpitDuration.name());
		maxHits = (Long) value.get(Fields.maxHits.name());
	}

	public static UserLoginAndProtectedView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginAndProtectedView(value);
	}

	public static List<UserLoginAndProtectedView> fromValues(
			List<GenericValue> values) {
		List<UserLoginAndProtectedView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginAndProtectedView(value));
		}
		return entities;
	}
}