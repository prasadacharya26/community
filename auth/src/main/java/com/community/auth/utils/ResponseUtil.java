package com.community.auth.utils;

import net.sf.json.JSONObject;

public class ResponseUtil {
	
	public static JSONObject getSuccessResponse(String status, String statusMsg, JSONObject respDataObject) {
		JSONObject respObject = new JSONObject();
		respObject.put("status", status);
		respObject.put("message", statusMsg);
		respObject.put("data", respDataObject);
		return respObject;
	}

}
