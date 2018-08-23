package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Comm Event Content Assoc
 */
@FieldNameConstants
public class CommEventContentAssoc implements Serializable {

	public static final long serialVersionUID = 9155227102833003520L;
	public static final String NAME = "CommEventContentAssoc";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Comm Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String commContentAssocTypeId;
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public CommEventContentAssoc(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		commContentAssocTypeId = (String) value
				.get(FIELD_COMM_CONTENT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CommEventContentAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommEventContentAssoc(value);
	}

	public static List<CommEventContentAssoc> fromValues(
			List<GenericValue> values) {
		List<CommEventContentAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommEventContentAssoc(value));
		}
		return entities;
	}
}