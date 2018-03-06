package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Vendor
 */
public class Vendor implements Serializable {

	public static final long serialVersionUID = 1928100022424096768L;
	public static final String NAME = "Vendor";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Manifest Company Name
	 */
	@Getter
	@Setter
	private String manifestCompanyName;
	/**
	 * Manifest Company Title
	 */
	@Getter
	@Setter
	private String manifestCompanyTitle;
	/**
	 * Manifest Logo Url
	 */
	@Getter
	@Setter
	private String manifestLogoUrl;
	/**
	 * Manifest Policies
	 */
	@Getter
	@Setter
	private String manifestPolicies;

	public enum Fields {
		partyId, manifestCompanyName, manifestCompanyTitle, manifestLogoUrl, manifestPolicies
	}

	public Vendor(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		manifestCompanyName = (String) value.get(Fields.manifestCompanyName
				.name());
		manifestCompanyTitle = (String) value.get(Fields.manifestCompanyTitle
				.name());
		manifestLogoUrl = (String) value.get(Fields.manifestLogoUrl.name());
		manifestPolicies = (String) value.get(Fields.manifestPolicies.name());
	}

	public static Vendor fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Vendor(value);
	}

	public static List<Vendor> fromValues(List<GenericValue> values) {
		List<Vendor> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Vendor(value));
		}
		return entities;
	}
}