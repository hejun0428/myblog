package com.zhy.utils;

import lombok.Data;

import java.io.File;
import java.io.Serializable;

@Data
public class InviteCard implements Serializable {
	private static final long serialVersionUID = 1L;

	private String url;
	
	private File file;

	public InviteCard (){
	}
	
	public InviteCard (String url, File file){
		this.url=url;
		this.file=file;
	}
}
