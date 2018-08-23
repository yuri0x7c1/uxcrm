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
 * Uom Conversion
 */
@FieldNameConstants
public class UomConversion implements Serializable {

	public static final long serialVersionUID = 191057911907476480L;
	public static final String NAME = "UomConversion";
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

	public UomConversion(GenericValue value) {
		uomId = (String) value.get(FIELD_UOM_ID);
		uomIdTo = (String) value.get(FIELD_UOM_ID_TO);
		conversionFactor = (Double) value.get(FIELD_CONVERSION_FACTOR);
		customMethodId = (String) value.get(FIELD_CUSTOM_METHOD_ID);
		decimalScale = (Long) value.get(FIELD_DECIMAL_SCALE);
		roundingMode = (String) value.get(FIELD_ROUNDING_MODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UomConversion fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UomConversion(value);
	}

	public static List<UomConversion> fromValues(List<GenericValue> values) {
		List<UomConversion> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomConversion(value));
		}
		return entities;
	}
}