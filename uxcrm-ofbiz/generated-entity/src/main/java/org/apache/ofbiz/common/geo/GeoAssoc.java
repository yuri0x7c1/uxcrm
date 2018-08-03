package org.apache.ofbiz.common.geo;

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
public class GeoAssoc implements Serializable {

	public static final long serialVersionUID = 8323925727087676416L;
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

	public enum Fields {
		geoId, geoIdTo, geoAssocTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GeoAssoc(GenericValue value) {
		geoId = (String) value.get(Fields.geoId.name());
		geoIdTo = (String) value.get(Fields.geoIdTo.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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