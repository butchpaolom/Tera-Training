package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.models.Person;


public class PersonTag extends SimpleTagSupport {
	private Person data;

	public void setData(Person data) {
		this.data = data;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print(data);
	}

}
