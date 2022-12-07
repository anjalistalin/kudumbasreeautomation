package com.example.kudumbasree;

public class NotifyModelClass {
    String MeetingId,MeetingTitle,Date,Time,Participants;

    public NotifyModelClass() {}

    public NotifyModelClass(String meetingId, String meetingTitle, String date, String time, String participants) {
        MeetingId = meetingId;
        MeetingTitle = meetingTitle;
        Date = date;
        Time = time;
        Participants = participants;
    }

    public String getMeetnigId() {
        return MeetingId;
    }

    public void setMeetingId(String meetingId) {
        MeetingId = meetingId;
    }

    public String getMeetingTitle() {
        return MeetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        MeetingTitle = meetingTitle;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getParticipants() {
        return Participants;
    }

    public void setParticipants(String participants) {
        Participants = participants;
    }
}
