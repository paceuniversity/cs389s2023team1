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
import com.example.buildingblocksteam1.databinding.FragmentDivideAndConquerQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DivideAndConquerQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DivideAndConquerQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentDivideAndConquerQuizBinding binding;
    private SharedViewModel viewModel;

    public DivideAndConquerQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DivideAndConquerQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DivideAndConquerQuizFragment newInstance(String param1, String param2) {
        DivideAndConquerQuizFragment fragment = new DivideAndConquerQuizFragment();
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

        binding = FragmentDivideAndConquerQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getDivideAndConquerScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is divide and conquer programming?","A problem-solving strategy that involves breaking a problem into smaller sub-problems, solving the sub-problems recursively, and combining the solutions to the sub-problems to solve the original problem.","A programming paradigm that involves designing software with a focus on data structures and algorithms.","A problem-solving strategy that involves using a finite set of instructions to automate the execution of a task.","A programming paradigm that involves using a database to store and manage data.","A","Divide and conquer programming is a problem-solving strategy that involves breaking a problem into smaller sub-problems, solving the sub-problems recursively, and combining the solutions to the sub-problems to solve the original problem."));
        questions.add(new Question("What is the main advantage of divide and conquer programming?","It can reduce the time complexity of the algorithm.","It can reduce the space complexity of the algorithm.","It can reduce the need for debugging.","It can reduce the need for documentation.","A","The main advantage of divide and conquer programming is that it can reduce the time complexity of the algorithm by breaking the problem into smaller sub-problems and solving them recursively."));
        questions.add(new Question("What is the time complexity of the merge sort algorithm?","O(nlogn)","O(n^2)","O(n)","O(logn)","A","The time complexity of the merge sort algorithm is O(nlogn), where n is the size of the input array. This makes it one of the most efficient sorting algorithms in terms of time complexity."));
        questions.add(new Question("What is the basic idea behind the merge sort algorithm?","To divide the input array into two halves, recursively sort the halves, and then merge the sorted halves back together.","To repeatedly partition the input array into smaller sub-arrays and then sort the sub-arrays using a pivot element.","To repeatedly swap adjacent elements in the input array until the array is sorted.","To repeatedly select the minimum element from the input array and move it to the front of the array until the array is sorted.","A","The basic idea behind the merge sort algorithm is to divide the input array into two halves, recursively sort the halves, and then merge the sorted halves back together."));
        questions.add(new Question("What is the time complexity of the quicksort algorithm in the worst case?","O(n^2)","O(nlogn)","O(n)","O(logn)","A","The time complexity of the quicksort algorithm in the worst case is O(n^2), where n is the size of the input array. This can happen if the pivot element is consistently chosen poorly, leading to unbalanced partitions."));
        questions.add(new Question("What is the basic idea behind the quicksort algorithm?","To repeatedly partition the input array into two sub-arrays based on a pivot element, and then recursively sort the sub-arrays.","To repeatedly divide the input array into smaller sub-arrays and sort them using a merge operation.","To repeatedly select the minimum element from the input array and move it to the front of the array until the array is sorted.","To repeatedly swap adjacent elements in the input array until the array is sorted.","A","The basic idea behind the quicksort algorithm is to repeatedly partition the input array into two sub-arrays based on a pivot element, and then recursively sort the sub-arrays."));
        questions.add(new Question("What is the time complexity of the binary search algorithm?","O(logn)","O(nlogn)","O(n)","O(1)","A","The time complexity of the binary search algorithm is O(logn), where n is the size of the input array. This makes it very efficient for searching sorted arrays."));
        questions.add(new Question("Which of the following is a disadvantage of divide and conquer algorithms?", "They require significant memory usage.", "They have slow worst-case time complexity.", "They are difficult to implement.", "They cannot handle large datasets.", "A","Divide and conquer algorithms may require significant memory usage, especially when recursively splitting large datasets into smaller subproblems."));
        questions.add(new Question("What is the time complexity of merge sort?", "O(n log n)", "O(n^2)", "O(n)", "O(log n)", "A", "Merge sort has a time complexity of O(n log n), making it an efficient sorting algorithm for large datasets."));
        questions.add(new Question("What is the base case in the merge sort algorithm?", "When there is only one element in the array.", "When the array is sorted.", "When the array is empty.", "When the array contains duplicates.", "A", "The base case in the merge sort algorithm is when there is only one element in the array, as a single element is always considered sorted."));
        questions.add(new Question("What is the divide step in the quicksort algorithm?", "Selecting a pivot element and partitioning the array into subarrays based on the pivot.", "Comparing adjacent elements and swapping them if they are in the wrong order.", "Iteratively selecting the smallest element and swapping it with the first unsorted element.", "Creating a binary search tree from the input data.", "A", "The divide step in the quicksort algorithm involves selecting a pivot element and partitioning the array into subarrays based on the pivot."));
        questions.add(new Question("What is the conquer step in the quicksort algorithm?", "Recursively sorting the subarrays.", "Selecting a pivot element and partitioning the array into subarrays based on the pivot.", "Iteratively selecting the smallest element and swapping it with the first unsorted element.", "Creating a binary search tree from the input data.", "A", "The conquer step in the quicksort algorithm involves recursively sorting the subarrays created in the divide step."));
        questions.add(new Question("What is a common way to choose the pivot element in the quicksort algorithm?", "Selecting the median of the first, middle, and last elements.", "Selecting the first element of the array.", "Selecting a random element from the array.", "Selecting the largest element in the array.", "A", "A common way to choose the pivot element in the quicksort algorithm is to select the median of the first, middle, and last elements."));
        questions.add(new Question("What is the worst-case time complexity of the quicksort algorithm?", "O(n^2)", "O(n log n)", "O(n)", "O(log n)", "A", "The worst-case time complexity of the quicksort algorithm is O(n^2), which occurs when the chosen pivot element is the largest or smallest element in the array."));
        questions.add(new Question("What is the base case in the binary search algorithm?", "When the array is empty or the search element is found.", "When the array contains duplicates.", "When the array is sorted.", "When there is only one element in the array.", "A", "The base case in the binary search algorithm is when the array is empty or the search element is found."));
        questions.add(new Question("What is the base case for a divide and conquer algorithm?", "A condition when the problem can be solved without further recursion.", "A condition when the problem can be solved with further recursion.", "A condition when the problem can be solved using iteration.", "A condition when the problem can only be solved using brute force.", "A", "The base case is a condition when the problem can be solved without further recursion."));
        questions.add(new Question("What is a common application of the divide and conquer algorithm?", "Sorting arrays", "Finding the shortest path in a graph", "Calculating Fibonacci numbers", "Performing linear regression", "A", "Sorting arrays is a common application of the divide and conquer algorithm."));
        questions.add(new Question("What is the difference between the merge sort and quick sort algorithms?", "Merge sort is a stable sort, while quick sort is not.", "Quick sort is a stable sort, while merge sort is not.", "Merge sort uses recursion, while quick sort uses iteration.", "Quick sort uses recursion, while merge sort uses iteration.", "B", "The difference between merge sort and quick sort is that merge sort is a stable sort, while quick sort is not."));
        questions.add(new Question("What is the space complexity of the merge sort algorithm?", "O(1)", "O(n)", "O(n log n)", "O(n^2)", "B", "The space complexity of merge sort algorithm is O(n)."));
        questions.add(new Question("What is the name of the technique used to find the closest pair of points in a set using divide and conquer?", "Brute force", "Greedy algorithm", "Dynamic programming", "Recursive splitting", "D", "The technique used to find the closest pair of points in a set using divide and conquer is called recursive splitting."));
        questions.add(new Question("What is the main idea behind the Karatsuba algorithm?", "Multiplying two numbers in O(n log n) time complexity.", "Dividing two numbers in O(n) time complexity.", "Multiplying two numbers in O(n) time complexity.", "Dividing two numbers in O(n log n) time complexity.", "A", "The main idea behind the Karatsuba algorithm is multiplying two numbers in O(n log n) time complexity."));
        questions.add(new Question("What is the space complexity of the Karatsuba algorithm?", "O(n)", "O(n^2)", "O(log n)", "O(1)", "C", "The space complexity of the Karatsuba algorithm is O(log n)."));
        questions.add(new Question("What is the main idea behind the binary search algorithm?", "Divide the search space in half and eliminate the half that does not contain the target value.", "Iterate through the search space one element at a time until the target value is found.", "Divide the search space in thirds and eliminate the third that does not contain the target value.", "Iterate through the search space two elements at a time until the target value is found.", "A", "The main idea behind the binary search algorithm is to divide the search space in half and eliminate the half that does not contain the target value."));

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
        viewModel.setDivideAndConquerQuestions(usedQuestions);


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
                viewModel.setDivideAndConquerScore(String.valueOf(score));

                NavHostFragment.findNavController(DivideAndConquerQuizFragment.this)
                        .navigate(R.id.action_divideAndConquerQuizFragment_to_divideAndConquerQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(DivideAndConquerQuizFragment.this)
                        .navigate(R.id.action_divideAndConquerQuizFragment_to_quizMenuFragment);
            }
        });
    }
}