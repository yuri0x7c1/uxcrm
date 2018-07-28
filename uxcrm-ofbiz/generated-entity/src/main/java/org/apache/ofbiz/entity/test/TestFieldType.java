package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Test Field Type
 */
public class TestFieldType implements Serializable {

	public static final long serialVersionUID = 673318710032188416L;
	public static final String NAME = "TestFieldType";
	/**
	 * Test Field Type Id
	 */
	@Getter
	@Setter
	private String testFieldTypeId;
	/**
	 * Blob Field
	 */
	@Getter
	@Setter
	private Blob blobField;
	/**
	 * Byte Array Field
	 */
	@Getter
	@Setter
	private byte[] byteArrayField;
	/**
	 * Object Field
	 */
	@Getter
	@Setter
	private Object objectField;
	/**
	 * Date Field
	 */
	@Getter
	@Setter
	private Date dateField;
	/**
	 * Time Field
	 */
	@Getter
	@Setter
	private Time timeField;
	/**
	 * Date Time Field
	 */
	@Getter
	@Setter
	private Timestamp dateTimeField;
	/**
	 * Fixed Point Field
	 */
	@Getter
	@Setter
	private BigDecimal fixedPointField;
	/**
	 * Floating Point Field
	 */
	@Getter
	@Setter
	private Double floatingPointField;
	/**
	 * Numeric Field
	 */
	@Getter
	@Setter
	private Long numericField;
	/**
	 * Clob Field
	 */
	@Getter
	@Setter
	private String clobField;
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
		testFieldTypeId, blobField, byteArrayField, objectField, dateField, timeField, dateTimeField, fixedPointField, floatingPointField, numericField, clobField, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestFieldType(GenericValue value) {
		testFieldTypeId = (String) value.get(Fields.testFieldTypeId.name());
		blobField = (Blob) value.get(Fields.blobField.name());
		byteArrayField = (byte[]) value.get(Fields.byteArrayField.name());
		objectField = (Object) value.get(Fields.objectField.name());
		dateField = (Date) value.get(Fields.dateField.name());
		timeField = (Time) value.get(Fields.timeField.name());
		dateTimeField = (Timestamp) value.get(Fields.dateTimeField.name());
		fixedPointField = (BigDecimal) value.get(Fields.fixedPointField.name());
		floatingPointField = (Double) value.get(Fields.floatingPointField
				.name());
		numericField = (Long) value.get(Fields.numericField.name());
		clobField = (String) value.get(Fields.clobField.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestFieldType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestFieldType(value);
	}

	public static List<TestFieldType> fromValues(List<GenericValue> values) {
		List<TestFieldType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestFieldType(value));
		}
		return entities;
	}
}