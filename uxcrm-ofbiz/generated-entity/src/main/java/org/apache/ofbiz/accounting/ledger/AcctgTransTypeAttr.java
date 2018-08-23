package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans Type Attr
 */
@FieldNameConstants
public class AcctgTransTypeAttr implements Serializable {

	public static final long serialVersionUID = 5652992180880363520L;
	public static final String NAME = "AcctgTransTypeAttr";
	/**
	 * Acctg Trans Type Id
	 */
	@Getter
	@Setter
	private String acctgTransTypeId;
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

	public AcctgTransTypeAttr(GenericValue value) {
		acctgTransTypeId = (String) value.get(FIELD_ACCTG_TRANS_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AcctgTransTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransTypeAttr(value);
	}

	public static List<AcctgTransTypeAttr> fromValues(List<GenericValue> values) {
		List<AcctgTransTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransTypeAttr(value));
		}
		return entities;
	}
}