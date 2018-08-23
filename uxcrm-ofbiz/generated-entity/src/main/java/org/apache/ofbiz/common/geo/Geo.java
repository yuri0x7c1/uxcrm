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
 * Geo
 */
@FieldNameConstants
public class Geo implements Serializable {

	public static final long serialVersionUID = 7530373637591324672L;
	public static final String NAME = "Geo";
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Type Id
	 */
	@Getter
	@Setter
	private String geoTypeId;
	/**
	 * Geo Name
	 */
	@Getter
	@Setter
	private String geoName;
	/**
	 * Geo Code
	 */
	@Getter
	@Setter
	private String geoCode;
	/**
	 * Geo Sec Code
	 */
	@Getter
	@Setter
	private String geoSecCode;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Well Known Text
	 */
	@Getter
	@Setter
	private String wellKnownText;
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

	public Geo(GenericValue value) {
		geoId = (String) value.get(FIELD_GEO_ID);
		geoTypeId = (String) value.get(FIELD_GEO_TYPE_ID);
		geoName = (String) value.get(FIELD_GEO_NAME);
		geoCode = (String) value.get(FIELD_GEO_CODE);
		geoSecCode = (String) value.get(FIELD_GEO_SEC_CODE);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		wellKnownText = (String) value.get(FIELD_WELL_KNOWN_TEXT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Geo fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Geo(value);
	}

	public static List<Geo> fromValues(List<GenericValue> values) {
		List<Geo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Geo(value));
		}
		return entities;
	}
}