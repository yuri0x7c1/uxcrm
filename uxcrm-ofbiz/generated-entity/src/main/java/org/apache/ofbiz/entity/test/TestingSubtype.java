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
 * Testing Subtype
 */
@FieldNameConstants
public class TestingSubtype implements Serializable {

	public static final long serialVersionUID = 328356854299448320L;
	public static final String NAME = "TestingSubtype";
	/**
	 * Testing Type Id
	 */
	@Getter
	@Setter
	private String testingTypeId;
	/**
	 * Subtype Description
	 */
	@Getter
	@Setter
	private String subtypeDescription;
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

	public TestingSubtype(GenericValue value) {
		testingTypeId = (String) value.get(FIELD_TESTING_TYPE_ID);
		subtypeDescription = (String) value.get(FIELD_SUBTYPE_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TestingSubtype fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingSubtype(value);
	}

	public static List<TestingSubtype> fromValues(List<GenericValue> values) {
		List<TestingSubtype> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingSubtype(value));
		}
		return entities;
	}
}