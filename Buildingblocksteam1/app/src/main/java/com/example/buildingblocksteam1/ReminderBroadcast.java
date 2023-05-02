package com.example.buildingblocksteam1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.buildingblocksteam1.NotificationHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ReminderBroadcast extends BroadcastReceiver
{
    private static final String TAG = "ReminderBroadcast";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private FirebaseAuth mAuth;

    private String name = null;
    @Override
    public void onReceive(Context context, Intent intent)
    {

        if (mAuth.getCurrentUser() != null) {
            String email = mAuth.getCurrentUser().getEmail();
            Task<QuerySnapshot> result = db.collection("UserInformation")
                    .whereEqualTo("Email", email)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    name = document.getData().get("username").toString();
                                    Log.d(TAG, "name => " + name);
                                    NotificationHelper notifyHelper = new NotificationHelper(context);
                                    notifyHelper.createNotificationChannel();
                                    String content = "Hello " + name + "! Have you studied recently?" ;
                                    NotificationCompat.Builder builder = notifyHelper.setNotificationBigTextContent(
                                            "Reminder",content);
                                    notifyHelper.showNotification(101,builder);
                                }
                            } else {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });
        }
    }
}