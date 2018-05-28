package org.apache.ofbiz.webapp.visit;

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
public class Visitor implements Serializable {

	public static final long serialVersionUID = 974254220184097792L;
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

	public enum Fields {
		visitorId, userLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, partyId
	}

	public Visitor(GenericValue value) {
		visitorId = (String) value.get(Fields.visitorId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		partyId = (String) value.get(Fields.partyId.name());
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