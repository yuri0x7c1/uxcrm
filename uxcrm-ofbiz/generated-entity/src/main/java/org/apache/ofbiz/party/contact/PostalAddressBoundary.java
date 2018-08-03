package org.apache.ofbiz.party.contact;

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
public class PostalAddressBoundary implements Serializable {

	public static final long serialVersionUID = 8027533811190270976L;
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

	public enum Fields {
		contactMechId, geoId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PostalAddressBoundary(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		geoId = (String) value.get(Fields.geoId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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