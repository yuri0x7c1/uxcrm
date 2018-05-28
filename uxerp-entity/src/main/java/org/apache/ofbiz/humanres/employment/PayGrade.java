package org.apache.ofbiz.humanres.employment;

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
public class PayGrade implements Serializable {

	public static final long serialVersionUID = 2180491967919244288L;
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

	public enum Fields {
		payGradeId, payGradeName, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PayGrade(GenericValue value) {
		payGradeId = (String) value.get(Fields.payGradeId.name());
		payGradeName = (String) value.get(Fields.payGradeName.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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