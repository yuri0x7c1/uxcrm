package org.apache.ofbiz.example.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example Feature Appl
 */
public class ExampleFeatureAppl implements Serializable {

	public static final long serialVersionUID = 6950002327990198272L;
	public static final String NAME = "ExampleFeatureAppl";
	/**
	 * Example Id
	 */
	@Getter
	@Setter
	private String exampleId;
	/**
	 * Example Feature Id
	 */
	@Getter
	@Setter
	private String exampleFeatureId;
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
	 * Example Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String exampleFeatureApplTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		exampleId, exampleFeatureId, fromDate, thruDate, exampleFeatureApplTypeId, sequenceNum
	}

	public ExampleFeatureAppl(GenericValue value) {
		exampleId = (String) value.get(Fields.exampleId.name());
		exampleFeatureId = (String) value.get(Fields.exampleFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		exampleFeatureApplTypeId = (String) value
				.get(Fields.exampleFeatureApplTypeId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ExampleFeatureAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ExampleFeatureAppl(value);
	}

	public static List<ExampleFeatureAppl> fromValues(List<GenericValue> values) {
		List<ExampleFeatureAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ExampleFeatureAppl(value));
		}
		return entities;
	}
}