package com.zhy.utils;

import com.alibaba.fastjson.JSONObject;
import com.ysx.wacc.common.util.CommonLogger;

/**
 * 
 * @author bleach
 *
 */
public class WxUserFactory {

   public static WxUser createWxUser(Object param)throws IllegalArgumentException {
	if (param instanceof String) {
	    return build((String) param);
	} else if (param instanceof JSONObject) {
	    return build((JSONObject) param);
	}else {
	    CommonLogger.error("参数类型错误");
	    throw new IllegalArgumentException();
	}

    }

    private static WxUser build(String json) {
	return JSONObject.toJavaObject(JSONObject.parseObject(json), WxUser.class);
    }

    private static WxUser build(JSONObject json) {
	return JSONObject.toJavaObject(json, WxUser.class);
    }

}
