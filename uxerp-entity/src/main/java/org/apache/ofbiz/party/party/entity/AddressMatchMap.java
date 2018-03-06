package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Address Match Map
 */
public class AddressMatchMap implements Serializable {

	public static final long serialVersionUID = 1258979669840841728L;
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

	public enum Fields {
		mapKey, mapValue, sequenceNum
	}

	public AddressMatchMap(GenericValue value) {
		mapKey = (String) value.get(Fields.mapKey.name());
		mapValue = (String) value.get(Fields.mapValue.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
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