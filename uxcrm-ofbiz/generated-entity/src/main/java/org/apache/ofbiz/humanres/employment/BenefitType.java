package org.apache.ofbiz.humanres.employment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Benefit Type
 */
public class BenefitType implements Serializable {

	public static final long serialVersionUID = 6895657856877915136L;
	public static final String NAME = "BenefitType";
	/**
	 * Benefit Type Id
	 */
	@Getter
	@Setter
	private String benefitTypeId;
	/**
	 * Benefit Name
	 */
	@Getter
	@Setter
	private String benefitName;
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
	 * Employer Paid Percentage
	 */
	@Getter
	@Setter
	private Double employerPaidPercentage;
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
		benefitTypeId, benefitName, parentTypeId, hasTable, description, employerPaidPercentage, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BenefitType(GenericValue value) {
		benefitTypeId = (String) value.get(Fields.benefitTypeId.name());
		benefitName = (String) value.get(Fields.benefitName.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		employerPaidPercentage = (Double) value
				.get(Fields.employerPaidPercentage.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static BenefitType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BenefitType(value);
	}

	public static List<BenefitType> fromValues(List<GenericValue> values) {
		List<BenefitType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BenefitType(value));
		}
		return entities;
	}
}