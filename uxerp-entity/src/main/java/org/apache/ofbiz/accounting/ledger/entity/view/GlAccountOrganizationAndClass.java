package org.apache.ofbiz.accounting.ledger.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Organization And Class
 */
public class GlAccountOrganizationAndClass implements Serializable {

	public static final long serialVersionUID = 1788493686522196992L;
	public static final String NAME = "GlAccountOrganizationAndClass";
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
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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

	public enum Fields {
		glAccountId, organizationPartyId, roleTypeId, fromDate, thruDate, glAccountTypeId, glAccountClassId, glResourceTypeId, glXbrlClassId, parentGlAccountId, accountCode, accountName, description, productId, externalId
	}

	public GlAccountOrganizationAndClass(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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