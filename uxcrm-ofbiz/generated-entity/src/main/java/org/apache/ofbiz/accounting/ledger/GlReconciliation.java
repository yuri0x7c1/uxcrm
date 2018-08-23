package org.apache.ofbiz.accounting.ledger;

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
 * Gl Reconciliation
 */
@FieldNameConstants
public class GlReconciliation implements Serializable {

	public static final long serialVersionUID = 8180406092561532928L;
	public static final String NAME = "GlReconciliation";
	/**
	 * Gl Reconciliation Id
	 */
	@Getter
	@Setter
	private String glReconciliationId;
	/**
	 * Gl Reconciliation Name
	 */
	@Getter
	@Setter
	private String glReconciliationName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Reconciled Balance
	 */
	@Getter
	@Setter
	private BigDecimal reconciledBalance;
	/**
	 * Opening Balance
	 */
	@Getter
	@Setter
	private BigDecimal openingBalance;
	/**
	 * Reconciled Date
	 */
	@Getter
	@Setter
	private Timestamp reconciledDate;
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

	public GlReconciliation(GenericValue value) {
		glReconciliationId = (String) value.get(FIELD_GL_RECONCILIATION_ID);
		glReconciliationName = (String) value.get(FIELD_GL_RECONCILIATION_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		reconciledBalance = (BigDecimal) value.get(FIELD_RECONCILED_BALANCE);
		openingBalance = (BigDecimal) value.get(FIELD_OPENING_BALANCE);
		reconciledDate = (Timestamp) value.get(FIELD_RECONCILED_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlReconciliation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlReconciliation(value);
	}

	public static List<GlReconciliation> fromValues(List<GenericValue> values) {
		List<GlReconciliation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlReconciliation(value));
		}
		return entities;
	}
}