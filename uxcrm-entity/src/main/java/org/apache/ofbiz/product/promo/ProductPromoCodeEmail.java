package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Code Email
 */
public class ProductPromoCodeEmail implements Serializable {

	public static final long serialVersionUID = 6762813329421173760L;
	public static final String NAME = "ProductPromoCodeEmail";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Email Address
	 */
	@Getter
	@Setter
	private String emailAddress;
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
		productPromoCodeId, emailAddress, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromoCodeEmail(GenericValue value) {
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		emailAddress = (String) value.get(Fields.emailAddress.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPromoCodeEmail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeEmail(value);
	}

	public static List<ProductPromoCodeEmail> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeEmail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeEmail(value));
		}
		return entities;
	}
}