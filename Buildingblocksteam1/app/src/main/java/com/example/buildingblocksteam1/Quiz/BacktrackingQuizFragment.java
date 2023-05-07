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
        questions.add(new Question("What is a linked list?", "A data structure that stores elements in contiguous memory locations", "A data structure that stores elements in non-contiguous memory locations and links them together", "A data structure that stores elements in a hash table", "A data structure that stores elements in a binary tree", "B", "A linked list is a data structure that stores elements in non-contiguous memory locations and links them together."));
        questions.add(new Question("What is a node in a linked list?", "The first element in the list", "The last element in the list", "A data structure that contains the element being stored and a pointer to the next node", "A data structure that contains the element being stored and a pointer to the previous node", "C", "A node in a linked list is a data structure that contains the element being stored and a pointer to the next node."));
        questions.add(new Question("What is the time complexity for inserting a node at the beginning of a linked list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The time complexity for inserting a node at the beginning of a linked list is O(1), constant time."));
        questions.add(new Question("What is the time complexity for inserting a node at the end of a linked list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "C", "The time complexity for inserting a node at the end of a linked list is O(n), where n is the number of nodes in the list."));
        questions.add(new Question("What is the time complexity for deleting a node at the beginning of a linked list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "A", "The time complexity for deleting a node at the beginning of a linked list is O(1), constant time."));
        questions.add(new Question("What is the time complexity for deleting a node at the end of a linked list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "C", "The time complexity for deleting a node at the end of a linked list is O(n), where n is the number of nodes in the list."));
        questions.add(new Question("What is a singly linked list?", "A linked list where each node has only one pointer to the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "A", "A singly linked list is a linked list where each node has only one pointer to the next node."));
        questions.add(new Question("What is a circular linked list?", "A linked list where each node has only one pointer to the next node and the last node points to the first node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "A", "A circular linked list is a linked list where each node has only one pointer to the next node and the last node points to the first node."));
        questions.add(new Question("What is a doubly linked list?", "A linked list where each node has only one pointer to the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "B", "A doubly linked list is a linked list where each node has two pointers, one to the previous node and one to the next node."));
        questions.add(new Question("What is the time complexity for searching an element in a linked list?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "C", "The time complexity for searching an element in a linked list is O(n), where n is the number of nodes in the list."));
        questions.add(new Question("What is a null pointer?", "A pointer that points to an empty memory location", "A pointer that points to the first node in a linked list", "A pointer that points to the last node in a linked list", "A pointer that points to a random node in a linked list", "A", "A null pointer is a pointer that points to an empty memory location."));

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