package org.apache.ofbiz.security.securitygroup;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class UserLoginAndProtectedView implements Serializable {

	public static final long serialVersionUID = 3234994399016517632L;
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

	public UserLoginAndProtectedView(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		groupId = (String) value.get(FIELD_GROUP_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		viewNameId = (String) value.get(FIELD_VIEW_NAME_ID);
		maxHitsDuration = (Long) value.get(FIELD_MAX_HITS_DURATION);
		tarpitDuration = (Long) value.get(FIELD_TARPIT_DURATION);
		maxHits = (Long) value.get(FIELD_MAX_HITS);
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