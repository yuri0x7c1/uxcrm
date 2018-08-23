package org.apache.ofbiz.marketing.reports;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TrackingCodeAndOrderHeader implements Serializable {

	public static final long serialVersionUID = 3484317380450038784L;
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

	public TrackingCodeAndOrderHeader(GenericValue value) {
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		orderId = (Long) value.get(FIELD_ORDER_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
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