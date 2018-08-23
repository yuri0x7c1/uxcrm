package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Postal Address Boundary
 */
@FieldNameConstants
public class PostalAddressBoundary implements Serializable {

	public static final long serialVersionUID = 4832795401166496768L;
	public static final String NAME = "PostalAddressBoundary";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
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

	public PostalAddressBoundary(GenericValue value) {
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PostalAddressBoundary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PostalAddressBoundary(value);
	}

	public static List<PostalAddressBoundary> fromValues(
			List<GenericValue> values) {
		List<PostalAddressBoundary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PostalAddressBoundary(value));
		}
		return entities;
	}
}