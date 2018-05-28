package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Promo Appl
 */
public class ProductStorePromoAppl implements Serializable {

	public static final long serialVersionUID = 6134184380661405696L;
	public static final String NAME = "ProductStorePromoAppl";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
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
	 * Manual Only
	 */
	@Getter
	@Setter
	private String manualOnly;
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
		productStoreId, productPromoId, fromDate, thruDate, sequenceNum, manualOnly, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStorePromoAppl(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		manualOnly = (String) value.get(Fields.manualOnly.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStorePromoAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStorePromoAppl(value);
	}

	public static List<ProductStorePromoAppl> fromValues(
			List<GenericValue> values) {
		List<ProductStorePromoAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStorePromoAppl(value));
		}
		return entities;
	}
}