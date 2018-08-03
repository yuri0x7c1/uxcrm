package org.apache.ofbiz.common.uom;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom Group
 */
public class UomGroup implements Serializable {

	public static final long serialVersionUID = 4164739284106257408L;
	public static final String NAME = "UomGroup";
	/**
	 * Uom Group Id
	 */
	@Getter
	@Setter
	private String uomGroupId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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
		uomGroupId, uomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UomGroup(GenericValue value) {
		uomGroupId = (String) value.get(Fields.uomGroupId.name());
		uomId = (String) value.get(Fields.uomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static UomGroup fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new UomGroup(value);
	}

	public static List<UomGroup> fromValues(List<GenericValue> values) {
		List<UomGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomGroup(value));
		}
		return entities;
	}
}