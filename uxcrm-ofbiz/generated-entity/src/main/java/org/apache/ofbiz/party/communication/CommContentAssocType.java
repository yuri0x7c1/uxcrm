package org.apache.ofbiz.party.communication;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Comm Content Assoc Type
 */
public class CommContentAssocType implements Serializable {

	public static final long serialVersionUID = 5312870420264089600L;
	public static final String NAME = "CommContentAssocType";
	/**
	 * Comm Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String commContentAssocTypeId;
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
		commContentAssocTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommContentAssocType(GenericValue value) {
		commContentAssocTypeId = (String) value
				.get(Fields.commContentAssocTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CommContentAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommContentAssocType(value);
	}

	public static List<CommContentAssocType> fromValues(
			List<GenericValue> values) {
		List<CommContentAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommContentAssocType(value));
		}
		return entities;
	}
}