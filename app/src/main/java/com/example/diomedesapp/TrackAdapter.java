package com.example.diomedesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    private final List<Track> tracks;

    public TrackAdapter(List<Track> tracks) {
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_track, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        Track track = tracks.get(position);
        holder.tvTrack.setText(track.getTrackName());
        holder.tvArtist.setText(track.getArtistName());
        holder.tvAlbum.setText("Álbum: " + track.getCollectionName());

        String date = track.getReleaseDate();
        String year = (date != null && date.length() >= 4) ? date.substring(0, 4) : "N/D";
        holder.tvYear.setText("Año: " + year);

        String cover = track.getArtworkUrl100();
        if (cover != null) {
            cover = cover.replace("100x100", "400x400");
        }
        Glide.with(holder.itemView.getContext()).load(cover).into(holder.imgCover);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    static class TrackViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCover;
        TextView tvTrack, tvArtist, tvAlbum, tvYear;

        TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.imgCover);
            tvTrack = itemView.findViewById(R.id.tvTrack);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
            tvYear = itemView.findViewById(R.id.tvYear);
        }
    }
}