package com.hokol.medium.http.bean;

public class WTaskStaffCommentedInfoBean
{
	/* 任务唯一标识 */
	private String task_id;

	public WTaskStaffCommentedInfoBean(String task_id)
	{
		this.task_id = task_id;
	}

	public String getTask_id()
	{
		return task_id;
	}

	public void setTask_id(String task_id)
	{
		this.task_id = task_id;
	}
}
