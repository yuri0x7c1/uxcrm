package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Acctg Preference
 */
@FieldNameConstants
public class PartyAcctgPreference implements Serializable {

	public static final long serialVersionUID = 3802463602132799488L;
	public static final String NAME = "PartyAcctgPreference";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Fiscal Year Start Month
	 */
	@Getter
	@Setter
	private Long fiscalYearStartMonth;
	/**
	 * Fiscal Year Start Day
	 */
	@Getter
	@Setter
	private Long fiscalYearStartDay;
	/**
	 * Tax Form Id
	 */
	@Getter
	@Setter
	private String taxFormId;
	/**
	 * Cogs Method Id
	 */
	@Getter
	@Setter
	private String cogsMethodId;
	/**
	 * Base Currency Uom Id
	 */
	@Getter
	@Setter
	private String baseCurrencyUomId;
	/**
	 * Invoice Seq Cust Meth Id
	 */
	@Getter
	@Setter
	private String invoiceSeqCustMethId;
	/**
	 * Invoice Id Prefix
	 */
	@Getter
	@Setter
	private String invoiceIdPrefix;
	/**
	 * Last Invoice Number
	 */
	@Getter
	@Setter
	private Long lastInvoiceNumber;
	/**
	 * Last Invoice Restart Date
	 */
	@Getter
	@Setter
	private Timestamp lastInvoiceRestartDate;
	/**
	 * Use Invoice Id For Returns
	 */
	@Getter
	@Setter
	private String useInvoiceIdForReturns;
	/**
	 * Quote Seq Cust Meth Id
	 */
	@Getter
	@Setter
	private String quoteSeqCustMethId;
	/**
	 * Quote Id Prefix
	 */
	@Getter
	@Setter
	private String quoteIdPrefix;
	/**
	 * Last Quote Number
	 */
	@Getter
	@Setter
	private Long lastQuoteNumber;
	/**
	 * Order Seq Cust Meth Id
	 */
	@Getter
	@Setter
	private String orderSeqCustMethId;
	/**
	 * Order Id Prefix
	 */
	@Getter
	@Setter
	private String orderIdPrefix;
	/**
	 * Last Order Number
	 */
	@Getter
	@Setter
	private Long lastOrderNumber;
	/**
	 * Refund Payment Method Id
	 */
	@Getter
	@Setter
	private String refundPaymentMethodId;
	/**
	 * Error Gl Journal Id
	 */
	@Getter
	@Setter
	private String errorGlJournalId;
	/**
	 * Old Invoice Sequence Enum Id
	 */
	@Getter
	@Setter
	private String oldInvoiceSequenceEnumId;
	/**
	 * Old Order Sequence Enum Id
	 */
	@Getter
	@Setter
	private String oldOrderSequenceEnumId;
	/**
	 * Old Quote Sequence Enum Id
	 */
	@Getter
	@Setter
	private String oldQuoteSequenceEnumId;
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

	public PartyAcctgPreference(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		fiscalYearStartMonth = (Long) value.get(FIELD_FISCAL_YEAR_START_MONTH);
		fiscalYearStartDay = (Long) value.get(FIELD_FISCAL_YEAR_START_DAY);
		taxFormId = (String) value.get(FIELD_TAX_FORM_ID);
		cogsMethodId = (String) value.get(FIELD_COGS_METHOD_ID);
		baseCurrencyUomId = (String) value.get(FIELD_BASE_CURRENCY_UOM_ID);
		invoiceSeqCustMethId = (String) value
				.get(FIELD_INVOICE_SEQ_CUST_METH_ID);
		invoiceIdPrefix = (String) value.get(FIELD_INVOICE_ID_PREFIX);
		lastInvoiceNumber = (Long) value.get(FIELD_LAST_INVOICE_NUMBER);
		lastInvoiceRestartDate = (Timestamp) value
				.get(FIELD_LAST_INVOICE_RESTART_DATE);
		useInvoiceIdForReturns = (String) value
				.get(FIELD_USE_INVOICE_ID_FOR_RETURNS);
		quoteSeqCustMethId = (String) value.get(FIELD_QUOTE_SEQ_CUST_METH_ID);
		quoteIdPrefix = (String) value.get(FIELD_QUOTE_ID_PREFIX);
		lastQuoteNumber = (Long) value.get(FIELD_LAST_QUOTE_NUMBER);
		orderSeqCustMethId = (String) value.get(FIELD_ORDER_SEQ_CUST_METH_ID);
		orderIdPrefix = (String) value.get(FIELD_ORDER_ID_PREFIX);
		lastOrderNumber = (Long) value.get(FIELD_LAST_ORDER_NUMBER);
		refundPaymentMethodId = (String) value
				.get(FIELD_REFUND_PAYMENT_METHOD_ID);
		errorGlJournalId = (String) value.get(FIELD_ERROR_GL_JOURNAL_ID);
		oldInvoiceSequenceEnumId = (String) value
				.get(FIELD_OLD_INVOICE_SEQUENCE_ENUM_ID);
		oldOrderSequenceEnumId = (String) value
				.get(FIELD_OLD_ORDER_SEQUENCE_ENUM_ID);
		oldQuoteSequenceEnumId = (String) value
				.get(FIELD_OLD_QUOTE_SEQUENCE_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyAcctgPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAcctgPreference(value);
	}

	public static List<PartyAcctgPreference> fromValues(
			List<GenericValue> values) {
		List<PartyAcctgPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAcctgPreference(value));
		}
		return entities;
	}
}