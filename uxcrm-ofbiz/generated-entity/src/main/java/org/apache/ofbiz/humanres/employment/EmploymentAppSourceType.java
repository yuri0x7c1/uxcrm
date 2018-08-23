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
 * Employment App Source Type
 */
@FieldNameConstants
public class EmploymentAppSourceType implements Serializable {

	public static final long serialVersionUID = 8467731497188267008L;
	public static final String NAME = "EmploymentAppSourceType";
	/**
	 * Employment App Source Type Id
	 */
	@Getter
	@Setter
	private String employmentAppSourceTypeId;
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

	public EmploymentAppSourceType(GenericValue value) {
		employmentAppSourceTypeId = (String) value
				.get(FIELD_EMPLOYMENT_APP_SOURCE_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EmploymentAppSourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmploymentAppSourceType(value);
	}

	public static List<EmploymentAppSourceType> fromValues(
			List<GenericValue> values) {
		List<EmploymentAppSourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmploymentAppSourceType(value));
		}
		return entities;
	}
}