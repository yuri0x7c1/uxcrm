package org.apache.ofbiz.common.language;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class StandardLanguage implements Serializable {

	public static final long serialVersionUID = 4443360094024690688L;
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

	public StandardLanguage(GenericValue value) {
		standardLanguageId = (String) value.get(FIELD_STANDARD_LANGUAGE_ID);
		langCode3t = (String) value.get(FIELD_LANG_CODE3T);
		langCode3b = (String) value.get(FIELD_LANG_CODE3B);
		langCode2 = (String) value.get(FIELD_LANG_CODE2);
		langName = (String) value.get(FIELD_LANG_NAME);
		langFamily = (String) value.get(FIELD_LANG_FAMILY);
		langCharset = (String) value.get(FIELD_LANG_CHARSET);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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