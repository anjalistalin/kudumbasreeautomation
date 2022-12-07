package com.example.kudumbasree;

public class JobModelClass {

    String JobCategory,Venue,InterviewDate,Time,Education;

    public JobModelClass() {
    }

    public JobModelClass(String jobCategory, String venue, String interviewDate, String time, String education) {
        JobCategory = jobCategory;
        Venue = venue;
        InterviewDate = interviewDate;
        Time = time;
        Education = education;
    }

    public String getJobCategory() {
        return JobCategory;
    }

    public void setJobCategory(String jobCategory) {
        JobCategory = jobCategory;
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

    public void setInterviewDate(String interviewDate) {
        InterviewDate = interviewDate;
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
