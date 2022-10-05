package com.example.youtube;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoRvAdapter  extends  RecyclerView.Adapter<VideoRvAdapter.ViewHolder>{


    public class ViewHolder extends RecyclerView.ViewHolder{

        VideoView videoView;

        public ViewHolder(View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.vv_video);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View videoView = inflater.inflate(R.layout.video_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(videoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoView videoView = holder.videoView;
        videoView.setVideoURI(Uri.parse("android.resource://com.example.youtube/"+R.raw.video));
        videoView.start();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
