package com.tags;

import java.io.IOException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class UserTag extends TagSupport{
	private String data;

	public void setData(String data) {
		this.data = data;
	}
	
	public int doStartTag() throws JspException {
		String username = (String) pageContext.getSession().getAttribute("username");
		JspWriter out = pageContext.getOut();
		try {
			out.print(username);
		} catch (IOException e) {
			throw new JspException("Error:" + e.getMessage());
		}
		return SKIP_BODY;
	}

}
