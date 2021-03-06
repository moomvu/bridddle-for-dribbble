package io.b1ackr0se.bridddle.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.transition.TransitionManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.b1ackr0se.bridddle.MainActivity;
import io.b1ackr0se.bridddle.R;
import io.b1ackr0se.bridddle.base.TransitionBaseActivity;
import io.b1ackr0se.bridddle.data.model.Comment;
import io.b1ackr0se.bridddle.data.model.Shot;
import io.b1ackr0se.bridddle.data.model.User;
import io.b1ackr0se.bridddle.ui.common.OnUserClickListener;
import io.b1ackr0se.bridddle.ui.detail.comment.CommentAdapter;
import io.b1ackr0se.bridddle.ui.login.DribbbleLoginActivity;
import io.b1ackr0se.bridddle.ui.search.SearchActivity;
import io.b1ackr0se.bridddle.ui.search.SearchPresenter;
import io.b1ackr0se.bridddle.ui.user.UserActivity;
import io.b1ackr0se.bridddle.ui.widget.AspectRatioImageView;
import io.b1ackr0se.bridddle.ui.widget.ColorPaletteView;
import io.b1ackr0se.bridddle.ui.widget.EndlessRecyclerOnScrollListener;
import io.b1ackr0se.bridddle.ui.widget.OnColorClickListener;
import io.b1ackr0se.bridddle.util.DateUtils;
import io.b1ackr0se.bridddle.util.LinkUtils;
import io.b1ackr0se.bridddle.util.SoftKey;
import io.b1ackr0se.bridddle.util.StringUtils;


public class ShotActivity extends TransitionBaseActivity implements OnColorClickListener, OnUserClickListener, ShotView {
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
    @BindView(R.id.color_palette_view) ColorPaletteView colorPaletteView;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.like_image) ImageView likeImageView;
    @BindView(R.id.liked_image) ImageView likedImageView;
    @BindView(R.id.like_container) FrameLayout likeContainer;

    @Inject ShotPresenter shotPresenter;
    @Inject StringUtils stringUtils;

    private Shot shot;
    private List<Comment> comments = new ArrayList<>();
    private CommentAdapter adapter;

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;

    @OnClick(R.id.like)
    public void onLike() {
        shotPresenter.performLikeOrUnlike();
    }

    @OnClick(R.id.share)
    public void onShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shot.getHtmlUrl());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share_msg)));
    }

    @OnClick(R.id.response)
    public void onResponse() {

    }

    @OnClick(R.id.author_detail)
    public void viewUser() {
        UserActivity.navigate(this, shot.getUser());
    }


    public static void navigate(Activity context, View view, Shot shot) {
        Intent intent = new Intent(context, ShotActivity.class);
        intent.putExtra("shot", shot);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shot);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        shotPresenter.attachView(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        nestedScrollView.setClipToPadding(false);

        if (SoftKey.isAvailable(this)) {
            nestedScrollView.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.navigation_bar_height));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore() {
                comments.add(null);
                adapter.notifyItemInserted(comments.size() - 1);
                shotPresenter.loadComment(false);
            }
        };

        adapter = new CommentAdapter(comments);
        adapter.setListener(this
        );

        recyclerView.setClipToPadding(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);

        shot = getIntent().getParcelableExtra("shot");

        shotPresenter.setShot(shot);

        shotPresenter.checkLike();

        shotPresenter.load();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        shotPresenter.detachView();
    }

    @Override
    protected void onLoggedIn() {
        shotPresenter.checkLike();
    }

    @Override
    public void bind() {
        loadShot();

        shotTitle.setText(shot.getTitle());

        LinkUtils.setTextWithLinks(shotDescription, shot.getDescription());

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

        likeCount.setText(stringUtils.formatWithText(R.plurals.like_number, R.string.no_like, shot.getLikesCount()));
        viewCount.setText(stringUtils.formatWithText(R.plurals.view_number, R.string.no_view, shot.getViewsCount()));
        responseCount.setText(stringUtils.formatWithText(R.plurals.comment_number, R.string.no_comment, shot.getCommentsCount()));

        if (shot.getCreatedAt() != null) {
            shotDate.setText(DateUtils.parse(shot.getCreatedAt()));
            shotDate.setVisibility(View.VISIBLE);
        } else {
            shotDate.setVisibility(View.GONE);
        }
    }

    @Override
    public void showComments(List<Comment> list) {
        setLoadMoreFinished();
        comments.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoComment() {
        setLoadMoreFinished();
    }

    @Override
    public void showError() {
        setLoadMoreFinished();
    }

    @Override
    public void showLike(boolean liked) {
        TransitionManager.beginDelayedTransition(likeContainer);
        likedImageView.setVisibility(liked ? View.VISIBLE : View.INVISIBLE);
        likeImageView.setVisibility(liked ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public void failedToLike(boolean like) {
        String msg = like ? getString(R.string.failed_to_like) : getString(R.string.failed_to_unlike);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void performLogin() {
        startActivityForResult(new Intent(this, DribbbleLoginActivity.class), MainActivity.REQUEST_CODE_LOGIN);
    }


    private void setLoadMoreFinished() {
        if (!comments.isEmpty()) {
            comments.remove(comments.size() - 1);
            adapter.notifyItemRemoved(comments.size());
        }
        endlessRecyclerOnScrollListener.setLoaded();
    }

    private void loadShot() {
        if (shot.getAnimated()) {
            Glide.with(this)
                    .load(shot.getImages().getHighestResImage())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .priority(Priority.IMMEDIATE)
                    .into(new GlideDrawableImageViewTarget(shotImageView) {
                        @Override
                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                            super.onResourceReady(resource, animation);
                            if (resource instanceof GifDrawable) {
                                generateColorPalette(((GifDrawable) resource).getFirstFrame());
                            } else if (resource instanceof GlideBitmapDrawable) {
                                generateColorPalette(((GlideBitmapDrawable) resource).getBitmap());
                            }
                        }
                    });
        } else {
            Glide.with(this)
                    .load(shot.getImages().getHighestResImage())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .priority(Priority.IMMEDIATE)
                    .into(new BitmapImageViewTarget(shotImageView) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            generateColorPalette(resource);
                        }
                    });
        }
    }

    private void generateColorPalette(Bitmap bitmap) {
        Palette.from(bitmap).maximumColorCount(8)
                .generate(this::bindColor);
    }

    private void bindColor(Palette palette) {
        List<Palette.Swatch> swatches = palette.getSwatches();
        colorPaletteView.setOnColorClickListener(this);
        colorPaletteView.setSwatches(swatches);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onColorClick(View view, @ColorInt int color) {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("search_type", SearchPresenter.SEARCH_COLOR);
        intent.putExtra("color", color);
        startActivity(intent);
    }

    @Override
    public void onUserClick(User user) {
        UserActivity.navigate(this, user);
    }
}
