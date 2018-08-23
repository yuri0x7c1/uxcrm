package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Box Type
 */
@FieldNameConstants
public class ShipmentBoxType implements Serializable {

	public static final long serialVersionUID = 7878680530336273408L;
	public static final String NAME = "ShipmentBoxType";
	/**
	 * Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String shipmentBoxTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Dimension Uom Id
	 */
	@Getter
	@Setter
	private String dimensionUomId;
	/**
	 * Box Length
	 */
	@Getter
	@Setter
	private BigDecimal boxLength;
	/**
	 * Box Width
	 */
	@Getter
	@Setter
	private BigDecimal boxWidth;
	/**
	 * Box Height
	 */
	@Getter
	@Setter
	private BigDecimal boxHeight;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Box Weight
	 */
	@Getter
	@Setter
	private BigDecimal boxWeight;
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

	public ShipmentBoxType(GenericValue value) {
		shipmentBoxTypeId = (String) value.get(FIELD_SHIPMENT_BOX_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		dimensionUomId = (String) value.get(FIELD_DIMENSION_UOM_ID);
		boxLength = (BigDecimal) value.get(FIELD_BOX_LENGTH);
		boxWidth = (BigDecimal) value.get(FIELD_BOX_WIDTH);
		boxHeight = (BigDecimal) value.get(FIELD_BOX_HEIGHT);
		weightUomId = (String) value.get(FIELD_WEIGHT_UOM_ID);
		boxWeight = (BigDecimal) value.get(FIELD_BOX_WEIGHT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentBoxType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentBoxType(value);
	}

	public static List<ShipmentBoxType> fromValues(List<GenericValue> values) {
		List<ShipmentBoxType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentBoxType(value));
		}
		return entities;
	}
}