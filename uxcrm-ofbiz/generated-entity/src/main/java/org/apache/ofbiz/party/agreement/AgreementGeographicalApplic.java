package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Geographical Applic
 */
public class AgreementGeographicalApplic implements Serializable {

	public static final long serialVersionUID = 2215131551333539840L;
	public static final String NAME = "AgreementGeographicalApplic";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
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
		agreementId, agreementItemSeqId, geoId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AgreementGeographicalApplic(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		geoId = (String) value.get(Fields.geoId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AgreementGeographicalApplic fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementGeographicalApplic(value);
	}

	public static List<AgreementGeographicalApplic> fromValues(
			List<GenericValue> values) {
		List<AgreementGeographicalApplic> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementGeographicalApplic(value));
		}
		return entities;
	}
}