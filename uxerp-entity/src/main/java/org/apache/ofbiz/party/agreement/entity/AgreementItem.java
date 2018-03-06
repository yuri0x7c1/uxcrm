package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Item
 */
public class AgreementItem implements Serializable {

	public static final long serialVersionUID = 6252635817238915072L;
	public static final String NAME = "AgreementItem";
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
	 * Agreement Item Type Id
	 */
	@Getter
	@Setter
	private String agreementItemTypeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Agreement Text
	 */
	@Getter
	@Setter
	private String agreementText;
	/**
	 * Agreement Image
	 */
	@Getter
	@Setter
	private Object agreementImage;

	public enum Fields {
		agreementId, agreementItemSeqId, agreementItemTypeId, currencyUomId, agreementText, agreementImage
	}

	public AgreementItem(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		agreementItemTypeId = (String) value.get(Fields.agreementItemTypeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		agreementText = (String) value.get(Fields.agreementText.name());
		agreementImage = (Object) value.get(Fields.agreementImage.name());
	}

	public static AgreementItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItem(value);
	}

	public static List<AgreementItem> fromValues(List<GenericValue> values) {
		List<AgreementItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItem(value));
		}
		return entities;
	}
}