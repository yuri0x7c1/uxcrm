package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Browser Type
 */
@FieldNameConstants
public class BrowserType implements Serializable {

	public static final long serialVersionUID = 4397461083469706240L;
	public static final String NAME = "BrowserType";
	/**
	 * Browser Type Id
	 */
	@Getter
	@Setter
	private String browserTypeId;
	/**
	 * Browser Name
	 */
	@Getter
	@Setter
	private String browserName;
	/**
	 * Browser Version
	 */
	@Getter
	@Setter
	private String browserVersion;
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

	public BrowserType(GenericValue value) {
		browserTypeId = (String) value.get(FIELD_BROWSER_TYPE_ID);
		browserName = (String) value.get(FIELD_BROWSER_NAME);
		browserVersion = (String) value.get(FIELD_BROWSER_VERSION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BrowserType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BrowserType(value);
	}

	public static List<BrowserType> fromValues(List<GenericValue> values) {
		List<BrowserType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BrowserType(value));
		}
		return entities;
	}
}