package org.apache.ofbiz.common.note.service.base;

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
import org.apache.ofbiz.common.note.NoteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.order.request.CustRequestItemNote;
import org.apache.ofbiz.order.request.CustRequestNote;
import org.apache.ofbiz.accounting.invoice.InvoiceNote;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignNote;
import org.apache.ofbiz.order.order.OrderHeaderNote;
import org.apache.ofbiz.party.party.PartyNote;
import org.apache.ofbiz.order.quote.QuoteNote;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortNote;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class NoteDataBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public NoteDataBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count NoteDatas
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(NoteData.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find NoteDatas
	 */
	public List<NoteData> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<NoteData> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(NoteData.NAME);
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
				entityList = NoteData.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one NoteData
	 */
	public Optional<NoteData> findOne(Object noteId) {
		List<NoteData> entityList = null;
		In in = new In();
		in.setEntityName(NoteData.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = NoteData.fromValues(out.getListIt()
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
	 * Get note party
	 */
	public Optional<Party> getNoteParty(NoteData noteData) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						noteData.getNoteParty())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
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
	 * Get cust request item notes
	 */
	public List<CustRequestItemNote> getCustRequestItemNotes(NoteData noteData,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestItemNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestItemNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestItemNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request notes
	 */
	public List<CustRequestNote> getCustRequestNotes(NoteData noteData,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice notes
	 */
	public List<InvoiceNote> getInvoiceNotes(NoteData noteData, Integer start,
			Integer number, List<String> orderBy) {
		List<InvoiceNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get marketing campaign notes
	 */
	public List<MarketingCampaignNote> getMarketingCampaignNotes(
			NoteData noteData, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaignNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order header notes
	 */
	public List<OrderHeaderNote> getOrderHeaderNotes(NoteData noteData,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderHeaderNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderHeaderNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeaderNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party notes
	 */
	public List<PartyNote> getPartyNotes(NoteData noteData, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote notes
	 */
	public List<QuoteNote> getQuoteNotes(NoteData noteData, Integer start,
			Integer number, List<String> orderBy) {
		List<QuoteNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work efforts
	 */
	public List<WorkEffort> getWorkEfforts(NoteData noteData, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort notes
	 */
	public List<WorkEffortNote> getWorkEffortNotes(NoteData noteData,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffortNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						noteData.getNoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}