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
import com.example.buildingblocksteam1.databinding.FragmentArraysQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArraysQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArraysQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentArraysQuizBinding binding;
    private SharedViewModel viewModel;

    public ArraysQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArraysQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArraysQuizFragment newInstance(String param1, String param2) {
        ArraysQuizFragment fragment = new ArraysQuizFragment();
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

        binding = FragmentArraysQuizBinding.inflate(inflater, container, false);

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

        // *** Creates the list of questions
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("What is an array list in Java?", "A resizable array", "A fixed-size array", "A linked list", "A hash table", "A", "An array list is a resizable array that can dynamically increase or decrease its size based on the number of elements it contains."));
        questions.add(new Question("How are elements stored in an array list?", "In a contiguous block of memory", "In a non-contiguous block of memory", "In a binary search tree", "In a hash table", "A", "Elements are stored in a contiguous block of memory in an array list, which allows for efficient indexing and random access."));
        questions.add(new Question("What is the time complexity of adding an element to the end of an array list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "Adding an element to the end of an array list is typically an O(1) operation, as long as the array list has sufficient capacity."));
        questions.add(new Question("What is the time complexity of adding an element to the beginning of an array list?", "O(n)", "O(log n)", "O(1)", "O(n^2)", "C", "Adding an element to the beginning of an array list is typically an O(n) operation, as all existing elements need to be shifted one position to the right."));
        questions.add(new Question("What is the time complexity of accessing an element in an array list by index?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "Accessing an element in an array list by index is an O(1) operation, as the index can be used to directly access the corresponding element."));
        questions.add(new Question("What is the time complexity of removing an element from the end of an array list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "Removing an element from the end of an array list is typically an O(1) operation."));
        questions.add(new Question("What is the time complexity of removing an element from the beginning of an array list?", "O(n)", "O(log n)", "O(1)", "O(n^2)", "A", "Removing an element from the beginning of an array list is typically an O(n) operation, as all existing elements need to be shifted one position to the left."));
        questions.add(new Question("What happens to an array list when the number of elements exceeds its capacity?", "The array list is resized to a larger capacity", "The array list is converted to a linked list", "The program terminates with an error", "The array list starts deleting the oldest elements", "A", "When the number of elements exceeds an array list's capacity, the array list is resized to a larger capacity to accommodate the new elements."));
        questions.add(new Question("What is the initial capacity of an array list in Java?", "10", "20", "100", "50", "A", "The initial capacity of an array list in Java is 10 elements."));
        questions.add(new Question("What is the difference between the size and capacity of an array list?", "The size is the number of elements in the array list, and the capacity is the maximum number of elements it can hold", "The size is the maximum number of elements the array list can hold, and the capacity is the number of elements currently in it", "There is no difference between the size and capacity of an array list", "The size and capacity are both determined at runtime", "A", "The size of an array list is the number of elements it currently contains, while the capacity is the maximum number of elements it can hold without needing to resize."));
        questions.add(new Question("What is the default value of an element in an array list of integers in Java?", "0", "1", "-1", "null", "D", "The default value of an element in an array list of integers is null."));
        questions.add(new Question("What is the default value of an element in an array list of booleans in Java?", "true", "false", "0", "null", "B", "The default value of an element in an array list of booleans is false."));
        questions.add(new Question("What is the difference between an array and an array list?", "An array has a fixed size, while an array list can resize dynamically", "An array is a collection of objects, while an array list is a collection of primitives", "An array is a linear data structure, while an array list is a non-linear data structure", "There is no difference between an array and an array list", "A", "An array has a fixed size that is determined at compile time, while an array list can resize dynamically to accommodate the number of elements it contains."));
        questions.add(new Question("Can an array list contain duplicate elements?", "Yes", "No", "Only if the duplicates are adjacent", "It depends on the data type of the array list", "A", "An array list can contain duplicate elements, as there is no restriction on the number of times an element can appear in the list."));
        questions.add(new Question("What is the time complexity of searching for an element in an unsorted array list?", "O(n)", "O(log n)", "O(1)", "O(n^2)", "A", "Searching for an element in an unsorted array list is typically an O(n) operation, as each element needs to be checked sequentially."));
        questions.add(new Question("What is the time complexity of searching for an element in a sorted array list?", "O(log n)", "O(n)", "O(1)", "O(n^2)", "A", "Searching for an element in a sorted array list is typically an O(log n) operation, as the binary search algorithm can be used to quickly locate the element."));
        questions.add(new Question("What is the difference between an iterator and a list iterator in Java?", "A list iterator can iterate in both directions, while an iterator can only iterate forward", "A list iterator can modify the list during iteration, while an iterator cannot", "A list iterator can only iterate over linked lists, while an iterator can iterate over any collection", "There is no difference between an iterator and a list iterator", "B", "A list iterator can modify the list during iteration, allowing for the addition, removal, or modification of elements. An iterator, on the other hand, can only iterate over a collection and cannot modify its elements."));
        questions.add(new Question("What is the difference between add() and set() methods in an array list?", "add() adds an element to the end of the list, while set() replaces an element at a specified index", "add() replaces an element at a specified index, while set() adds an element to the end of the list", "add() and set() perform the same function", "add() adds an element to the beginning of the list, while set() replaces an element at a specified index", "A", "The add() method adds an element to the end of the list, while the set() method replaces the element at the specified index with a new value."));
        questions.add(new Question("What is the difference between remove() and clear() methods in an array list?", "remove() removes a single element at a specified index, while clear() removes all elements from the list", "remove() removes all elements from the list, while clear() removes a single element at a specified index", "remove() and clear() perform the same function", "remove() removes the first occurrence of a specified element, while clear() removes all occurrences of the element", "A", "The remove() method removes a single element at a specified index from the list, while the clear() method removes all elements from the list."));
        questions.add(new Question("What is the time complexity of adding an element to the end of an array list?", "O(1)", "O(n)", "O(log n)", "O(n^2)", "A", "Adding an element to the end of an array list is typically an O(1) operation, as long as there is enough capacity in the underlying array to accommodate the new element."));

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
        viewModel.setArraysQuestions(usedQuestions);


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
                viewModel.setArraysScore(String.valueOf(score));

                NavHostFragment.findNavController(ArraysQuizFragment.this)
                        .navigate(R.id.action_arraysQuizFragment_to_arraysQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(ArraysQuizFragment.this)
                        .navigate(R.id.action_arraysQuizFragment_to_quizMenuFragment);
            }
        });
    }
}