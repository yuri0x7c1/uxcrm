package org.apache.ofbiz.shipment.receipt;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Rejection Reason
 */
@FieldNameConstants
public class RejectionReason implements Serializable {

	public static final long serialVersionUID = 7375462338183350272L;
	public static final String NAME = "RejectionReason";
	/**
	 * Rejection Id
	 */
	@Getter
	@Setter
	private String rejectionId;
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

	public RejectionReason(GenericValue value) {
		rejectionId = (String) value.get(FIELD_REJECTION_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static RejectionReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RejectionReason(value);
	}

	public static List<RejectionReason> fromValues(List<GenericValue> values) {
		List<RejectionReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RejectionReason(value));
		}
		return entities;
	}
}