package org.apache.ofbiz.product.price;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Payment Method Type
 */
public class ProductPaymentMethodType implements Serializable {

	public static final long serialVersionUID = 6661361826517841920L;
	public static final String NAME = "ProductPaymentMethodType";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Product Price Purpose Id
	 */
	@Getter
	@Setter
	private String productPricePurposeId;
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		productId, paymentMethodTypeId, productPricePurposeId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPaymentMethodType(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		productPricePurposeId = (String) value.get(Fields.productPricePurposeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPaymentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPaymentMethodType(value);
	}

	public static List<ProductPaymentMethodType> fromValues(
			List<GenericValue> values) {
		List<ProductPaymentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPaymentMethodType(value));
		}
		return entities;
	}
}