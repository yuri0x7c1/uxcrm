package org.apache.ofbiz.shipment.shipment;

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
public class ShipmentPackage implements Serializable {

	public static final long serialVersionUID = 3590650476500379648L;
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

	public enum Fields {
		shipmentId, shipmentPackageSeqId, shipmentBoxTypeId, dateCreated, boxLength, boxHeight, boxWidth, dimensionUomId, weight, weightUomId, insuredValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentPackage(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		shipmentBoxTypeId = (String) value.get(Fields.shipmentBoxTypeId.name());
		dateCreated = (Timestamp) value.get(Fields.dateCreated.name());
		boxLength = (BigDecimal) value.get(Fields.boxLength.name());
		boxHeight = (BigDecimal) value.get(Fields.boxHeight.name());
		boxWidth = (BigDecimal) value.get(Fields.boxWidth.name());
		dimensionUomId = (String) value.get(Fields.dimensionUomId.name());
		weight = (BigDecimal) value.get(Fields.weight.name());
		weightUomId = (String) value.get(Fields.weightUomId.name());
		insuredValue = (BigDecimal) value.get(Fields.insuredValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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