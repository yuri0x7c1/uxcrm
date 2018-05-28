package org.apache.ofbiz.entity.test;

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
public class TestingSubtype implements Serializable {

	public static final long serialVersionUID = 9012265776783510528L;
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

	public enum Fields {
		testingTypeId, subtypeDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingSubtype(GenericValue value) {
		testingTypeId = (String) value.get(Fields.testingTypeId.name());
		subtypeDescription = (String) value.get(Fields.subtypeDescription
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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