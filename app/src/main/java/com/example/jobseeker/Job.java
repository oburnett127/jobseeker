package com.example.jobseeker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "job")
public class Job {
    @PrimaryKey(autoGenerate = true)
    private final int id;
    @ColumnInfo(name = "employer")
    private String employer;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "desc")
    private String desc;
    @ColumnInfo(name = "post_date")
    private final String postDate;

    public Job(int id, String employer, String title, String desc, String postDate) {
        this.id = id;
        this.employer = employer;
        this.title = title;
        this.desc = desc;
        this.postDate = postDate;
    }

    public int getId() {return id;}

    public String getEmployer() {
        return employer;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", employer='" + employer + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", postDate='" + postDate + '\'' +
                '}';
    }
}
