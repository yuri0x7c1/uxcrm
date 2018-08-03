package org.apache.ofbiz.shipment.picklist;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist Status History
 */
public class PicklistStatusHistory implements Serializable {

	public static final long serialVersionUID = 990853764867531776L;
	public static final String NAME = "PicklistStatusHistory";
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
	/**
	 * Change Date
	 */
	@Getter
	@Setter
	private Timestamp changeDate;
	/**
	 * Change User Login Id
	 */
	@Getter
	@Setter
	private String changeUserLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Id To
	 */
	@Getter
	@Setter
	private String statusIdTo;
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
		picklistId, changeDate, changeUserLoginId, statusId, statusIdTo, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PicklistStatusHistory(GenericValue value) {
		picklistId = (String) value.get(Fields.picklistId.name());
		changeDate = (Timestamp) value.get(Fields.changeDate.name());
		changeUserLoginId = (String) value.get(Fields.changeUserLoginId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusIdTo = (String) value.get(Fields.statusIdTo.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PicklistStatusHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PicklistStatusHistory(value);
	}

	public static List<PicklistStatusHistory> fromValues(
			List<GenericValue> values) {
		List<PicklistStatusHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PicklistStatusHistory(value));
		}
		return entities;
	}
}