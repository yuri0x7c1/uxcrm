package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Product Appl
 */
public class AgreementProductAppl implements Serializable {

	public static final long serialVersionUID = 2007817251556930560L;
	public static final String NAME = "AgreementProductAppl";
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
		agreementId, agreementItemSeqId, productId, price, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AgreementProductAppl(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		productId = (String) value.get(Fields.productId.name());
		price = (BigDecimal) value.get(Fields.price.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AgreementProductAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementProductAppl(value);
	}

	public static List<AgreementProductAppl> fromValues(
			List<GenericValue> values) {
		List<AgreementProductAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementProductAppl(value));
		}
		return entities;
	}
}