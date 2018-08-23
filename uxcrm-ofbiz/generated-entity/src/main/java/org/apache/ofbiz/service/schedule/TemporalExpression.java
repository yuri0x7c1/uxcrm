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
 * Temporal Expression
 */
@FieldNameConstants
public class TemporalExpression implements Serializable {

	public static final long serialVersionUID = 6189172802735221760L;
	public static final String NAME = "TemporalExpression";
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

	public TemporalExpression(GenericValue value) {
		tempExprId = (String) value.get(FIELD_TEMP_EXPR_ID);
		tempExprTypeId = (String) value.get(FIELD_TEMP_EXPR_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		date1 = (Timestamp) value.get(FIELD_DATE1);
		date2 = (Timestamp) value.get(FIELD_DATE2);
		integer1 = (Long) value.get(FIELD_INTEGER1);
		integer2 = (Long) value.get(FIELD_INTEGER2);
		string1 = (String) value.get(FIELD_STRING1);
		string2 = (String) value.get(FIELD_STRING2);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TemporalExpression fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TemporalExpression(value);
	}

	public static List<TemporalExpression> fromValues(List<GenericValue> values) {
		List<TemporalExpression> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TemporalExpression(value));
		}
		return entities;
	}
}