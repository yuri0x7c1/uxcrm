package org.apache.ofbiz.entity.sequence;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sequence Value Item
 */
@FieldNameConstants
public class SequenceValueItem implements Serializable {

	public static final long serialVersionUID = 3967132287281812480L;
	public static final String NAME = "SequenceValueItem";
	/**
	 * Seq Name
	 */
	@Getter
	@Setter
	private String seqName;
	/**
	 * Seq Id
	 */
	@Getter
	@Setter
	private Long seqId;
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

	public SequenceValueItem(GenericValue value) {
		seqName = (String) value.get(FIELD_SEQ_NAME);
		seqId = (Long) value.get(FIELD_SEQ_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SequenceValueItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SequenceValueItem(value);
	}

	public static List<SequenceValueItem> fromValues(List<GenericValue> values) {
		List<SequenceValueItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SequenceValueItem(value));
		}
		return entities;
	}
}