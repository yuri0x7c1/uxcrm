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
 * User Pref Group Type
 */
@FieldNameConstants
public class UserPrefGroupType implements Serializable {

	public static final long serialVersionUID = 6973935771126700032L;
	public static final String NAME = "UserPrefGroupType";
	/**
	 * User Pref Group Type Id
	 */
	@Getter
	@Setter
	private String userPrefGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public UserPrefGroupType(GenericValue value) {
		userPrefGroupTypeId = (String) value.get(FIELD_USER_PREF_GROUP_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UserPrefGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserPrefGroupType(value);
	}

	public static List<UserPrefGroupType> fromValues(List<GenericValue> values) {
		List<UserPrefGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserPrefGroupType(value));
		}
		return entities;
	}
}