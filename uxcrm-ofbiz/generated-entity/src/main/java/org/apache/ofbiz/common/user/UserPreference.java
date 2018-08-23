package org.apache.ofbiz.common.user;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Preference
 */
@FieldNameConstants
public class UserPreference implements Serializable {

	public static final long serialVersionUID = 3601787332740810752L;
	public static final String NAME = "UserPreference";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * User Pref Type Id
	 */
	@Getter
	@Setter
	private String userPrefTypeId;
	/**
	 * User Pref Group Type Id
	 */
	@Getter
	@Setter
	private String userPrefGroupTypeId;
	/**
	 * User Pref Value
	 */
	@Getter
	@Setter
	private String userPrefValue;
	/**
	 * User Pref Data Type
	 */
	@Getter
	@Setter
	private String userPrefDataType;
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

	public UserPreference(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		userPrefTypeId = (String) value.get(FIELD_USER_PREF_TYPE_ID);
		userPrefGroupTypeId = (String) value.get(FIELD_USER_PREF_GROUP_TYPE_ID);
		userPrefValue = (String) value.get(FIELD_USER_PREF_VALUE);
		userPrefDataType = (String) value.get(FIELD_USER_PREF_DATA_TYPE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UserPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserPreference(value);
	}

	public static List<UserPreference> fromValues(List<GenericValue> values) {
		List<UserPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserPreference(value));
		}
		return entities;
	}
}