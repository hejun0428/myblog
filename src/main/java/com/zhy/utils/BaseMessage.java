package com.zhy.utils;


import lombok.Data;

@Data
public class BaseMessage {
	
    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;
    private int FuncFlag;
}
