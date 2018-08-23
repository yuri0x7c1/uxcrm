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
 * Picklist
 */
@FieldNameConstants
public class Picklist implements Serializable {

	public static final long serialVersionUID = 2138454067729492992L;
	public static final String NAME = "Picklist";
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Picklist Date
	 */
	@Getter
	@Setter
	private Timestamp picklistDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public Picklist(GenericValue value) {
		picklistId = (String) value.get(FIELD_PICKLIST_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		picklistDate = (Timestamp) value.get(FIELD_PICKLIST_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Picklist fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Picklist(value);
	}

	public static List<Picklist> fromValues(List<GenericValue> values) {
		List<Picklist> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Picklist(value));
		}
		return entities;
	}
}