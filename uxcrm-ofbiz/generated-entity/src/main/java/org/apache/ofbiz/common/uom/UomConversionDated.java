package org.apache.ofbiz.common.uom;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class UomConversionDated implements Serializable {

	public static final long serialVersionUID = 73354216073917440L;
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

	public UomConversionDated(GenericValue value) {
		uomId = (String) value.get(FIELD_UOM_ID);
		uomIdTo = (String) value.get(FIELD_UOM_ID_TO);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		conversionFactor = (Double) value.get(FIELD_CONVERSION_FACTOR);
		customMethodId = (String) value.get(FIELD_CUSTOM_METHOD_ID);
		decimalScale = (Long) value.get(FIELD_DECIMAL_SCALE);
		roundingMode = (String) value.get(FIELD_ROUNDING_MODE);
		purposeEnumId = (String) value.get(FIELD_PURPOSE_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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