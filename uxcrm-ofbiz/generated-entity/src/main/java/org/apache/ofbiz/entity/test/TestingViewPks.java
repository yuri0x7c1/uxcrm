package org.apache.ofbiz.entity.test;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing View Pks
 */
@FieldNameConstants
public class TestingViewPks implements Serializable {

	public static final long serialVersionUID = 4866578892789662720L;
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

	public TestingViewPks(GenericValue value) {
		testingTypeId = (String) value.get(FIELD_TESTING_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		subtypeDescription = (String) value.get(FIELD_SUBTYPE_DESCRIPTION);
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