package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Type Gl Account
 */
@FieldNameConstants
public class FixedAssetTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 6942619562717492224L;
	public static final String NAME = "FixedAssetTypeGlAccount";
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Asset Gl Account Id
	 */
	@Getter
	@Setter
	private String assetGlAccountId;
	/**
	 * Acc Dep Gl Account Id
	 */
	@Getter
	@Setter
	private String accDepGlAccountId;
	/**
	 * Dep Gl Account Id
	 */
	@Getter
	@Setter
	private String depGlAccountId;
	/**
	 * Profit Gl Account Id
	 */
	@Getter
	@Setter
	private String profitGlAccountId;
	/**
	 * Loss Gl Account Id
	 */
	@Getter
	@Setter
	private String lossGlAccountId;
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

	public FixedAssetTypeGlAccount(GenericValue value) {
		fixedAssetTypeId = (String) value.get(FIELD_FIXED_ASSET_TYPE_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		assetGlAccountId = (String) value.get(FIELD_ASSET_GL_ACCOUNT_ID);
		accDepGlAccountId = (String) value.get(FIELD_ACC_DEP_GL_ACCOUNT_ID);
		depGlAccountId = (String) value.get(FIELD_DEP_GL_ACCOUNT_ID);
		profitGlAccountId = (String) value.get(FIELD_PROFIT_GL_ACCOUNT_ID);
		lossGlAccountId = (String) value.get(FIELD_LOSS_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FixedAssetTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetTypeGlAccount(value);
	}

	public static List<FixedAssetTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<FixedAssetTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetTypeGlAccount(value));
		}
		return entities;
	}
}