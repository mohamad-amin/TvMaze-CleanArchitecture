package com.sixthsolution.easymvp.tvmaze.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.interactor.impl.ConvertFilmToJsonUseCase;
import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;
import com.sixthsolution.easymvp.tvmaze.view.viewholder.IconicFilmViewHolder;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by mohamadamin on 9/1/16.
 */
public class IconicFilmAdapter extends UltimateViewAdapter<IconicFilmViewHolder> {

    private List<Film> films;
    private BaseActivity activity;
    private ConvertFilmToJsonUseCase convertFilmToUseCase;

    @Inject
    public IconicFilmAdapter(BaseActivity activity, ConvertFilmToJsonUseCase useCase) {
        this.activity = activity;
        this.convertFilmToUseCase = useCase;
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
    public void onBindViewHolder(final IconicFilmViewHolder holder, final int position) {
        loadFilm(holder, films.get(position));
        convertFilmToUseCase.execute(new Subscriber() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onNext(Object o) {
                holder.setFilmJson((String)o);
            }
        });
    }

    public void loadFilm(IconicFilmViewHolder view, Film film) {
        view.showIcon(film.getImage().getOriginal());
        view.showTitle(film.getName());
    }

    @Override
    public IconicFilmViewHolder newFooterHolder(View view) {
        return null;
    }

    @Override
    public IconicFilmViewHolder newHeaderHolder(View view) {
        return null;
    }

    @Override
    public IconicFilmViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.list_item_big, parent, false);
        IconicFilmViewHolder holder = new IconicFilmViewHolder(view, activity);
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
