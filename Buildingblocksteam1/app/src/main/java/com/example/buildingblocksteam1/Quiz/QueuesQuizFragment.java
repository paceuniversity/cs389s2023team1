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
import com.example.buildingblocksteam1.databinding.FragmentQueuesQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QueuesQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QueuesQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentQueuesQuizBinding binding;
    private SharedViewModel viewModel;

    public QueuesQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QueuesQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QueuesQuizFragment newInstance(String param1, String param2) {
        QueuesQuizFragment fragment = new QueuesQuizFragment();
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

        binding = FragmentQueuesQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getQueuesScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("Which of the following is not an operation in a queue?", "Push", "Pop", "Enqueue", "Dequeue", "A", "Push is not an operation in a queue. It is used in a stack to insert an element at the top of the stack."));
        questions.add(new Question("What is the time complexity to insert an element at the end of a queue?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "A", "Inserting an element at the end of a queue has a time complexity of O(1)."));
        questions.add(new Question("Which of the following data structures can be used to implement a queue?", "Array", "Linked List", "Tree", "All of the above", "D", "All of the above data structures can be used to implement a queue."));
        questions.add(new Question("In a circular queue, what is the role of the front and rear pointers?", "Front pointer points to the end and rear pointer points to the beginning.", "Front pointer points to the beginning and rear pointer points to the end.", "Front and rear pointers both point to the beginning.", "Front and rear pointers both point to the end.", "B", "In a circular queue, the front pointer points to the beginning and the rear pointer points to the end."));
        questions.add(new Question("What is the time complexity to delete an element from the front of a queue?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "A", "Deleting an element from the front of a queue has a time complexity of O(1)."));
        questions.add(new Question("What happens when you try to add an element to a full queue?", "The element is added at the front of the queue.", "The element is added at the end of the queue and the last element is lost.", "The element is not added and an exception is thrown.", "The element is added and the first element is lost.", "C", "When you try to add an element to a full queue, the element is not added and an exception is thrown."));
        questions.add(new Question("What is the time complexity to search for an element in a queue?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "C", "Searching for an element in a queue has a time complexity of O(n)."));
        questions.add(new Question("What is the role of a queue in a breadth-first search algorithm?", "To store the vertices of the graph in depth-first order.", "To store the vertices of the graph in breadth-first order.", "To store the edges of the graph in depth-first order.", "To store the edges of the graph in breadth-first order.", "B", "In a breadth-first search algorithm, the queue is used to store the vertices of the graph in breadth-first order."));
        questions.add(new Question("What is the role of a queue in a CPU scheduling algorithm?", "To store the processes in priority order.", "To store the processes in a random order.", "To store the processes in the order in which they arrived.", "To store the processes in the order of their execution time.", "C", "In a CPU scheduling algorithm, the queue is used to store the processes in the order in which they arrived."));
        questions.add(new Question("What is the difference between a stack and a queue?", "A stack uses the LIFO (last in, first out) policy, while a queue uses the FIFO (first in, first out) policy.", "A stack uses the FIFO (first in, first out) policy, while a queue uses the LIFO (last in, first out) policy.", "A stack and a queue are the same data structure.", "A stack is used for breadth-first search, while a queue is used for depth-first search.", "A", "The main difference between a stack and a queue is that a stack uses the LIFO (last in, first out) policy, while a queue uses the FIFO (first in, first out) policy."));
        questions.add(new Question("Which of the following is a disadvantage of using an array to implement a queue?", "Arrays have a fixed size, which limits the number of elements that can be stored in the queue.", "Arrays are slower than linked lists when inserting or deleting elements from the queue.", "Arrays are more difficult to implement than linked lists.", "Arrays are less efficient than trees when searching for elements in the queue.", "A", "A disadvantage of using an array to implement a queue is that arrays have a fixed size, which limits the number of elements that can be stored in the queue."));
        questions.add(new Question("What is the time complexity to insert an element at the front of a queue implemented as a linked list?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "A", "Inserting an element at the front of a queue implemented as a linked list has a time complexity of O(1)."));
        questions.add(new Question("What is the time complexity to insert an element at the front of a queue implemented as an array?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "C", "Inserting an element at the front of a queue implemented as an array has a time complexity of O(n), as all elements need to be shifted one position to the right."));
        questions.add(new Question("What is the time complexity to delete an element from the end of a queue implemented as a linked list?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "C", "Deleting an element from the end of a queue implemented as a linked list has a time complexity of O(n), as the second-to-last element needs to be updated to point to null."));
        questions.add(new Question("What is the time complexity to delete an element from the end of a queue implemented as an array?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "A", "Deleting an element from the end of a queue implemented as an array has a time complexity of O(1)."));
        questions.add(new Question("What is the role of a queue in a print spooling system?", "To store the documents in priority order.", "To store the documents in a random order.", "To store the documents in the order in which they were sent to the printer.", "To store the documents in the order in which they were received by the printer.", "D", "In a print spooling system, the queue is used to store the documents in the order in which they were received by the printer."));
        questions.add(new Question("Which of the following is a common application of a queue?", "Maintaining a history of visited URLs in a web browser.", "Implementing an undo/redo feature in a text editor.", "Storing the list of recently played songs in a music player.", "All of the above.", "D", "Queues are commonly used for maintaining a history of visited URLs in a web browser, implementing an undo/redo feature in a text editor, and storing the list of recently played songs in a music player."));
        questions.add(new Question("Which of the following is not a basic operation supported by a queue?", "Insertion of an element at the front of the queue.", "Deletion of an element from the front of the queue.", "Insertion of an element at the end of the queue.", "Deletion of an element from the end of the queue.", "D", "Deleting an element from the end of a queue is not a basic operation supported by a queue. Queues are designed to remove elements from the front."));
        questions.add(new Question("Which of the following is a disadvantage of using a linked list to implement a queue?", "Linked lists have a fixed size, which limits the number of elements that can be stored in the queue.", "Linked lists are slower than arrays when accessing elements in the queue.", "Linked lists use more memory than arrays to store the same number of elements.", "Linked lists are less efficient than arrays when inserting or deleting elements from the queue.", "D", "A disadvantage of using a linked list to implement a queue is that linked lists are less efficient than arrays when inserting or deleting elements from the queue."));
        questions.add(new Question("What is the maximum number of elements that can be stored in a queue implemented as an array of size N?", "N", "N-1", "2N", "2N-1", "B", "In a queue implemented as an array of size N, the maximum number of elements that can be stored is N-1, as one position needs to be reserved for the front of the queue."));
        questions.add(new Question("What is the time complexity to insert an element at the end of a queue implemented as a linked list?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "A", "Inserting an element at the end of a queue implemented as a linked list has a time complexity of O(1)."));
        questions.add(new Question("What is the time complexity to insert an element at the end of a queue implemented as an array?", "O(1)", "O(log n)", "O(n)", "O(n log n)", "D", "Inserting an element at the end of a queue implemented as an array has a time complexity of O(n), if the array is full and needs to be resized, or O(1) if there is enough space in the array."));

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
        viewModel.setQueuesQuestions(usedQuestions);


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
                viewModel.setQueuesScore(String.valueOf(score));

                NavHostFragment.findNavController(QueuesQuizFragment.this)
                        .navigate(R.id.action_queuesQuizFragment_to_queuesQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QueuesQuizFragment.this)
                        .navigate(R.id.action_queuesQuizFragment_to_quizMenuFragment);
            }
        });
    }
}