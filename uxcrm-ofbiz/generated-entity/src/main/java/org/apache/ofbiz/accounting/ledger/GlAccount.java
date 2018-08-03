package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account
 */
public class GlAccount implements Serializable {

	public static final long serialVersionUID = 351825516237824L;
	public static final String NAME = "GlAccount";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
	/**
	 * Parent Gl Account Id
	 */
	@Getter
	@Setter
	private String parentGlAccountId;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Account Name
	 */
	@Getter
	@Setter
	private String accountName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
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
		glAccountId, glAccountTypeId, glAccountClassId, glResourceTypeId, glXbrlClassId, parentGlAccountId, accountCode, accountName, description, productId, externalId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccount(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		glResourceTypeId = (String) value.get(Fields.glResourceTypeId.name());
		glXbrlClassId = (String) value.get(Fields.glXbrlClassId.name());
		parentGlAccountId = (String) value.get(Fields.parentGlAccountId.name());
		accountCode = (String) value.get(Fields.accountCode.name());
		accountName = (String) value.get(Fields.accountName.name());
		description = (String) value.get(Fields.description.name());
		productId = (String) value.get(Fields.productId.name());
		externalId = (String) value.get(Fields.externalId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlAccount fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccount(value);
	}

	public static List<GlAccount> fromValues(List<GenericValue> values) {
		List<GlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccount(value));
		}
		return entities;
	}
}