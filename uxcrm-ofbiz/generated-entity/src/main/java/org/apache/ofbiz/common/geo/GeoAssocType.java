package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc Type
 */
@FieldNameConstants
public class GeoAssocType implements Serializable {

	public static final long serialVersionUID = 8207354118332968960L;
	public static final String NAME = "GeoAssocType";
	/**
	 * Geo Assoc Type Id
	 */
	@Getter
	@Setter
	private String geoAssocTypeId;
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

	public GeoAssocType(GenericValue value) {
		geoAssocTypeId = (String) value.get(FIELD_GEO_ASSOC_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GeoAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssocType(value);
	}

	public static List<GeoAssocType> fromValues(List<GenericValue> values) {
		List<GeoAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssocType(value));
		}
		return entities;
	}
}