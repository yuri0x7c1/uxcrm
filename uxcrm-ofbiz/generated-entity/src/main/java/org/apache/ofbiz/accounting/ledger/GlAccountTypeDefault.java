package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Type Default
 */
public class GlAccountTypeDefault implements Serializable {

	public static final long serialVersionUID = 4913362668007656448L;
	public static final String NAME = "GlAccountTypeDefault";
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
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
		glAccountTypeId, organizationPartyId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccountTypeDefault(GenericValue value) {
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
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

	public static GlAccountTypeDefault fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountTypeDefault(value);
	}

	public static List<GlAccountTypeDefault> fromValues(
			List<GenericValue> values) {
		List<GlAccountTypeDefault> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountTypeDefault(value));
		}
		return entities;
	}
}