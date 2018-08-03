package org.apache.ofbiz.accounting.ledger;

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
public class ProductAverageCostType implements Serializable {

	public static final long serialVersionUID = 1928015300455548928L;
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

	public enum Fields {
		productAverageCostTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductAverageCostType(GenericValue value) {
		productAverageCostTypeId = (String) value
				.get(Fields.productAverageCostTypeId.name());
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