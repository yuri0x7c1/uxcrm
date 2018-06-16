package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Ident Type
 */
public class FixedAssetIdentType implements Serializable {

	public static final long serialVersionUID = 8995252950795189248L;
	public static final String NAME = "FixedAssetIdentType";
	/**
	 * Fixed Asset Ident Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetIdentTypeId;
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
		fixedAssetIdentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetIdentType(GenericValue value) {
		fixedAssetIdentTypeId = (String) value.get(Fields.fixedAssetIdentTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FixedAssetIdentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetIdentType(value);
	}

	public static List<FixedAssetIdentType> fromValues(List<GenericValue> values) {
		List<FixedAssetIdentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetIdentType(value));
		}
		return entities;
	}
}