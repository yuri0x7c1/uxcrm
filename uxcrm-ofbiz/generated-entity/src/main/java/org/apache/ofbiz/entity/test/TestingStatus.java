package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Status
 */
public class TestingStatus implements Serializable {

	public static final long serialVersionUID = 8971772918089141248L;
	public static final String NAME = "TestingStatus";
	/**
	 * Testing Status Id
	 */
	@Getter
	@Setter
	private String testingStatusId;
	/**
	 * Testing Id
	 */
	@Getter
	@Setter
	private String testingId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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
		testingStatusId, testingId, statusId, statusDate, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingStatus(GenericValue value) {
		testingStatusId = (String) value.get(Fields.testingStatusId.name());
		testingId = (String) value.get(Fields.testingId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestingStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingStatus(value);
	}

	public static List<TestingStatus> fromValues(List<GenericValue> values) {
		List<TestingStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingStatus(value));
		}
		return entities;
	}
}