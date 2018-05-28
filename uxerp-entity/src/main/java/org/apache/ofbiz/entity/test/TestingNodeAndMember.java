package org.apache.ofbiz.entity.test;

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
public class TestingNodeAndMember implements Serializable {

	public static final long serialVersionUID = 8857784084247583744L;
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

	public enum Fields {
		description, testingNodeId, primaryParentNodeId, fromDate, extendFromDate, testingId, extendThruDate, thruDate
	}

	public TestingNodeAndMember(GenericValue value) {
		description = (String) value.get(Fields.description.name());
		testingNodeId = (String) value.get(Fields.testingNodeId.name());
		primaryParentNodeId = (String) value.get(Fields.primaryParentNodeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		extendFromDate = (Timestamp) value.get(Fields.extendFromDate.name());
		testingId = (String) value.get(Fields.testingId.name());
		extendThruDate = (Timestamp) value.get(Fields.extendThruDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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