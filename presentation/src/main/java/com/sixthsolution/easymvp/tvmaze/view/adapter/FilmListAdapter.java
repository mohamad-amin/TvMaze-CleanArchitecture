package com.sixthsolution.easymvp.tvmaze.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;
import com.sixthsolution.easymvp.tvmaze.view.viewholder.FilmListViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * Created by mohamadamin on 9/1/16.
 */
public class FilmListAdapter extends UltimateViewAdapter<FilmListViewHolder> {

    private List<Film> films;
    private BaseActivity activity;

    public FilmListAdapter(BaseActivity activity) {
        this.activity = activity;
        this.films = Collections.emptyList();
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    private LayoutInflater getInflater() {
        return LayoutInflater.from(activity);
    }

    @Override
    public void onBindViewHolder(final FilmListViewHolder holder, final int position) {
        holder.bindFilm(films.get(position));
    }

    @Override
    public FilmListViewHolder newFooterHolder(View view) {
        return null;
    }

    @Override
    public FilmListViewHolder newHeaderHolder(View view) {
        return null;
    }

    @Override
    public FilmListViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.list_item_big, parent, false);
        FilmListViewHolder holder = new FilmListViewHolder(view, activity);
        return holder;
    }

    @Override
    public int getAdapterItemCount() {
        return films == null ? 0 : films.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

}
