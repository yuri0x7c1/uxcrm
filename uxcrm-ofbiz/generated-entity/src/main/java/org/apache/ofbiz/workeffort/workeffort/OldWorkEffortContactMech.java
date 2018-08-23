package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OldWorkEffortContactMech implements Serializable {

	public static final long serialVersionUID = 6182760140821653504L;
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

	public OldWorkEffortContactMech(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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