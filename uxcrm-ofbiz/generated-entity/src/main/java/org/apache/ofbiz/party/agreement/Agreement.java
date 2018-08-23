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
 * Agreement
 */
@FieldNameConstants
public class Agreement implements Serializable {

	public static final long serialVersionUID = 5268877228709749760L;
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

	public Agreement(GenericValue value) {
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		agreementTypeId = (String) value.get(FIELD_AGREEMENT_TYPE_ID);
		agreementDate = (Timestamp) value.get(FIELD_AGREEMENT_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		textData = (String) value.get(FIELD_TEXT_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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