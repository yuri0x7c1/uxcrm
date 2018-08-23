package org.apache.ofbiz.entity.test;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TestFieldType implements Serializable {

	public static final long serialVersionUID = 161652951235303424L;
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

	public TestFieldType(GenericValue value) {
		testFieldTypeId = (String) value.get(FIELD_TEST_FIELD_TYPE_ID);
		blobField = (Blob) value.get(FIELD_BLOB_FIELD);
		byteArrayField = (byte[]) value.get(FIELD_BYTE_ARRAY_FIELD);
		objectField = (Object) value.get(FIELD_OBJECT_FIELD);
		dateField = (Date) value.get(FIELD_DATE_FIELD);
		timeField = (Time) value.get(FIELD_TIME_FIELD);
		dateTimeField = (Timestamp) value.get(FIELD_DATE_TIME_FIELD);
		fixedPointField = (BigDecimal) value.get(FIELD_FIXED_POINT_FIELD);
		floatingPointField = (Double) value.get(FIELD_FLOATING_POINT_FIELD);
		numericField = (Long) value.get(FIELD_NUMERIC_FIELD);
		clobField = (String) value.get(FIELD_CLOB_FIELD);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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