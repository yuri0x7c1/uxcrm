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
 * Agreement Item
 */
@FieldNameConstants
public class AgreementItem implements Serializable {

	public static final long serialVersionUID = 3146723761172581376L;
	public static final String NAME = "AgreementItem";
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

	public AgreementItem(GenericValue value) {
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		agreementItemTypeId = (String) value.get(FIELD_AGREEMENT_ITEM_TYPE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		agreementText = (String) value.get(FIELD_AGREEMENT_TEXT);
		agreementImage = (Object) value.get(FIELD_AGREEMENT_IMAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AgreementItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItem(value);
	}

	public static List<AgreementItem> fromValues(List<GenericValue> values) {
		List<AgreementItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItem(value));
		}
		return entities;
	}
}