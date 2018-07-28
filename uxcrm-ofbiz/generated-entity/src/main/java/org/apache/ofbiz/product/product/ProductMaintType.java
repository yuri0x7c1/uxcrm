package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Maint Type
 */
public class ProductMaintType implements Serializable {

	public static final long serialVersionUID = 6096235095807752192L;
	public static final String NAME = "ProductMaintType";
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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
		productMaintTypeId, description, parentTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductMaintType(GenericValue value) {
		productMaintTypeId = (String) value.get(Fields.productMaintTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductMaintType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMaintType(value);
	}

	public static List<ProductMaintType> fromValues(List<GenericValue> values) {
		List<ProductMaintType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMaintType(value));
		}
		return entities;
	}
}