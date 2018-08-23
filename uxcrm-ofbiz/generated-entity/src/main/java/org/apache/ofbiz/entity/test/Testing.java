package org.apache.ofbiz.entity.test;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing
 */
@FieldNameConstants
public class Testing implements Serializable {

	public static final long serialVersionUID = 214764517031608320L;
	public static final String NAME = "Testing";
	/**
	 * Testing Id
	 */
	@Getter
	@Setter
	private String testingId;
	/**
	 * Testing Type Id
	 */
	@Getter
	@Setter
	private String testingTypeId;
	/**
	 * Testing Name
	 */
	@Getter
	@Setter
	private String testingName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Testing Size
	 */
	@Getter
	@Setter
	private Long testingSize;
	/**
	 * Testing Date
	 */
	@Getter
	@Setter
	private Timestamp testingDate;
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

	public Testing(GenericValue value) {
		testingId = (String) value.get(FIELD_TESTING_ID);
		testingTypeId = (String) value.get(FIELD_TESTING_TYPE_ID);
		testingName = (String) value.get(FIELD_TESTING_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		comments = (String) value.get(FIELD_COMMENTS);
		testingSize = (Long) value.get(FIELD_TESTING_SIZE);
		testingDate = (Timestamp) value.get(FIELD_TESTING_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Testing fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Testing(value);
	}

	public static List<Testing> fromValues(List<GenericValue> values) {
		List<Testing> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Testing(value));
		}
		return entities;
	}
}