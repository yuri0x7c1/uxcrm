package org.apache.ofbiz.product.category;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Gl Account
 */
public class ProductCategoryGlAccount implements Serializable {

	public static final long serialVersionUID = 3560725527726615552L;
	public static final String NAME = "ProductCategoryGlAccount";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
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
		productCategoryId, organizationPartyId, glAccountTypeId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCategoryGlAccount(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
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

	public static ProductCategoryGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryGlAccount(value);
	}

	public static List<ProductCategoryGlAccount> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryGlAccount(value));
		}
		return entities;
	}
}