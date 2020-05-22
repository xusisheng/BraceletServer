package com.aw.braceletserver.utils;

import org.apache.commons.lang.StringUtils;


public class CheckParamUtils {

	public static boolean checkBlankParams(String paramName, Object paramValue, StringBuffer returnStr) {
		if (paramValue instanceof String){
			if (StringUtils.isBlank((String)paramValue)) {
				returnStr.append(paramName + "未上传");
				return false;
			}
		}else{
			if (paramValue == null) {
				returnStr.append(paramName + "未上传");
				return false;
			}
		}
		return true;
	}
}
