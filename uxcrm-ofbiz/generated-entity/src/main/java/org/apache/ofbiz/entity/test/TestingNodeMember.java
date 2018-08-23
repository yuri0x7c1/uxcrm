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
 * Testing Node Member
 */
@FieldNameConstants
public class TestingNodeMember implements Serializable {

	public static final long serialVersionUID = 7467412622559655936L;
	public static final String NAME = "TestingNodeMember";
	/**
	 * Testing Node Id
	 */
	@Getter
	@Setter
	private String testingNodeId;
	/**
	 * Testing Id
	 */
	@Getter
	@Setter
	private String testingId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Extend From Date
	 */
	@Getter
	@Setter
	private Timestamp extendFromDate;
	/**
	 * Extend Thru Date
	 */
	@Getter
	@Setter
	private Timestamp extendThruDate;
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

	public TestingNodeMember(GenericValue value) {
		testingNodeId = (String) value.get(FIELD_TESTING_NODE_ID);
		testingId = (String) value.get(FIELD_TESTING_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		extendFromDate = (Timestamp) value.get(FIELD_EXTEND_FROM_DATE);
		extendThruDate = (Timestamp) value.get(FIELD_EXTEND_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TestingNodeMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingNodeMember(value);
	}

	public static List<TestingNodeMember> fromValues(List<GenericValue> values) {
		List<TestingNodeMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingNodeMember(value));
		}
		return entities;
	}
}