package com.sixthsolution.easymvp.tvmaze.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.ActivityComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerActivityComponent;
import com.sixthsolution.easymvp.tvmaze.model.Constants;
import com.sixthsolution.easymvp.tvmaze.presenter.FilmDetailPresenter;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmDetailView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = FilmDetailPresenter.class, layout = R.layout.activity_show)
public class ShowActivity extends BaseActivity implements FilmDetailView {

    @Inject
    @Presenter
    FilmDetailPresenter presenter;

    private ActivityComponent activityComponent;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.header_tabs) TabLayout tabLayout;
    @BindView(R.id.app_bar) AppBarLayout appBarLayout;
    @BindView(R.id.header_text) TextView subtitleText;
    @BindView(R.id.header_image) ImageView headerImage;
    @BindView(R.id.toolbar_layout) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.view_pager) ViewPager viewPager;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            headerImage.setTransitionName(getString(R.string.transition_image));
            Glide.with(this)
                    .load(getIntent().getStringExtra(Constants.IMAGE_URL))
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .fitCenter()
                    .into(headerImage);

        }
        setupToolbar();

        initializeInjector();

    }

    private void initializeInjector() {

        this.activityComponent = DaggerActivityComponent.builder()
                .dataComponent(getDataComponent())
                .activityModule(getActivityModule())
                .build();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        changeExpandedTitle();
    }

    private void changeExpandedTitle() {

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    collapsingToolbar.setTitle(title);
                } else {
                    collapsingToolbar.setTitle(" ");
                }
            }

        });

    }

    @Override
    public void showFilm(Film film) {
        showTitle(film.getName());
        showSummary(film.getSummary());
    }

    public void showTitle(String title) {
        collapsingToolbar.setTitle(title);
        toolbar.setTitle(title);
        this.title = title;
    }

    public void showSummary(String summary) {
        subtitleText.setText(Html.fromHtml(summary).toString().trim());
    }

//    public void setViewPagerAdapter(FragmentPagerAdapter adapter) {
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorView() {
        // Todo
    }

    @Override
    public void showProgressBar() {
        // Todo
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
