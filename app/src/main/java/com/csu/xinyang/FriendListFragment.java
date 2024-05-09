package com.csu.xinyang;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.List;

public class FriendListFragment extends Fragment {

    private LottieAnimationView loadingView;

    public static FriendListFragment newInstance() {
        return new FriendListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext())); // 选择布局管理器，例如LinearLayoutManager

        List<String> dataList = Arrays.asList(
                "Apple",
                "Banana",
                "Cherry",
                "Date",
                "Elderberry",
                "Fig",
                "Grape",
                "Honeydew",
                "Ivyberry",
                "Jackfruit"
        );
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.INVISIBLE);
        loadingView = view.findViewById(R.id.loading_animation);
        loadingView.playAnimation(); // 播放加载动画

        new Handler().postDelayed(()->{
            // 5秒后模拟数据加载完成并隐藏加载动画，显示实际列表（这里简化处理，实际应加载数据）
            loadingView.animate()
                    .alpha(0f) // 从完全透明变为完全不透明
                    .setDuration(200) // 设置动画持续时间为5000毫秒
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            loadingView.setVisibility(View.VISIBLE); // 在动画开始时设置为可见
                        }
                    })
                    .start();
            recyclerView.setVisibility(View.VISIBLE);
        },4800);
        return view;
    }
}