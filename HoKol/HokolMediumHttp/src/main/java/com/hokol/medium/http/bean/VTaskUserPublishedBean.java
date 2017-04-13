package com.hokol.medium.http.bean;

import java.util.List;

public class VTaskUserPublishedBean
{
	private List<VTaskUserPublishedOneBean> list;

	public List<VTaskUserPublishedOneBean> getList()
	{
		return list;
	}

	public void setList(List<VTaskUserPublishedOneBean> list)
	{
		this.list = list;
	}

	public static class VTaskUserPublishedOneBean
	{
		/* 任务ID */
		private String task_id;

		/* 任务费用 */
		private float task_fee;

		/* 任务标题 */
		private String task_title;

		/* 任务结束时间(时间戳) */
		private long task_end_time;

		/* 任务发布者昵称 */
		private String user_nickname;

		/* 任务发布者头像(链接) */
		private String user_logo;

		/* 任务状态(1:待报名, 2:待交易, 3:待评价, 4:已完成，5:已结束【用户取消交易】) */
		private int status;

		/* 任务报名人数 */
		private String join_num;

		public String getTask_id()
		{
			return task_id;
		}

		public void setTask_id(String task_id)
		{
			this.task_id = task_id;
		}

		public float getTask_fee()
		{
			return task_fee;
		}

		public void setTask_fee(float task_fee)
		{
			this.task_fee = task_fee;
		}

		public String getTask_title()
		{
			return task_title;
		}

		public void setTask_title(String task_title)
		{
			this.task_title = task_title;
		}

		public long getTask_end_time()
		{
			return task_end_time;
		}

		public void setTask_end_time(long task_end_time)
		{
			this.task_end_time = task_end_time;
		}

		public String getUser_nickname()
		{
			return user_nickname;
		}

		public void setUser_nickname(String user_nickname)
		{
			this.user_nickname = user_nickname;
		}

		public String getUser_logo()
		{
			return user_logo;
		}

		public void setUser_logo(String user_logo)
		{
			this.user_logo = user_logo;
		}

		public int getStatus()
		{
			return status;
		}

		public void setStatus(int status)
		{
			this.status = status;
		}

		public String getJoin_num()
		{
			return join_num;
		}

		public void setJoin_num(String join_num)
		{
			this.join_num = join_num;
		}
	}
}
