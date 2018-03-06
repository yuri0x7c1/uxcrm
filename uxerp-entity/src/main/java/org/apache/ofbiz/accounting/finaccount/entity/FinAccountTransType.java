package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Trans Type
 */
public class FinAccountTransType implements Serializable {

	public static final long serialVersionUID = 4722611688266797056L;
	public static final String NAME = "FinAccountTransType";
	/**
	 * Fin Account Trans Type Id
	 */
	@Getter
	@Setter
	private String finAccountTransTypeId;
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

	public enum Fields {
		finAccountTransTypeId, parentTypeId, hasTable, description
	}

	public FinAccountTransType(GenericValue value) {
		finAccountTransTypeId = (String) value.get(Fields.finAccountTransTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FinAccountTransType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTransType(value);
	}

	public static List<FinAccountTransType> fromValues(List<GenericValue> values) {
		List<FinAccountTransType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTransType(value));
		}
		return entities;
	}
}