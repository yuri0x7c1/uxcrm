package org.apache.ofbiz.humanres.ability;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Perf Review
 */
@FieldNameConstants
public class PerfReview implements Serializable {

	public static final long serialVersionUID = 646143557078506496L;
	public static final String NAME = "PerfReview";
	/**
	 * Employee Party Id
	 */
	@Getter
	@Setter
	private String employeePartyId;
	/**
	 * Employee Role Type Id
	 */
	@Getter
	@Setter
	private String employeeRoleTypeId;
	/**
	 * Perf Review Id
	 */
	@Getter
	@Setter
	private String perfReviewId;
	/**
	 * Manager Party Id
	 */
	@Getter
	@Setter
	private String managerPartyId;
	/**
	 * Manager Role Type Id
	 */
	@Getter
	@Setter
	private String managerRoleTypeId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public PerfReview(GenericValue value) {
		employeePartyId = (String) value.get(FIELD_EMPLOYEE_PARTY_ID);
		employeeRoleTypeId = (String) value.get(FIELD_EMPLOYEE_ROLE_TYPE_ID);
		perfReviewId = (String) value.get(FIELD_PERF_REVIEW_ID);
		managerPartyId = (String) value.get(FIELD_MANAGER_PARTY_ID);
		managerRoleTypeId = (String) value.get(FIELD_MANAGER_ROLE_TYPE_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		emplPositionId = (String) value.get(FIELD_EMPL_POSITION_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PerfReview fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerfReview(value);
	}

	public static List<PerfReview> fromValues(List<GenericValue> values) {
		List<PerfReview> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerfReview(value));
		}
		return entities;
	}
}