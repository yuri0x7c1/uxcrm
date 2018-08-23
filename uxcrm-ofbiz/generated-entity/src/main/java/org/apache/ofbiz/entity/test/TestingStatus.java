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
 * Testing Status
 */
@FieldNameConstants
public class TestingStatus implements Serializable {

	public static final long serialVersionUID = 605595151494705152L;
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

	public TestingStatus(GenericValue value) {
		testingStatusId = (String) value.get(FIELD_TESTING_STATUS_ID);
		testingId = (String) value.get(FIELD_TESTING_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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