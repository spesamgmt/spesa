package com.spesa.codeGenerator.form;

import java.util.List;


public class CodeGeneratorForm {

	List<FieldForm> fieldList;
	private String title;

	public List<FieldForm> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldForm> fieldList) {
		this.fieldList = fieldList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
