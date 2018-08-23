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
 * Agreement Item Type Attr
 */
@FieldNameConstants
public class AgreementItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 7074468708613753856L;
	public static final String NAME = "AgreementItemTypeAttr";
	/**
	 * Agreement Item Type Id
	 */
	@Getter
	@Setter
	private String agreementItemTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public AgreementItemTypeAttr(GenericValue value) {
		agreementItemTypeId = (String) value.get(FIELD_AGREEMENT_ITEM_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AgreementItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItemTypeAttr(value);
	}

	public static List<AgreementItemTypeAttr> fromValues(
			List<GenericValue> values) {
		List<AgreementItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItemTypeAttr(value));
		}
		return entities;
	}
}