package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Code Party
 */
public class ProductPromoCodeParty implements Serializable {

	public static final long serialVersionUID = 4348970788883820544L;
	public static final String NAME = "ProductPromoCodeParty";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
		productPromoCodeId, partyId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromoCodeParty(GenericValue value) {
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPromoCodeParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeParty(value);
	}

	public static List<ProductPromoCodeParty> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeParty(value));
		}
		return entities;
	}
}