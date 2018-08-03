package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Promo And Appl
 */
public class ProductStorePromoAndAppl implements Serializable {

	public static final long serialVersionUID = 1629754179453820928L;
	public static final String NAME = "ProductStorePromoAndAppl";
	/**
	 * Promo Name
	 */
	@Getter
	@Setter
	private String promoName;
	/**
	 * User Entered
	 */
	@Getter
	@Setter
	private String userEntered;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
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
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		promoName, userEntered, fromDate, sequenceNum, manualOnly, productStoreId, productPromoId, thruDate
	}

	public ProductStorePromoAndAppl(GenericValue value) {
		promoName = (String) value.get(Fields.promoName.name());
		userEntered = (String) value.get(Fields.userEntered.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		manualOnly = (String) value.get(Fields.manualOnly.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ProductStorePromoAndAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStorePromoAndAppl(value);
	}

	public static List<ProductStorePromoAndAppl> fromValues(
			List<GenericValue> values) {
		List<ProductStorePromoAndAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStorePromoAndAppl(value));
		}
		return entities;
	}
}