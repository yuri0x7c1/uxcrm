package org.apache.ofbiz.accounting.finaccount;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Type Gl Account
 */
@FieldNameConstants
public class FinAccountTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 2672414553860622336L;
	public static final String NAME = "FinAccountTypeGlAccount";
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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

	public FinAccountTypeGlAccount(GenericValue value) {
		finAccountTypeId = (String) value.get(FIELD_FIN_ACCOUNT_TYPE_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FinAccountTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTypeGlAccount(value);
	}

	public static List<FinAccountTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<FinAccountTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTypeGlAccount(value));
		}
		return entities;
	}
}