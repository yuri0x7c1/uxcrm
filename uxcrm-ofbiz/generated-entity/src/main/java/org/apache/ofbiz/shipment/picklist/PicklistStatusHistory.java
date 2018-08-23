package org.apache.ofbiz.shipment.picklist;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PicklistStatusHistory implements Serializable {

	public static final long serialVersionUID = 1899068507351552000L;
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

	public PicklistStatusHistory(GenericValue value) {
		picklistId = (String) value.get(FIELD_PICKLIST_ID);
		changeDate = (Timestamp) value.get(FIELD_CHANGE_DATE);
		changeUserLoginId = (String) value.get(FIELD_CHANGE_USER_LOGIN_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusIdTo = (String) value.get(FIELD_STATUS_ID_TO);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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