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
import org.apache.ofbiz.order.quote.QuoteTypeAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.quote.QuoteType;
import org.apache.ofbiz.order.quote.QuoteAttribute;
import org.apache.ofbiz.order.quote.Quote;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class QuoteTypeAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public QuoteTypeAttrBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count QuoteTypeAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(QuoteTypeAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find QuoteTypeAttrs
	 */
	public List<QuoteTypeAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<QuoteTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteTypeAttr.NAME);
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
				entityList = QuoteTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one QuoteTypeAttr
	 */
	public Optional<QuoteTypeAttr> findOne(Object quoteTypeId, Object attrName) {
		List<QuoteTypeAttr> entityList = null;
		In in = new In();
		in.setEntityName(QuoteTypeAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("quoteTypeId", EntityOperator.EQUALS,
						quoteTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteTypeAttr.fromValues(out.getListIt()
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
	 * Get quote type
	 */
	public Optional<QuoteType> getQuoteType(QuoteTypeAttr quoteTypeAttr) {
		List<QuoteType> entityList = null;
		In in = new In();
		in.setEntityName(QuoteType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteTypeId", EntityOperator.EQUALS,
						quoteTypeAttr.getQuoteTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteType.fromValues(out.getListIt()
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
	 * Get quote attributes
	 */
	public List<QuoteAttribute> getQuoteAttributes(QuoteTypeAttr quoteTypeAttr,
			Integer start, Integer number, List<String> orderBy) {
		List<QuoteAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						quoteTypeAttr.getAttrName())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quotes
	 */
	public List<Quote> getQuotes(QuoteTypeAttr quoteTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<Quote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Quote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteTypeId", EntityOperator.EQUALS,
						quoteTypeAttr.getQuoteTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Quote.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}