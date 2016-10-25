package com.sixthsolution.easymvp.tvmaze.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerActivityComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DataComponent;
import com.sixthsolution.easymvp.tvmaze.model.Constants;
import com.sixthsolution.easymvp.tvmaze.presenter.FilmDetailPresenter;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmDetailView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = FilmDetailPresenter.class, layout = R.layout.activity_film_detail)
public class FilmDetailActivity extends BaseActivity implements FilmDetailView {

    @Inject
    @Presenter
    FilmDetailPresenter presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.header_tabs) TabLayout tabLayout;
    @BindView(R.id.app_bar) AppBarLayout appBarLayout;
    @BindView(R.id.header_text) TextView subtitleText;
    @BindView(R.id.header_image) ImageView headerImage;
    @BindView(R.id.toolbar_layout) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.info_type) TextView typeText;
    @BindView(R.id.info_title) TextView titleText;
    @BindView(R.id.info_genres) TextView genresText;
    @BindView(R.id.info_status) TextView statusText;
    @BindView(R.id.info_rating) TextView ratingText;
    @BindView(R.id.info_network) TextView networkText;
    @BindView(R.id.info_runtime) TextView runtimeText;
    @BindView(R.id.info_language) TextView languageText;
    @BindView(R.id.info_schedule) TextView scheduleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

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

    }

    @Override
    protected void injectDependencies(DataComponent dataComponent) {

        DaggerActivityComponent.builder()
                .dataComponent(dataComponent)
                .activityModule(getActivityModule())
                .build()
                .inject(this);

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        changeExpandedTitle();
    }

//    private void changeExpandedTitle() {
//
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    collapsingToolbar.setTitle(title);
//                } else {
//                    collapsingToolbar.setTitle(" ");
//                }
//            }
//
//        });
//
//    }


    @Override
    public void showType(String type) {
        String addition = "Type: ";
        typeText.setText(getBoldSpanned(addition+type, 0, addition.length()));
    }

    @Override
    public void showRate(double rate) {
        String text = rate + " out of 5";
        String addition = "Rating: ";
        ratingText.setText(getBoldSpanned(addition+text, 0, addition.length()));
    }

    @Override
    public void showGenres(String genres) {
        String addition = "Genres: ";
        genresText.setText(getBoldSpanned(addition+genres, 0, addition.length()));
    }

    @Override
    public void showStatus(String status) {
        String addition = "Status: ";
        statusText.setText(getBoldSpanned(addition+status, 0, addition.length()));
    }

    @Override
    public void showRuntime(String runtime) {
        String addition = "Runtime: ";
        runtimeText.setText(getBoldSpanned(addition+runtime+" minutes", 0, addition.length()));
    }

    @Override
    public void showNetwork(String network) {
        String addition = "Airs On: ";
        networkText.setText(getBoldSpanned(addition+network, 0, addition.length()));
    }

    @Override
    public void showSchedule(String schedule) {
        String addition = "Schedule: ";
        scheduleText.setText(getBoldSpanned(addition+schedule, 0, addition.length()));
    }

    @Override
    public void showLanguage(String language) {
        String addition = "Language: ";
        languageText.setText(getBoldSpanned(addition+language, 0, addition.length()));
    }

    @Override
    public void showTitle(String title) {
        collapsingToolbar.setTitle(title);
        toolbar.setTitle(title);
        titleText.setText(title);
    }

    @Override
    public void showSummary(String summary) {
        subtitleText.setText(Html.fromHtml(summary).toString().trim());
    }

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
    public Intent getComingIntent() {
        return getIntent();
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

    private SpannableString getBoldSpanned(String string, int start, int end) {
        SpannableString text = new SpannableString(string);
        text.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return text;
    }
    
}
