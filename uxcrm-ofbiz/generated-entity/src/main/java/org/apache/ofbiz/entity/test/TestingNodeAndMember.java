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
 * Testing Node And Member
 */
@FieldNameConstants
public class TestingNodeAndMember implements Serializable {

	public static final long serialVersionUID = 8845544853458659328L;
	public static final String NAME = "TestingNodeAndMember";
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Testing Node Id
	 */
	@Getter
	@Setter
	private String testingNodeId;
	/**
	 * Primary Parent Node Id
	 */
	@Getter
	@Setter
	private String primaryParentNodeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Extend From Date
	 */
	@Getter
	@Setter
	private Timestamp extendFromDate;
	/**
	 * Testing Id
	 */
	@Getter
	@Setter
	private String testingId;
	/**
	 * Extend Thru Date
	 */
	@Getter
	@Setter
	private Timestamp extendThruDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public TestingNodeAndMember(GenericValue value) {
		description = (String) value.get(FIELD_DESCRIPTION);
		testingNodeId = (String) value.get(FIELD_TESTING_NODE_ID);
		primaryParentNodeId = (String) value.get(FIELD_PRIMARY_PARENT_NODE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		extendFromDate = (Timestamp) value.get(FIELD_EXTEND_FROM_DATE);
		testingId = (String) value.get(FIELD_TESTING_ID);
		extendThruDate = (Timestamp) value.get(FIELD_EXTEND_THRU_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static TestingNodeAndMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingNodeAndMember(value);
	}

	public static List<TestingNodeAndMember> fromValues(
			List<GenericValue> values) {
		List<TestingNodeAndMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingNodeAndMember(value));
		}
		return entities;
	}
}