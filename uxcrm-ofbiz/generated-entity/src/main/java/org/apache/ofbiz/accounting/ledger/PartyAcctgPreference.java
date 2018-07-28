package org.apache.ofbiz.accounting.ledger;

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
public class PartyAcctgPreference implements Serializable {

	public static final long serialVersionUID = 8081550218708248576L;
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

	public enum Fields {
		partyId, fiscalYearStartMonth, fiscalYearStartDay, taxFormId, cogsMethodId, baseCurrencyUomId, invoiceSeqCustMethId, invoiceIdPrefix, lastInvoiceNumber, lastInvoiceRestartDate, useInvoiceIdForReturns, quoteSeqCustMethId, quoteIdPrefix, lastQuoteNumber, orderSeqCustMethId, orderIdPrefix, lastOrderNumber, refundPaymentMethodId, errorGlJournalId, oldInvoiceSequenceEnumId, oldOrderSequenceEnumId, oldQuoteSequenceEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyAcctgPreference(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		fiscalYearStartMonth = (Long) value.get(Fields.fiscalYearStartMonth
				.name());
		fiscalYearStartDay = (Long) value.get(Fields.fiscalYearStartDay.name());
		taxFormId = (String) value.get(Fields.taxFormId.name());
		cogsMethodId = (String) value.get(Fields.cogsMethodId.name());
		baseCurrencyUomId = (String) value.get(Fields.baseCurrencyUomId.name());
		invoiceSeqCustMethId = (String) value.get(Fields.invoiceSeqCustMethId
				.name());
		invoiceIdPrefix = (String) value.get(Fields.invoiceIdPrefix.name());
		lastInvoiceNumber = (Long) value.get(Fields.lastInvoiceNumber.name());
		lastInvoiceRestartDate = (Timestamp) value
				.get(Fields.lastInvoiceRestartDate.name());
		useInvoiceIdForReturns = (String) value
				.get(Fields.useInvoiceIdForReturns.name());
		quoteSeqCustMethId = (String) value.get(Fields.quoteSeqCustMethId
				.name());
		quoteIdPrefix = (String) value.get(Fields.quoteIdPrefix.name());
		lastQuoteNumber = (Long) value.get(Fields.lastQuoteNumber.name());
		orderSeqCustMethId = (String) value.get(Fields.orderSeqCustMethId
				.name());
		orderIdPrefix = (String) value.get(Fields.orderIdPrefix.name());
		lastOrderNumber = (Long) value.get(Fields.lastOrderNumber.name());
		refundPaymentMethodId = (String) value.get(Fields.refundPaymentMethodId
				.name());
		errorGlJournalId = (String) value.get(Fields.errorGlJournalId.name());
		oldInvoiceSequenceEnumId = (String) value
				.get(Fields.oldInvoiceSequenceEnumId.name());
		oldOrderSequenceEnumId = (String) value
				.get(Fields.oldOrderSequenceEnumId.name());
		oldQuoteSequenceEnumId = (String) value
				.get(Fields.oldQuoteSequenceEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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