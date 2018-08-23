package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Item Note
 */
@FieldNameConstants
public class CustRequestItemNote implements Serializable {

	public static final long serialVersionUID = 4862972217476030464L;
	public static final String NAME = "CustRequestItemNote";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
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

	public CustRequestItemNote(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestItemNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestItemNote(value);
	}

	public static List<CustRequestItemNote> fromValues(List<GenericValue> values) {
		List<CustRequestItemNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestItemNote(value));
		}
		return entities;
	}
}