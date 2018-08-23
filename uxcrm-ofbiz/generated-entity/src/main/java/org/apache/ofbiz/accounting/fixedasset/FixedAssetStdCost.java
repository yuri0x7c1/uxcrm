package org.apache.ofbiz.accounting.fixedasset;

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
 * Fixed Asset Std Cost
 */
@FieldNameConstants
public class FixedAssetStdCost implements Serializable {

	public static final long serialVersionUID = 8351005599636048896L;
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

	public FixedAssetStdCost(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		fixedAssetStdCostTypeId = (String) value
				.get(FIELD_FIXED_ASSET_STD_COST_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		amountUomId = (String) value.get(FIELD_AMOUNT_UOM_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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