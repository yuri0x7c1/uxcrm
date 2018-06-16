package org.apache.ofbiz.webapp.visit;

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
public class BrowserType implements Serializable {

	public static final long serialVersionUID = 2915938154737159168L;
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

	public enum Fields {
		browserTypeId, browserName, browserVersion, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BrowserType(GenericValue value) {
		browserTypeId = (String) value.get(Fields.browserTypeId.name());
		browserName = (String) value.get(Fields.browserName.name());
		browserVersion = (String) value.get(Fields.browserVersion.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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