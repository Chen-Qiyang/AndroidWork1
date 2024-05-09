package com.csu.xinyang;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // 设置ViewPager2的适配器
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), getLifecycle()));

        // 将TabLayout与ViewPager2关联
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("好友列表");
                    break;
                case 1:
                    tab.setText("我的好友");
                    break;
            }
        }).attach();
    }

    // FragmentAdapter类
    private static class PagerAdapter extends FragmentStateAdapter {

        public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // 根据位置返回不同的Fragment实例
            return FriendListFragment.newInstance();
        }

        @Override
        public int getItemCount() {
            return 2; // 当前示例只有一个Fragment，即好友列表
        }
    }
}