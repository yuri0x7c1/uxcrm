package org.apache.ofbiz.common.uom.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom Conversion
 */
public class UomConversion implements Serializable {

	public static final long serialVersionUID = 9216647749047040000L;
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

	public enum Fields {
		uomId, uomIdTo, conversionFactor, customMethodId, decimalScale, roundingMode
	}

	public UomConversion(GenericValue value) {
		uomId = (String) value.get(Fields.uomId.name());
		uomIdTo = (String) value.get(Fields.uomIdTo.name());
		conversionFactor = (Double) value.get(Fields.conversionFactor.name());
		customMethodId = (String) value.get(Fields.customMethodId.name());
		decimalScale = (Long) value.get(Fields.decimalScale.name());
		roundingMode = (String) value.get(Fields.roundingMode.name());
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