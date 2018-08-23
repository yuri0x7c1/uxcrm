package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visitor
 */
@FieldNameConstants
public class Visitor implements Serializable {

	public static final long serialVersionUID = 404245025301679104L;
	public static final String NAME = "Visitor";
	/**
	 * Visitor Id
	 */
	@Getter
	@Setter
	private String visitorId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
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
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public Visitor(GenericValue value) {
		visitorId = (String) value.get(FIELD_VISITOR_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		partyId = (String) value.get(FIELD_PARTY_ID);
	}

	public static Visitor fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Visitor(value);
	}

	public static List<Visitor> fromValues(List<GenericValue> values) {
		List<Visitor> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Visitor(value));
		}
		return entities;
	}
}