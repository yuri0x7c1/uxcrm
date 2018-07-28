package org.apache.ofbiz.product.category;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Content Type
 */
public class ProductCategoryContentType implements Serializable {

	public static final long serialVersionUID = 1611897390681752576L;
	public static final String NAME = "ProductCategoryContentType";
	/**
	 * Prod Cat Content Type Id
	 */
	@Getter
	@Setter
	private String prodCatContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		prodCatContentTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCategoryContentType(GenericValue value) {
		prodCatContentTypeId = (String) value.get(Fields.prodCatContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductCategoryContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryContentType(value);
	}

	public static List<ProductCategoryContentType> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryContentType(value));
		}
		return entities;
	}
}