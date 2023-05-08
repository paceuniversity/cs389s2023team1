package com.example.buildingblocksteam1.Quiz;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.buildingblocksteam1.Question;
import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.SharedViewModel;
import com.example.buildingblocksteam1.databinding.FragmentFeedbackArraysBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedbackArraysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedbackArraysFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentFeedbackArraysBinding binding;
    private SharedViewModel viewModel;

    public FeedbackArraysFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedbackArraysFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedbackArraysFragment newInstance(String param1, String param2) {
        FeedbackArraysFragment fragment = new FeedbackArraysFragment();
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

        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFeedbackArraysBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getArraysScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                // Update UI with the new data
            }
        });
        // *** Gets the resources

        Resources res = getResources();
        int regularColor = res.getColor(R.color.regular_text);
        int buttonColor = res.getColor(R.color.button_text);


        // *** Add the questions as radio buttons into the view
        LinearLayout root = binding.linearLayout;
        ArrayList<Question> questions = viewModel.getArraysQuestions().getValue();
        for (int i = 0; i < 10; i++) {
            TextView text = new TextView(this.getContext());
            text.setText("" + (i+1) + ". " + questions.get(i).getQuestion());
            text.setTextColor(regularColor);
            root.addView(text);

            RadioGroup radioGroup = new RadioGroup(this.getContext());


            ArrayList<String> answers = questions.get(i).getAnswerList();
            RadioButton temp = null;
            for (int j = 0; j < 4; j++) {
                RadioButton radioButton = new RadioButton(this.getContext());
                radioButton.setText(answers.get(j));
                radioButton.setButtonTintList(ColorStateList.valueOf(regularColor));
                radioButton.setTextColor(regularColor);
                if (radioButton.getText().equals(questions.get(i).getAnswer())) {
                    radioButton.setTag("true");
                    radioButton.setSelected(true);
                    radioButton.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    radioButton.setTextColor(res.getColor(R.color.green));
                    temp = radioButton;
                }
                radioButton.setText("" + (char)(j+65) + ". " + answers.get(j));
                radioGroup.addView(radioButton);
            }

            root.addView(radioGroup);

            TextView feedback = new TextView(getContext());
            feedback.setText("\n\nFeedback: " + questions.get(i).getFeedback() + "\n\n");
            feedback.setTextColor(res.getColor(R.color.figma_orange));
            feedback.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            root.addView(feedback);

        }

        Button submit = binding.buttonSubmit;
        root.removeView(submit);
        root.addView(submit);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(FeedbackArraysFragment.this)
                        .navigate(R.id.action_feedbackArraysFragment_to_quizMenuFragment);
            }
        });
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(FeedbackArraysFragment.this)
                        .navigate(R.id.action_feedbackArraysFragment_to_quizMenuFragment);
            }
        });
    }
}