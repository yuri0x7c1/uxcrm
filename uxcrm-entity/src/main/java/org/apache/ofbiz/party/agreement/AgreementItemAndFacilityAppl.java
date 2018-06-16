package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Item And Facility Appl
 */
public class AgreementItemAndFacilityAppl implements Serializable {

	public static final long serialVersionUID = 7573780781082501120L;
	public static final String NAME = "AgreementItemAndFacilityAppl";
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Agreement Text
	 */
	@Getter
	@Setter
	private String agreementText;
	/**
	 * Agreement Image
	 */
	@Getter
	@Setter
	private Object agreementImage;
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Agreement Item Type Id
	 */
	@Getter
	@Setter
	private String agreementItemTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Agreement Date
	 */
	@Getter
	@Setter
	private Timestamp agreementDate;
	/**
	 * Agreement Type Id
	 */
	@Getter
	@Setter
	private String agreementTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Text Data
	 */
	@Getter
	@Setter
	private String textData;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;

	public enum Fields {
		currencyUomId, agreementText, agreementImage, agreementId, agreementItemSeqId, agreementItemTypeId, facilityId, roleTypeIdTo, partyIdFrom, productId, agreementDate, agreementTypeId, description, roleTypeIdFrom, thruDate, fromDate, textData, partyIdTo
	}

	public AgreementItemAndFacilityAppl(GenericValue value) {
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		agreementText = (String) value.get(Fields.agreementText.name());
		agreementImage = (Object) value.get(Fields.agreementImage.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		agreementItemTypeId = (String) value.get(Fields.agreementItemTypeId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		productId = (String) value.get(Fields.productId.name());
		agreementDate = (Timestamp) value.get(Fields.agreementDate.name());
		agreementTypeId = (String) value.get(Fields.agreementTypeId.name());
		description = (String) value.get(Fields.description.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		textData = (String) value.get(Fields.textData.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
	}

	public static AgreementItemAndFacilityAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItemAndFacilityAppl(value);
	}

	public static List<AgreementItemAndFacilityAppl> fromValues(
			List<GenericValue> values) {
		List<AgreementItemAndFacilityAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItemAndFacilityAppl(value));
		}
		return entities;
	}
}