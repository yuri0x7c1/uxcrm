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
 * Container Geo Point
 */
@FieldNameConstants
public class ContainerGeoPoint implements Serializable {

	public static final long serialVersionUID = 1107748297408434176L;
	public static final String NAME = "ContainerGeoPoint";
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public ContainerGeoPoint(GenericValue value) {
		containerId = (String) value.get(FIELD_CONTAINER_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContainerGeoPoint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContainerGeoPoint(value);
	}

	public static List<ContainerGeoPoint> fromValues(List<GenericValue> values) {
		List<ContainerGeoPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContainerGeoPoint(value));
		}
		return entities;
	}
}