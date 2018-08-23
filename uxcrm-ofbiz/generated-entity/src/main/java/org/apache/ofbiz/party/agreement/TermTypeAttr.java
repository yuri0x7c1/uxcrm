package org.apache.ofbiz.party.agreement;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Term Type Attr
 */
@FieldNameConstants
public class TermTypeAttr implements Serializable {

	public static final long serialVersionUID = 8154632412628658176L;
	public static final String NAME = "TermTypeAttr";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public TermTypeAttr(GenericValue value) {
		termTypeId = (String) value.get(FIELD_TERM_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TermTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TermTypeAttr(value);
	}

	public static List<TermTypeAttr> fromValues(List<GenericValue> values) {
		List<TermTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TermTypeAttr(value));
		}
		return entities;
	}
}