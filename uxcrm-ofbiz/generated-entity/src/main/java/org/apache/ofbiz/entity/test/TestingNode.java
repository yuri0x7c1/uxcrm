package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Node
 */
public class TestingNode implements Serializable {

	public static final long serialVersionUID = 584797690221105152L;
	public static final String NAME = "TestingNode";
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
		testingNodeId, primaryParentNodeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingNode(GenericValue value) {
		testingNodeId = (String) value.get(Fields.testingNodeId.name());
		primaryParentNodeId = (String) value.get(Fields.primaryParentNodeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestingNode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingNode(value);
	}

	public static List<TestingNode> fromValues(List<GenericValue> values) {
		List<TestingNode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingNode(value));
		}
		return entities;
	}
}