package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.List;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
@Parcel
public class Film {

    long updated;
    FilmLink links;
    Producer network;
    Schedule schedule;
    FilmRating rating;
    FilmImageUrl image;
    List<String> genres;
    int id, runtime, weight;
    String url, name, type, language, status, premiered, webChannel, summary;

    @ParcelConstructor
    public Film(long updated, FilmLink links, Producer network, Schedule schedule,
                FilmRating rating, FilmImageUrl image, List<String> genres, int id,
                int runtime, int weight, String url, String name, String type, String language,
                String status, String premiered, String webChannel, String summary) {
        this.updated = updated;
        this.links = links;
        this.network = network;
        this.schedule = schedule;
        this.rating = rating;
        this.image = image;
        this.genres = genres;
        this.id = id;
        this.runtime = runtime;
        this.weight = weight;
        this.url = url;
        this.name = name;
        this.type = type;
        this.language = language;
        this.status = status;
        this.premiered = premiered;
        this.webChannel = webChannel;
        this.summary = summary;
    }

    public FilmLink getLinks() {
        return links;
    }

    public void setLinks(FilmLink links) {
        this.links = links;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public Producer getNetwork() {
        return network;
    }

    public void setNetwork(Producer network) {
        this.network = network;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public FilmRating getRating() {
        return rating;
    }

    public void setRating(FilmRating rating) {
        this.rating = rating;
    }

    public FilmImageUrl getImage() {
        return image;
    }

    public void setImage(FilmImageUrl image) {
        this.image = image;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(String webChannel) {
        this.webChannel = webChannel;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
