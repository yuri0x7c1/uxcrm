package org.apache.ofbiz.example.example.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example Item
 */
public class ExampleItem implements Serializable {

	public static final long serialVersionUID = 52858452311472128L;
	public static final String NAME = "ExampleItem";
	/**
	 * Example Id
	 */
	@Getter
	@Setter
	private String exampleId;
	/**
	 * Example Item Seq Id
	 */
	@Getter
	@Setter
	private String exampleItemSeqId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private Double amount;
	/**
	 * Amount Uom Id
	 */
	@Getter
	@Setter
	private String amountUomId;

	public enum Fields {
		exampleId, exampleItemSeqId, description, amount, amountUomId
	}

	public ExampleItem(GenericValue value) {
		exampleId = (String) value.get(Fields.exampleId.name());
		exampleItemSeqId = (String) value.get(Fields.exampleItemSeqId.name());
		description = (String) value.get(Fields.description.name());
		amount = (Double) value.get(Fields.amount.name());
		amountUomId = (String) value.get(Fields.amountUomId.name());
	}

	public static ExampleItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ExampleItem(value);
	}

	public static List<ExampleItem> fromValues(List<GenericValue> values) {
		List<ExampleItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ExampleItem(value));
		}
		return entities;
	}
}