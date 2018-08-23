package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class AddressMatchMap implements Serializable {

	public static final long serialVersionUID = 689059662944585728L;
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

	public AddressMatchMap(GenericValue value) {
		mapKey = (String) value.get(FIELD_MAP_KEY);
		mapValue = (String) value.get(FIELD_MAP_VALUE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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