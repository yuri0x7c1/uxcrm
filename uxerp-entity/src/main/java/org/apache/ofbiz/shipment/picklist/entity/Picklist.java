package org.apache.ofbiz.shipment.picklist.entity;

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
public class Picklist implements Serializable {

	public static final long serialVersionUID = 737529581974470656L;
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

	public enum Fields {
		picklistId, description, facilityId, shipmentMethodTypeId, statusId, picklistDate, createdByUserLogin, lastModifiedByUserLogin
	}

	public Picklist(GenericValue value) {
		picklistId = (String) value.get(Fields.picklistId.name());
		description = (String) value.get(Fields.description.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		picklistDate = (Timestamp) value.get(Fields.picklistDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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