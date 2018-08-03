package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Type
 */
public class ProductType implements Serializable {

	public static final long serialVersionUID = 6623395349904131072L;
	public static final String NAME = "ProductType";
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Is Physical
	 */
	@Getter
	@Setter
	private String isPhysical;
	/**
	 * Is Digital
	 */
	@Getter
	@Setter
	private String isDigital;
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
		productTypeId, parentTypeId, isPhysical, isDigital, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductType(GenericValue value) {
		productTypeId = (String) value.get(Fields.productTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		isPhysical = (String) value.get(Fields.isPhysical.name());
		isDigital = (String) value.get(Fields.isDigital.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductType(value);
	}

	public static List<ProductType> fromValues(List<GenericValue> values) {
		List<ProductType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductType(value));
		}
		return entities;
	}
}