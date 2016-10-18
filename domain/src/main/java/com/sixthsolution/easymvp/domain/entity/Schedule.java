package com.sixthsolution.easymvp.domain.entity;

import java.util.List;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
public class Schedule {

    private String time;
    private List<String> days;

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
