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
 * Agreement Item And Party Appl
 */
@FieldNameConstants
public class AgreementItemAndPartyAppl implements Serializable {

	public static final long serialVersionUID = 1382529196186423296L;
	public static final String NAME = "AgreementItemAndPartyAppl";
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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

	public AgreementItemAndPartyAppl(GenericValue value) {
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		agreementText = (String) value.get(FIELD_AGREEMENT_TEXT);
		agreementImage = (Object) value.get(FIELD_AGREEMENT_IMAGE);
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		agreementItemTypeId = (String) value.get(FIELD_AGREEMENT_ITEM_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		agreementDate = (Timestamp) value.get(FIELD_AGREEMENT_DATE);
		agreementTypeId = (String) value.get(FIELD_AGREEMENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		textData = (String) value.get(FIELD_TEXT_DATA);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
	}

	public static AgreementItemAndPartyAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItemAndPartyAppl(value);
	}

	public static List<AgreementItemAndPartyAppl> fromValues(
			List<GenericValue> values) {
		List<AgreementItemAndPartyAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItemAndPartyAppl(value));
		}
		return entities;
	}
}