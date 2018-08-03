package org.apache.ofbiz.party.agreement.service.base;

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
import org.apache.ofbiz.party.agreement.AgreementItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementItemType;
import org.apache.ofbiz.party.agreement.AgreementItemTypeAttr;
import org.apache.ofbiz.party.agreement.Addendum;
import org.apache.ofbiz.party.agreement.AgreementEmploymentAppl;
import org.apache.ofbiz.party.agreement.AgreementFacilityAppl;
import org.apache.ofbiz.party.agreement.AgreementGeographicalApplic;
import org.apache.ofbiz.party.agreement.AgreementItemAttribute;
import org.apache.ofbiz.party.agreement.AgreementPartyApplic;
import org.apache.ofbiz.party.agreement.AgreementProductAppl;
import org.apache.ofbiz.party.agreement.AgreementPromoAppl;
import org.apache.ofbiz.party.agreement.AgreementTerm;
import org.apache.ofbiz.party.agreement.AgreementWorkEffortApplic;
import org.apache.ofbiz.party.agreement.OldAgreementWorkEffortAppl;
import org.apache.ofbiz.product.supplier.SupplierProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AgreementItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AgreementItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AgreementItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AgreementItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AgreementItems
	 */
	public List<AgreementItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AgreementItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementItem.NAME);
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
				entityList = AgreementItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AgreementItem
	 */
	public Optional<AgreementItem> findOne(Object agreementId,
			Object agreementItemSeqId) {
		List<AgreementItem> entityList = null;
		In in = new In();
		in.setEntityName(AgreementItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementId), new EntityExpr("agreementItemSeqId",
						EntityOperator.EQUALS, agreementItemSeqId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementItem.fromValues(out.getListIt()
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
	 * Get agreement
	 */
	public Optional<Agreement> getAgreement(AgreementItem agreementItem) {
		List<Agreement> entityList = null;
		In in = new In();
		in.setEntityName(Agreement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Agreement.fromValues(out.getListIt()
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
	 * Get agreement item type
	 */
	public Optional<AgreementItemType> getAgreementItemType(
			AgreementItem agreementItem) {
		List<AgreementItemType> entityList = null;
		In in = new In();
		in.setEntityName(AgreementItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementItemTypeId",
						EntityOperator.EQUALS, agreementItem
								.getAgreementItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementItemType.fromValues(out.getListIt()
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
	 * Get agreement item type attrs
	 */
	public List<AgreementItemTypeAttr> getAgreementItemTypeAttrs(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementItemTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementItemTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementItemTypeId",
						EntityOperator.EQUALS, agreementItem
								.getAgreementItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementItemTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get addendums
	 */
	public List<Addendum> getAddendums(AgreementItem agreementItem,
			Integer start, Integer number, List<String> orderBy) {
		List<Addendum> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Addendum.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Addendum.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement employment appls
	 */
	public List<AgreementEmploymentAppl> getAgreementEmploymentAppls(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementEmploymentAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementEmploymentAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementEmploymentAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement facility appls
	 */
	public List<AgreementFacilityAppl> getAgreementFacilityAppls(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementFacilityAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementFacilityAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementFacilityAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement geographical applics
	 */
	public List<AgreementGeographicalApplic> getAgreementGeographicalApplics(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementGeographicalApplic> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementGeographicalApplic.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementGeographicalApplic.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement item attributes
	 */
	public List<AgreementItemAttribute> getAgreementItemAttributes(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementItemAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementItemAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementItemAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement party applics
	 */
	public List<AgreementPartyApplic> getAgreementPartyApplics(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementPartyApplic> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementPartyApplic.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementPartyApplic.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement product appls
	 */
	public List<AgreementProductAppl> getAgreementProductAppls(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementProductAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementProductAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementProductAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement promo appls
	 */
	public List<AgreementPromoAppl> getAgreementPromoAppls(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementPromoAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementPromoAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementPromoAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement terms
	 */
	public List<AgreementTerm> getAgreementTerms(AgreementItem agreementItem,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementTerm.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement work effort applics
	 */
	public List<AgreementWorkEffortApplic> getAgreementWorkEffortApplics(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementWorkEffortApplic> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementWorkEffortApplic.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementWorkEffortApplic.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old agreement work effort appls
	 */
	public List<OldAgreementWorkEffortAppl> getOldAgreementWorkEffortAppls(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OldAgreementWorkEffortAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldAgreementWorkEffortAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldAgreementWorkEffortAppl.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get supplier products
	 */
	public List<SupplierProduct> getSupplierProducts(
			AgreementItem agreementItem, Integer start, Integer number,
			List<String> orderBy) {
		List<SupplierProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementItem.getAgreementId()), new EntityExpr(
						"agreementItemSeqId", EntityOperator.EQUALS,
						agreementItem.getAgreementItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}