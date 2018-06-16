package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Type Attr
 */
public class ProductTypeAttr implements Serializable {

	public static final long serialVersionUID = 1635991073078215680L;
	public static final String NAME = "ProductTypeAttr";
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
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
		productTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductTypeAttr(GenericValue value) {
		productTypeId = (String) value.get(Fields.productTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductTypeAttr(value);
	}

	public static List<ProductTypeAttr> fromValues(List<GenericValue> values) {
		List<ProductTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductTypeAttr(value));
		}
		return entities;
	}
}