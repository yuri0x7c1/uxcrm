package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Gl Account
 */
public class ProductGlAccount implements Serializable {

	public static final long serialVersionUID = 3760847959718507520L;
	public static final String NAME = "ProductGlAccount";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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
		productId, organizationPartyId, glAccountTypeId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductGlAccount(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductGlAccount(value);
	}

	public static List<ProductGlAccount> fromValues(List<GenericValue> values) {
		List<ProductGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductGlAccount(value));
		}
		return entities;
	}
}