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
import com.example.buildingblocksteam1.databinding.FragmentSortingQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SortingQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SortingQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentSortingQuizBinding binding;
    private SharedViewModel viewModel;

    public SortingQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SortingQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SortingQuizFragment newInstance(String param1, String param2) {
        SortingQuizFragment fragment = new SortingQuizFragment();
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

        binding = FragmentSortingQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getSortingScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is a sorting algorithm?", "A method of arranging elements in a specific order.", "A way to calculate the sum of two numbers.", "A technique for searching elements in a collection.", "A method of deleting elements from an array.", "A", "A sorting algorithm is a method of arranging elements in a specific order, such as ascending or descending."));
        questions.add(new Question("What is the time complexity of the bubble sort algorithm?", "O(n)", "O(n log n)", "O(n^2)", "O(1)", "C", "The time complexity of the bubble sort algorithm is O(n^2), where n is the number of elements in the array."));
        questions.add(new Question("What is the time complexity of the quicksort algorithm?", "O(n)", "O(n log n)", "O(n^2)", "O(1)", "B", "The time complexity of the quicksort algorithm is O(n log n) on average, making it one of the fastest sorting algorithms."));
        questions.add(new Question("What is the time complexity of the insertion sort algorithm?", "O(n)", "O(n log n)", "O(n^2)", "O(1)", "C", "The time complexity of the insertion sort algorithm is O(n^2), where n is the number of elements in the array."));
        questions.add(new Question("What is the main disadvantage of using the selection sort algorithm?", "It is inefficient for large arrays.", "It requires a lot of memory.", "It can only sort arrays of a specific size.", "It does not work for arrays with repeating elements.", "A", "The main disadvantage of using the selection sort algorithm is that it is inefficient for large arrays, as it has a time complexity of O(n^2) regardless of the input."));
        questions.add(new Question("What is the difference between stable and unstable sorting algorithms?", "Stable sorting algorithms maintain the relative order of equal elements, while unstable algorithms do not.", "Unstable sorting algorithms are faster than stable algorithms.", "Stable sorting algorithms only work with integers, while unstable algorithms work with any data type.", "Unstable sorting algorithms are easier to implement than stable algorithms.", "A", "The difference between stable and unstable sorting algorithms is that stable sorting algorithms maintain the relative order of equal elements, while unstable algorithms do not. This can be important when sorting complex data structures where the order of equal elements may be significant."));
        questions.add(new Question("What is the time complexity of the merge sort algorithm?", "O(n)", "O(n log n)", "O(n^2)", "O(1)", "B", "The time complexity of the merge sort algorithm is O(n log n), where n is the number of elements in the array. It is an efficient algorithm, but requires additional memory for the merging step."));
        questions.add(new Question("What is the worst-case time complexity of bubble sort?", "O(n^2)", "O(n log n)", "O(n)", "O(log n)", "A", "The worst-case time complexity of bubble sort is O(n^2), where n is the number of elements in the array. This occurs when the array is in reverse order."));
        questions.add(new Question("What is the worst-case time complexity of quicksort?", "O(n^2)", "O(n log n)", "O(n)", "O(log n)", "A", "The worst-case time complexity of quicksort is O(n^2), where n is the number of elements in the array. This occurs when the pivot is selected poorly and results in a highly unbalanced partitioning of the array."));
        questions.add(new Question("What is the best-case time complexity of quicksort?", "O(n log n)", "O(n)", "O(n^2)", "O(log n)", "A", "The best-case time complexity of quicksort is O(n log n), where n is the number of elements in the array. This occurs when the pivot is always chosen to be the median element of the current partition."));
        questions.add(new Question("What is the time complexity of merge sort?", "O(n log n)", "O(n)", "O(n^2)", "O(log n)", "A", "The time complexity of merge sort is O(n log n), where n is the number of elements in the array. This is true in both the best and worst cases."));
        questions.add(new Question("What is the worst-case time complexity of insertion sort?", "O(n^2)", "O(n log n)", "O(n)", "O(log n)", "A", "The worst-case time complexity of insertion sort is O(n^2), where n is the number of elements in the array. This occurs when the array is in reverse order and each element must be shifted all the way to the beginning."));
        questions.add(new Question("What is the worst-case time complexity of selection sort?", "O(n^2)", "O(n log n)", "O(n)", "O(log n)", "A", "The worst-case time complexity of selection sort is O(n^2), where n is the number of elements in the array. This occurs when the array is in reverse order and each element must be compared with every other element to find the minimum."));
        questions.add(new Question("What is the time complexity of heapsort?", "O(n log n)", "O(n)", "O(n^2)", "O(log n)", "A", "The time complexity of heapsort is O(n log n), where n is the number of elements in the array. This is true in both the best and worst cases."));
        questions.add(new Question("What is the worst-case time complexity of the QuickSort algorithm?", "O(n^2)", "O(n log n)", "O(log n)", "O(1)", "A", "The worst-case time complexity of the QuickSort algorithm is O(n^2), where n is the number of elements in the array. This can happen when the pivot is chosen poorly and results in uneven partitioning."));
        questions.add(new Question("What is the difference between a stable and unstable sorting algorithm?", "A stable algorithm maintains the relative order of equal elements, while an unstable algorithm does not guarantee this.", "A stable algorithm is faster than an unstable algorithm.", "A stable algorithm has a lower time complexity than an unstable algorithm.", "An unstable algorithm is less memory intensive than a stable algorithm.", "A", "A stable sorting algorithm maintains the relative order of equal elements, while an unstable algorithm does not guarantee this. For example, if we have two elements with the same value, a stable algorithm will always sort them in the same order, whereas an unstable algorithm may switch their order."));
        questions.add(new Question("What is the time complexity of the merge operation in MergeSort?", "O(n)", "O(n log n)", "O(log n)", "O(1)", "A", "The merge operation in MergeSort has a time complexity of O(n), where n is the number of elements being merged. This is because it requires iterating over each element once to compare and combine them into a new sorted array."));
        questions.add(new Question("What is the time complexity of the bubble sort algorithm?", "O(n)", "O(n^2)", "O(n log n)", "O(1)", "B", "The time complexity of the bubble sort algorithm is O(n^2), where n is the number of elements in the array."));
        questions.add(new Question("What is the time complexity of the quicksort algorithm in the average case?", "O(n)", "O(n^2)", "O(n log n)", "O(1)", "C", "The time complexity of the quicksort algorithm in the average case is O(n log n), where n is the number of elements in the array."));
        questions.add(new Question("What is the worst case time complexity of the mergesort algorithm?", "O(n)", "O(n^2)", "O(n log n)", "O(1)", "C", "The worst case time complexity of the mergesort algorithm is O(n log n), where n is the number of elements in the array."));
        questions.add(new Question("What is the difference between stable and unstable sorting algorithms?", "Stable algorithms preserve the order of equal elements, while unstable algorithms do not.", "Stable algorithms always have a better time complexity than unstable algorithms.", "Unstable algorithms are only used for small datasets.", "Unstable algorithms are more memory efficient than stable algorithms.", "A", "Stable sorting algorithms preserve the relative order of equal elements, while unstable sorting algorithms do not guarantee this."));
        questions.add(new Question("Which sorting algorithm is known for having a time complexity of O(n) in some cases?", "Bubble sort", "Quicksort", "Mergesort", "Radix sort", "D", "Radix sort is known for having a time complexity of O(n) in some cases, making it a very efficient sorting algorithm for certain types of data."));
        questions.add(new Question("What is the time complexity of the selection sort algorithm?", "O(n)", "O(n^2)", "O(n log n)", "O(1)", "B", "The time complexity of the selection sort algorithm is O(n^2), where n is the number of elements in the array."));
        questions.add(new Question("What is the main advantage of using the heapsort algorithm?", "It has a better average-case time complexity than quicksort.", "It is a stable sorting algorithm.", "It can be used for both small and large datasets.", "It has a worst-case time complexity of O(n log n).", "D", "The main advantage of using the heapsort algorithm is that it has a worst-case time complexity of O(n log n), which makes it a good choice for large datasets that require guaranteed worst-case performance."));


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
        viewModel.setSortingQuestions(usedQuestions);


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
                viewModel.setSortingScore(String.valueOf(score));

                NavHostFragment.findNavController(SortingQuizFragment.this)
                        .navigate(R.id.action_sortingQuizFragment_to_sortingQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(SortingQuizFragment.this)
                        .navigate(R.id.action_sortingQuizFragment_to_quizMenuFragment);
            }
        });
    }
}