package org.apache.ofbiz.security.cert;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * X 509 Issuer Provision
 */
public class X509IssuerProvision implements Serializable {

	public static final long serialVersionUID = 1777839175860261888L;
	public static final String NAME = "X509IssuerProvision";
	/**
	 * Cert Provision Id
	 */
	@Getter
	@Setter
	private String certProvisionId;
	/**
	 * Common Name
	 */
	@Getter
	@Setter
	private String commonName;
	/**
	 * Organizational Unit
	 */
	@Getter
	@Setter
	private String organizationalUnit;
	/**
	 * Organization Name
	 */
	@Getter
	@Setter
	private String organizationName;
	/**
	 * City Locality
	 */
	@Getter
	@Setter
	private String cityLocality;
	/**
	 * State Province
	 */
	@Getter
	@Setter
	private String stateProvince;
	/**
	 * Country
	 */
	@Getter
	@Setter
	private String country;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
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
		certProvisionId, commonName, organizationalUnit, organizationName, cityLocality, stateProvince, country, serialNumber, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public X509IssuerProvision(GenericValue value) {
		certProvisionId = (String) value.get(Fields.certProvisionId.name());
		commonName = (String) value.get(Fields.commonName.name());
		organizationalUnit = (String) value.get(Fields.organizationalUnit
				.name());
		organizationName = (String) value.get(Fields.organizationName.name());
		cityLocality = (String) value.get(Fields.cityLocality.name());
		stateProvince = (String) value.get(Fields.stateProvince.name());
		country = (String) value.get(Fields.country.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static X509IssuerProvision fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new X509IssuerProvision(value);
	}

	public static List<X509IssuerProvision> fromValues(List<GenericValue> values) {
		List<X509IssuerProvision> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new X509IssuerProvision(value));
		}
		return entities;
	}
}