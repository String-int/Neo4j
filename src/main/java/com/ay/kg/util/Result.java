package com.ay.kg.util;

import com.google.gson.Gson;

public class Result {
	public String code;//0,1
	public String msg;
	public String info;
	public Integer count;
	public Object data;

	public static String toClient(Object data){
		Result r = new Result();
		r.data = data;
		Gson t = new Gson();
		return t.toJson(r);
	}
	public static String toClient(String code,String msg){
		Result r = new Result();
		r.code =code;
		r.msg = msg;
		r.count=0;
		Gson t = new Gson();
		return t.toJson(r);
	}
	public static String toClient(String code,String msg,String info){
		Result r = new Result();
		r.code =code;
		r.msg = msg;
		r.info = info;
		r.count=0;
		Gson t = new Gson();
		return t.toJson(r);
	}
	public static String toClient(String code,String msg,Object data){
		Result r = new Result();
		r.code =code;
		r.msg = msg;
		r.data = data;
		Gson t = new Gson();
		return t.toJson(r);
	}
	public static String toClient(String code,String msg,Integer count,Object data){
		Result r = new Result();
		r.code =code;
		r.msg = msg;
		r.count=count;
		r.data = data;
		Gson t = new Gson();
		return t.toJson(r);
	}	
}
