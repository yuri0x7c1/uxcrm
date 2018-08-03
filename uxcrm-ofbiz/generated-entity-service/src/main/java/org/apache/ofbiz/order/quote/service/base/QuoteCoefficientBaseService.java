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
import org.apache.ofbiz.order.quote.QuoteCoefficient;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.quote.Quote;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class QuoteCoefficientBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public QuoteCoefficientBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count QuoteCoefficients
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(QuoteCoefficient.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find QuoteCoefficients
	 */
	public List<QuoteCoefficient> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<QuoteCoefficient> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteCoefficient.NAME);
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
				entityList = QuoteCoefficient.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one QuoteCoefficient
	 */
	public Optional<QuoteCoefficient> findOne(Object quoteId, Object coeffName) {
		List<QuoteCoefficient> entityList = null;
		In in = new In();
		in.setEntityName(QuoteCoefficient.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("quoteId", EntityOperator.EQUALS, quoteId),
				new EntityExpr("coeffName", EntityOperator.EQUALS, coeffName)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteCoefficient.fromValues(out.getListIt()
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
	public Optional<Quote> getQuote(QuoteCoefficient quoteCoefficient) {
		List<Quote> entityList = null;
		In in = new In();
		in.setEntityName(Quote.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteId", EntityOperator.EQUALS,
						quoteCoefficient.getQuoteId())), EntityOperator.AND));
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
}