package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Std Cost
 */
public class FixedAssetStdCost implements Serializable {

	public static final long serialVersionUID = 5934552861855409152L;
	public static final String NAME = "FixedAssetStdCost";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Fixed Asset Std Cost Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetStdCostTypeId;
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
	 * Amount Uom Id
	 */
	@Getter
	@Setter
	private String amountUomId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
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
		fixedAssetId, fixedAssetStdCostTypeId, fromDate, thruDate, amountUomId, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetStdCost(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		fixedAssetStdCostTypeId = (String) value
				.get(Fields.fixedAssetStdCostTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		amountUomId = (String) value.get(Fields.amountUomId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FixedAssetStdCost fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetStdCost(value);
	}

	public static List<FixedAssetStdCost> fromValues(List<GenericValue> values) {
		List<FixedAssetStdCost> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetStdCost(value));
		}
		return entities;
	}
}