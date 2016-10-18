package com.sixthsolution.easymvp.domain.entity;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
public class Country {

    private String name;
    private String code;
    private String timezone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
