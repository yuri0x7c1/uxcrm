package org.apache.ofbiz.entity.sequence;

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
public class SequenceValueItem implements Serializable {

	public static final long serialVersionUID = 8865068675765605376L;
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

	public enum Fields {
		seqName, seqId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SequenceValueItem(GenericValue value) {
		seqName = (String) value.get(Fields.seqName.name());
		seqId = (Long) value.get(Fields.seqId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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