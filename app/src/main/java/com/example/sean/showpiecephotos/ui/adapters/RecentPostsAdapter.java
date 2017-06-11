package com.example.sean.showpiecephotos.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.sean.showpiecephotos.model.Pojo.recentPosts.InstagramPost;
import com.example.sean.showpiecephotos.model.Pojo.recentPosts.nested.Datum;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class RecentPostsAdapter extends RecyclerView.Adapter<RecentPostsAdapter.ViewHolder> {

    // Used Datum part of model and split the InstagramPost response
    private List<Datum> recentPosts;

    public RecentPostsAdapter() {
        this.recentPosts = new ArrayList<>();
    }

    public void addPost(InstagramPost instagramPost) {
        recentPosts.addAll(instagramPost.getData());
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return recentPosts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
