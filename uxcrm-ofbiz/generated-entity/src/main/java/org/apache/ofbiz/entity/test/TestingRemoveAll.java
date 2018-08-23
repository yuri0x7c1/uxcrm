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
 * Testing Remove All
 */
@FieldNameConstants
public class TestingRemoveAll implements Serializable {

	public static final long serialVersionUID = 3784894537806929920L;
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

	public TestingRemoveAll(GenericValue value) {
		testingRemoveAllId = (String) value.get(FIELD_TESTING_REMOVE_ALL_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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