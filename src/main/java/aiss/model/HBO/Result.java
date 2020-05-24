
package aiss.model.HBO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "poster_path",
    "popularity",
    "id",
    "overview",
    "backdrop_path",
    "vote_average",
    "media_type",
    "first_air_date",
    "origin_country",
    "genre_ids",
    "original_language",
    "vote_count",
    "name",
    "original_name",
    "adult",
    "release_date",
    "original_title",
    "title",
    "video",
    "profile_path",
    "known_for"
})
public class Result {

    @JsonProperty("poster_path")
    private Object posterPath;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("backdrop_path")
    private Object backdropPath;
    @JsonProperty("vote_average")
    private Integer voteAverage;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("first_air_date")
    private String firstAirDate;
    @JsonProperty("origin_country")
    private List<String> originCountry = null;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds = null;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonProperty("name")
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private Boolean video;
    @JsonProperty("profile_path")
    private String profilePath;
    @JsonProperty("known_for")
    private List<KnownFor> knownFor = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("poster_path")
    public Object getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    @JsonProperty("popularity")
    public Double getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("backdrop_path")
    public Object getBackdropPath() {
        return backdropPath;
    }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
    }

    @JsonProperty("vote_average")
    public Integer getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    @JsonProperty("media_type")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty("media_type")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @JsonProperty("first_air_date")
    public String getFirstAirDate() {
        return firstAirDate;
    }

    @JsonProperty("first_air_date")
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    @JsonProperty("origin_country")
    public List<String> getOriginCountry() {
        return originCountry;
    }

    @JsonProperty("origin_country")
    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    @JsonProperty("genre_ids")
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    @JsonProperty("genre_ids")
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    @JsonProperty("original_language")
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("original_language")
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("vote_count")
    public Integer getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("original_name")
    public String getOriginalName() {
        return originalName;
    }

    @JsonProperty("original_name")
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @JsonProperty("adult")
    public Boolean getAdult() {
        return adult;
    }

    @JsonProperty("adult")
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("original_title")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("original_title")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("video")
    public Boolean getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(Boolean video) {
        this.video = video;
    }

    @JsonProperty("profile_path")
    public String getProfilePath() {
        return profilePath;
    }

    @JsonProperty("profile_path")
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    @JsonProperty("known_for")
    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    @JsonProperty("known_for")
    public void setKnownFor(List<KnownFor> knownFor) {
        this.knownFor = knownFor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
