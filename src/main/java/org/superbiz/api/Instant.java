package org.superbiz.api;

import java.util.Date;

// standard Pojo as DTO
public class Instant {
    private Date date;

    public Instant() {
        // no-op
    }

    public Instant(final Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }
}
