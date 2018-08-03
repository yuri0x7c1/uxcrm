package org.apache.ofbiz.order._return;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Type Map
 */
public class ReturnItemTypeMap implements Serializable {

	public static final long serialVersionUID = 722308761370273792L;
	public static final String NAME = "ReturnItemTypeMap";
	/**
	 * Return Item Map Key
	 */
	@Getter
	@Setter
	private String returnItemMapKey;
	/**
	 * Return Header Type Id
	 */
	@Getter
	@Setter
	private String returnHeaderTypeId;
	/**
	 * Return Item Type Id
	 */
	@Getter
	@Setter
	private String returnItemTypeId;
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
		returnItemMapKey, returnHeaderTypeId, returnItemTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReturnItemTypeMap(GenericValue value) {
		returnItemMapKey = (String) value.get(Fields.returnItemMapKey.name());
		returnHeaderTypeId = (String) value.get(Fields.returnHeaderTypeId
				.name());
		returnItemTypeId = (String) value.get(Fields.returnItemTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ReturnItemTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemTypeMap(value);
	}

	public static List<ReturnItemTypeMap> fromValues(List<GenericValue> values) {
		List<ReturnItemTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemTypeMap(value));
		}
		return entities;
	}
}