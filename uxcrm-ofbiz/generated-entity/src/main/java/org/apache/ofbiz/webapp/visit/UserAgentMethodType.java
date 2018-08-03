package org.apache.ofbiz.webapp.visit;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Agent Method Type
 */
public class UserAgentMethodType implements Serializable {

	public static final long serialVersionUID = 2812190083654026240L;
	public static final String NAME = "UserAgentMethodType";
	/**
	 * User Agent Method Type Id
	 */
	@Getter
	@Setter
	private String userAgentMethodTypeId;
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
		userAgentMethodTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserAgentMethodType(GenericValue value) {
		userAgentMethodTypeId = (String) value.get(Fields.userAgentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static UserAgentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserAgentMethodType(value);
	}

	public static List<UserAgentMethodType> fromValues(List<GenericValue> values) {
		List<UserAgentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserAgentMethodType(value));
		}
		return entities;
	}
}