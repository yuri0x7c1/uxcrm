package org.apache.ofbiz.service.schedule;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TemporalExpressionChild implements Serializable {

	public static final long serialVersionUID = 371911517131707392L;
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

	public TemporalExpressionChild(GenericValue value) {
		fromTempExprId = (String) value.get(FIELD_FROM_TEMP_EXPR_ID);
		exprAssocType = (String) value.get(FIELD_EXPR_ASSOC_TYPE);
		description = (String) value.get(FIELD_DESCRIPTION);
		integer1 = (Long) value.get(FIELD_INTEGER1);
		tempExprId = (String) value.get(FIELD_TEMP_EXPR_ID);
		date2 = (Timestamp) value.get(FIELD_DATE2);
		date1 = (Timestamp) value.get(FIELD_DATE1);
		integer2 = (Long) value.get(FIELD_INTEGER2);
		string1 = (String) value.get(FIELD_STRING1);
		string2 = (String) value.get(FIELD_STRING2);
		tempExprTypeId = (String) value.get(FIELD_TEMP_EXPR_TYPE_ID);
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