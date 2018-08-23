package org.apache.ofbiz.product.price;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductPriceAutoNotice implements Serializable {

	public static final long serialVersionUID = 8873848559755716608L;
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

	public ProductPriceAutoNotice(GenericValue value) {
		productPriceNoticeId = (String) value
				.get(FIELD_PRODUCT_PRICE_NOTICE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		runDate = (Timestamp) value.get(FIELD_RUN_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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