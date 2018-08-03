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
import org.apache.ofbiz.party.agreement.Agreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.RoleType;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.party.party.PartyRelationship;
import org.apache.ofbiz.party.agreement.AgreementType;
import org.apache.ofbiz.party.agreement.AgreementTypeAttr;
import org.apache.ofbiz.party.agreement.Addendum;
import org.apache.ofbiz.party.agreement.AgreementAttribute;
import org.apache.ofbiz.party.agreement.AgreementContent;
import org.apache.ofbiz.party.agreement.AgreementFacilityAppl;
import org.apache.ofbiz.party.agreement.AgreementGeographicalApplic;
import org.apache.ofbiz.party.agreement.AgreementItem;
import org.apache.ofbiz.party.agreement.AgreementPartyApplic;
import org.apache.ofbiz.party.agreement.AgreementProductAppl;
import org.apache.ofbiz.party.agreement.AgreementPromoAppl;
import org.apache.ofbiz.party.agreement.AgreementRole;
import org.apache.ofbiz.party.agreement.AgreementTerm;
import org.apache.ofbiz.party.agreement.AgreementWorkEffortApplic;
import org.apache.ofbiz.party.agreement.OldAgreementWorkEffortAppl;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AgreementBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AgreementBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Agreements
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Agreement.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Agreements
	 */
	public List<Agreement> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Agreement> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Agreement.NAME);
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
				entityList = Agreement.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Agreement
	 */
	public Optional<Agreement> findOne(Object agreementId) {
		List<Agreement> entityList = null;
		In in = new In();
		in.setEntityName(Agreement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreementId)), EntityOperator.AND));
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
	 * Get product
	 */
	public Optional<Product> getProduct(Agreement agreement) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						agreement.getProductId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
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
	 * Get from party
	 */
	public Optional<Party> getFromParty(Agreement agreement) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						agreement.getPartyIdFrom())), EntityOperator.AND));
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
	 * Get from role type
	 */
	public Optional<RoleType> getFromRoleType(Agreement agreement) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						agreement.getRoleTypeIdFrom())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
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
	 * Get from party role
	 */
	public Optional<PartyRole> getFromPartyRole(Agreement agreement) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, agreement
						.getPartyIdFrom()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, agreement.getRoleTypeIdFrom())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
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
	 * Get to party
	 */
	public Optional<Party> getToParty(Agreement agreement) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						agreement.getPartyIdTo())), EntityOperator.AND));
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
	 * Get to role type
	 */
	public Optional<RoleType> getToRoleType(Agreement agreement) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						agreement.getRoleTypeIdTo())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
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
	 * Get to party role
	 */
	public Optional<PartyRole> getToPartyRole(Agreement agreement) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, agreement
						.getPartyIdTo()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, agreement.getRoleTypeIdTo())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
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
	 * Get party relationships
	 */
	public List<PartyRelationship> getPartyRelationships(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyRelationship> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						agreement.getRoleTypeIdFrom()),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS, agreement
						.getRoleTypeIdTo()),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, agreement
						.getPartyIdFrom()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, agreement
						.getPartyIdTo())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationship.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement type
	 */
	public Optional<AgreementType> getAgreementType(Agreement agreement) {
		List<AgreementType> entityList = null;
		In in = new In();
		in.setEntityName(AgreementType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("agreementTypeId",
						EntityOperator.EQUALS, agreement.getAgreementTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementType.fromValues(out.getListIt()
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
	 * Get agreement type attrs
	 */
	public List<AgreementTypeAttr> getAgreementTypeAttrs(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("agreementTypeId",
						EntityOperator.EQUALS, agreement.getAgreementTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementTypeAttr.fromValues(out.getListIt()
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
	public List<Addendum> getAddendums(Agreement agreement, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
	 * Get agreement attributes
	 */
	public List<AgreementAttribute> getAgreementAttributes(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement contents
	 */
	public List<AgreementContent> getAgreementContents(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContent.fromValues(out.getListIt()
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
			Agreement agreement, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
			Agreement agreement, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
	 * Get agreement items
	 */
	public List<AgreementItem> getAgreementItems(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
	 * Get agreement party applics
	 */
	public List<AgreementPartyApplic> getAgreementPartyApplics(
			Agreement agreement, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
			Agreement agreement, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
	public List<AgreementPromoAppl> getAgreementPromoAppls(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
	 * Get agreement roles
	 */
	public List<AgreementRole> getAgreementRoles(Agreement agreement,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementRole.fromValues(out.getListIt()
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
	public List<AgreementTerm> getAgreementTerms(Agreement agreement,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
			Agreement agreement, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
			Agreement agreement, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementId", EntityOperator.EQUALS,
						agreement.getAgreementId())), EntityOperator.AND));
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
}