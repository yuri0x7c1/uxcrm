package org.apache.ofbiz.product.facility.entity;

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
public class ContainerGeoPoint implements Serializable {

	public static final long serialVersionUID = 4809230361066475520L;
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

	public enum Fields {
		containerId, geoPointId, fromDate, thruDate
	}

	public ContainerGeoPoint(GenericValue value) {
		containerId = (String) value.get(Fields.containerId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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