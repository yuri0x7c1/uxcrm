package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Package
 */
@FieldNameConstants
public class ShipmentPackage implements Serializable {

	public static final long serialVersionUID = 4048134904825254912L;
	public static final String NAME = "ShipmentPackage";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String shipmentBoxTypeId;
	/**
	 * Date Created
	 */
	@Getter
	@Setter
	private Timestamp dateCreated;
	/**
	 * Box Length
	 */
	@Getter
	@Setter
	private BigDecimal boxLength;
	/**
	 * Box Height
	 */
	@Getter
	@Setter
	private BigDecimal boxHeight;
	/**
	 * Box Width
	 */
	@Getter
	@Setter
	private BigDecimal boxWidth;
	/**
	 * Dimension Uom Id
	 */
	@Getter
	@Setter
	private String dimensionUomId;
	/**
	 * Weight
	 */
	@Getter
	@Setter
	private BigDecimal weight;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Insured Value
	 */
	@Getter
	@Setter
	private BigDecimal insuredValue;
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

	public ShipmentPackage(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		shipmentBoxTypeId = (String) value.get(FIELD_SHIPMENT_BOX_TYPE_ID);
		dateCreated = (Timestamp) value.get(FIELD_DATE_CREATED);
		boxLength = (BigDecimal) value.get(FIELD_BOX_LENGTH);
		boxHeight = (BigDecimal) value.get(FIELD_BOX_HEIGHT);
		boxWidth = (BigDecimal) value.get(FIELD_BOX_WIDTH);
		dimensionUomId = (String) value.get(FIELD_DIMENSION_UOM_ID);
		weight = (BigDecimal) value.get(FIELD_WEIGHT);
		weightUomId = (String) value.get(FIELD_WEIGHT_UOM_ID);
		insuredValue = (BigDecimal) value.get(FIELD_INSURED_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentPackage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentPackage(value);
	}

	public static List<ShipmentPackage> fromValues(List<GenericValue> values) {
		List<ShipmentPackage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentPackage(value));
		}
		return entities;
	}
}