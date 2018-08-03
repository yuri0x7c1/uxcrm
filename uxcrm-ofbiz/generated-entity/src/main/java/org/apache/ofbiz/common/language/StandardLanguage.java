package org.apache.ofbiz.common.language;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Standard Language
 */
public class StandardLanguage implements Serializable {

	public static final long serialVersionUID = 6554044860686810112L;
	public static final String NAME = "StandardLanguage";
	/**
	 * Standard Language Id
	 */
	@Getter
	@Setter
	private String standardLanguageId;
	/**
	 * Lang Code 3 T
	 */
	@Getter
	@Setter
	private String langCode3t;
	/**
	 * Lang Code 3 B
	 */
	@Getter
	@Setter
	private String langCode3b;
	/**
	 * Lang Code 2
	 */
	@Getter
	@Setter
	private String langCode2;
	/**
	 * Lang Name
	 */
	@Getter
	@Setter
	private String langName;
	/**
	 * Lang Family
	 */
	@Getter
	@Setter
	private String langFamily;
	/**
	 * Lang Charset
	 */
	@Getter
	@Setter
	private String langCharset;
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
		standardLanguageId, langCode3t, langCode3b, langCode2, langName, langFamily, langCharset, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public StandardLanguage(GenericValue value) {
		standardLanguageId = (String) value.get(Fields.standardLanguageId
				.name());
		langCode3t = (String) value.get(Fields.langCode3t.name());
		langCode3b = (String) value.get(Fields.langCode3b.name());
		langCode2 = (String) value.get(Fields.langCode2.name());
		langName = (String) value.get(Fields.langName.name());
		langFamily = (String) value.get(Fields.langFamily.name());
		langCharset = (String) value.get(Fields.langCharset.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static StandardLanguage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StandardLanguage(value);
	}

	public static List<StandardLanguage> fromValues(List<GenericValue> values) {
		List<StandardLanguage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StandardLanguage(value));
		}
		return entities;
	}
}