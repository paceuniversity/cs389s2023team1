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
import com.example.buildingblocksteam1.databinding.FragmentStacksQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StacksQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StacksQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentStacksQuizBinding binding;
    private SharedViewModel viewModel;

    public StacksQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StacksQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StacksQuizFragment newInstance(String param1, String param2) {
        StacksQuizFragment fragment = new StacksQuizFragment();
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

        binding = FragmentStacksQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getStacksScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is a stack in data structures?", "A linear data structure that follows the Last-In-First-Out (LIFO) principle.", "A nonlinear data structure that follows the First-In-First-Out (FIFO) principle.", "A data structure that stores elements in a sorted manner.", "A data structure that links elements together.", "A", "A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle, which means that the last element added to the stack will be the first one to be removed."));
        questions.add(new Question("What are the two primary operations that can be performed on a stack?", "Push and Pop", "Insert and Delete", "Enqueue and Dequeue", "Sort and Search", "A", "The two primary operations that can be performed on a stack are Push and Pop. Push adds an element to the top of the stack, while Pop removes the top element."));
        questions.add(new Question("What happens when you try to Pop an empty stack?", "Stack Underflow Error", "Stack Overflow Error", "Segmentation Fault", "No Error, the stack becomes empty", "A", "When you try to Pop an empty stack, you will get a Stack Underflow Error. This means that the stack is empty and there is no element to remove."));
        questions.add(new Question("What is the time complexity of the Push and Pop operations on a stack?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The time complexity of the Push and Pop operations on a stack is O(1), which means that it takes constant time regardless of the size of the stack."));
        questions.add(new Question("What is the data structure used to implement a stack?", "Array", "Linked List", "Tree", "Graph", "B", "The data structure used to implement a stack is a Linked List, which allows for efficient insertion and removal of elements from the top of the stack."));
        questions.add(new Question("What is a common application of stacks?", "Expression Evaluation", "Searching", "Sorting", "Graph Traversal", "A", "A common application of stacks is Expression Evaluation, which involves parsing and evaluating mathematical expressions."));
        questions.add(new Question("What is a stack frame?", "A memory structure that stores information about a function call.", "A data structure that stores elements in a sorted manner.", "A data structure that links elements together.", "A memory structure that stores global variables.", "A", "A stack frame is a memory structure that stores information about a function call, including the function's parameters, return address, and local variables."));
        questions.add(new Question("What data structure is a stack similar to?", "Queue", "List", "Array", "Tree", "A", "A stack is similar to a queue in that it is a collection of elements with a specific order of access, but the access order is different."));
        questions.add(new Question("What is the name of the operation that adds an element to the top of a stack?", "Add", "Insert", "Push", "Pop", "C", "The push operation adds an element to the top of a stack."));
        questions.add(new Question("What is the name of the operation that removes an element from the top of a stack?", "Add", "Insert", "Push", "Pop", "D", "The pop operation removes an element from the top of a stack."));
        questions.add(new Question("What is the name of the element at the top of a stack?", "First", "Last", "Front", "Top", "D", "The element at the top of a stack is called the top element."));
        questions.add(new Question("What is the time complexity of the push and pop operations on a stack implemented as an array?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The push and pop operations on a stack implemented as an array have a time complexity of O(1)."));
        questions.add(new Question("What is the name of the data structure that can be used to implement a stack?", "Array", "List", "Tree", "All of the above", "D", "All of the above data structures can be used to implement a stack, but some may have different time complexities for certain operations."));
        questions.add(new Question("What is the name of the stack operation that returns the top element without removing it?", "Peek", "Pop", "Push", "Top", "A", "The peek operation returns the top element of a stack without removing it."));
        questions.add(new Question("What is a stack?", "A data structure that follows the LIFO (last in, first out) principle.", "A data structure that follows the FIFO (first in, first out) principle.", "A data structure that randomly stores and retrieves elements.", "A data structure that can store elements in any order.", "A", "A stack is a data structure that follows the LIFO (last in, first out) principle."));
        questions.add(new Question("What is the time complexity of push operation in a stack?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The time complexity of push operation in a stack is O(1), as it simply involves adding an element to the top of the stack."));
        questions.add(new Question("What is the time complexity of pop operation in a stack?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The time complexity of pop operation in a stack is O(1), as it simply involves removing an element from the top of the stack."));
        questions.add(new Question("What is the time complexity of peek operation in a stack?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The time complexity of peek operation in a stack is O(1), as it simply involves returning the top element of the stack."));
        questions.add(new Question("What is the maximum number of elements that can be stored in a stack?", "There is no fixed limit.", "It depends on the size of the stack.", "It depends on the amount of available memory.", "It depends on the number of operations performed on the stack.", "C", "The maximum number of elements that can be stored in a stack depends on the amount of available memory."));
        questions.add(new Question("Which of the following is not an application of stack data structure?", "Function calls and recursion.", "Expression conversion (infix to postfix, postfix to prefix, etc.).", "Undo operation in text editors.", "Finding shortest path in a graph.", "D", "Finding shortest path in a graph is not an application of stack data structure."));
        questions.add(new Question("What is a stack frame?", "A frame of memory allocated to a function call.", "A frame of memory allocated to a variable.", "A frame of memory allocated to a loop.", "A frame of memory allocated to a class.", "A", "A stack frame is a frame of memory allocated to a function call."));


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
        viewModel.setStacksQuestions(usedQuestions);


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
                viewModel.setStacksScore(String.valueOf(score));

                NavHostFragment.findNavController(StacksQuizFragment.this)
                        .navigate(R.id.action_stacksQuizFragment_to_stacksQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(StacksQuizFragment.this)
                        .navigate(R.id.action_stacksQuizFragment_to_quizMenuFragment);
            }
        });
    }
}