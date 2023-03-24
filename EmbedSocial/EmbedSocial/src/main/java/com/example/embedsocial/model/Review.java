package com.example.embedsocial.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
//Json datotekata ja konvertirav vo klasa koja gi sodrzi site atributi od json datotekata
@Data
public class Review {

    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("reviewId")
    public String getReviewId() {
        return this.reviewId; }
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId; }
    String reviewId;
    @JsonProperty("reviewFullText")
    public String getReviewFullText() {
        return this.reviewFullText; }
    public void setReviewFullText(String reviewFullText) {
        this.reviewFullText = reviewFullText; }
    String reviewFullText;
    @JsonProperty("reviewText")
    public String getReviewText() {
        return this.reviewText; }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText; }
    String reviewText;
    @JsonProperty("numLikes")
    public int getNumLikes() {
        return this.numLikes; }
    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes; }
    int numLikes;
    @JsonProperty("numComments")
    public int getNumComments() {
        return this.numComments; }
    public void setNumComments(int numComments) {
        this.numComments = numComments; }
    int numComments;
    @JsonProperty("numShares")
    public int getNumShares() {
        return this.numShares; }
    public void setNumShares(int numShares) {
        this.numShares = numShares; }
    int numShares;
    @JsonProperty("rating")
    public int getRating() {
        return this.rating; }
    public void setRating(int rating) {
        this.rating = rating; }
    int rating;
    @JsonProperty("reviewCreatedOn")
    public String getReviewCreatedOn() {
        return this.reviewCreatedOn; }
    public void setReviewCreatedOn(String reviewCreatedOn) {
        this.reviewCreatedOn = reviewCreatedOn; }
    String reviewCreatedOn;
    @JsonProperty("reviewCreatedOnDate")
    public Date getReviewCreatedOnDate() {
        return this.reviewCreatedOnDate; }
    public void setReviewCreatedOnDate(Date reviewCreatedOnDate) {
        this.reviewCreatedOnDate = reviewCreatedOnDate; }
    Date reviewCreatedOnDate;
    @JsonProperty("reviewCreatedOnTime")
    public int getReviewCreatedOnTime() {
        return this.reviewCreatedOnTime; }
    public void setReviewCreatedOnTime(int reviewCreatedOnTime) {
        this.reviewCreatedOnTime = reviewCreatedOnTime; }
    int reviewCreatedOnTime;
    @JsonProperty("reviewerId")
    public Object getReviewerId() {
        return this.reviewerId; }
    public void setReviewerId(Object reviewerId) {
        this.reviewerId = reviewerId; }
    Object reviewerId;
    @JsonProperty("reviewerUrl")
    public Object getReviewerUrl() {
        return this.reviewerUrl; }
    public void setReviewerUrl(Object reviewerUrl) {
        this.reviewerUrl = reviewerUrl; }
    Object reviewerUrl;
    @JsonProperty("reviewerName")
    public String getReviewerName() {
        return this.reviewerName; }
    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName; }
    String reviewerName;
    @JsonProperty("reviewerEmail")
    public Object getReviewerEmail() {
        return this.reviewerEmail; }
    public void setReviewerEmail(Object reviewerEmail) {
        this.reviewerEmail = reviewerEmail; }
    Object reviewerEmail;
    @JsonProperty("sourceType")
    public String getSourceType() {
        return this.sourceType; }
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType; }
    String sourceType;
    @JsonProperty("isVerified")
    public boolean getIsVerified() {
        return this.isVerified; }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified; }
    boolean isVerified;
    @JsonProperty("source")
    public String getSource() {
        return this.source; }
    public void setSource(String source) {
        this.source = source; }
    String source;
    @JsonProperty("sourceName")
    public String getSourceName() {
        return this.sourceName; }
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName; }
    String sourceName;
    @JsonProperty("sourceId")
    public String getSourceId() {
        return this.sourceId; }
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId; }
    String sourceId;
    @JsonProperty("tags")
    public ArrayList<Object> getTags() {
        return this.tags; }
    public void setTags(ArrayList<Object> tags) {
        this.tags = tags; }
    ArrayList<Object> tags;
    @JsonProperty("href")
    public Object getHref() {
        return this.href; }
    public void setHref(Object href) {
        this.href = href; }
    Object href;
    @JsonProperty("logoHref")
    public Object getLogoHref() {
        return this.logoHref; }
    public void setLogoHref(Object logoHref) {
        this.logoHref = logoHref; }
    Object logoHref;
    @JsonProperty("photos")
    public ArrayList<Object> getPhotos() {
        return this.photos; }
    public void setPhotos(ArrayList<Object> photos) {
        this.photos = photos; }
    ArrayList<Object> photos;


}
