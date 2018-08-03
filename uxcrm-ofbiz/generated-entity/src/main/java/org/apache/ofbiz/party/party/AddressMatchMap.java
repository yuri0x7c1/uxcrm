package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Address Match Map
 */
public class AddressMatchMap implements Serializable {

	public static final long serialVersionUID = 6357681513234683904L;
	public static final String NAME = "AddressMatchMap";
	/**
	 * Map Key
	 */
	@Getter
	@Setter
	private String mapKey;
	/**
	 * Map Value
	 */
	@Getter
	@Setter
	private String mapValue;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		mapKey, mapValue, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AddressMatchMap(GenericValue value) {
		mapKey = (String) value.get(Fields.mapKey.name());
		mapValue = (String) value.get(Fields.mapValue.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AddressMatchMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AddressMatchMap(value);
	}

	public static List<AddressMatchMap> fromValues(List<GenericValue> values) {
		List<AddressMatchMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AddressMatchMap(value));
		}
		return entities;
	}
}