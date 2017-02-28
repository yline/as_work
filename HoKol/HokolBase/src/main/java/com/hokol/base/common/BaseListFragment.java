package com.hokol.base.common;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;

import com.hokol.base.application.BaseApplication;


/**
 * @author yline 2017/2/28 --> 15:47
 * @version 1.0.0
 */
public class BaseListFragment extends ListFragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		BaseApplication.addFragmentForRecordV4(this);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		BaseApplication.removeFragmentForRecordV4(this);
	}
}
