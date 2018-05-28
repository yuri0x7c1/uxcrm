package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Organization And Class
 */
public class GlAccountOrganizationAndClass implements Serializable {

	public static final long serialVersionUID = 7789475762493030400L;
	public static final String NAME = "GlAccountOrganizationAndClass";
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Parent Gl Account Id
	 */
	@Getter
	@Setter
	private String parentGlAccountId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;

	public enum Fields {
		fromDate, roleTypeId, glAccountId, organizationPartyId, thruDate, accountCode, productId, accountName, description, externalId, glAccountTypeId, glResourceTypeId, parentGlAccountId, glAccountClassId, glXbrlClassId
	}

	public GlAccountOrganizationAndClass(GenericValue value) {
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		accountCode = (String) value.get(Fields.accountCode.name());
		productId = (String) value.get(Fields.productId.name());
		accountName = (String) value.get(Fields.accountName.name());
		description = (String) value.get(Fields.description.name());
		externalId = (String) value.get(Fields.externalId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glResourceTypeId = (String) value.get(Fields.glResourceTypeId.name());
		parentGlAccountId = (String) value.get(Fields.parentGlAccountId.name());
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		glXbrlClassId = (String) value.get(Fields.glXbrlClassId.name());
	}

	public static GlAccountOrganizationAndClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountOrganizationAndClass(value);
	}

	public static List<GlAccountOrganizationAndClass> fromValues(
			List<GenericValue> values) {
		List<GlAccountOrganizationAndClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountOrganizationAndClass(value));
		}
		return entities;
	}
}