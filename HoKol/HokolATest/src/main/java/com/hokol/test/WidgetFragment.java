package com.hokol.test;

import android.view.View;

import com.hokol.test.common.BaseTestFragment;
import com.hokol.test.widget.ADActivity;
import com.hokol.test.widget.DropMenuActivity;
import com.hokol.test.widget.GlideActivity;
import com.hokol.test.widget.LabelLayoutActivity;
import com.hokol.test.widget.RecycleActivity;
import com.hokol.test.widget.SecondaryActivity;
import com.hokol.test.widget.SwipeRefreshActivity;

public class WidgetFragment extends BaseTestFragment
{
	@Override
	protected void test()
	{
		addButton("AD 广告", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ADActivity.actionStart(getContext());
			}
		});

		addButton("下拉菜单", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				DropMenuActivity.actionStart(getContext());
			}
		});

		addButton("多个标签", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				LabelLayoutActivity.actionStart(getContext());
			}
		});
		
		addButton("Recycler", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				RecycleActivity.actionStart(getContext());
			}
		});

		addButton("Glide", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				GlideActivity.actionStart(getContext());
			}
		});

		addButton("Secondary", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				SecondaryActivity.actionStart(getContext());
			}
		});

		addButton("SwipeRefresh", new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				SwipeRefreshActivity.actionStart(getContext());
			}
		});
	}
}
