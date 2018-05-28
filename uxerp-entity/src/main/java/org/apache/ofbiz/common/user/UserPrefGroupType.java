package org.apache.ofbiz.common.user;

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
public class UserPrefGroupType implements Serializable {

	public static final long serialVersionUID = 3531977694749031424L;
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

	public enum Fields {
		userPrefGroupTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserPrefGroupType(GenericValue value) {
		userPrefGroupTypeId = (String) value.get(Fields.userPrefGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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