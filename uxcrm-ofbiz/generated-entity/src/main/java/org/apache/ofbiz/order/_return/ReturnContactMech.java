package org.apache.ofbiz.order._return;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Contact Mech
 */
public class ReturnContactMech implements Serializable {

	public static final long serialVersionUID = 7975131172070695936L;
	public static final String NAME = "ReturnContactMech";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
		returnId, contactMechPurposeTypeId, contactMechId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReturnContactMech(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ReturnContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnContactMech(value);
	}

	public static List<ReturnContactMech> fromValues(List<GenericValue> values) {
		List<ReturnContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnContactMech(value));
		}
		return entities;
	}
}