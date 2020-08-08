package com.saurav.freecodemoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapterClass extends RecyclerView.Adapter<VideoAdapterClass.VideoViewHolder> {


    private List<VideoItemBin> videoItemBins;

    public VideoAdapterClass(List<VideoItemBin> videoItemBins) {
        this.videoItemBins = videoItemBins;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_video,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        holder.setVideoData(videoItemBins.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItemBins.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView mVideoView;
        TextView mTextVideoTitle, mTextDescription;
        ProgressBar mProgressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            mVideoView = itemView.findViewById(R.id.videoView);
            mTextVideoTitle = itemView.findViewById(R.id.textVideoTitle);
            mTextDescription = itemView.findViewById(R.id.textVideoDescription);
            mProgressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        void setVideoData(VideoItemBin videoItemBin) {
            mTextVideoTitle.setText(videoItemBin.videoTitle);
            mTextDescription.setText(videoItemBin.videoDescription);
            mVideoView.setVideoPath(videoItemBin.videoURL);
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mProgressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio = mp.getVideoHeight() / (float) mp.getVideoHeight();
                    float screenRatio = mVideoView.getWidth() / (float) mVideoView.getHeight();

                    float scale = videoRatio / screenRatio;

                    if (scale >= 1f) {
                        mVideoView.setScaleX(scale);
                    } else {
                        mVideoView.setScaleY(1f / scale);
                    }
                }
            });

            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();

                }
            });
        }
    }
}
