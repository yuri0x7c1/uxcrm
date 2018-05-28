package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Item
 */
public class TestingItem implements Serializable {

	public static final long serialVersionUID = 6350237476530011136L;
	public static final String NAME = "TestingItem";
	/**
	 * Testing Id
	 */
	@Getter
	@Setter
	private String testingId;
	/**
	 * Testing Seq Id
	 */
	@Getter
	@Setter
	private String testingSeqId;
	/**
	 * Testing History
	 */
	@Getter
	@Setter
	private String testingHistory;
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
		testingId, testingSeqId, testingHistory, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingItem(GenericValue value) {
		testingId = (String) value.get(Fields.testingId.name());
		testingSeqId = (String) value.get(Fields.testingSeqId.name());
		testingHistory = (String) value.get(Fields.testingHistory.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestingItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingItem(value);
	}

	public static List<TestingItem> fromValues(List<GenericValue> values) {
		List<TestingItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingItem(value));
		}
		return entities;
	}
}