package com.hokol.medium.http.bean;

public class WDynamicUserDetailBean
{
	private String user_id;

	private String user_id_find;

	public WDynamicUserDetailBean(String user_id, String user_id_find)
	{
		this.user_id = user_id;
		this.user_id_find = user_id_find;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getUser_id_find()
	{
		return user_id_find;
	}

	public void setUser_id_find(String user_id_find)
	{
		this.user_id_find = user_id_find;
	}
}
