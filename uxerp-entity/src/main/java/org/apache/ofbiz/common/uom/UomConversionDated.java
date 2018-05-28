package org.apache.ofbiz.common.uom;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom Conversion Dated
 */
public class UomConversionDated implements Serializable {

	public static final long serialVersionUID = 8666082883138492416L;
	public static final String NAME = "UomConversionDated";
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Uom Id To
	 */
	@Getter
	@Setter
	private String uomIdTo;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Conversion Factor
	 */
	@Getter
	@Setter
	private Double conversionFactor;
	/**
	 * Custom Method Id
	 */
	@Getter
	@Setter
	private String customMethodId;
	/**
	 * Decimal Scale
	 */
	@Getter
	@Setter
	private Long decimalScale;
	/**
	 * Rounding Mode
	 */
	@Getter
	@Setter
	private String roundingMode;
	/**
	 * Purpose Enum Id
	 */
	@Getter
	@Setter
	private String purposeEnumId;
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
		uomId, uomIdTo, fromDate, thruDate, conversionFactor, customMethodId, decimalScale, roundingMode, purposeEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UomConversionDated(GenericValue value) {
		uomId = (String) value.get(Fields.uomId.name());
		uomIdTo = (String) value.get(Fields.uomIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		conversionFactor = (Double) value.get(Fields.conversionFactor.name());
		customMethodId = (String) value.get(Fields.customMethodId.name());
		decimalScale = (Long) value.get(Fields.decimalScale.name());
		roundingMode = (String) value.get(Fields.roundingMode.name());
		purposeEnumId = (String) value.get(Fields.purposeEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static UomConversionDated fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UomConversionDated(value);
	}

	public static List<UomConversionDated> fromValues(List<GenericValue> values) {
		List<UomConversionDated> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomConversionDated(value));
		}
		return entities;
	}
}