package org.apache.ofbiz.common.period;

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
public class PeriodType implements Serializable {

	public static final long serialVersionUID = 5208498848886172672L;
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

	public enum Fields {
		periodTypeId, description, periodLength, uomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PeriodType(GenericValue value) {
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		description = (String) value.get(Fields.description.name());
		periodLength = (Long) value.get(Fields.periodLength.name());
		uomId = (String) value.get(Fields.uomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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