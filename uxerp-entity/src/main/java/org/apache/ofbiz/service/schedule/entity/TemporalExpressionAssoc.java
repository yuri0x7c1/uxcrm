package org.apache.ofbiz.service.schedule.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Temporal Expression Assoc
 */
public class TemporalExpressionAssoc implements Serializable {

	public static final long serialVersionUID = 5585278198978885632L;
	public static final String NAME = "TemporalExpressionAssoc";
	/**
	 * From Temp Expr Id
	 */
	@Getter
	@Setter
	private String fromTempExprId;
	/**
	 * To Temp Expr Id
	 */
	@Getter
	@Setter
	private String toTempExprId;
	/**
	 * Expr Assoc Type
	 */
	@Getter
	@Setter
	private String exprAssocType;

	public enum Fields {
		fromTempExprId, toTempExprId, exprAssocType
	}

	public TemporalExpressionAssoc(GenericValue value) {
		fromTempExprId = (String) value.get(Fields.fromTempExprId.name());
		toTempExprId = (String) value.get(Fields.toTempExprId.name());
		exprAssocType = (String) value.get(Fields.exprAssocType.name());
	}

	public static TemporalExpressionAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TemporalExpressionAssoc(value);
	}

	public static List<TemporalExpressionAssoc> fromValues(
			List<GenericValue> values) {
		List<TemporalExpressionAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TemporalExpressionAssoc(value));
		}
		return entities;
	}
}