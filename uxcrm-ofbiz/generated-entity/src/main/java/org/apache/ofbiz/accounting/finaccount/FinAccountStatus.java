package org.apache.ofbiz.accounting.finaccount;

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
public class FinAccountStatus implements Serializable {

	public static final long serialVersionUID = 5492547177951346688L;
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

	public enum Fields {
		finAccountId, statusId, statusDate, statusEndDate, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FinAccountStatus(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		statusEndDate = (Timestamp) value.get(Fields.statusEndDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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