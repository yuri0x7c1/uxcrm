package org.apache.ofbiz.product.category;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Type Attr
 */
public class ProductCategoryTypeAttr implements Serializable {

	public static final long serialVersionUID = 556317772669186048L;
	public static final String NAME = "ProductCategoryTypeAttr";
	/**
	 * Product Category Type Id
	 */
	@Getter
	@Setter
	private String productCategoryTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		productCategoryTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCategoryTypeAttr(GenericValue value) {
		productCategoryTypeId = (String) value.get(Fields.productCategoryTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductCategoryTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryTypeAttr(value);
	}

	public static List<ProductCategoryTypeAttr> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryTypeAttr(value));
		}
		return entities;
	}
}