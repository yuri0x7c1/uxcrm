package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Remove All
 */
public class TestingRemoveAll implements Serializable {

	public static final long serialVersionUID = 2220132272637774848L;
	public static final String NAME = "TestingRemoveAll";
	/**
	 * Testing Remove All Id
	 */
	@Getter
	@Setter
	private String testingRemoveAllId;
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
		testingRemoveAllId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingRemoveAll(GenericValue value) {
		testingRemoveAllId = (String) value.get(Fields.testingRemoveAllId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestingRemoveAll fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingRemoveAll(value);
	}

	public static List<TestingRemoveAll> fromValues(List<GenericValue> values) {
		List<TestingRemoveAll> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingRemoveAll(value));
		}
		return entities;
	}
}