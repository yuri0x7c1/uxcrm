package org.apache.ofbiz.shipment.receipt;

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
public class RejectionReason implements Serializable {

	public static final long serialVersionUID = 2984557712836689920L;
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

	public enum Fields {
		rejectionId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RejectionReason(GenericValue value) {
		rejectionId = (String) value.get(Fields.rejectionId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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