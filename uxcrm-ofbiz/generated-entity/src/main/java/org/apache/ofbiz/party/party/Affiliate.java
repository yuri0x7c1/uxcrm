package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Affiliate
 */
@FieldNameConstants
public class Affiliate implements Serializable {

	public static final long serialVersionUID = 730613067468822528L;
	public static final String NAME = "Affiliate";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Affiliate Name
	 */
	@Getter
	@Setter
	private String affiliateName;
	/**
	 * Affiliate Description
	 */
	@Getter
	@Setter
	private String affiliateDescription;
	/**
	 * Year Established
	 */
	@Getter
	@Setter
	private String yearEstablished;
	/**
	 * Site Type
	 */
	@Getter
	@Setter
	private String siteType;
	/**
	 * Site Page Views
	 */
	@Getter
	@Setter
	private String sitePageViews;
	/**
	 * Site Visitors
	 */
	@Getter
	@Setter
	private String siteVisitors;
	/**
	 * Date Time Created
	 */
	@Getter
	@Setter
	private Timestamp dateTimeCreated;
	/**
	 * Date Time Approved
	 */
	@Getter
	@Setter
	private Timestamp dateTimeApproved;
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

	public Affiliate(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		affiliateName = (String) value.get(FIELD_AFFILIATE_NAME);
		affiliateDescription = (String) value.get(FIELD_AFFILIATE_DESCRIPTION);
		yearEstablished = (String) value.get(FIELD_YEAR_ESTABLISHED);
		siteType = (String) value.get(FIELD_SITE_TYPE);
		sitePageViews = (String) value.get(FIELD_SITE_PAGE_VIEWS);
		siteVisitors = (String) value.get(FIELD_SITE_VISITORS);
		dateTimeCreated = (Timestamp) value.get(FIELD_DATE_TIME_CREATED);
		dateTimeApproved = (Timestamp) value.get(FIELD_DATE_TIME_APPROVED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Affiliate fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Affiliate(value);
	}

	public static List<Affiliate> fromValues(List<GenericValue> values) {
		List<Affiliate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Affiliate(value));
		}
		return entities;
	}
}