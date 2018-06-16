package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing
 */
public class Testing implements Serializable {

	public static final long serialVersionUID = 6830698849427759104L;
	public static final String NAME = "Testing";
	/**
	 * Testing Id
	 */
	@Getter
	@Setter
	private String testingId;
	/**
	 * Testing Type Id
	 */
	@Getter
	@Setter
	private String testingTypeId;
	/**
	 * Testing Name
	 */
	@Getter
	@Setter
	private String testingName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Testing Size
	 */
	@Getter
	@Setter
	private Long testingSize;
	/**
	 * Testing Date
	 */
	@Getter
	@Setter
	private Timestamp testingDate;
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
		testingId, testingTypeId, testingName, description, comments, testingSize, testingDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Testing(GenericValue value) {
		testingId = (String) value.get(Fields.testingId.name());
		testingTypeId = (String) value.get(Fields.testingTypeId.name());
		testingName = (String) value.get(Fields.testingName.name());
		description = (String) value.get(Fields.description.name());
		comments = (String) value.get(Fields.comments.name());
		testingSize = (Long) value.get(Fields.testingSize.name());
		testingDate = (Timestamp) value.get(Fields.testingDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Testing fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Testing(value);
	}

	public static List<Testing> fromValues(List<GenericValue> values) {
		List<Testing> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Testing(value));
		}
		return entities;
	}
}