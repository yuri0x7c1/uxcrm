package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo
 */
public class ProductPromo implements Serializable {

	public static final long serialVersionUID = 6737759807372510208L;
	public static final String NAME = "ProductPromo";
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Promo Name
	 */
	@Getter
	@Setter
	private String promoName;
	/**
	 * Promo Text
	 */
	@Getter
	@Setter
	private String promoText;
	/**
	 * User Entered
	 */
	@Getter
	@Setter
	private String userEntered;
	/**
	 * Show To Customer
	 */
	@Getter
	@Setter
	private String showToCustomer;
	/**
	 * Require Code
	 */
	@Getter
	@Setter
	private String requireCode;
	/**
	 * Use Limit Per Order
	 */
	@Getter
	@Setter
	private Long useLimitPerOrder;
	/**
	 * Use Limit Per Customer
	 */
	@Getter
	@Setter
	private Long useLimitPerCustomer;
	/**
	 * Use Limit Per Promotion
	 */
	@Getter
	@Setter
	private Long useLimitPerPromotion;
	/**
	 * Billback Factor
	 */
	@Getter
	@Setter
	private BigDecimal billbackFactor;
	/**
	 * Override Org Party Id
	 */
	@Getter
	@Setter
	private String overrideOrgPartyId;
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
		productPromoId, promoName, promoText, userEntered, showToCustomer, requireCode, useLimitPerOrder, useLimitPerCustomer, useLimitPerPromotion, billbackFactor, overrideOrgPartyId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromo(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		promoName = (String) value.get(Fields.promoName.name());
		promoText = (String) value.get(Fields.promoText.name());
		userEntered = (String) value.get(Fields.userEntered.name());
		showToCustomer = (String) value.get(Fields.showToCustomer.name());
		requireCode = (String) value.get(Fields.requireCode.name());
		useLimitPerOrder = (Long) value.get(Fields.useLimitPerOrder.name());
		useLimitPerCustomer = (Long) value.get(Fields.useLimitPerCustomer
				.name());
		useLimitPerPromotion = (Long) value.get(Fields.useLimitPerPromotion
				.name());
		billbackFactor = (BigDecimal) value.get(Fields.billbackFactor.name());
		overrideOrgPartyId = (String) value.get(Fields.overrideOrgPartyId
				.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPromo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromo(value);
	}

	public static List<ProductPromo> fromValues(List<GenericValue> values) {
		List<ProductPromo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromo(value));
		}
		return entities;
	}
}