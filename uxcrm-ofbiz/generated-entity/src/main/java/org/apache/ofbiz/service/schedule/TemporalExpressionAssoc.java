package org.apache.ofbiz.service.schedule;

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
public class TemporalExpressionAssoc implements Serializable {

	public static final long serialVersionUID = 2755574832996647936L;
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

	public enum Fields {
		fromTempExprId, toTempExprId, exprAssocType, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TemporalExpressionAssoc(GenericValue value) {
		fromTempExprId = (String) value.get(Fields.fromTempExprId.name());
		toTempExprId = (String) value.get(Fields.toTempExprId.name());
		exprAssocType = (String) value.get(Fields.exprAssocType.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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