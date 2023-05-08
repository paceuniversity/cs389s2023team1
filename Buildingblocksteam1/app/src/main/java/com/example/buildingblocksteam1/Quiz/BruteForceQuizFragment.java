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
import com.example.buildingblocksteam1.databinding.FragmentBruteForceQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BruteForceQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BruteForceQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentBruteForceQuizBinding binding;
    private SharedViewModel viewModel;

    public BruteForceQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BruteForceQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BruteForceQuizFragment newInstance(String param1, String param2) {
        BruteForceQuizFragment fragment = new BruteForceQuizFragment();
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

        binding = FragmentBruteForceQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getBruteForceScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is a brute force algorithm?", "An algorithm that tries all possible solutions to a problem to find the optimal solution.", "An algorithm that uses a divide-and-conquer strategy to solve a problem.", "An algorithm that relies on randomness to find the optimal solution.", "An algorithm that uses heuristics to find the optimal solution.", "A", "A brute force algorithm tries all possible solutions to a problem to find the optimal solution."));
        questions.add(new Question("What is the time complexity of a brute force algorithm?", "Exponential", "Linear", "Polynomial", "Logarithmic", "A", "The time complexity of a brute force algorithm is typically exponential, as it must try all possible solutions."));
        questions.add(new Question("What is the main disadvantage of a brute force algorithm?", "Its time complexity is often prohibitively high.", "It cannot find optimal solutions to problems.", "It requires a large amount of memory.", "It is not robust to changes in the problem instance.", "A", "The main disadvantage of a brute force algorithm is that its time complexity is often prohibitively high."));
        questions.add(new Question("What is a common optimization technique for brute force algorithms?", "Pruning", "Parallelization", "Randomization", "Memoization", "A", "Pruning is a common optimization technique for brute force algorithms that involves eliminating branches of the search tree that cannot possibly lead to the optimal solution."));
        questions.add(new Question("What is the brute force approach to finding the shortest path between two nodes in a graph?", "Try all possible paths between the two nodes and choose the shortest.", "Use Dijkstra's algorithm.", "Use the Floyd-Warshall algorithm.", "Use the A* algorithm.", "A", "The brute force approach to finding the shortest path between two nodes in a graph is to try all possible paths between the two nodes and choose the shortest."));
        questions.add(new Question("What is the brute force approach to finding a Hamiltonian cycle in a graph?", "Try all possible cycles in the graph and check if they are Hamiltonian.", "Use the Travelling Salesman Problem algorithm.", "Use the Minimum Spanning Tree algorithm.", "Use the Maximum Flow algorithm.", "A", "The brute force approach to finding a Hamiltonian cycle in a graph is to try all possible cycles in the graph and check if they are Hamiltonian."));
        questions.add(new Question("What is the brute force approach to finding a maximum subarray in an array?", "Try all possible subarrays of the array and choose the one with the maximum sum.", "Use the Merge Sort algorithm.", "Use the Quick Sort algorithm.", "Use the Heap Sort algorithm.", "A", "The brute force approach to finding a maximum subarray in an array is to try all possible subarrays of the array and choose the one with the maximum sum."));
        questions.add(new Question("What is the time complexity of brute force algorithms?", "O(n)", "O(n log n)", "O(n^2)", "O(2^n)", "D", "The time complexity of brute force algorithms is typically O(2^n), where n is the size of the input. This is because a brute force algorithm tries every possible solution."));
        questions.add(new Question("What is a disadvantage of using a brute force algorithm?", "It may not always find the optimal solution.", "It is only suitable for small input sizes.", "It is very difficult to implement.", "It requires a lot of memory.", "A", "One disadvantage of using a brute force algorithm is that it may not always find the optimal solution, especially for large input sizes. This is because it tries every possible solution, which can be very time-consuming."));
        questions.add(new Question("Which of the following is an example of a problem that can be solved using a brute force algorithm?", "Sorting a large array of integers", "Finding the shortest path in a graph", "Calculating the Fibonacci sequence", "Finding all permutations of a set of items", "D", "Finding all permutations of a set of items is an example of a problem that can be solved using a brute force algorithm. This is because the algorithm simply generates all possible permutations and checks each one for correctness."));
        questions.add(new Question("What is a characteristic of a good brute force algorithm?", "It should be easy to understand and implement.", "It should use complex data structures.", "It should have a time complexity of O(n log n).", "It should be able to solve any problem.", "A", "A good brute force algorithm should be easy to understand and implement. This is because the algorithm tries every possible solution, so it is already quite complex."));
        questions.add(new Question("Which of the following is an advantage of using a brute force algorithm?", "It always finds the optimal solution.", "It is very fast for large input sizes.", "It requires very little memory.", "It is easy to implement.", "D", "One advantage of using a brute force algorithm is that it is easy to implement. However, it may not always find the optimal solution and can be very slow for large input sizes."));
        questions.add(new Question("What is the difference between a brute force algorithm and a greedy algorithm?", "A brute force algorithm tries every possible solution, while a greedy algorithm only considers locally optimal choices.", "A brute force algorithm is always faster than a greedy algorithm.", "A greedy algorithm tries every possible solution, while a brute force algorithm only considers locally optimal choices.", "A greedy algorithm is always faster than a brute force algorithm.", "A", "The main difference between a brute force algorithm and a greedy algorithm is that a brute force algorithm tries every possible solution, while a greedy algorithm only considers locally optimal choices."));
        questions.add(new Question("What is the worst-case time complexity of a brute-force algorithm?","Exponential","Logarithmic","Linear","Quadratic","A","The worst-case time complexity of a brute-force algorithm is exponential, which means the running time grows rapidly as the input size increases."));
        questions.add(new Question("What is the advantage of a brute-force algorithm over other algorithms?","It is simple and easy to implement.","It is faster than other algorithms for most inputs.","It always produces the correct result.","It requires less memory than other algorithms.","C","The advantage of a brute-force algorithm over other algorithms is that it always produces the correct result. It does this by systematically checking all possible solutions, so there is no chance of missing the correct answer."));
        questions.add(new Question("What is the difference between a brute-force algorithm and a greedy algorithm?","A brute-force algorithm checks all possible solutions, while a greedy algorithm makes the locally optimal choice at each step.","A brute-force algorithm is always faster than a greedy algorithm.","A brute-force algorithm is always correct, while a greedy algorithm may not be.","A brute-force algorithm requires less memory than a greedy algorithm.","A","The main difference between a brute-force algorithm and a greedy algorithm is that a brute-force algorithm checks all possible solutions, while a greedy algorithm makes the locally optimal choice at each step. This means that a greedy algorithm may not always produce the correct result, but it can be much faster than a brute-force algorithm."));
        questions.add(new Question("What is the difference between a brute-force algorithm and a backtracking algorithm?","A backtracking algorithm prunes the search tree by abandoning partial solutions that cannot be completed, while a brute-force algorithm checks all possible solutions.","A brute-force algorithm is always faster than a backtracking algorithm.","A backtracking algorithm is always correct, while a brute-force algorithm may not be.","A backtracking algorithm requires less memory than a brute-force algorithm.","A","The main difference between a brute-force algorithm and a backtracking algorithm is that a backtracking algorithm prunes the search tree by abandoning partial solutions that cannot be completed, while a brute-force algorithm checks all possible solutions. This means that a backtracking algorithm can be much faster than a brute-force algorithm, but it may not always produce the correct result."));
        questions.add(new Question("What is the time complexity of a brute-force algorithm that checks all possible permutations of a set of n elements?","n!","n^2","2^n","log(n)","A","The time complexity of a brute-force algorithm that checks all possible permutations of a set of n elements is n!, which grows very rapidly as n increases. This makes it impractical for large input sizes."));


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
        viewModel.setBruteForceQuestions(usedQuestions);


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
                viewModel.setBruteForceScore(String.valueOf(score));

                NavHostFragment.findNavController(BruteForceQuizFragment.this)
                        .navigate(R.id.action_bruteForceQuizFragment_to_bruteForceQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(BruteForceQuizFragment.this)
                        .navigate(R.id.action_bruteForceQuizFragment_to_quizMenuFragment);
            }
        });
    }
}