package io.b1ackr0se.bridddle.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Shot implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("attachments_count")
    @Expose
    private Integer attachmentsCount;
    @SerializedName("rebounds_count")
    @Expose
    private Integer reboundsCount;
    @SerializedName("buckets_count")
    @Expose
    private Integer bucketsCount;
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("attachments_url")
    @Expose
    private String attachmentsUrl;
    @SerializedName("buckets_url")
    @Expose
    private String bucketsUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("likes_url")
    @Expose
    private String likesUrl;
    @SerializedName("projects_url")
    @Expose
    private String projectsUrl;
    @SerializedName("rebounds_url")
    @Expose
    private String reboundsUrl;
    @SerializedName("animated")
    @Expose
    private Boolean animated;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<String>();
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("team")
    @Expose
    private Team team;

    private boolean isLiked;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The images
     */
    public Images getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     *
     * @return
     * The viewsCount
     */
    public Integer getViewsCount() {
        return viewsCount;
    }

    /**
     *
     * @param viewsCount
     * The views_count
     */
    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     *
     * @return
     * The likesCount
     */
    public Integer getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The likes_count
     */
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    /**
     *
     * @return
     * The commentsCount
     */
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     *
     * @param commentsCount
     * The comments_count
     */
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     *
     * @return
     * The attachmentsCount
     */
    public Integer getAttachmentsCount() {
        return attachmentsCount;
    }

    /**
     *
     * @param attachmentsCount
     * The attachments_count
     */
    public void setAttachmentsCount(Integer attachmentsCount) {
        this.attachmentsCount = attachmentsCount;
    }

    /**
     *
     * @return
     * The reboundsCount
     */
    public Integer getReboundsCount() {
        return reboundsCount;
    }

    /**
     *
     * @param reboundsCount
     * The rebounds_count
     */
    public void setReboundsCount(Integer reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    /**
     *
     * @return
     * The bucketsCount
     */
    public Integer getBucketsCount() {
        return bucketsCount;
    }

    /**
     *
     * @param bucketsCount
     * The buckets_count
     */
    public void setBucketsCount(Integer bucketsCount) {
        this.bucketsCount = bucketsCount;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * @param htmlUrl
     * The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     *
     * @return
     * The attachmentsUrl
     */
    public String getAttachmentsUrl() {
        return attachmentsUrl;
    }

    /**
     *
     * @param attachmentsUrl
     * The attachments_url
     */
    public void setAttachmentsUrl(String attachmentsUrl) {
        this.attachmentsUrl = attachmentsUrl;
    }

    /**
     *
     * @return
     * The bucketsUrl
     */
    public String getBucketsUrl() {
        return bucketsUrl;
    }

    /**
     *
     * @param bucketsUrl
     * The buckets_url
     */
    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }

    /**
     *
     * @return
     * The commentsUrl
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     *
     * @param commentsUrl
     * The comments_url
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     *
     * @return
     * The likesUrl
     */
    public String getLikesUrl() {
        return likesUrl;
    }

    /**
     *
     * @param likesUrl
     * The likes_url
     */
    public void setLikesUrl(String likesUrl) {
        this.likesUrl = likesUrl;
    }

    /**
     *
     * @return
     * The projectsUrl
     */
    public String getProjectsUrl() {
        return projectsUrl;
    }

    /**
     *
     * @param projectsUrl
     * The projects_url
     */
    public void setProjectsUrl(String projectsUrl) {
        this.projectsUrl = projectsUrl;
    }

    /**
     *
     * @return
     * The reboundsUrl
     */
    public String getReboundsUrl() {
        return reboundsUrl;
    }

    /**
     *
     * @param reboundsUrl
     * The rebounds_url
     */
    public void setReboundsUrl(String reboundsUrl) {
        this.reboundsUrl = reboundsUrl;
    }

    /**
     *
     * @return
     * The animated
     */
    public Boolean getAnimated() {
        return animated;
    }

    /**
     *
     * @param animated
     * The animated
     */
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return
     * The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The team
     */
    public Team getTeam() {
        return team;
    }

    /**
     *
     * @param team
     * The team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeValue(this.width);
        dest.writeValue(this.height);
        dest.writeParcelable(this.images, flags);
        dest.writeValue(this.viewsCount);
        dest.writeValue(this.likesCount);
        dest.writeValue(this.commentsCount);
        dest.writeValue(this.attachmentsCount);
        dest.writeValue(this.reboundsCount);
        dest.writeValue(this.bucketsCount);
        dest.writeLong(createdAt != null ? createdAt.getTime() : -1L);
        dest.writeString(this.updatedAt);
        dest.writeString(this.htmlUrl);
        dest.writeString(this.attachmentsUrl);
        dest.writeString(this.bucketsUrl);
        dest.writeString(this.commentsUrl);
        dest.writeString(this.likesUrl);
        dest.writeString(this.projectsUrl);
        dest.writeString(this.reboundsUrl);
        dest.writeValue(this.animated);
        dest.writeStringList(this.tags);
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.team, flags);
        dest.writeValue(this.isLiked);
    }

    public Shot() {
    }

    protected Shot(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.description = in.readString();
        this.width = (Integer) in.readValue(Integer.class.getClassLoader());
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
        this.images = in.readParcelable(Images.class.getClassLoader());
        this.viewsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.likesCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.commentsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.attachmentsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.reboundsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.bucketsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt != -1 ? new Date(tmpCreatedAt) : null;
        this.updatedAt = in.readString();
        this.htmlUrl = in.readString();
        this.attachmentsUrl = in.readString();
        this.bucketsUrl = in.readString();
        this.commentsUrl = in.readString();
        this.likesUrl = in.readString();
        this.projectsUrl = in.readString();
        this.reboundsUrl = in.readString();
        this.animated = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.tags = in.createStringArrayList();
        this.user = in.readParcelable(User.class.getClassLoader());
        this.team = in.readParcelable(Team.class.getClassLoader());
        this.isLiked = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Shot> CREATOR = new Parcelable.Creator<Shot>() {
        @Override
        public Shot createFromParcel(Parcel source) {
            return new Shot(source);
        }

        @Override
        public Shot[] newArray(int size) {
            return new Shot[size];
        }
    };
}