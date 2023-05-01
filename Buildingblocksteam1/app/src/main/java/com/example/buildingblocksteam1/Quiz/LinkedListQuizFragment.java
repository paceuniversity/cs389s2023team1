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
import com.example.buildingblocksteam1.databinding.FragmentLinkedListQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LinkedListQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinkedListQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentLinkedListQuizBinding binding;
    private SharedViewModel viewModel;

    public LinkedListQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LinkedListQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinkedListQuizFragment newInstance(String param1, String param2) {
        LinkedListQuizFragment fragment = new LinkedListQuizFragment();
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

        binding = FragmentLinkedListQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("1", "A data structure that stores elements in an array", "A data structure that stores elements in a tree", "A data structure that stores elements in a sequence of nodes", "A data structure that stores elements in a stack", "A data structure that stores elements in a sequence of nodes", "A linked list is a data structure that stores elements in a sequence of nodes. Each node contains data and a pointer to the next node in the list."));
        questions.add(new Question("2", "Requires more memory for pointers", "More difficult to implement than a singly linked list", "More difficult to traverse than a doubly linked list", "May result in infinite loops if not implemented carefully", "May result in infinite loops if not implemented carefully", "A disadvantage of using a circular linked list is that it may result in infinite loops if not implemented carefully, since there is no natural endpoint in the list."));
        questions.add(new Question("3", "A linked list where each node has only one pointer to the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A doubly linked list is a linked list where each node has two pointers, one to the previous node and one to the next node."));
        questions.add(new Question("4", "A data structure that stores elements in an array", "A data structure that stores elements in a tree", "A data structure that stores elements in a sequence of nodes", "A data structure that stores elements in a stack", "A data structure that stores elements in a sequence of nodes", "A linked list is a data structure that stores elements in a sequence of nodes. Each node contains data and a pointer to the next node in the list."));
        questions.add(new Question("5", "Requires more memory for pointers", "More difficult to implement than a singly linked list", "More difficult to traverse than a doubly linked list", "May result in infinite loops if not implemented carefully", "May result in infinite loops if not implemented carefully", "A disadvantage of using a circular linked list is that it may result in infinite loops if not implemented carefully, since there is no natural endpoint in the list."));
        questions.add(new Question("6", "A linked list where each node has only one pointer to the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A doubly linked list is a linked list where each node has two pointers, one to the previous node and one to the next node."));
        questions.add(new Question("7", "A data structure that stores elements in an array", "A data structure that stores elements in a tree", "A data structure that stores elements in a sequence of nodes", "A data structure that stores elements in a stack", "A data structure that stores elements in a sequence of nodes", "A linked list is a data structure that stores elements in a sequence of nodes. Each node contains data and a pointer to the next node in the list."));
        questions.add(new Question("8", "Requires more memory for pointers", "More difficult to implement than a singly linked list", "More difficult to traverse than a doubly linked list", "May result in infinite loops if not implemented carefully", "May result in infinite loops if not implemented carefully", "A disadvantage of using a circular linked list is that it may result in infinite loops if not implemented carefully, since there is no natural endpoint in the list."));
        questions.add(new Question("9", "A linked list where each node has only one pointer to the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A doubly linked list is a linked list where each node has two pointers, one to the previous node and one to the next node."));
        questions.add(new Question("10", "A data structure that stores elements in an array", "A data structure that stores elements in a tree", "A data structure that stores elements in a sequence of nodes", "A data structure that stores elements in a stack", "A data structure that stores elements in a sequence of nodes", "A linked list is a data structure that stores elements in a sequence of nodes. Each node contains data and a pointer to the next node in the list."));
        questions.add(new Question("11", "Requires more memory for pointers", "More difficult to implement than a singly linked list", "More difficult to traverse than a doubly linked list", "May result in infinite loops if not implemented carefully", "May result in infinite loops if not implemented carefully", "A disadvantage of using a circular linked list is that it may result in infinite loops if not implemented carefully, since there is no natural endpoint in the list."));
        questions.add(new Question("12", "A linked list where each node has only one pointer to the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A linked list where each node has three pointers, one to the previous node, one to the next node, and one to a random node", "A linked list where each node has two data values, one representing the previous node and one representing the next node", "A linked list where each node has two pointers, one to the previous node and one to the next node", "A doubly linked list is a linked list where each node has two pointers, one to the previous node and one to the next node."));

        // *** Shuffles the questions Array List
        Collections.shuffle(questions, new Random());


        // *** Add the questions as radio buttons into the view
        LinearLayout root = binding.linearLayout;
        ArrayList<Question> usedQuestions = new ArrayList<Question>();
        for (int i = 0; i < 10; i++) {
            TextView text = new TextView(this.getContext());
            text.setText("" + (i+1) + ". " + questions.get(i).getQuestion());
            text.setTextColor(regularColor);
            root.addView(text);

            RadioGroup radioGroup = new RadioGroup(this.getContext());


            ArrayList<String> answers = questions.get(i).getAnswerList();
            Collections.shuffle(answers, new Random());
            for (int j = 0; j < 4; j++) {
                RadioButton radioButton = new RadioButton(this.getContext());
                radioButton.setText("" + (char)(j+65) + ". " + answers.get(j));
                radioButton.setButtonTintList(ColorStateList.valueOf(regularColor));
                radioButton.setTextColor(regularColor);
                if (radioButton.getText().equals(questions.get(i).getAnswer())) {
                    radioButton.setTag("true");
                }
                radioGroup.addView(radioButton);
            }

            root.addView(radioGroup);

            usedQuestions.add(questions.get(i));
        }
        viewModel.setQuestions(usedQuestions);

//        Button buttonSubmit2 = new Button(this.getContext());
//        buttonSubmit2.setTextColor(buttonColor);
//        buttonSubmit2.setLayoutParams(new LinearLayout.LayoutParams(411, -2));
//        root.addView(buttonSubmit2);




        return binding.getRoot();
        //return inflater.inflate(R.layout.fragment_quiz_menu, container, false);
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
                viewModel.setLinkedlistScore(String.valueOf(score));

                NavHostFragment.findNavController(LinkedListQuizFragment.this)
                        .navigate(R.id.action_linkedListQuizFragment_to_linkedListQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(LinkedListQuizFragment.this)
                        .navigate(R.id.action_linkedListQuizFragment_to_quizMenuFragment);
            }
        });
    }
}