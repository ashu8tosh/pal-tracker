package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return getId() == timeEntry.getId() &&
                getProjectId() == timeEntry.getProjectId() &&
                getUserId() == timeEntry.getUserId() &&
                getHours() == timeEntry.getHours() &&
                getDate().equals(timeEntry.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectId(), getUserId(), getDate(), getHours());
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    private int hours;

    public long getId() {
        return id;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        //this.id = Math.incrementExact(1);
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }
    public TimeEntry(long id,long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }
    public TimeEntry()
    {

    }


}
