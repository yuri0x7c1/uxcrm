package org.apache.ofbiz.passport.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Third Party Login
 */
public class ThirdPartyLogin implements Serializable {

	public static final long serialVersionUID = 7031500655940622336L;
	public static final String NAME = "ThirdPartyLogin";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Login Meth Type Id
	 */
	@Getter
	@Setter
	private String loginMethTypeId;
	/**
	 * Login Provider Id
	 */
	@Getter
	@Setter
	private String loginProviderId;
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		productStoreId, loginMethTypeId, loginProviderId, fromDate, thruDate, sequenceNum
	}

	public ThirdPartyLogin(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		loginMethTypeId = (String) value.get(Fields.loginMethTypeId.name());
		loginProviderId = (String) value.get(Fields.loginProviderId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ThirdPartyLogin fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ThirdPartyLogin(value);
	}

	public static List<ThirdPartyLogin> fromValues(List<GenericValue> values) {
		List<ThirdPartyLogin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ThirdPartyLogin(value));
		}
		return entities;
	}
}