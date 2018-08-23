package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Average Cost Type
 */
@FieldNameConstants
public class ProductAverageCostType implements Serializable {

	public static final long serialVersionUID = 5461396292533136384L;
	public static final String NAME = "ProductAverageCostType";
	/**
	 * Product Average Cost Type Id
	 */
	@Getter
	@Setter
	private String productAverageCostTypeId;
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

	public ProductAverageCostType(GenericValue value) {
		productAverageCostTypeId = (String) value
				.get(FIELD_PRODUCT_AVERAGE_COST_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductAverageCostType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAverageCostType(value);
	}

	public static List<ProductAverageCostType> fromValues(
			List<GenericValue> values) {
		List<ProductAverageCostType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAverageCostType(value));
		}
		return entities;
	}
}