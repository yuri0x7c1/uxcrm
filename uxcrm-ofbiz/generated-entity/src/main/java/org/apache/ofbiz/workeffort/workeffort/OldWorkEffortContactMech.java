package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Work Effort Contact Mech
 */
public class OldWorkEffortContactMech implements Serializable {

	public static final long serialVersionUID = 7557732004583632896L;
	public static final String NAME = "OldWorkEffortContactMech";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public enum Fields {
		workEffortId, contactMechId, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldWorkEffortContactMech(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldWorkEffortContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldWorkEffortContactMech(value);
	}

	public static List<OldWorkEffortContactMech> fromValues(
			List<GenericValue> values) {
		List<OldWorkEffortContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldWorkEffortContactMech(value));
		}
		return entities;
	}
}