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
 * Cust Request Note
 */
@FieldNameConstants
public class CustRequestNote implements Serializable {

	public static final long serialVersionUID = 2104420534561856512L;
	public static final String NAME = "CustRequestNote";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
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

	public CustRequestNote(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestNote(value);
	}

	public static List<CustRequestNote> fromValues(List<GenericValue> values) {
		List<CustRequestNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestNote(value));
		}
		return entities;
	}
}