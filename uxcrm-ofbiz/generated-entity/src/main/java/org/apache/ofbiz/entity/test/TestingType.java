package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Type
 */
public class TestingType implements Serializable {

	public static final long serialVersionUID = 2841628901076020224L;
	public static final String NAME = "TestingType";
	/**
	 * Testing Type Id
	 */
	@Getter
	@Setter
	private String testingTypeId;
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

	public enum Fields {
		testingTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingType(GenericValue value) {
		testingTypeId = (String) value.get(Fields.testingTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestingType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingType(value);
	}

	public static List<TestingType> fromValues(List<GenericValue> values) {
		List<TestingType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingType(value));
		}
		return entities;
	}
}