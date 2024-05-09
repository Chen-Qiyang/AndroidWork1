package com.csu.xinyang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private List<String> dataList;

    // 构造函数，用于接收数据列表
    public MyRecyclerViewAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    // 创建 ViewHolder 实例
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(itemView);
    }

    // 绑定数据到 ViewHolder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String data = dataList.get(position);
        holder.textView.setText(data);
        // 更多数据绑定...
    }

    // 返回数据项数量
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // ViewHolder 类定义
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}