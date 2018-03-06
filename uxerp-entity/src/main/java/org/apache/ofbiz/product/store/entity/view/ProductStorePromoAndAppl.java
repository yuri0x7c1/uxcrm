package org.apache.ofbiz.product.store.entity.view;

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

	public static final long serialVersionUID = 2403574300669320192L;
	public static final String NAME = "ProductStorePromoAndAppl";
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

	public enum Fields {
		productStoreId, productPromoId, fromDate, thruDate, sequenceNum, manualOnly, promoName, userEntered
	}

	public ProductStorePromoAndAppl(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		manualOnly = (String) value.get(Fields.manualOnly.name());
		promoName = (String) value.get(Fields.promoName.name());
		userEntered = (String) value.get(Fields.userEntered.name());
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