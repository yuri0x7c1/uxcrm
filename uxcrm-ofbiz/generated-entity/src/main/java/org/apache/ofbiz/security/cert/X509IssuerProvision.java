package org.apache.ofbiz.security.cert;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class X509IssuerProvision implements Serializable {

	public static final long serialVersionUID = 2137666792212501504L;
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

	public X509IssuerProvision(GenericValue value) {
		certProvisionId = (String) value.get(FIELD_CERT_PROVISION_ID);
		commonName = (String) value.get(FIELD_COMMON_NAME);
		organizationalUnit = (String) value.get(FIELD_ORGANIZATIONAL_UNIT);
		organizationName = (String) value.get(FIELD_ORGANIZATION_NAME);
		cityLocality = (String) value.get(FIELD_CITY_LOCALITY);
		stateProvince = (String) value.get(FIELD_STATE_PROVINCE);
		country = (String) value.get(FIELD_COUNTRY);
		serialNumber = (String) value.get(FIELD_SERIAL_NUMBER);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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