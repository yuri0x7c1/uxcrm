package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pay Grade
 */
@FieldNameConstants
public class PayGrade implements Serializable {

	public static final long serialVersionUID = 2054061530253538304L;
	public static final String NAME = "PayGrade";
	/**
	 * Pay Grade Id
	 */
	@Getter
	@Setter
	private String payGradeId;
	/**
	 * Pay Grade Name
	 */
	@Getter
	@Setter
	private String payGradeName;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public PayGrade(GenericValue value) {
		payGradeId = (String) value.get(FIELD_PAY_GRADE_ID);
		payGradeName = (String) value.get(FIELD_PAY_GRADE_NAME);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PayGrade fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PayGrade(value);
	}

	public static List<PayGrade> fromValues(List<GenericValue> values) {
		List<PayGrade> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PayGrade(value));
		}
		return entities;
	}
}