package com.example.kudumbasree;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link adsprofile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class adsprofile extends Fragment {
    EditText Meetingid, Time, Date, Participants,Meetingtitle;
    DatabaseReference databaseReference;
    Button Send;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public adsprofile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment adsprofile.
     */
    // TODO: Rename and change types and number of parameters
    public static adsprofile newInstance(String param1, String param2) {
        adsprofile fragment = new adsprofile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_adsprofile, container, false);
        Meetingid = v.findViewById(R.id.meetingid);
        Time = v.findViewById(R.id.time);
        Date = v.findViewById(R.id.date);
        Participants = v.findViewById(R.id.participants);
        Meetingtitle=v.findViewById(R.id.meeetingtitle);
        Send = v.findViewById(R.id.send);




        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kudumbasree-581e9-default-rtdb.firebaseio.com/");
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String meetingidStr = Meetingid.getText().toString();
                String meetingtitleStr= Meetingtitle.getText().toString();
                String timeStr = Time.getText().toString();
                String dateStr = Date.getText().toString();
                String participantsStr = Participants.getText().toString();

                if(meetingidStr.isEmpty() || timeStr.isEmpty() || dateStr.isEmpty() || participantsStr.isEmpty()) {

                        Toast.makeText(getActivity(), "Please enter the details", Toast.LENGTH_SHORT).show();
                    }else{
                    databaseReference.child("MeetingDetails").child(meetingtitleStr).child("MeetingTitle").setValue(meetingtitleStr);
                        databaseReference.child("MeetingDetails").child(meetingtitleStr).child("MeetingId").setValue(meetingidStr);
                        databaseReference.child("MeetingDetails").child(meetingtitleStr).child("Time").setValue(timeStr);
                        databaseReference.child("MeetingDetails").child(meetingtitleStr).child("Date").setValue(dateStr);
                        databaseReference.child("MeetingDetails").child(meetingtitleStr).child("Participants").setValue(participantsStr);

                        Toast.makeText(getActivity(), "Informations are entered", Toast.LENGTH_SHORT).show();


                    }

                initChannels(getActivity());
                }
                private void initChannels(FragmentActivity content) {
                    int notificationId = new Random().nextInt(100);
                    String channelId = "notification_channel_1";


                    NotificationManager notificationManager=(NotificationManager) content.getSystemService(FragmentActivity.NOTIFICATION_SERVICE);
                    Intent notificationintent= new Intent(getActivity(),Notificationxmljava.class);
                    notificationintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    notificationintent.putExtra("message","This is an notification message");
                    PendingIntent pendingIntent=PendingIntent.getActivity(getContext(),1,notificationintent,PendingIntent.FLAG_UPDATE_CURRENT);
                    NotificationCompat.Builder builder=new NotificationCompat.Builder(getActivity(),channelId);
                    builder.setSmallIcon(R.drawable.ic_baseline_keyboard_arrow_left_24);
                    builder.setDefaults(NotificationCompat.DEFAULT_ALL);
                    builder.setContentTitle("Notification?");
                    builder.setContentText("Message");
                    builder.setContentIntent(pendingIntent);
                    builder.setAutoCancel(true);
                    builder.setPriority(NotificationCompat.PRIORITY_MAX);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            if(notificationManager!=null && notificationManager.getNotificationChannel(channelId)==null){
                                NotificationChannel notificationChannel=new NotificationChannel(channelId,"Notification channel_1",NotificationManager.IMPORTANCE_HIGH);
                                notificationChannel.setDescription("This channel is used to notify user");
                                notificationChannel.enableLights(true);
                                notificationChannel.enableVibration(true);
                                notificationManager.createNotificationChannel(notificationChannel);

                            }
                        }
                    Notification notification=builder.build();
                        if(notificationManager != null){
                            notificationManager.notify(notificationId,notification);


                    }
                }
            });
        return v;
    }
}