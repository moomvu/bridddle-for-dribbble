package io.b1ackr0se.bridddle.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.b1ackr0se.bridddle.R;
import io.b1ackr0se.bridddle.base.BaseActivity;
import io.b1ackr0se.bridddle.data.model.Shot;
import io.b1ackr0se.bridddle.ui.widget.AspectRatioImageView;
import io.b1ackr0se.bridddle.util.DateUtils;
import io.b1ackr0se.bridddle.util.LinkUtils;
import io.b1ackr0se.bridddle.util.SoftKey;


public class ShotActivity extends BaseActivity {
    @BindView(R.id.nested_scroll_view) NestedScrollView nestedScrollView;
    @BindView(R.id.imageview_shot) AspectRatioImageView shotImageView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.app_bar) AppBarLayout appBarLayout;
    @BindView(R.id.shot_title) TextView shotTitle;
    @BindView(R.id.shot_author_image) ImageView shotAuthorImage;
    @BindView(R.id.shot_author_name) TextView shotAuthorName;
    @BindView(R.id.shot_date) TextView shotDate;
    @BindView(R.id.shot_description) TextView shotDescription;
    @BindView(R.id.like_count) TextView likeCount;
    @BindView(R.id.view_count) TextView viewCount;
    @BindView(R.id.response_count) TextView responseCount;

    private Shot shot;

    @OnClick(R.id.like)
    public void onLike() {

    }

    @OnClick(R.id.share)
    public void onShare() {

    }

    @OnClick(R.id.response)
    public void onResponse() {

    }

    public static void navigate(Activity context, View view, Shot shot) {
        Intent intent = new Intent(context, ShotActivity.class);
        intent.putExtra("shot", shot);
        ImageView coverStartView = (ImageView) view.findViewById(R.id.shot_image);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_up, R.anim.iddle);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        nestedScrollView.setClipToPadding(false);
        if (SoftKey.isAvailable(this)) {
            nestedScrollView.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.navigation_bar_height));
        }

        shot = getIntent().getParcelableExtra("shot");

        Glide.with(this)
                .load(shot.getImages().getHighestResImage())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .priority(Priority.IMMEDIATE)
                .into(shotImageView);

        shotTitle.setText(shot.getTitle());

        LinkUtils.setTextWithLinks(shotDescription, LinkUtils.fromHtml(shot.getDescription(), false));

        shotAuthorName.setText(shot.getUser().getName());

        Glide.with(this).load(shot.getUser().getAvatarUrl())
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(shotAuthorImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(ShotActivity.this.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        shotAuthorImage.setImageDrawable(circularBitmapDrawable);
                    }
                });


        likeCount.setText(String.valueOf(shot.getLikesCount()) + " LIKES");
        viewCount.setText(String.valueOf(shot.getViewsCount()) + " VIEWS");
        responseCount.setText(String.valueOf(shot.getCommentsCount()) + " RESPONSES");
        shotDate.setText(DateUtils.parse(shot.getCreatedAt()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.slide_down);
    }
}
