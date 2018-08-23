package org.apache.ofbiz.common.period;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Period Type
 */
@FieldNameConstants
public class PeriodType implements Serializable {

	public static final long serialVersionUID = 5886526037024952320L;
	public static final String NAME = "PeriodType";
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Period Length
	 */
	@Getter
	@Setter
	private Long periodLength;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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

	public PeriodType(GenericValue value) {
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		periodLength = (Long) value.get(FIELD_PERIOD_LENGTH);
		uomId = (String) value.get(FIELD_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PeriodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PeriodType(value);
	}

	public static List<PeriodType> fromValues(List<GenericValue> values) {
		List<PeriodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PeriodType(value));
		}
		return entities;
	}
}