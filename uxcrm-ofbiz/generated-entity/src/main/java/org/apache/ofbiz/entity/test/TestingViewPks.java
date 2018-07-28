package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing View Pks
 */
public class TestingViewPks implements Serializable {

	public static final long serialVersionUID = 5736423668600142848L;
	public static final String NAME = "TestingViewPks";
	/**
	 * Testing Type Id
	 */
	@Getter
	@Setter
	private String testingTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Subtype Description
	 */
	@Getter
	@Setter
	private String subtypeDescription;

	public enum Fields {
		testingTypeId, description, subtypeDescription
	}

	public TestingViewPks(GenericValue value) {
		testingTypeId = (String) value.get(Fields.testingTypeId.name());
		description = (String) value.get(Fields.description.name());
		subtypeDescription = (String) value.get(Fields.subtypeDescription
				.name());
	}

	public static TestingViewPks fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingViewPks(value);
	}

	public static List<TestingViewPks> fromValues(List<GenericValue> values) {
		List<TestingViewPks> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingViewPks(value));
		}
		return entities;
	}
}