package org.apache.ofbiz.marketing.reports;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code And Order Header
 */
public class TrackingCodeAndOrderHeader implements Serializable {

	public static final long serialVersionUID = 5935547550429360128L;
	public static final String NAME = "TrackingCodeAndOrderHeader";
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private Long orderId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Tracking Code Id
	 */
	@Getter
	@Setter
	private String trackingCodeId;

	public enum Fields {
		grandTotal, orderId, orderDate, trackingCodeId
	}

	public TrackingCodeAndOrderHeader(GenericValue value) {
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		orderId = (Long) value.get(Fields.orderId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
	}

	public static TrackingCodeAndOrderHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeAndOrderHeader(value);
	}

	public static List<TrackingCodeAndOrderHeader> fromValues(
			List<GenericValue> values) {
		List<TrackingCodeAndOrderHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeAndOrderHeader(value));
		}
		return entities;
	}
}