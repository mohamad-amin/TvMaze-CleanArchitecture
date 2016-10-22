package com.sixthsolution.easymvp.tvmaze.view.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.model.Constants;
import com.sixthsolution.easymvp.tvmaze.view.activity.ShowActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mohamadamin on 9/1/16.
 */
public class IconicFilmViewHolder extends UltimateRecyclerviewViewHolder<Film> {

    @BindView(R.id.header_image) ImageView imageView;
    @BindView(R.id.item_title) TextView titleText;

    private String filmJson;
    private String imageUrl;
    private Activity activity;

    public IconicFilmViewHolder(View view, Activity activity) {
        super(view);
        this.activity = activity;
        ButterKnife.bind(this, view);
        view.setOnClickListener(view1 -> launchIntent());
    }

    private void launchIntent() {
        Intent intent = new Intent(activity, ShowActivity.class);
        intent.putExtra(Constants.IMAGE_URL, imageUrl);
        intent.putExtra(Constants.EXTRA_FILM, filmJson);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            activity, imageView, activity.getString(R.string.transition_image));
            activity.startActivity(intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }

    public void setFilmJson(String filmJson) {
        this.filmJson = filmJson;
    }

    public void showIcon(String url) {
        this.imageUrl = url;
        Glide.with(getContext().getApplicationContext())
                .load(url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontTransform()
                .fitCenter()
                .into(imageView);
    }

    public void showTitle(String title) {
        titleText.setText(title);
    }

}
