package org.apache.ofbiz.humanres.ability.entity;

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
public class PerfReview implements Serializable {

	public static final long serialVersionUID = 4122049941179648000L;
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

	public enum Fields {
		employeePartyId, employeeRoleTypeId, perfReviewId, managerPartyId, managerRoleTypeId, paymentId, emplPositionId, fromDate, thruDate, comments
	}

	public PerfReview(GenericValue value) {
		employeePartyId = (String) value.get(Fields.employeePartyId.name());
		employeeRoleTypeId = (String) value.get(Fields.employeeRoleTypeId
				.name());
		perfReviewId = (String) value.get(Fields.perfReviewId.name());
		managerPartyId = (String) value.get(Fields.managerPartyId.name());
		managerRoleTypeId = (String) value.get(Fields.managerRoleTypeId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
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