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
 * Fin Account Status
 */
@FieldNameConstants
public class FinAccountStatus implements Serializable {

	public static final long serialVersionUID = 1676756230321651712L;
	public static final String NAME = "FinAccountStatus";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Status End Date
	 */
	@Getter
	@Setter
	private Timestamp statusEndDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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

	public FinAccountStatus(GenericValue value) {
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		statusEndDate = (Timestamp) value.get(FIELD_STATUS_END_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FinAccountStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountStatus(value);
	}

	public static List<FinAccountStatus> fromValues(List<GenericValue> values) {
		List<FinAccountStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountStatus(value));
		}
		return entities;
	}
}