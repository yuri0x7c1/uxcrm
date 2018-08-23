package org.apache.ofbiz.accounting.finaccount;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FinAccountType implements Serializable {

	public static final long serialVersionUID = 2504159057937259520L;
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

	public FinAccountType(GenericValue value) {
		finAccountTypeId = (String) value.get(FIELD_FIN_ACCOUNT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		replenishEnumId = (String) value.get(FIELD_REPLENISH_ENUM_ID);
		isRefundable = (String) value.get(FIELD_IS_REFUNDABLE);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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