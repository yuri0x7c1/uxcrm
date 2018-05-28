package org.apache.ofbiz.accounting.finaccount;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Type
 */
public class FinAccountType implements Serializable {

	public static final long serialVersionUID = 5349898547827597312L;
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
		finAccountTypeId, parentTypeId, replenishEnumId, isRefundable, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FinAccountType(GenericValue value) {
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		replenishEnumId = (String) value.get(Fields.replenishEnumId.name());
		isRefundable = (String) value.get(Fields.isRefundable.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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