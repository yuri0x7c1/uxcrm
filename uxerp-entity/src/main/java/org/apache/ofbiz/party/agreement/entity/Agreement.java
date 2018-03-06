package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement
 */
public class Agreement implements Serializable {

	public static final long serialVersionUID = 8757008827417830400L;
	public static final String NAME = "Agreement";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Agreement Type Id
	 */
	@Getter
	@Setter
	private String agreementTypeId;
	/**
	 * Agreement Date
	 */
	@Getter
	@Setter
	private Timestamp agreementDate;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Text Data
	 */
	@Getter
	@Setter
	private String textData;

	public enum Fields {
		agreementId, productId, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, agreementTypeId, agreementDate, fromDate, thruDate, description, textData
	}

	public Agreement(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		productId = (String) value.get(Fields.productId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		agreementTypeId = (String) value.get(Fields.agreementTypeId.name());
		agreementDate = (Timestamp) value.get(Fields.agreementDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		description = (String) value.get(Fields.description.name());
		textData = (String) value.get(Fields.textData.name());
	}

	public static Agreement fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Agreement(value);
	}

	public static List<Agreement> fromValues(List<GenericValue> values) {
		List<Agreement> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Agreement(value));
		}
		return entities;
	}
}