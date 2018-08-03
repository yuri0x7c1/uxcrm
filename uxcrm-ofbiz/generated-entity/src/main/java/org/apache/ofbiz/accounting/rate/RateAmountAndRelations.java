package org.apache.ofbiz.accounting.rate;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Rate Amount And Relations
 */
public class RateAmountAndRelations implements Serializable {

	public static final long serialVersionUID = 4151693471901250560L;
	public static final String NAME = "RateAmountAndRelations";
	/**
	 * Rate Description
	 */
	@Getter
	@Setter
	private String rateDescription;
	/**
	 * Period Description
	 */
	@Getter
	@Setter
	private String periodDescription;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Employee Position Description
	 */
	@Getter
	@Setter
	private String employeePositionDescription;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Rate Amount
	 */
	@Getter
	@Setter
	private BigDecimal rateAmount;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Rate Currency Uom Id
	 */
	@Getter
	@Setter
	private String rateCurrencyUomId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public enum Fields {
		rateDescription, periodDescription, firstName, middleName, lastName, groupName, employeePositionDescription, workEffortName, workEffortId, rateTypeId, rateAmount, periodTypeId, thruDate, fromDate, emplPositionTypeId, rateCurrencyUomId, partyId
	}

	public RateAmountAndRelations(GenericValue value) {
		rateDescription = (String) value.get(Fields.rateDescription.name());
		periodDescription = (String) value.get(Fields.periodDescription.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		groupName = (String) value.get(Fields.groupName.name());
		employeePositionDescription = (String) value
				.get(Fields.employeePositionDescription.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		rateAmount = (BigDecimal) value.get(Fields.rateAmount.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		rateCurrencyUomId = (String) value.get(Fields.rateCurrencyUomId.name());
		partyId = (String) value.get(Fields.partyId.name());
	}

	public static RateAmountAndRelations fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RateAmountAndRelations(value);
	}

	public static List<RateAmountAndRelations> fromValues(
			List<GenericValue> values) {
		List<RateAmountAndRelations> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RateAmountAndRelations(value));
		}
		return entities;
	}
}