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
 * Fin Account Trans Type
 */
@FieldNameConstants
public class FinAccountTransType implements Serializable {

	public static final long serialVersionUID = 7453210221951140864L;
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

	public FinAccountTransType(GenericValue value) {
		finAccountTransTypeId = (String) value
				.get(FIELD_FIN_ACCOUNT_TRANS_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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