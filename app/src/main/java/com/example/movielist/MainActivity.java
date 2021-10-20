package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movielist.Adapter.MovieAdapter;
import com.example.movielist.Model.MovieModel;
import com.example.movielist.ViewModel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ItemClickListener {

    private List<MovieModel> mMovieModelList;
    private MovieAdapter mAdapter;
    private MovieViewModel mMovieViewModel;
    private RecyclerView mRecyclerView;

    RecyclerView.LayoutManager mLayoutManager;
    private TextView noResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){
        mRecyclerView = findViewById(R.id.recyclerView);
        noResult = findViewById(R.id.noResultText);
        mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MovieAdapter(this, mMovieModelList, this);

        mRecyclerView.setAdapter(mAdapter);

        mMovieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        mMovieViewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    mMovieModelList = movieModels;
                    mAdapter.setMovieList(movieModels);
                    noResult.setVisibility(View.GONE);
                } else{
                    noResult.setVisibility(View.VISIBLE);
                }
            }
        });
        mMovieViewModel.makeApiCall();
    }

    @Override
    public void onMovieClick(MovieModel movie) {
        Toast.makeText(this, "Movie : " + movie.getTitle(), Toast.LENGTH_SHORT).show();
    }
}