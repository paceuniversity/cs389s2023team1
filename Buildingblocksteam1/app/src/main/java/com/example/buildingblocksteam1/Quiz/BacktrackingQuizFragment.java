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
import com.example.buildingblocksteam1.databinding.FragmentBacktrackingQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BacktrackingQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BacktrackingQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentBacktrackingQuizBinding binding;
    private SharedViewModel viewModel;

    public BacktrackingQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BacktrackingQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BacktrackingQuizFragment newInstance(String param1, String param2) {
        BacktrackingQuizFragment fragment = new BacktrackingQuizFragment();
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

        binding = FragmentBacktrackingQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getBacktrackingScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is backtracking?","A general algorithmic technique that incrementally builds candidate solutions and abandons a candidate as soon as it determines that the candidate cannot possibly be completed to a valid solution.","A technique that uses dynamic programming to solve optimization problems.","A technique that uses divide and conquer to solve optimization problems.","A technique that uses greedy algorithms to solve optimization problems.","A","Backtracking is a general algorithmic technique that incrementally builds candidate solutions and abandons a candidate as soon as it determines that the candidate cannot possibly be completed to a valid solution."));
        questions.add(new Question("What is the difference between backtracking and brute-force?","Backtracking can be used to solve problems with a small solution space by pruning invalid candidates, while brute-force tries all possible candidates.","Backtracking tries all possible candidates, while brute-force prunes invalid candidates.","Backtracking is faster than brute-force for most problems.","Backtracking is slower than brute-force for most problems.","A","The difference between backtracking and brute-force is that backtracking can be used to solve problems with a small solution space by pruning invalid candidates, while brute-force tries all possible candidates."));
        questions.add(new Question("What is a common data structure used for backtracking?","A stack.","A queue.","A linked list.","An array.","A","A stack is a common data structure used for backtracking."));
        questions.add(new Question("What is the time complexity of backtracking?","Exponential.","Polynomial.","Logarithmic.","Linear.","A","The time complexity of backtracking is often exponential."));
        questions.add(new Question("What is the difference between depth-first search and backtracking?","Depth-first search is used for graph traversal, while backtracking is used to solve problems.","Backtracking is used for graph traversal, while depth-first search is used to solve problems.","Depth-first search always finds the optimal solution, while backtracking may not.","Backtracking always finds the optimal solution, while depth-first search may not.","A","The difference between depth-first search and backtracking is that depth-first search is used for graph traversal, while backtracking is used to solve problems."));
        questions.add(new Question("What is pruning in backtracking?","Eliminating a candidate that cannot possibly be completed to a valid solution.","Adding a candidate that cannot possibly be completed to a valid solution.","Choosing a candidate that cannot possibly be completed to a valid solution.","Modifying a candidate that cannot possibly be completed to a valid solution.","A","Pruning in backtracking is the process of eliminating a candidate that cannot possibly be completed to a valid solution."));
        questions.add(new Question("What is the difference between forward checking and backtracking?","Forward checking is a domain reduction technique that can be combined with backtracking to improve its performance.","Forward checking is a search technique that is used instead of backtracking.","Forward checking is an optimization technique that can be used to solve large-scale optimization problems.","Forward checking always finds the optimal solution, while backtracking may not.","A","The difference between forward checking and backtracking is that forward checking is a domain reduction technique that can be combined with backtracking to improve its performance."));
        questions.add(new Question("What is a benefit of using backtracking over other techniques?","It can be more efficient than other techniques when applied to problems with a small solution space.","It always finds the optimal solution.","It can solve problems with a large solution space.","It requires less memory than other techniques.","A","A benefit of using backtracking over other techniques is that it can be more efficient than other techniques when applied to problems with a small solution space."));
        questions.add(new Question("What is the main advantage of backtracking over brute force?", "It can be more efficient by pruning the search space.", "It is easier to implement.", "It can handle larger input sizes.", "It always finds the optimal solution.", "A", "Backtracking can be more efficient than brute force by pruning the search space, which means avoiding unnecessary computations."));
        questions.add(new Question("Which of the following is NOT a characteristic of backtracking?", "It always finds the optimal solution.", "It uses a depth-first search strategy.", "It involves recursion.", "It prunes the search space.", "A", "Backtracking does not always find the optimal solution, as it may terminate early if a solution is found that satisfies the constraints."));
        questions.add(new Question("What is the main disadvantage of backtracking?", "It can be very time-consuming for large search spaces.", "It is difficult to implement.", "It can only handle small input sizes.", "It always finds the optimal solution.", "A", "Backtracking can be very time-consuming for large search spaces, as it may require exploring a large number of potential solutions."));
        questions.add(new Question("What is the difference between backtracking and dynamic programming?", "Backtracking is used for finding solutions to constraint satisfaction problems, while dynamic programming is used for solving optimization problems.", "Backtracking is faster than dynamic programming.", "Backtracking always uses recursion, while dynamic programming can be implemented iteratively or recursively.", "Dynamic programming is used for finding solutions to constraint satisfaction problems, while backtracking is used for traversing graphs or trees.", "A", "Backtracking is used for finding solutions to constraint satisfaction problems, while dynamic programming is used for solving optimization problems by breaking them down into smaller subproblems."));
        questions.add(new Question("What is the goal of backtracking?", "To find a solution to a constraint satisfaction problem.", "To traverse a graph or tree.", "To optimize a problem by breaking it down into smaller subproblems.", "To compute the longest common subsequence of two sequences.", "A", "The goal of backtracking is to find a solution to a constraint satisfaction problem by systematically exploring potential solutions and backtracking when a dead end is reached."));
        questions.add(new Question("What is the difference between backtracking and branch and bound?", "Backtracking is used for finding solutions to constraint satisfaction problems, while branch and bound is used for optimization problems.", "Backtracking is always recursive, while branch and bound can be implemented iteratively or recursively.", "Backtracking is faster than branch and bound.", "Branch and bound is used for finding solutions to constraint satisfaction problems, while backtracking is used for traversing graphs or trees.", "A", "Backtracking is used for finding solutions to constraint satisfaction problems, while branch and bound is used for solving optimization problems by pruning the search space."));


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
        viewModel.setBacktrackingQuestions(usedQuestions);


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
                viewModel.setBacktrackingScore(String.valueOf(score));

                NavHostFragment.findNavController(BacktrackingQuizFragment.this)
                        .navigate(R.id.action_backtrackingQuizFragment_to_backtrackingQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(BacktrackingQuizFragment.this)
                        .navigate(R.id.action_backtrackingQuizFragment_to_quizMenuFragment);
            }
        });
    }
}