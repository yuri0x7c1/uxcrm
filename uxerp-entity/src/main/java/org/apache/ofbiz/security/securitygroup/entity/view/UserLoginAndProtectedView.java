package org.apache.ofbiz.security.securitygroup.entity.view;

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

	public static final long serialVersionUID = 1585399305569560576L;
	public static final String NAME = "UserLoginAndProtectedView";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
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
	 * View Name Id
	 */
	@Getter
	@Setter
	private String viewNameId;
	/**
	 * Max Hits
	 */
	@Getter
	@Setter
	private Long maxHits;
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

	public enum Fields {
		userLoginId, groupId, fromDate, thruDate, viewNameId, maxHits, maxHitsDuration, tarpitDuration
	}

	public UserLoginAndProtectedView(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		groupId = (String) value.get(Fields.groupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		viewNameId = (String) value.get(Fields.viewNameId.name());
		maxHits = (Long) value.get(Fields.maxHits.name());
		maxHitsDuration = (Long) value.get(Fields.maxHitsDuration.name());
		tarpitDuration = (Long) value.get(Fields.tarpitDuration.name());
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