package org.apache.ofbiz.entity.sequence.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sequence Value Item
 */
public class SequenceValueItem implements Serializable {

	public static final long serialVersionUID = 7016225880442730496L;
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

	public enum Fields {
		seqName, seqId
	}

	public SequenceValueItem(GenericValue value) {
		seqName = (String) value.get(Fields.seqName.name());
		seqId = (Long) value.get(Fields.seqId.name());
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