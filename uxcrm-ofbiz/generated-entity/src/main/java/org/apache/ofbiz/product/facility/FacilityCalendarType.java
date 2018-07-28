package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Calendar Type
 */
public class FacilityCalendarType implements Serializable {

	public static final long serialVersionUID = 749702142316190720L;
	public static final String NAME = "FacilityCalendarType";
	/**
	 * Facility Calendar Type Id
	 */
	@Getter
	@Setter
	private String facilityCalendarTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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
		facilityCalendarTypeId, parentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityCalendarType(GenericValue value) {
		facilityCalendarTypeId = (String) value
				.get(Fields.facilityCalendarTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FacilityCalendarType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityCalendarType(value);
	}

	public static List<FacilityCalendarType> fromValues(
			List<GenericValue> values) {
		List<FacilityCalendarType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityCalendarType(value));
		}
		return entities;
	}
}