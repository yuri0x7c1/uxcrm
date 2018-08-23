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
 * Testing Node
 */
@FieldNameConstants
public class TestingNode implements Serializable {

	public static final long serialVersionUID = 6145637462672090112L;
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

	public TestingNode(GenericValue value) {
		testingNodeId = (String) value.get(FIELD_TESTING_NODE_ID);
		primaryParentNodeId = (String) value.get(FIELD_PRIMARY_PARENT_NODE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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