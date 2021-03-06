package com.hokol.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.widget.ImageView;

import com.hokol.R;
import com.hokol.application.AppStateManager;
import com.hokol.fragment.MainCareFragment;
import com.hokol.fragment.MainHomeFragment;
import com.hokol.fragment.MainMineFragment;
import com.hokol.fragment.MainNewsFragment;
import com.hokol.fragment.MainTaskFragment;
import com.hokol.medium.http.bean.VEnterLoginPhonePwdBean;
import com.hokol.viewhelper.MainHelper;
import com.yline.application.SDKManager;
import com.yline.base.BaseAppCompatActivity;
import com.yline.log.LogFileUtil;


/**
 * 主页面
 *
 * @author yline 2017/3/2 --> 10:01
 * @version 1.0.0
 */
public class MainActivity extends BaseAppCompatActivity
{
	private MainHelper mainHelper;
	
	private FragmentManager fragmentManager = getSupportFragmentManager();
	
	private MainNewsFragment mainNewsFragment;
	
	private MainCareFragment mainCareFragment;
	
	private MainHomeFragment mainHomeFragment;
	
	private MainTaskFragment mainTaskFragment;
	
	private MainMineFragment mainMineFragment;
	
	private TabLayout tabLayout;
	
	private ImageView imageFlashView;
	
	/**
	 * 开启主页面, 并存入用户信息
	 *
	 * @param context
	 * @param loginPhonePwdBean 用户信息
	 */
	public static void actionStart(Context context, VEnterLoginPhonePwdBean loginPhonePwdBean)
	{
		// 设置本地数据
		AppStateManager.getInstance().setLoginUserInfo(context, loginPhonePwdBean);

		// 设置 做动画
		AppStateManager.getInstance().setFirstFlash(true);

		context.startActivity(new Intent(context, MainActivity.class));
	}
	
	/**
	 * 退出登录
	 * 重新开启主界面
	 *
	 * @param context
	 */
	public static void actionStart(Context context)
	{
		AppStateManager.getInstance().clearLoginUserInfo(context); // 清除本地数据
		SDKManager.finishActivity();

		// 设置不做动画
		AppStateManager.getInstance().setFirstFlash(false);

		context.startActivity(new Intent(context, MainActivity.class));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageFlashView = (ImageView) findViewById(R.id.iv_main_logo);

		tabLayout = (TabLayout) findViewById(R.id.tab_layout_main);

		mainHelper = new MainHelper();
		if (AppStateManager.getInstance().isFirstFlash())
		{
			mainHelper.initFlashAnimator(imageFlashView);
		}

		initView();
		initData();

		initShowData();
	}
	
	/**
	 * 显示用户第一次看到的内容
	 */
	private void initShowData()
	{
		doSelected(TAB.Home.position);
	}
	
	private void initView()
	{
		int[] icons = {TAB.News.icon, TAB.Care.icon, TAB.Home.icon, TAB.Task.icon, TAB.Mine.icon};
		mainHelper.initTabLayout(this, tabLayout, icons);

		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
		{
			@Override
			public void onTabSelected(TabLayout.Tab tab)
			{
				int position = tab.getPosition();
				if (position == TAB.News.position)
				{
					fragmentManager.beginTransaction().show(mainNewsFragment).commit();
				}
				else if (position == TAB.Care.position)
				{
					fragmentManager.beginTransaction().show(mainCareFragment).commit();
				}
				else if (position == TAB.Home.position)
				{
					fragmentManager.beginTransaction().show(mainHomeFragment).commit();
				}
				else if (position == TAB.Task.position)
				{
					fragmentManager.beginTransaction().show(mainTaskFragment).commit();
				}
				else if (position == TAB.Mine.position)
				{
					fragmentManager.beginTransaction().show(mainMineFragment).commit();
				}
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab)
			{
				int position = tab.getPosition();
				if (position == TAB.News.position)
				{
					fragmentManager.beginTransaction().hide(mainNewsFragment).commit();
				}
				else if (position == TAB.Care.position)
				{
					fragmentManager.beginTransaction().hide(mainCareFragment).commit();
				}
				else if (position == TAB.Home.position)
				{
					fragmentManager.beginTransaction().hide(mainHomeFragment).commit();
				}
				else if (position == TAB.Task.position)
				{
					fragmentManager.beginTransaction().hide(mainTaskFragment).commit();
				}
				else if (position == TAB.Mine.position)
				{
					fragmentManager.beginTransaction().hide(mainMineFragment).commit();
				}
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab)
			{

			}
		});
	}
	
	private void initData()
	{
		mainNewsFragment = MainNewsFragment.newInstance();
		mainCareFragment = MainCareFragment.newInstance();
		mainHomeFragment = MainHomeFragment.newInstance();
		mainTaskFragment = MainTaskFragment.newInstance();
		mainMineFragment = MainMineFragment.newInstance();

		fragmentManager.beginTransaction().add(R.id.fl_main_content, mainNewsFragment).hide(mainNewsFragment).add(R.id.fl_main_content, mainCareFragment).hide(mainCareFragment).add(R.id.fl_main_content, mainHomeFragment).hide(mainHomeFragment).add(R.id.fl_main_content, mainTaskFragment).hide(mainTaskFragment).add(R.id.fl_main_content, mainMineFragment).hide(mainMineFragment).commit();
	}
	
	public void doSelected(int index)
	{
		tabLayout.getTabAt(index).select();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		LogFileUtil.v("request Code = " + requestCode);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == android.R.id.home)
		{
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	public enum TAB
	{
		News(0, R.drawable.main_tab_news),

		Care(1, R.drawable.main_tab_care),

		Home(2, R.drawable.main_tab_home),

		Task(3, R.drawable.main_tab_task),

		Mine(4, R.drawable.main_tab_mine);

		private final int position;

		private final int icon;

		/**
		 * @param position 位置
		 * @param icon     tab资源
		 */
		TAB(int position, int icon)
		{
			this.position = position;
			this.icon = icon;
		}

		public int getPosition()
		{
			return position;
		}

		public int getIcon()
		{
			return icon;
		}
	}
}
