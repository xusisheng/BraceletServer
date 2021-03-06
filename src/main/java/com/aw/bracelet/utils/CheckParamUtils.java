package com.aw.bracelet.utils;

import org.apache.commons.lang3.StringUtils;

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
