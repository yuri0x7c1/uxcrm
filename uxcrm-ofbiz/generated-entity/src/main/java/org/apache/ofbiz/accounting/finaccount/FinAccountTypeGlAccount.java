package org.apache.ofbiz.accounting.finaccount;

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
public class FinAccountTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 2831309603209634816L;
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

	public enum Fields {
		finAccountTypeId, organizationPartyId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FinAccountTypeGlAccount(GenericValue value) {
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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