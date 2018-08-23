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
 * Geo Assoc
 */
@FieldNameConstants
public class GeoAssoc implements Serializable {

	public static final long serialVersionUID = 5691581296028217344L;
	public static final String NAME = "GeoAssoc";
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Id To
	 */
	@Getter
	@Setter
	private String geoIdTo;
	/**
	 * Geo Assoc Type Id
	 */
	@Getter
	@Setter
	private String geoAssocTypeId;
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

	public GeoAssoc(GenericValue value) {
		geoId = (String) value.get(FIELD_GEO_ID);
		geoIdTo = (String) value.get(FIELD_GEO_ID_TO);
		geoAssocTypeId = (String) value.get(FIELD_GEO_ASSOC_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GeoAssoc fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssoc(value);
	}

	public static List<GeoAssoc> fromValues(List<GenericValue> values) {
		List<GeoAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssoc(value));
		}
		return entities;
	}
}