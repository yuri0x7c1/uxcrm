package org.apache.ofbiz.product.promo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Code
 */
public class ProductPromoCode implements Serializable {

	public static final long serialVersionUID = 7412863417063566336L;
	public static final String NAME = "ProductPromoCode";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * User Entered
	 */
	@Getter
	@Setter
	private String userEntered;
	/**
	 * Require Email Or Party
	 */
	@Getter
	@Setter
	private String requireEmailOrParty;
	/**
	 * Use Limit Per Code
	 */
	@Getter
	@Setter
	private Long useLimitPerCode;
	/**
	 * Use Limit Per Customer
	 */
	@Getter
	@Setter
	private Long useLimitPerCustomer;
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
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;

	public enum Fields {
		productPromoCodeId, productPromoId, userEntered, requireEmailOrParty, useLimitPerCode, useLimitPerCustomer, fromDate, thruDate, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public ProductPromoCode(GenericValue value) {
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		userEntered = (String) value.get(Fields.userEntered.name());
		requireEmailOrParty = (String) value.get(Fields.requireEmailOrParty
				.name());
		useLimitPerCode = (Long) value.get(Fields.useLimitPerCode.name());
		useLimitPerCustomer = (Long) value.get(Fields.useLimitPerCustomer
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
	}

	public static ProductPromoCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCode(value);
	}

	public static List<ProductPromoCode> fromValues(List<GenericValue> values) {
		List<ProductPromoCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCode(value));
		}
		return entities;
	}
}