package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Type Attr
 */
public class FixedAssetTypeAttr implements Serializable {

	public static final long serialVersionUID = 4857121123209207808L;
	public static final String NAME = "FixedAssetTypeAttr";
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
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
		fixedAssetTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetTypeAttr(GenericValue value) {
		fixedAssetTypeId = (String) value.get(Fields.fixedAssetTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FixedAssetTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetTypeAttr(value);
	}

	public static List<FixedAssetTypeAttr> fromValues(List<GenericValue> values) {
		List<FixedAssetTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetTypeAttr(value));
		}
		return entities;
	}
}