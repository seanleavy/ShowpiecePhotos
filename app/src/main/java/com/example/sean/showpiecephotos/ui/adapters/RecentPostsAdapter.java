package com.example.sean.showpiecephotos.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.R2;
import com.example.sean.showpiecephotos.model.Pojo.recentPosts.InstagramPost;
import com.example.sean.showpiecephotos.model.Pojo.recentPosts.nested.Datum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_posts_row_item, parent, false);
        ViewHolder recentPostsViewholder = new ViewHolder(v);
        return recentPostsViewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.caption.setText(recentPosts.get(position).getCaption().getText());
        holder.fullName.setText(recentPosts.get(position).getUser().getFullName());
        holder.likes.setText(recentPosts.get(position).getLikes().getCount().toString());
        //populate widget values here with datum.get
    }

    @Override
    public int getItemCount() {
        return recentPosts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.post_image)
        ImageView postImage;

        @BindView(R.id.post_fullname)
        TextView fullName;

        @BindView(R.id.post_likes)
        TextView likes;

        @BindView(R.id.post_caption_text)
        TextView caption;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
