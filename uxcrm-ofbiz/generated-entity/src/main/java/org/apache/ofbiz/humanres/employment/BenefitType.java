package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class BenefitType implements Serializable {

	public static final long serialVersionUID = 6967182015158742016L;
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

	public BenefitType(GenericValue value) {
		benefitTypeId = (String) value.get(FIELD_BENEFIT_TYPE_ID);
		benefitName = (String) value.get(FIELD_BENEFIT_NAME);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		employerPaidPercentage = (Double) value
				.get(FIELD_EMPLOYER_PAID_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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