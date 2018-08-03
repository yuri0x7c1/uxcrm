package org.apache.ofbiz.accounting.ledger;

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
public class GlReconciliation implements Serializable {

	public static final long serialVersionUID = 1724827540701358080L;
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

	public enum Fields {
		glReconciliationId, glReconciliationName, description, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, glAccountId, statusId, organizationPartyId, reconciledBalance, openingBalance, reconciledDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlReconciliation(GenericValue value) {
		glReconciliationId = (String) value.get(Fields.glReconciliationId
				.name());
		glReconciliationName = (String) value.get(Fields.glReconciliationName
				.name());
		description = (String) value.get(Fields.description.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		statusId = (String) value.get(Fields.statusId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		reconciledBalance = (BigDecimal) value.get(Fields.reconciledBalance
				.name());
		openingBalance = (BigDecimal) value.get(Fields.openingBalance.name());
		reconciledDate = (Timestamp) value.get(Fields.reconciledDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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