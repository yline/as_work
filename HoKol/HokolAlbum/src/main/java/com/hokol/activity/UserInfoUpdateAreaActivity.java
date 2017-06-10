package com.hokol.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;

import com.hokol.R;
import com.hokol.fragment.UserInfoUpdateAreaFragment;
import com.hokol.medium.http.XHttpUtil;
import com.hokol.medium.http.bean.VAreaAllBean;
import com.yline.base.BaseAppCompatActivity;
import com.yline.http.XHttpAdapter;

public class UserInfoUpdateAreaActivity extends BaseAppCompatActivity implements FragmentManager.OnBackStackChangedListener, AdapterView.OnItemClickListener
{
	private UserInfoUpdateAreaFragment areaFragment;

	private VAreaAllBean areaAllBean;

	private String firstSelectString;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_info_update_area);

		findViewById(R.id.iv_user_info).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});

		getSupportFragmentManager().addOnBackStackChangedListener(this);
		areaFragment = UserInfoUpdateAreaFragment.newInstance();
		areaFragment.setOnItemClickListener(this);
		getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, areaFragment).commit();

		XHttpUtil.doAreaAll(new XHttpAdapter<VAreaAllBean>()
		{
			@Override
			public void onSuccess(VAreaAllBean vAreaAllBean)
			{
				areaAllBean = vAreaAllBean;

				areaFragment.refresh(areaAllBean.getProvinceNameList());
			}
		});
	}

	@Override
	public void onBackStackChanged()
	{

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		int count = getSupportFragmentManager().getBackStackEntryCount(); // 压入底部的数量
		if (count == 0) // 还在第一选择
		{
			firstSelectString = areaFragment.getSelectedItem(position);

			areaFragment = UserInfoUpdateAreaFragment.newInstance();

			String pCode = areaAllBean.getProvinceCode(firstSelectString);
			areaFragment.refresh(areaAllBean.getCityNameList(pCode));
			areaFragment.setOnItemClickListener(this);
			getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, areaFragment)
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("second").commit();
		}
		else if (count == 1) // 第二选择
		{
			UserInfoActivity.actionResultUpdate(UserInfoUpdateAreaActivity.this, firstSelectString, areaFragment.getSelectedItem(position));
			this.finish();
		}
	}

	public static void actionStartForResult(Activity activity, int requestCode)
	{
		Intent intent = new Intent(activity, UserInfoUpdateAreaActivity.class);
		activity.startActivityForResult(intent, requestCode);
	}
}
