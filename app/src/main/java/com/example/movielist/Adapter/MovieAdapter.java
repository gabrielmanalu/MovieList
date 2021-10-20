package com.example.movielist.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movielist.Model.MovieModel;
import com.example.movielist.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context mContext;
    private List<MovieModel>movieList;
    private ItemClickListener mClickListener;

    public MovieAdapter(Context context, List<MovieModel> movieList, ItemClickListener clickListener) {
        mContext = context;
        this.movieList = movieList;
        mClickListener = clickListener;
    }

    public void setMovieList(List<MovieModel> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onMovieClick(movieList.get(position));
            }
        });
        Glide.with(mContext)
                .load(this.movieList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);

        holder.tvTitle.setText(this.movieList.get(position).getTitle().toString());
    }

    @Override
    public int getItemCount() {
        if(this.movieList != null){
            return this.movieList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.titleView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }


    public interface ItemClickListener{
        public void onMovieClick(MovieModel movie);
    }
}
