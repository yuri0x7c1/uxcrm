package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Type Attr
 */
public class FacilityTypeAttr implements Serializable {

	public static final long serialVersionUID = 6263679812554778624L;
	public static final String NAME = "FacilityTypeAttr";
	/**
	 * Facility Type Id
	 */
	@Getter
	@Setter
	private String facilityTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		facilityTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityTypeAttr(GenericValue value) {
		facilityTypeId = (String) value.get(Fields.facilityTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FacilityTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityTypeAttr(value);
	}

	public static List<FacilityTypeAttr> fromValues(List<GenericValue> values) {
		List<FacilityTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityTypeAttr(value));
		}
		return entities;
	}
}