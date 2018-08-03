package org.apache.ofbiz.entity.test;

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
public class TestBlob implements Serializable {

	public static final long serialVersionUID = 5262019409042814976L;
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

	public enum Fields {
		testBlobId, testBlobField, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestBlob(GenericValue value) {
		testBlobId = (String) value.get(Fields.testBlobId.name());
		testBlobField = (Blob) value.get(Fields.testBlobField.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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