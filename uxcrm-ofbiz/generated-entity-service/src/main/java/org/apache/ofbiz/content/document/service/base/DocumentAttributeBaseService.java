package org.apache.ofbiz.content.document.service.base;

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
import org.apache.ofbiz.content.document.DocumentAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.document.Document;
import org.apache.ofbiz.content.document.DocumentTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class DocumentAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public DocumentAttributeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count DocumentAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(DocumentAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find DocumentAttributes
	 */
	public List<DocumentAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<DocumentAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DocumentAttribute.NAME);
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
				entityList = DocumentAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one DocumentAttribute
	 */
	public Optional<DocumentAttribute> findOne(Object documentId,
			Object attrName) {
		List<DocumentAttribute> entityList = null;
		In in = new In();
		in.setEntityName(DocumentAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						documentId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DocumentAttribute.fromValues(out.getListIt()
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
	 * Get document
	 */
	public Optional<Document> getDocument(DocumentAttribute documentAttribute) {
		List<Document> entityList = null;
		In in = new In();
		in.setEntityName(Document.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						documentAttribute.getDocumentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Document.fromValues(out.getListIt()
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
	 * Get document type attrs
	 */
	public List<DocumentTypeAttr> getDocumentTypeAttrs(
			DocumentAttribute documentAttribute, Integer start, Integer number,
			List<String> orderBy) {
		List<DocumentTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DocumentTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						documentAttribute.getAttrName())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DocumentTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}