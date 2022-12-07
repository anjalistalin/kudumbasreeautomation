package com.example.kudumbasree;

public class MeetingModelClass {
    String MeetingId,Time,Date,Participants;

    public MeetingModelClass() {
    }

    public MeetingModelClass(String meetingId, String time, String date, String participants) {
        MeetingId = meetingId;
        Time = time;
        Date = date;
        Participants = participants;
    }

    public String getMeetingId() {
        return MeetingId;
    }

    public void setMeetingId(String meetingId) {
        MeetingId = meetingId;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getParticipants() {
        return Participants;
    }

    public void setParticipants(String participants) {
        Participants = participants;
    }
}
