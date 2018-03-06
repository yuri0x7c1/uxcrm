package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Promo Appl
 */
public class AgreementPromoAppl implements Serializable {

	public static final long serialVersionUID = 110805971251380224L;
	public static final String NAME = "AgreementPromoAppl";
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
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
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
		agreementId, agreementItemSeqId, productPromoId, fromDate, thruDate, sequenceNum
	}

	public AgreementPromoAppl(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static AgreementPromoAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementPromoAppl(value);
	}

	public static List<AgreementPromoAppl> fromValues(List<GenericValue> values) {
		List<AgreementPromoAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementPromoAppl(value));
		}
		return entities;
	}
}