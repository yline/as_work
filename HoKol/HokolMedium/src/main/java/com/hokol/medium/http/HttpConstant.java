package com.hokol.medium.http;

/**
 * Http常量库
 *
 * @author yline 2017/2/28 --> 23:54
 * @version 1.0.0
 */
public class HttpConstant
{
	// 是否 输出日志
	public static final boolean isDebug = true;

	// HttpClient设置
	public static final int REQUEST_SUCCESS_CODE = 0;

	public static final int CONNECT_TIME_OUT = 10;

	public static final String MEDIA_TYPE_JSON = "application/json; charset=utf-8";

	// Http Url 信息
	private static final String HTTP_URL_HEAD = "http://192.168.1.100/index.php/Back/Api/";

	public static final String HTTP_PHONE_LOGIN_URL = HTTP_URL_HEAD + "login";
}
