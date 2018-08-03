package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Group Type
 */
public class FacilityGroupType implements Serializable {

	public static final long serialVersionUID = 8045127271489731584L;
	public static final String NAME = "FacilityGroupType";
	/**
	 * Facility Group Type Id
	 */
	@Getter
	@Setter
	private String facilityGroupTypeId;
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
		facilityGroupTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityGroupType(GenericValue value) {
		facilityGroupTypeId = (String) value.get(Fields.facilityGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FacilityGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupType(value);
	}

	public static List<FacilityGroupType> fromValues(List<GenericValue> values) {
		List<FacilityGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupType(value));
		}
		return entities;
	}
}