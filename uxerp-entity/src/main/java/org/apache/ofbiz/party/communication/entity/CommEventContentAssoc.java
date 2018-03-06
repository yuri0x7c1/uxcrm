package org.apache.ofbiz.party.communication.entity;

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
public class CommEventContentAssoc implements Serializable {

	public static final long serialVersionUID = 1212922540635700224L;
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

	public enum Fields {
		contentId, communicationEventId, commContentAssocTypeId, fromDate, thruDate, sequenceNum
	}

	public CommEventContentAssoc(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		commContentAssocTypeId = (String) value
				.get(Fields.commContentAssocTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
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