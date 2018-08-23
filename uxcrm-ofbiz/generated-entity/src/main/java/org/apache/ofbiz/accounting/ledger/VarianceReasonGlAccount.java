package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Variance Reason Gl Account
 */
@FieldNameConstants
public class VarianceReasonGlAccount implements Serializable {

	public static final long serialVersionUID = 3201123232685629440L;
	public static final String NAME = "VarianceReasonGlAccount";
	/**
	 * Variance Reason Id
	 */
	@Getter
	@Setter
	private String varianceReasonId;
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

	public VarianceReasonGlAccount(GenericValue value) {
		varianceReasonId = (String) value.get(FIELD_VARIANCE_REASON_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static VarianceReasonGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VarianceReasonGlAccount(value);
	}

	public static List<VarianceReasonGlAccount> fromValues(
			List<GenericValue> values) {
		List<VarianceReasonGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VarianceReasonGlAccount(value));
		}
		return entities;
	}
}