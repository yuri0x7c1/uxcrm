package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Std Cost Type
 */
public class FixedAssetStdCostType implements Serializable {

	public static final long serialVersionUID = 8961023572633695232L;
	public static final String NAME = "FixedAssetStdCostType";
	/**
	 * Fixed Asset Std Cost Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetStdCostTypeId;
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
		fixedAssetStdCostTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetStdCostType(GenericValue value) {
		fixedAssetStdCostTypeId = (String) value
				.get(Fields.fixedAssetStdCostTypeId.name());
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

	public static FixedAssetStdCostType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetStdCostType(value);
	}

	public static List<FixedAssetStdCostType> fromValues(
			List<GenericValue> values) {
		List<FixedAssetStdCostType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetStdCostType(value));
		}
		return entities;
	}
}