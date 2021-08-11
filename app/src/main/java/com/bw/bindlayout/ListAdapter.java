package com.bw.bindlayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.bindlayout.databinding.ItemListBinding;
import com.bw.bindlayout.entity.UserBean;

import java.util.List;

/**
 * @ClassName ListAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/10 21:24
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private List<UserBean> mList;

    public ListAdapter(List<UserBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyViewHolder holder, int position) {
        ItemListBinding binding = (ItemListBinding) holder.dataBinding;
        binding.setUser(mList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mList!=null){
            return mList.size();
        }else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ViewDataBinding dataBinding;
        public MyViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.dataBinding = viewDataBinding;
        }
    }
}
