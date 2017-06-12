package com.example.sean.showpiecephotos.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.model.Pojo.recent.Datum;
import com.example.sean.showpiecephotos.model.Pojo.recent.RecentPosts;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecentPostsAdapter extends RecyclerView.Adapter<RecentPostsAdapter.ViewHolder> {

    // Used Datum part of model and split the InstagramPost response
    private List<Datum> recentPosts;

    private Context context;

    public RecentPostsAdapter(Context context) {
        this.recentPosts = new ArrayList<>();
        this.context = context;
    }

    public void add(RecentPosts recentMedia) {
        this.recentPosts.addAll(recentMedia.getData());
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
        Picasso.with(context).load(recentPosts.get(position).getImages().getThumbnail().getUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .into(holder.postImage);
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
