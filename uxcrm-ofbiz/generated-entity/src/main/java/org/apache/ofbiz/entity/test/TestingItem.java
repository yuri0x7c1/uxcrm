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
 * Testing Item
 */
@FieldNameConstants
public class TestingItem implements Serializable {

	public static final long serialVersionUID = 8157873223734940672L;
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

	public TestingItem(GenericValue value) {
		testingId = (String) value.get(FIELD_TESTING_ID);
		testingSeqId = (String) value.get(FIELD_TESTING_SEQ_ID);
		testingHistory = (String) value.get(FIELD_TESTING_HISTORY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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