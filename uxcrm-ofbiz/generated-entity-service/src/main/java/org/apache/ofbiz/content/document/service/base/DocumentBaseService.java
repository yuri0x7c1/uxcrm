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
import org.apache.ofbiz.content.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.document.DocumentType;
import org.apache.ofbiz.content.document.DocumentTypeAttr;
import org.apache.ofbiz.content.document.DocumentAttribute;
import org.apache.ofbiz.shipment.shipment.ShippingDocument;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class DocumentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public DocumentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Documents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Document.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Documents
	 */
	public List<Document> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Document> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Document.NAME);
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
				entityList = Document.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Document
	 */
	public Optional<Document> findOne(Object documentId) {
		List<Document> entityList = null;
		In in = new In();
		in.setEntityName(Document.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						documentId)), EntityOperator.AND));
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
	 * Get document type
	 */
	public Optional<DocumentType> getDocumentType(Document document) {
		List<DocumentType> entityList = null;
		In in = new In();
		in.setEntityName(DocumentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentTypeId", EntityOperator.EQUALS,
						document.getDocumentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DocumentType.fromValues(out.getListIt()
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
	public List<DocumentTypeAttr> getDocumentTypeAttrs(Document document,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("documentTypeId", EntityOperator.EQUALS,
						document.getDocumentTypeId())), EntityOperator.AND));
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

	/**
	 * Get document attributes
	 */
	public List<DocumentAttribute> getDocumentAttributes(Document document,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						document.getDocumentId())), EntityOperator.AND));
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
	 * Get shipping document
	 */
	public Optional<ShippingDocument> getShippingDocument(Document document) {
		List<ShippingDocument> entityList = null;
		In in = new In();
		in.setEntityName(ShippingDocument.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						document.getDocumentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShippingDocument.fromValues(out.getListIt()
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