package org.apache.ofbiz.service.schedule;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Temporal Expression Child
 */
public class TemporalExpressionChild implements Serializable {

	public static final long serialVersionUID = 154996585488178176L;
	public static final String NAME = "TemporalExpressionChild";
	/**
	 * From Temp Expr Id
	 */
	@Getter
	@Setter
	private String fromTempExprId;
	/**
	 * Expr Assoc Type
	 */
	@Getter
	@Setter
	private String exprAssocType;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Integer 1
	 */
	@Getter
	@Setter
	private Long integer1;
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Date 2
	 */
	@Getter
	@Setter
	private Timestamp date2;
	/**
	 * Date 1
	 */
	@Getter
	@Setter
	private Timestamp date1;
	/**
	 * Integer 2
	 */
	@Getter
	@Setter
	private Long integer2;
	/**
	 * String 1
	 */
	@Getter
	@Setter
	private String string1;
	/**
	 * String 2
	 */
	@Getter
	@Setter
	private String string2;
	/**
	 * Temp Expr Type Id
	 */
	@Getter
	@Setter
	private String tempExprTypeId;

	public enum Fields {
		fromTempExprId, exprAssocType, description, integer1, tempExprId, date2, date1, integer2, string1, string2, tempExprTypeId
	}

	public TemporalExpressionChild(GenericValue value) {
		fromTempExprId = (String) value.get(Fields.fromTempExprId.name());
		exprAssocType = (String) value.get(Fields.exprAssocType.name());
		description = (String) value.get(Fields.description.name());
		integer1 = (Long) value.get(Fields.integer1.name());
		tempExprId = (String) value.get(Fields.tempExprId.name());
		date2 = (Timestamp) value.get(Fields.date2.name());
		date1 = (Timestamp) value.get(Fields.date1.name());
		integer2 = (Long) value.get(Fields.integer2.name());
		string1 = (String) value.get(Fields.string1.name());
		string2 = (String) value.get(Fields.string2.name());
		tempExprTypeId = (String) value.get(Fields.tempExprTypeId.name());
	}

	public static TemporalExpressionChild fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TemporalExpressionChild(value);
	}

	public static List<TemporalExpressionChild> fromValues(
			List<GenericValue> values) {
		List<TemporalExpressionChild> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TemporalExpressionChild(value));
		}
		return entities;
	}
}