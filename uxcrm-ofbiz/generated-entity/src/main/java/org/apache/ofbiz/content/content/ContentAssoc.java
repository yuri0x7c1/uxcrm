package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc
 */
@FieldNameConstants
public class ContentAssoc implements Serializable {

	public static final long serialVersionUID = 7557853002394606592L;
	public static final String NAME = "ContentAssoc";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Id To
	 */
	@Getter
	@Setter
	private String contentIdTo;
	/**
	 * Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String contentAssocTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Content Assoc Predicate Id
	 */
	@Getter
	@Setter
	private String contentAssocPredicateId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Map Key
	 */
	@Getter
	@Setter
	private String mapKey;
	/**
	 * Upper Coordinate
	 */
	@Getter
	@Setter
	private Long upperCoordinate;
	/**
	 * Left Coordinate
	 */
	@Getter
	@Setter
	private Long leftCoordinate;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public ContentAssoc(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentIdTo = (String) value.get(FIELD_CONTENT_ID_TO);
		contentAssocTypeId = (String) value.get(FIELD_CONTENT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		contentAssocPredicateId = (String) value
				.get(FIELD_CONTENT_ASSOC_PREDICATE_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		mapKey = (String) value.get(FIELD_MAP_KEY);
		upperCoordinate = (Long) value.get(FIELD_UPPER_COORDINATE);
		leftCoordinate = (Long) value.get(FIELD_LEFT_COORDINATE);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssoc(value);
	}

	public static List<ContentAssoc> fromValues(List<GenericValue> values) {
		List<ContentAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssoc(value));
		}
		return entities;
	}
}