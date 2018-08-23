package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FacilityTypeAttr implements Serializable {

	public static final long serialVersionUID = 5038034969830992896L;
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

	public FacilityTypeAttr(GenericValue value) {
		facilityTypeId = (String) value.get(FIELD_FACILITY_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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