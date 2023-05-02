package com.example.buildingblocksteam1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.buildingblocksteam1.databinding.FragmentFirstBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";
    private FragmentFirstBinding binding;
    private String name = null;
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.dailyQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_quizMenuFragment);
            }
        });


        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_login);
            }
        });
        binding.lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_lessonsFragment2);
            }
        });
        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checks whether signed in or not and makes it a sign out button
                if (mAuth.getCurrentUser() == null) {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_signup);
                } else {
                    mAuth.signOut();
                }
                SignupOrSignout();
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        SignupOrSignout();
        notificationWithUsername();
    }

    //checks whether user is signed in or not and updates UI
    private void SignupOrSignout() {
        if (mAuth.getCurrentUser() != null) {
            binding.buttonSignup.setText("Sign Out");
            binding.buttonSignup.invalidate();
        } else {
            binding.buttonSignup.setText("Sign Up");
            binding.buttonSignup.invalidate();
        }
    }

    //Puts username in a global variable named "name"
    private void grabUsername() {
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
                                    Log.d(TAG, document.getId() + " => " + document.getData());
                                    Log.d(TAG, "name => " + name);
                                }
                            } else {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });
        }
    }

    //creates a notification with the username
    private void notificationWithUsername(){
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
                                    Log.d(TAG, "name => " + name);NotificationHelper notifyHelp = new NotificationHelper(getContext());
                                    notifyHelp.createNotificationChannel();
                                    String content = "Hello " + name + "!";
                                    NotificationCompat.Builder builder = notifyHelp.setNotificationContent("Welcome!",content);
                                    notifyHelp.showNotification(1,builder);
                                }
                            } else {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });
        }
    }

    //creates a notification
    private void NotificationTest(){
        NotificationHelper notifyHelp = new NotificationHelper(getContext());
        notifyHelp.createNotificationChannel();
        String content = "Hello!";
        NotificationCompat.Builder builder = notifyHelp.setNotificationContent("Reminder",content);
        notifyHelp.showNotification(1,builder);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}