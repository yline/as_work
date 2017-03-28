package com.hokol.medium.http;

import com.hokol.base.log.LogFileUtil;
import com.hokol.medium.http.helper.IHttpResponse;

/**
 * 配置每次的请求参数
 *
 * @param <Result>
 */
public abstract class XHttpAdapter<Result> implements IHttpResponse<Result>
{
	public abstract void onSuccess(Result result);

	@Override
	public void onFailureCode(int code)
	{
		if (isDebug())
		{
			LogFileUtil.e("onFailureCode", "code = " + code);
		}
	}

	@Override
	public void onFailure(Exception ex)
	{
		if (isDebug())
		{
			LogFileUtil.e("onFailure", "net exception happened", ex);
		}
	}

	protected boolean isDebug()
	{
		return HttpConstant.isDefaultDebug();
	}
}
