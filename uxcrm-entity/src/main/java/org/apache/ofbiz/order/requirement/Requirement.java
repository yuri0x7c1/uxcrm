package org.apache.ofbiz.order.requirement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement
 */
public class Requirement implements Serializable {

	public static final long serialVersionUID = 4464307116306862080L;
	public static final String NAME = "Requirement";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Requirement Start Date
	 */
	@Getter
	@Setter
	private Timestamp requirementStartDate;
	/**
	 * Required By Date
	 */
	@Getter
	@Setter
	private Timestamp requiredByDate;
	/**
	 * Estimated Budget
	 */
	@Getter
	@Setter
	private BigDecimal estimatedBudget;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Use Case
	 */
	@Getter
	@Setter
	private String useCase;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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
		requirementId, requirementTypeId, facilityId, deliverableId, fixedAssetId, productId, statusId, description, requirementStartDate, requiredByDate, estimatedBudget, quantity, useCase, reason, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Requirement(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		deliverableId = (String) value.get(Fields.deliverableId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		productId = (String) value.get(Fields.productId.name());
		statusId = (String) value.get(Fields.statusId.name());
		description = (String) value.get(Fields.description.name());
		requirementStartDate = (Timestamp) value
				.get(Fields.requirementStartDate.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		estimatedBudget = (BigDecimal) value.get(Fields.estimatedBudget.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		useCase = (String) value.get(Fields.useCase.name());
		reason = (String) value.get(Fields.reason.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Requirement fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Requirement(value);
	}

	public static List<Requirement> fromValues(List<GenericValue> values) {
		List<Requirement> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Requirement(value));
		}
		return entities;
	}
}