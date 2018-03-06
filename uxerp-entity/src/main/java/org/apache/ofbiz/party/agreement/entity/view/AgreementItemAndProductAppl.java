package org.apache.ofbiz.party.agreement.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Item And Product Appl
 */
public class AgreementItemAndProductAppl implements Serializable {

	public static final long serialVersionUID = 5432035320098845696L;
	public static final String NAME = "AgreementItemAndProductAppl";
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
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Price
	 */
	@Getter
	@Setter
	private BigDecimal price;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Agreement Type Id
	 */
	@Getter
	@Setter
	private String agreementTypeId;
	/**
	 * Agreement Date
	 */
	@Getter
	@Setter
	private Timestamp agreementDate;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Text Data
	 */
	@Getter
	@Setter
	private String textData;

	public enum Fields {
		agreementId, agreementItemSeqId, agreementItemTypeId, currencyUomId, agreementText, agreementImage, productId, price, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, agreementTypeId, agreementDate, fromDate, thruDate, description, textData
	}

	public AgreementItemAndProductAppl(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		agreementItemTypeId = (String) value.get(Fields.agreementItemTypeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		agreementText = (String) value.get(Fields.agreementText.name());
		agreementImage = (Object) value.get(Fields.agreementImage.name());
		productId = (String) value.get(Fields.productId.name());
		price = (BigDecimal) value.get(Fields.price.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		agreementTypeId = (String) value.get(Fields.agreementTypeId.name());
		agreementDate = (Timestamp) value.get(Fields.agreementDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		description = (String) value.get(Fields.description.name());
		textData = (String) value.get(Fields.textData.name());
	}

	public static AgreementItemAndProductAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItemAndProductAppl(value);
	}

	public static List<AgreementItemAndProductAppl> fromValues(
			List<GenericValue> values) {
		List<AgreementItemAndProductAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItemAndProductAppl(value));
		}
		return entities;
	}
}