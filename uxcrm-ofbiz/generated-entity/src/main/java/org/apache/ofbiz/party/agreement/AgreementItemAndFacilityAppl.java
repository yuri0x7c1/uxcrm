package org.apache.ofbiz.party.agreement;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class AgreementItemAndFacilityAppl implements Serializable {

	public static final long serialVersionUID = 7009400281302693888L;
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

	public AgreementItemAndFacilityAppl(GenericValue value) {
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		agreementText = (String) value.get(FIELD_AGREEMENT_TEXT);
		agreementImage = (Object) value.get(FIELD_AGREEMENT_IMAGE);
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		agreementItemTypeId = (String) value.get(FIELD_AGREEMENT_ITEM_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		agreementDate = (Timestamp) value.get(FIELD_AGREEMENT_DATE);
		agreementTypeId = (String) value.get(FIELD_AGREEMENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		textData = (String) value.get(FIELD_TEXT_DATA);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
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