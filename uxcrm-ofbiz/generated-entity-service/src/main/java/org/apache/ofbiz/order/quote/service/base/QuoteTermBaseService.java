package org.apache.ofbiz.order.quote.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.order.quote.QuoteTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.quote.Quote;
import org.apache.ofbiz.order.quote.QuoteItem;
import org.apache.ofbiz.party.agreement.TermType;
import org.apache.ofbiz.order.quote.QuoteTermAttribute;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class QuoteTermBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public QuoteTermBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count QuoteTerms
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(QuoteTerm.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find QuoteTerms
	 */
	public List<QuoteTerm> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<QuoteTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteTerm.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one QuoteTerm
	 */
	public Optional<QuoteTerm> findOne(Object termTypeId, Object quoteId,
			Object quoteItemSeqId) {
		List<QuoteTerm> entityList = null;
		In in = new In();
		in.setEntityName(QuoteTerm.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("termTypeId", EntityOperator.EQUALS,
						termTypeId), new EntityExpr("quoteId",
						EntityOperator.EQUALS, quoteId),
						new EntityExpr("quoteItemSeqId", EntityOperator.EQUALS,
								quoteItemSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteTerm.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get quote
	 */
	public Optional<Quote> getQuote(QuoteTerm quoteTerm) {
		List<Quote> entityList = null;
		In in = new In();
		in.setEntityName(Quote.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteId", EntityOperator.EQUALS,
						quoteTerm.getQuoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Quote
						.fromValues(out.getListIt().getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get quote item
	 */
	public Optional<QuoteItem> getQuoteItem(QuoteTerm quoteTerm) {
		List<QuoteItem> entityList = null;
		In in = new In();
		in.setEntityName(QuoteItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("quoteId", EntityOperator.EQUALS, quoteTerm
						.getQuoteId()), new EntityExpr("quoteItemSeqId",
						EntityOperator.EQUALS, quoteTerm.getQuoteItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteItem.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get term type
	 */
	public Optional<TermType> getTermType(QuoteTerm quoteTerm) {
		List<TermType> entityList = null;
		In in = new In();
		in.setEntityName(TermType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("termTypeId", EntityOperator.EQUALS,
						quoteTerm.getTermTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TermType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get quote term attributes
	 */
	public List<QuoteTermAttribute> getQuoteTermAttributes(QuoteTerm quoteTerm,
			Integer start, Integer number, List<String> orderBy) {
		List<QuoteTermAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteTermAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("termTypeId", EntityOperator.EQUALS, quoteTerm
						.getTermTypeId()), new EntityExpr("quoteId",
						EntityOperator.EQUALS, quoteTerm.getQuoteId()),
				new EntityExpr("quoteItemSeqId", EntityOperator.EQUALS,
						quoteTerm.getQuoteItemSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteTermAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}