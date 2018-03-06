package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Type
 */
public class FinAccountType implements Serializable {

	public static final long serialVersionUID = 4783170127828178944L;
	public static final String NAME = "FinAccountType";
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Replenish Enum Id
	 */
	@Getter
	@Setter
	private String replenishEnumId;
	/**
	 * Is Refundable
	 */
	@Getter
	@Setter
	private String isRefundable;
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
		finAccountTypeId, parentTypeId, replenishEnumId, isRefundable, hasTable, description
	}

	public FinAccountType(GenericValue value) {
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		replenishEnumId = (String) value.get(Fields.replenishEnumId.name());
		isRefundable = (String) value.get(Fields.isRefundable.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FinAccountType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountType(value);
	}

	public static List<FinAccountType> fromValues(List<GenericValue> values) {
		List<FinAccountType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountType(value));
		}
		return entities;
	}
}