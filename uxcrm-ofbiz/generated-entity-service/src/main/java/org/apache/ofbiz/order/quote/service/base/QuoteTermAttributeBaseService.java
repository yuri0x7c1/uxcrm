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
import org.apache.ofbiz.order.quote.QuoteTermAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.quote.QuoteTerm;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class QuoteTermAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public QuoteTermAttributeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count QuoteTermAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(QuoteTermAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find QuoteTermAttributes
	 */
	public List<QuoteTermAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one QuoteTermAttribute
	 */
	public Optional<QuoteTermAttribute> findOne(Object termTypeId,
			Object quoteId, Object quoteItemSeqId, Object attrName) {
		List<QuoteTermAttribute> entityList = null;
		In in = new In();
		in.setEntityName(QuoteTermAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("termTypeId", EntityOperator.EQUALS,
						termTypeId), new EntityExpr("quoteId",
						EntityOperator.EQUALS, quoteId),
						new EntityExpr("quoteItemSeqId", EntityOperator.EQUALS,
								quoteItemSeqId), new EntityExpr("attrName",
								EntityOperator.EQUALS, attrName)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteTermAttribute.fromValues(out.getListIt()
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
	 * Get quote term
	 */
	public Optional<QuoteTerm> getQuoteTerm(
			QuoteTermAttribute quoteTermAttribute) {
		List<QuoteTerm> entityList = null;
		In in = new In();
		in.setEntityName(QuoteTerm.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("termTypeId", EntityOperator.EQUALS,
						quoteTermAttribute.getTermTypeId()),
				new EntityExpr("quoteId", EntityOperator.EQUALS,
						quoteTermAttribute.getQuoteId()), new EntityExpr(
						"quoteItemSeqId", EntityOperator.EQUALS,
						quoteTermAttribute.getQuoteItemSeqId())),
				EntityOperator.AND));
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
}