package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 9/6/16.
 */
@Parcel
public class Season {

    int id, season, number, runtime;
    String url, name, airdate, airtime, airstamp, summary;
    FilmImageUrl image;

    @ParcelConstructor
    public Season(int id, int season, int number, int runtime, String url,
                  String name, String airdate,
                  String airtime, String airstamp, String summary, FilmImageUrl image) {
        this.id = id;
        this.season = season;
        this.number = number;
        this.runtime = runtime;
        this.url = url;
        this.name = name;
        this.airdate = airdate;
        this.airtime = airtime;
        this.airstamp = airstamp;
        this.summary = summary;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
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

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getAirstamp() {
        return airstamp;
    }

    public void setAirstamp(String airstamp) {
        this.airstamp = airstamp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public FilmImageUrl getImage() {
        return image;
    }

    public void setImage(FilmImageUrl image) {
        this.image = image;
    }

}
