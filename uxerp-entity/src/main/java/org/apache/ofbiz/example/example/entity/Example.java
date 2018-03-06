package org.apache.ofbiz.example.example.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example
 */
public class Example implements Serializable {

	public static final long serialVersionUID = 8189700108416210944L;
	public static final String NAME = "Example";
	/**
	 * Example Id
	 */
	@Getter
	@Setter
	private String exampleId;
	/**
	 * Example Type Id
	 */
	@Getter
	@Setter
	private String exampleTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Example Name
	 */
	@Getter
	@Setter
	private String exampleName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Example Size
	 */
	@Getter
	@Setter
	private Long exampleSize;
	/**
	 * Example Date
	 */
	@Getter
	@Setter
	private Timestamp exampleDate;
	/**
	 * Another Date
	 */
	@Getter
	@Setter
	private Timestamp anotherDate;
	/**
	 * Another Text
	 */
	@Getter
	@Setter
	private String anotherText;

	public enum Fields {
		exampleId, exampleTypeId, statusId, exampleName, description, longDescription, comments, exampleSize, exampleDate, anotherDate, anotherText
	}

	public Example(GenericValue value) {
		exampleId = (String) value.get(Fields.exampleId.name());
		exampleTypeId = (String) value.get(Fields.exampleTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		exampleName = (String) value.get(Fields.exampleName.name());
		description = (String) value.get(Fields.description.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		comments = (String) value.get(Fields.comments.name());
		exampleSize = (Long) value.get(Fields.exampleSize.name());
		exampleDate = (Timestamp) value.get(Fields.exampleDate.name());
		anotherDate = (Timestamp) value.get(Fields.anotherDate.name());
		anotherText = (String) value.get(Fields.anotherText.name());
	}

	public static Example fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Example(value);
	}

	public static List<Example> fromValues(List<GenericValue> values) {
		List<Example> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Example(value));
		}
		return entities;
	}
}