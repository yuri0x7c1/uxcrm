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
 * Temporal Expression Assoc
 */
@FieldNameConstants
public class TemporalExpressionAssoc implements Serializable {

	public static final long serialVersionUID = 6063476753889762304L;
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

	public TemporalExpressionAssoc(GenericValue value) {
		fromTempExprId = (String) value.get(FIELD_FROM_TEMP_EXPR_ID);
		toTempExprId = (String) value.get(FIELD_TO_TEMP_EXPR_ID);
		exprAssocType = (String) value.get(FIELD_EXPR_ASSOC_TYPE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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