package com.sixthsolution.easymvp.tvmaze.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.ActivityComponent;
import com.sixthsolution.easymvp.tvmaze.presenter.FilmsListPresenter;
import com.sixthsolution.easymvp.tvmaze.view.adapter.IconicFilmAdapter;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseFragment;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmsListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import easymvp.annotation.FragmentView;
import easymvp.annotation.Presenter;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

@FragmentView(presenter = FilmsListPresenter.class)
public class FilmsListFragment extends BaseFragment implements FilmsListView {

    @BindView(R.id.films_list_recycler) UltimateRecyclerView recyclerView;
    @BindView(R.id.progress_bar) MaterialProgressBar progressBar;
    @BindView(R.id.films_list_error) View networkErrorView;

    @Inject
    @Presenter
    FilmsListPresenter presenter;

    @Inject
    IconicFilmAdapter adapter;

    @OnClick(R.id.network_error_button)
    public void onClick() {
        presenter.reload();
    }

    public FilmsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(ActivityComponent.class).inject(this);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_films_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showFilms(List<Film> films) {
        adapter.setFilms(films);
        recyclerView.setAdapter(adapter);
        showRecyclerView();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorView() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        networkErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBar() {
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        networkErrorView.setVisibility(View.GONE);
    }

    private void showRecyclerView() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        networkErrorView.setVisibility(View.GONE);
    }


}
