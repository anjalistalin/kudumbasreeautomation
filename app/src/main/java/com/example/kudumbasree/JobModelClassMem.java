package com.example.kudumbasree;

public class JobModelClassMem {
    String JobCategory,Venue,InterviewDate,Time,Education;

    public JobModelClassMem() {
    }

    public JobModelClassMem(String jobcategory, String venue, String interviewdate, String time, String education) {
        JobCategory = jobcategory;
        Venue = venue;
        InterviewDate = interviewdate;
        Time = time;
        Education = education;
    }

    public String getJobcategory() {
        return JobCategory;
    }

    public void setJobcategory(String jobcategory) {
        JobCategory = jobcategory;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getInterviewDate() {
        return InterviewDate;
    }

    public void setInterviewDate(String interviewdate) {
        InterviewDate = interviewdate;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }
}
