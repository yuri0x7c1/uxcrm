package org.apache.ofbiz.entity.test;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Blob;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Test Blob
 */
@FieldNameConstants
public class TestBlob implements Serializable {

	public static final long serialVersionUID = 7977594869537186816L;
	public static final String NAME = "TestBlob";
	/**
	 * Test Blob Id
	 */
	@Getter
	@Setter
	private String testBlobId;
	/**
	 * Test Blob Field
	 */
	@Getter
	@Setter
	private Blob testBlobField;
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

	public TestBlob(GenericValue value) {
		testBlobId = (String) value.get(FIELD_TEST_BLOB_ID);
		testBlobField = (Blob) value.get(FIELD_TEST_BLOB_FIELD);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TestBlob fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new TestBlob(value);
	}

	public static List<TestBlob> fromValues(List<GenericValue> values) {
		List<TestBlob> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestBlob(value));
		}
		return entities;
	}
}