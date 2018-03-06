package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Auto Notice
 */
public class ProductPriceAutoNotice implements Serializable {

	public static final long serialVersionUID = 408950934310902784L;
	public static final String NAME = "ProductPriceAutoNotice";
	/**
	 * Product Price Notice Id
	 */
	@Getter
	@Setter
	private String productPriceNoticeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Run Date
	 */
	@Getter
	@Setter
	private Timestamp runDate;
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
		productPriceNoticeId, facilityId, runDate, fromDate, thruDate
	}

	public ProductPriceAutoNotice(GenericValue value) {
		productPriceNoticeId = (String) value.get(Fields.productPriceNoticeId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		runDate = (Timestamp) value.get(Fields.runDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ProductPriceAutoNotice fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceAutoNotice(value);
	}

	public static List<ProductPriceAutoNotice> fromValues(
			List<GenericValue> values) {
		List<ProductPriceAutoNotice> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceAutoNotice(value));
		}
		return entities;
	}
}