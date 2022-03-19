package com.example.jobseeker;

public class Job {

    private final String employer;
    private final String title;
    private final String desc;
    private final String postDate;

    public Job(String employer, String title, String desc, String postDate) {
        this.employer = employer;
        this.title = title;
        this.desc = desc;
        this.postDate = postDate;
    }

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

    @Override
    public String toString() {
        return "Job{" +
                "employer='" + employer + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", postDate='" + postDate + '\'' +
                '}';
    }
}
