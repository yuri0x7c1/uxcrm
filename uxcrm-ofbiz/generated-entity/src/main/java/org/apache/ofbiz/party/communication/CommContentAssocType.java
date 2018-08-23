package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CommContentAssocType implements Serializable {

	public static final long serialVersionUID = 4311884321611313152L;
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

	public CommContentAssocType(GenericValue value) {
		commContentAssocTypeId = (String) value
				.get(FIELD_COMM_CONTENT_ASSOC_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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