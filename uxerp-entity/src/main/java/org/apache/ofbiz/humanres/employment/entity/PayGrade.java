package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pay Grade
 */
public class PayGrade implements Serializable {

	public static final long serialVersionUID = 475579868658900992L;
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

	public enum Fields {
		payGradeId, payGradeName, comments
	}

	public PayGrade(GenericValue value) {
		payGradeId = (String) value.get(Fields.payGradeId.name());
		payGradeName = (String) value.get(Fields.payGradeName.name());
		comments = (String) value.get(Fields.comments.name());
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