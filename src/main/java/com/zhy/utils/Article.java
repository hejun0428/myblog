package com.zhy.utils;


/**
 * 图文model
 * 
 */
public class Article {
	// 图文消息名称  
    private String Title;
    // 图文消息描述  
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大�?40*320，小�?0*80，限制图片链接的域名�?��与开发�?填写的基本资料中的Url�?��  
    private String Picurl;   //公众号回复用
    
    private String PicUrl;   //疑似 直接return
    
    // 点击图文消息跳转链接  
    private String Url;
  
    
    
    
    
    public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getTitle() {
        return Title;  
    }  
  
    public void setTitle(String title) {
        Title = title;  
    }  
  
    public String getDescription() {
        return null == Description ? "" : Description;  
    }  
  
    public void setDescription(String description) {
        Description = description;  
    }  
  
  
    public String getPicurl() {
		return Picurl;
	}
    /**
     * 客服消息
     * @param picurl
     */
	public void setPicurl(String picurl) {
		Picurl = picurl;
	}

	public String getUrl() {
        return null == Url ? "" : Url;  
    }  
  
    public void setUrl(String url) {
        Url = url;  
    } 
    @Override
    public String toString() {
    	return "[标题]"+Title+" [desc]"+Description+"[url]"+Url;
    }
    
}
