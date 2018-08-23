package org.apache.ofbiz.entity;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

/**
 * Java Resource
 */
@FieldNameConstants
public class JavaResource implements Serializable {

	public static final long serialVersionUID = 3694117500254562304L;
	public static final String NAME = "JavaResource";
	/**
	 * Resource Name
	 */
	@Getter
	@Setter
	private String resourceName;
	/**
	 * Resource Value
	 */
	@Getter
	@Setter
	private byte[] resourceValue;
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

	public JavaResource(org.apache.ofbiz.entity.GenericValue value) {
		resourceName = (String) value.get(FIELD_RESOURCE_NAME);
		resourceValue = (byte[]) value.get(FIELD_RESOURCE_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static JavaResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JavaResource(value);
	}

	public static List<JavaResource> fromValues(List<GenericValue> values) {
		List<JavaResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JavaResource(value));
		}
		return entities;
	}
}