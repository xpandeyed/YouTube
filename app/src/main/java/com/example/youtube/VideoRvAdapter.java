package com.example.youtube;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


//Recycler view with multiple view types

public class VideoRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    VideoRvAdapter(Context con){
        this.context = con;
    }

    public class ViewHolderVideos extends RecyclerView.ViewHolder {

        VideoView videoView;

        public ViewHolderVideos(View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.vv_video);
        }
    }

    public class ViewHolderShorts extends RecyclerView.ViewHolder{

        RecyclerView rvShorts;

        public ViewHolderShorts(View itemView){
            super(itemView);
            rvShorts = itemView.findViewById(R.id.rv_shorts);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position!=0 && position % 3 == 0) return 0;
        else return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        if(viewType==0){
            LayoutInflater inflaterForShorts = LayoutInflater.from(context);
            View shortsView = inflaterForShorts.inflate(R.layout.shorts_rv, parent, false);
            return new ViewHolderShorts(shortsView);
        }

        LayoutInflater inflater = LayoutInflater.from(context);
        View videoView = inflater.inflate(R.layout.video_item, parent, false);
        return new ViewHolderVideos(videoView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            ViewHolderShorts viewHolderShorts = (ViewHolderShorts) holder;
            LinearLayoutManager linearLayoutManagerForShorts = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            RecyclerView rvShorts = viewHolderShorts.rvShorts;
            rvShorts.setLayoutManager(linearLayoutManagerForShorts);
            rvShorts.setItemAnimator(new DefaultItemAnimator());
            ShortsRvAdapter adapterForShorts = new ShortsRvAdapter();
            rvShorts.setAdapter(adapterForShorts);

        } else {
            ViewHolderVideos  viewHolderVideos = (ViewHolderVideos) holder;
            VideoView videoView = viewHolderVideos.videoView;
            videoView.setVideoURI(Uri.parse("android.resource://com.example.youtube/" + R.raw.video));
            videoView.start();
            videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoView.start();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return 10;
    }
}
