package com.example.buildingblocksteam1.Quiz;

import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.buildingblocksteam1.SharedViewModel;
import com.example.buildingblocksteam1.databinding.FragmentDynamicQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DynamicQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentDynamicQuizBinding binding;
    private SharedViewModel viewModel;

    public DynamicQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DynamicQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DynamicQuizFragment newInstance(String param1, String param2) {
        DynamicQuizFragment fragment = new DynamicQuizFragment();
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
        // *** Creates the viewModel that allows data transfer between fragments
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDynamicQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getDynamicScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                // Update UI with the new data
            }
        });

        // *** Gets the resources

        Resources res = getResources();
        int regularColor = res.getColor(R.color.regular_text);
        int buttonColor = res.getColor(R.color.button_text);

        // *** Creates the list of questions
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("What is dynamic programming?","A method for solving complex problems by breaking them down into simpler subproblems and solving each subproblem only once.","A method for solving problems by guessing the solution and then checking if it is correct.","A method for solving problems by generating random solutions and checking if they are correct.","A method for solving problems by trying all possible solutions and selecting the best one.","A","Dynamic programming is a method for solving complex problems by breaking them down into simpler subproblems and solving each subproblem only once."));
        questions.add(new Question("What is the principle of optimality in dynamic programming?","A solution to a problem can be obtained by combining solutions to subproblems that overlap and have already been solved.","A solution to a problem can be obtained by breaking it down into smaller subproblems.","A solution to a problem can be obtained by generating all possible solutions and selecting the best one.","A solution to a problem can be obtained by guessing the solution and then checking if it is correct.","A","The principle of optimality in dynamic programming states that a solution to a problem can be obtained by combining solutions to subproblems that overlap and have already been solved."));
        questions.add(new Question("What is memoization?","A technique used in dynamic programming to store the results of expensive function calls and return the cached result when the same inputs occur again.","A technique used in divide and conquer to reduce the number of subproblems that need to be solved.","A technique used in dynamic programming to solve a problem by breaking it down into smaller subproblems.","A technique used in dynamic programming to generate all possible solutions and select the best one.","A","Memoization is a technique used in dynamic programming to store the results of expensive function calls and return the cached result when the same inputs occur again."));
        questions.add(new Question("What is the difference between top-down and bottom-up dynamic programming?","Top-down dynamic programming starts by solving the largest subproblems first and works its way down to the smallest subproblems, while bottom-up dynamic programming starts by solving the smallest subproblems first and works its way up to the largest subproblems.","Top-down dynamic programming divides the problem into smaller subproblems, while bottom-up dynamic programming solves the problem by generating all possible solutions and selecting the best one.","Top-down dynamic programming solves the problem by guessing the solution and then checking if it is correct, while bottom-up dynamic programming solves the problem by applying a set of rules or formulas to derive the solution.","Top-down dynamic programming solves each subproblem only once, while bottom-up dynamic programming can solve each subproblem multiple times.","A","The difference between top-down and bottom-up dynamic programming is that top-down dynamic programming starts by solving the largest subproblems first and works its way down to the smallest subproblems, while bottom-up dynamic programming starts by solving the smallest subproblems first and works its way up to the largest subproblems."));
        questions.add(new Question("What is memoization in dynamic programming?","Storing the results of expensive function calls and returning the cached result when the same inputs occur again.","Breaking down a problem into smaller subproblems and solving each subproblem individually.","Choosing the optimal substructure of a problem to find the optimal solution.","Using an optimal data structure to solve a problem efficiently.","A","Memoization is a technique in dynamic programming where the results of expensive function calls are stored and returned when the same inputs occur again, instead of recomputing the function."));
        questions.add(new Question("What is the time complexity of dynamic programming algorithms?","O(n^2) or better.","O(n^3) or better.","O(n^4) or better.","O(2^n) or better.","A","The time complexity of dynamic programming algorithms is usually O(n^2) or better."));
        questions.add(new Question("What is the principle of optimality in dynamic programming?","An optimal solution to a problem contains optimal solutions to its subproblems.","A problem can be solved optimally by breaking it down into smaller subproblems and solving each subproblem individually.","The best substructure of a problem can always be chosen to find the optimal solution.","An optimal data structure can be used to solve a problem efficiently.","A","The principle of optimality in dynamic programming states that an optimal solution to a problem contains optimal solutions to its subproblems."));
        questions.add(new Question("What is the difference between dynamic programming and divide-and-conquer?","Dynamic programming breaks down problems into overlapping subproblems and solves them using memoization or tabulation, while divide-and-conquer breaks down problems into non-overlapping subproblems and solves them recursively.","Dynamic programming breaks down problems into non-overlapping subproblems and solves them recursively, while divide-and-conquer breaks down problems into overlapping subproblems and solves them using memoization or tabulation.","Dynamic programming and divide-and-conquer are the same thing.","Dynamic programming and divide-and-conquer are completely unrelated.","A","The difference between dynamic programming and divide-and-conquer is that dynamic programming breaks down problems into overlapping subproblems and solves them using memoization or tabulation, while divide-and-conquer breaks down problems into non-overlapping subproblems and solves them recursively."));
        questions.add(new Question("What is the difference between memoization and tabulation?","Memoization is a top-down approach that uses recursion, while tabulation is a bottom-up approach that uses iteration.","Memoization is a bottom-up approach that uses iteration, while tabulation is a top-down approach that uses recursion.","Memoization and tabulation are the same thing.","There is no difference between memoization and tabulation.","A","The difference between memoization and tabulation is that memoization is a top-down approach that uses recursion, while tabulation is a bottom-up approach that uses iteration."));
        questions.add(new Question("What is tabulation?","A technique that involves storing the results of function calls in a table.","A technique that involves converting a function into an iterative form.","A technique that involves using brute force to solve problems.","A technique that involves using recursion to solve problems.","A","Tabulation is a technique that involves storing the results of function calls in a table."));

        // *** Shuffles the questions Array List
        Collections.shuffle(questions, new Random());


        // *** Add the questions as radio buttons into the view
        LinearLayout root = binding.linearLayout;
        ArrayList<Question> usedQuestions = new ArrayList<Question>();
        for (int i = 0; i < 10; i++) {
            TextView text = new TextView(this.getContext());
            if (i == 0) {
                text.setText("" + (i+1) + ". " + questions.get(i).getQuestion());
            }
            else {
                text.setText("\n" + (i+1) + ". " + questions.get(i).getQuestion());
            }
            text.setTextColor(regularColor);
            root.addView(text);

            RadioGroup radioGroup = new RadioGroup(this.getContext());


            ArrayList<String> answers = questions.get(i).getAnswerList();
            Collections.shuffle(answers, new Random());
            for (int j = 0; j < 4; j++) {
                RadioButton radioButton = new RadioButton(this.getContext());
                radioButton.setText(answers.get(j));
                radioButton.setButtonTintList(ColorStateList.valueOf(regularColor));
                radioButton.setTextColor(regularColor);
                if (radioButton.getText().equals(questions.get(i).getAnswer())) {
                    radioButton.setTag("true");
                }
                radioButton.setText("" + (char)(j+65) + ". " + answers.get(j));
                radioGroup.addView(radioButton);
            }

            root.addView(radioGroup);

            usedQuestions.add(questions.get(i));
        }
        Button submit = binding.buttonSubmit;
        root.removeView(submit);
        root.addView(submit);
        viewModel.setDynamicQuestions(usedQuestions);


        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;
                LinearLayout root = binding.linearLayout;
                for (int i = 0; i < root.getChildCount(); i++) {
                    View child = root.getChildAt(i);
                    if (child instanceof RadioGroup) {
                        RadioGroup radioGroup = (RadioGroup) child;
                        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                        RadioButton selectedRadioButton = radioGroup.findViewById(selectedRadioButtonId);
                        if (selectedRadioButton != null) {
                            if (selectedRadioButton.getTag() != null) {
                                String tag = (String) selectedRadioButton.getTag();
                                if (tag.equals("true")) {
                                    score += 10;
                                    // The correct radio button is selected
                                }
                            }
                        }
                    }
                }
                viewModel.setDynamicScore(String.valueOf(score));

                NavHostFragment.findNavController(DynamicQuizFragment.this)
                        .navigate(R.id.action_dynamicQuizFragment_to_dynamicQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(DynamicQuizFragment.this)
                        .navigate(R.id.action_dynamicQuizFragment_to_quizMenuFragment);
            }
        });
    }
}