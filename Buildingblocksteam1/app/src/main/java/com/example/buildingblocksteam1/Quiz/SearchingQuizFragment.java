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
import com.example.buildingblocksteam1.databinding.FragmentSearchingQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchingQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchingQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentSearchingQuizBinding binding;
    private SharedViewModel viewModel;

    public SearchingQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchingQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchingQuizFragment newInstance(String param1, String param2) {
        SearchingQuizFragment fragment = new SearchingQuizFragment();
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

        binding = FragmentSearchingQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getSearchingScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is the time complexity of linear search?", "O(n^2)", "O(log n)", "O(n)", "O(1)", "C", "Linear search has a time complexity of O(n), where n is the size of the array being searched."));
        questions.add(new Question("What is the time complexity of binary search?", "O(n^2)", "O(log n)", "O(n)", "O(1)", "B", "Binary search has a time complexity of O(log n), where n is the size of the array being searched."));
        questions.add(new Question("What is the disadvantage of linear search compared to binary search?", "Linear search is slower.", "Linear search requires the array to be sorted.", "Linear search only works on small arrays.", "Linear search is not as accurate as binary search.", "A", "Linear search has a time complexity of O(n), making it slower than binary search which has a time complexity of O(log n)."));
        questions.add(new Question("What is the disadvantage of binary search compared to linear search?", "Binary search is slower.", "Binary search requires the array to be sorted.", "Binary search only works on small arrays.", "Binary search is not as accurate as linear search.", "B", "Binary search requires the array to be sorted, which can be a time-consuming process."));
        questions.add(new Question("What is the best case time complexity of linear search?", "O(n^2)", "O(log n)", "O(n)", "O(1)", "D", "The best case time complexity of linear search is O(1), which occurs when the target element is found at the first index of the array."));
        questions.add(new Question("Which of the following is an example of a linear search algorithm?", "Binary search", "Interpolation search", "Jump search", "Sequential search", "D", "Sequential search is a linear search algorithm."));
        questions.add(new Question("Which of the following is a disadvantage of using binary search?", "It requires the input to be sorted", "It can only be used on arrays of integers", "It has a worst-case time complexity of O(n)", "It is difficult to implement", "A", "Binary search requires the input to be sorted."));
        questions.add(new Question("What is the time complexity of binary search?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "B", "Binary search has a time complexity of O(log n)."));
        questions.add(new Question("What is the difference between breadth-first search and depth-first search?", "Breadth-first search always finds the shortest path", "Depth-first search always finds the shortest path", "Breadth-first search always uses less memory", "Depth-first search always uses less memory", "A", "Breadth-first search always finds the shortest path, while depth-first search does not."));
        questions.add(new Question("Which of the following is an example of an uninformed search algorithm?", "A* search", "Greedy best-first search", "Depth-first search", "Hill climbing", "C", "Depth-first search is an example of an uninformed search algorithm."));
        questions.add(new Question("What is the difference between interpolation search and binary search?", "Interpolation search is faster than binary search", "Interpolation search requires the input to be sorted", "Interpolation search uses the middle element as the pivot", "Interpolation search uses the value of the element being searched for to determine the search range", "D", "Interpolation search uses the value of the element being searched for to determine the search range, while binary search uses the middle element as the pivot."));
        questions.add(new Question("What is the difference between linear search and binary search?", "Linear search can only be used on sorted input", "Binary search is faster than linear search", "Binary search can only be used on sorted input", "Linear search is faster than binary search", "C", "Binary search can only be used on sorted input, while linear search can be used on unsorted input."));
        questions.add(new Question("What is the time complexity of breadth-first search?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "C", "Breadth-first search has a time complexity of O(n)."));
        questions.add(new Question("Which of the following is an example of an informed search algorithm?", "Depth-first search", "Breadth-first search", "A* search", "Hill climbing", "C", "A* search is an example of an informed search algorithm."));
        questions.add(new Question("What is the difference between uniform cost search and Dijkstra's algorithm?", "Uniform cost search can only be used on weighted graphs", "Dijkstra's algorithm always finds the shortest path", "Uniform cost search always uses less memory", "Dijkstra's algorithm always uses less memory", "B", "Dijkstra's algorithm always finds the shortest path, while uniform cost search does not."));

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
        viewModel.setSearchingQuestions(usedQuestions);


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
                viewModel.setSearchingScore(String.valueOf(score));

                NavHostFragment.findNavController(SearchingQuizFragment.this)
                        .navigate(R.id.action_searchingQuizFragment_to_searchingQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(SearchingQuizFragment.this)
                        .navigate(R.id.action_searchingQuizFragment_to_quizMenuFragment);
            }
        });
    }
}