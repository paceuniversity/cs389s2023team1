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
import com.example.buildingblocksteam1.databinding.FragmentGreedyQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GreedyQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GreedyQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentGreedyQuizBinding binding;
    private SharedViewModel viewModel;

    public GreedyQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GreedyQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GreedyQuizFragment newInstance(String param1, String param2) {
        GreedyQuizFragment fragment = new GreedyQuizFragment();
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

        binding = FragmentGreedyQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getGreedyScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is a greedy algorithm?","A. An algorithm that always makes the optimal choice at each step","B. An algorithm that randomly makes choices at each step","C. An algorithm that backtracks to find the optimal solution","D. An algorithm that uses dynamic programming to find the optimal solution","A","A greedy algorithm always makes the optimal choice at each step, without considering the overall future consequences."));
        questions.add(new Question("What is the main advantage of using a greedy algorithm?","A. It always finds the optimal solution","B. It is easy to implement","C. It works well with large datasets","D. It can handle complex problems","B","Greedy algorithms are relatively easy to implement, which makes them a popular choice for solving optimization problems."));
        questions.add(new Question("What is the main disadvantage of using a greedy algorithm?","A. It can be slow on large datasets","B. It may not always find the optimal solution","C. It requires a lot of memory","D. It is difficult to implement","B","One of the main disadvantages of using a greedy algorithm is that it may not always find the optimal solution, since it only considers the local optimal choice at each step."));
        questions.add(new Question("What is the difference between a greedy algorithm and a dynamic programming algorithm?","A. Greedy algorithms use a top-down approach, while dynamic programming algorithms use a bottom-up approach","B. Greedy algorithms always find the optimal solution, while dynamic programming algorithms may not","C. Greedy algorithms use memoization to avoid recalculating subproblems, while dynamic programming algorithms do not","D. Greedy algorithms only consider the current optimal choice, while dynamic programming algorithms consider all possible choices","D","Unlike greedy algorithms, dynamic programming algorithms consider all possible choices and store solutions to subproblems in a table to avoid recalculating them."));
        questions.add(new Question("What is the Knapsack problem?","A. A problem in which a thief must choose which items to steal from a store without being caught","B. A problem in which a person must pack a knapsack with items of varying weights and values to maximize the total value","C. A problem in which a person must arrange a set of numbers to form the largest possible number","D. A problem in which a person must find the shortest path between two points in a graph","B","The Knapsack problem is a classic optimization problem in which a person must pack a knapsack with items of varying weights and values to maximize the total value."));
        questions.add(new Question("What is the fractional Knapsack problem?","A. A variant of the Knapsack problem in which items can only be taken in integer quantities","B. A variant of the Knapsack problem in which items can be taken in fractional quantities","C. A variant of the Knapsack problem in which the knapsack has a fixed size","D. A variant of the Knapsack problem in which the items have different weights and values","B","In the fractional Knapsack problem, items can be taken in fractional quantities, which allows for more flexible solutions."));
        questions.add(new Question("What is the greedy algorithm strategy?","Choosing the best option at each step without considering the global optimal solution","Choosing the worst option at each step without considering the global optimal solution","Choosing a random option at each step without considering the global optimal solution","Choosing the best option at each step while also considering the global optimal solution","A","The greedy algorithm strategy is to choose the best option at each step without considering the global optimal solution."));
        questions.add(new Question("Which of the following problems can be solved using a greedy algorithm?","Finding the shortest path in a graph","Finding the minimum spanning tree of a graph","Finding the maximum flow in a network","Finding the longest common subsequence of two strings","B","The minimum spanning tree problem can be solved using a greedy algorithm."));
        questions.add(new Question("What is the time complexity of the greedy algorithm for finding the minimum spanning tree of a graph?","O(V^2)","O(ElogE)","O(ElogV)","O(V^3)","C","The time complexity of the greedy algorithm for finding the minimum spanning tree of a graph is O(ElogV), where E is the number of edges and V is the number of vertices in the graph."));
        questions.add(new Question("What is the greedy algorithm for the fractional knapsack problem?","Sort the items by their value-to-weight ratio in non-increasing order, and take as much of the item with the highest ratio as possible","Sort the items by their value-to-weight ratio in non-decreasing order, and take as much of the item with the highest ratio as possible","Sort the items by their weight in non-increasing order, and take as much of the item with the lowest weight as possible","Sort the items by their value in non-increasing order, and take as much of the item with the highest value as possible","A","The greedy algorithm for the fractional knapsack problem is to sort the items by their value-to-weight ratio in non-increasing order, and take as much of the item with the highest ratio as possible."));
        questions.add(new Question("What is the time complexity of the greedy algorithm for the fractional knapsack problem?","O(n)","O(nlogn)","O(n^2)","O(n^3)","B","The time complexity of the greedy algorithm for the fractional knapsack problem is O(nlogn), where n is the number of items in the knapsack."));
        questions.add(new Question("What is the greedy algorithm for the activity selection problem?","Select the activity with the earliest finish time, and then recursively select the activity with the earliest finish time among the remaining activities that do not overlap with the previously selected activity","Select the activity with the latest start time, and then recursively select the activity with the latest start time among the remaining activities that do not overlap with the previously selected activity","Select the activity with the shortest duration, and then recursively select the activity with the shortest duration among the remaining activities that do not overlap with the previously selected activity","Select the activity with the longest duration, and then recursively select the activity with the longest duration among the remaining activities that do not overlap with the previously selected activity","A","The greedy algorithm for the activity selection problem is to select the activity with the earliest finish time, and then recursively select the activity with the earliest finish time among the remaining activities that do not overlap with the previously selected activity."));
        questions.add(new Question("What is the time complexity of the greedy algorithm for the activity selection problem?","O(n)","O(nlogn)","O(n^2)","O(n^3)","B","The time complexity of the greedy algorithm for the activity selection problem is O(nlogn), where n is the number of activities."));
        questions.add(new Question("Which of the following problems can be solved using a greedy algorithm?", "Finding the shortest path in a graph with negative weights", "Finding the longest common subsequence of two strings", "Sorting a list of integers", "Finding the minimum spanning tree of a graph", "C", "A greedy algorithm can be used to solve sorting problems or optimization problems in which making the locally optimal choice at each stage leads to a globally optimal solution. In contrast, finding the shortest path in a graph with negative weights requires the Bellman-Ford algorithm, and finding the longest common subsequence of two strings requires dynamic programming. Finding the minimum spanning tree of a graph requires algorithms like Kruskal's algorithm or Prim's algorithm."));
        questions.add(new Question("Which of the following is an example of a problem that can be solved using a greedy algorithm?", "Travelling Salesman Problem", "Knapsack Problem", "Huffman Coding", "Longest Increasing Subsequence", "C", "Huffman coding is an example of a problem that can be solved using a greedy algorithm. It is used for lossless data compression and works by assigning shorter codes to frequently occurring characters and longer codes to less frequently occurring characters. The Travelling Salesman Problem and the Knapsack Problem are examples of NP-complete problems, which means that they are unlikely to have efficient algorithms for solving them in the worst case. The Longest Increasing Subsequence problem can be solved using dynamic programming."));
        questions.add(new Question("What is the main idea behind a greedy algorithm?", "To make the locally optimal choice at each stage", "To exhaustively search the solution space", "To divide the problem into smaller subproblems", "To choose the option with the highest probability of success", "A", "The main idea behind a greedy algorithm is to make the locally optimal choice at each stage, hoping that this will lead to a globally optimal solution. This means that the algorithm chooses the option that appears to be the best at the current moment, without considering the consequences of this choice for future steps. While this strategy can sometimes lead to a globally optimal solution, it is not guaranteed to do so."));
        questions.add(new Question("Which of the following is a disadvantage of using a greedy algorithm?", "It can be difficult to prove that the solution is optimal", "It is usually slower than other algorithms", "It always finds the optimal solution", "It can only be used for a limited set of problems", "A", "A disadvantage of using a greedy algorithm is that it can be difficult to prove that the solution is optimal. This is because the algorithm makes the locally optimal choice at each stage, without considering the consequences for future steps. While this strategy can sometimes lead to a globally optimal solution, it is not guaranteed to do so. In contrast, some other algorithms, like dynamic programming or backtracking, can guarantee to find the optimal solution, but may be slower or more memory-intensive."));

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
        viewModel.setGreedyQuestions(usedQuestions);


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
                viewModel.setGreedyScore(String.valueOf(score));

                NavHostFragment.findNavController(GreedyQuizFragment.this)
                        .navigate(R.id.action_greedyQuizFragment_to_greedyQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(GreedyQuizFragment.this)
                        .navigate(R.id.action_greedyQuizFragment_to_quizMenuFragment);
            }
        });
    }
}