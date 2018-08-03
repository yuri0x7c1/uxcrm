package org.apache.ofbiz.content.content;

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
public class ContentAssoc implements Serializable {

	public static final long serialVersionUID = 6944908344955868160L;
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

	public enum Fields {
		contentId, contentIdTo, contentAssocTypeId, fromDate, thruDate, contentAssocPredicateId, dataSourceId, sequenceNum, mapKey, upperCoordinate, leftCoordinate, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentAssoc(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentIdTo = (String) value.get(Fields.contentIdTo.name());
		contentAssocTypeId = (String) value.get(Fields.contentAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		contentAssocPredicateId = (String) value
				.get(Fields.contentAssocPredicateId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		mapKey = (String) value.get(Fields.mapKey.name());
		upperCoordinate = (Long) value.get(Fields.upperCoordinate.name());
		leftCoordinate = (Long) value.get(Fields.leftCoordinate.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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