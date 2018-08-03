package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Ident
 */
public class FixedAssetIdent implements Serializable {

	public static final long serialVersionUID = 3273929070214218752L;
	public static final String NAME = "FixedAssetIdent";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Fixed Asset Ident Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetIdentTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;
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
		fixedAssetId, fixedAssetIdentTypeId, idValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetIdent(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		fixedAssetIdentTypeId = (String) value.get(Fields.fixedAssetIdentTypeId
				.name());
		idValue = (String) value.get(Fields.idValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FixedAssetIdent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetIdent(value);
	}

	public static List<FixedAssetIdent> fromValues(List<GenericValue> values) {
		List<FixedAssetIdent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetIdent(value));
		}
		return entities;
	}
}