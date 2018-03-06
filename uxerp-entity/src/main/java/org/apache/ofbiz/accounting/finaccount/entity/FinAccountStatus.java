package org.apache.ofbiz.accounting.finaccount.entity;

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

	public static final long serialVersionUID = 8393609746346680320L;
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

	public enum Fields {
		finAccountId, statusId, statusDate, statusEndDate, changeByUserLoginId
	}

	public FinAccountStatus(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		statusEndDate = (Timestamp) value.get(Fields.statusEndDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
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