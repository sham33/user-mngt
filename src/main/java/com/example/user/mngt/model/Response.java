package com.example.user.mngt.model;

import java.util.List;

public class Response {

	private String resMsg;
	private String userId;
	List<ValidationField> valErrors;

	public Response() {
	}

	public Response(String resMsg, String userId, List<ValidationField> valErrors) {
		this.resMsg = resMsg;
		this.userId = userId;
		this.valErrors = valErrors;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ValidationField> getValErrors() {
		return valErrors;
	}

	public void setValErrors(List<ValidationField> errorsList) {
		this.valErrors = errorsList;
	}

}
