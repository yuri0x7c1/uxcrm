package org.apache.ofbiz.service.schedule.entity.view;

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

	public static final long serialVersionUID = 7586740127075712000L;
	public static final String NAME = "TemporalExpressionChild";
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
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Temp Expr Type Id
	 */
	@Getter
	@Setter
	private String tempExprTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Date 1
	 */
	@Getter
	@Setter
	private Timestamp date1;
	/**
	 * Date 2
	 */
	@Getter
	@Setter
	private Timestamp date2;
	/**
	 * Integer 1
	 */
	@Getter
	@Setter
	private Long integer1;
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

	public enum Fields {
		fromTempExprId, toTempExprId, exprAssocType, tempExprId, tempExprTypeId, description, date1, date2, integer1, integer2, string1, string2
	}

	public TemporalExpressionChild(GenericValue value) {
		fromTempExprId = (String) value.get(Fields.fromTempExprId.name());
		toTempExprId = (String) value.get(Fields.toTempExprId.name());
		exprAssocType = (String) value.get(Fields.exprAssocType.name());
		tempExprId = (String) value.get(Fields.tempExprId.name());
		tempExprTypeId = (String) value.get(Fields.tempExprTypeId.name());
		description = (String) value.get(Fields.description.name());
		date1 = (Timestamp) value.get(Fields.date1.name());
		date2 = (Timestamp) value.get(Fields.date2.name());
		integer1 = (Long) value.get(Fields.integer1.name());
		integer2 = (Long) value.get(Fields.integer2.name());
		string1 = (String) value.get(Fields.string1.name());
		string2 = (String) value.get(Fields.string2.name());
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