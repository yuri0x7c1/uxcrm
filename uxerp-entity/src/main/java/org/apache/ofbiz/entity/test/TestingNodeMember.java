package org.apache.ofbiz.entity.test;

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
public class TestingNodeMember implements Serializable {

	public static final long serialVersionUID = 6207017678873372672L;
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

	public enum Fields {
		testingNodeId, testingId, fromDate, thruDate, extendFromDate, extendThruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingNodeMember(GenericValue value) {
		testingNodeId = (String) value.get(Fields.testingNodeId.name());
		testingId = (String) value.get(Fields.testingId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		extendFromDate = (Timestamp) value.get(Fields.extendFromDate.name());
		extendThruDate = (Timestamp) value.get(Fields.extendThruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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