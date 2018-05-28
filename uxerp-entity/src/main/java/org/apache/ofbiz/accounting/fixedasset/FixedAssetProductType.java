package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Product Type
 */
public class FixedAssetProductType implements Serializable {

	public static final long serialVersionUID = 6785076315597377536L;
	public static final String NAME = "FixedAssetProductType";
	/**
	 * Fixed Asset Product Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetProductTypeId;
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
		fixedAssetProductTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetProductType(GenericValue value) {
		fixedAssetProductTypeId = (String) value
				.get(Fields.fixedAssetProductTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FixedAssetProductType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetProductType(value);
	}

	public static List<FixedAssetProductType> fromValues(
			List<GenericValue> values) {
		List<FixedAssetProductType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetProductType(value));
		}
		return entities;
	}
}