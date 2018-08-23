package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductType implements Serializable {

	public static final long serialVersionUID = 4904995897227387904L;
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

	public ProductType(GenericValue value) {
		productTypeId = (String) value.get(FIELD_PRODUCT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		isPhysical = (String) value.get(FIELD_IS_PHYSICAL);
		isDigital = (String) value.get(FIELD_IS_DIGITAL);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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