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
import com.example.buildingblocksteam1.databinding.FragmentHashTablesQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HashTablesQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HashTablesQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentHashTablesQuizBinding binding;
    private SharedViewModel viewModel;

    public HashTablesQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HashTablesQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HashTablesQuizFragment newInstance(String param1, String param2) {
        HashTablesQuizFragment fragment = new HashTablesQuizFragment();
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

        binding = FragmentHashTablesQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getHashTablesScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is the average time complexity for searching in a hash table with chaining collision resolution?","A. O(1)","B. O(log n)","C. O(n)","D. O(n log n)","A","In a hash table with chaining collision resolution, searching takes constant time on average, which is O(1)."));
        questions.add(new Question("What is the worst-case time complexity for searching in a hash table with linear probing collision resolution?","A. O(1)","B. O(log n)","C. O(n)","D. O(n log n)","C","In the worst case, searching in a hash table with linear probing collision resolution can take O(n) time if the table is completely filled up and there are many collisions."));
        questions.add(new Question("What is the purpose of the load factor in a hash table?","A. To determine the size of the table","B. To determine the number of collisions","C. To determine the hash function","D. To balance the trade-off between space and time complexity","D","The load factor in a hash table is used to balance the trade-off between space and time complexity. It is the ratio of the number of elements stored in the table to the size of the table."));
        questions.add(new Question("What is the advantage of using a hash table with chaining collision resolution compared to linear probing?","A. Less memory overhead","B. Faster search times","C. Better cache performance","D. Can handle more collisions","D","Hash tables with chaining can handle more collisions than those with linear probing, which makes them more efficient when dealing with large amounts of data."));
        questions.add(new Question("What is the disadvantage of using a hash table with open addressing collision resolution compared to chaining?","A. More memory overhead","B. Slower search times","C. Worse cache performance","D. Can't handle as many collisions","D","Hash tables with open addressing cannot handle as many collisions as those with chaining, which limits their efficiency when dealing with large amounts of data."));
        questions.add(new Question("What is a hash table?","A data structure that stores key-value pairs and supports constant-time insertion, deletion, and retrieval of values.","A data structure that stores values in a linked list.","A data structure that stores values in a binary search tree.","A data structure that stores values in an array.","A","A hash table is a data structure that stores key-value pairs and supports constant-time insertion, deletion, and retrieval of values."));
        questions.add(new Question("What is a hash function?","A function that maps keys to indices in a hash table.","A function that maps values to indices in a hash table.","A function that sorts values in a hash table.","A function that searches for values in a hash table.","A","A hash function is a function that maps keys to indices in a hash table."));
        questions.add(new Question("What is collision in a hash table?","When two or more keys map to the same index in a hash table.","When a key is not found in a hash table.","When a hash table is full.","When a key is deleted from a hash table.","A","Collision in a hash table occurs when two or more keys map to the same index."));
        questions.add(new Question("What is chaining in hash tables?","A method of resolving collisions by storing multiple values in a linked list at each index.","A method of resolving collisions by rehashing the table.","A method of resolving collisions by deleting one of the colliding keys.","A method of resolving collisions by swapping the values of the colliding keys.","A","Chaining in hash tables is a method of resolving collisions by storing multiple values in a linked list at each index."));
        questions.add(new Question("What is open addressing in hash tables?","A method of resolving collisions by probing for an empty slot in the table.","A method of resolving collisions by rehashing the table.","A method of resolving collisions by deleting one of the colliding keys.","A method of resolving collisions by swapping the values of the colliding keys.","A","Open addressing in hash tables is a method of resolving collisions by probing for an empty slot in the table."));
        questions.add(new Question("What is linear probing in hash tables?","A method of open addressing that probes for the next empty slot in the table.","A method of open addressing that probes for the first empty slot after the collision.","A method of open addressing that probes for the next slot with a different hash value.","A method of open addressing that probes for the first slot with a different hash value.","B","Linear probing in hash tables is a method of open addressing that probes for the first empty slot after the collision."));
        questions.add(new Question("What is quadratic probing in hash tables?","A method of open addressing that probes for the next slot with a hash value incremented by a quadratic function.","A method of open addressing that probes for the first empty slot after the collision.","A method of open addressing that probes for the next slot with a different hash value.","A method of open addressing that probes for the first slot with a different hash value.","A","Quadratic probing in hash tables is a method of open addressing that probes for the next slot with a hash value incremented by a quadratic function."));
        questions.add(new Question("What is double hashing in hash tables?","A method of open addressing that uses a second hash function to determine the next probe location.","A method of open addressing that probes for the first empty slot after the collision.","A method of open addressing that probes for the next slot with a different hash value.","A method of open addressing that probes for the first slot with a different hash value.","A","Double hashing in hash tables is a method of open addressing that uses a second hash function to determine the next probe location."));
        questions.add(new Question("What is load factor in hash tables?","The ratio of the number of elements stored in a hash table to the size of the table.","The number of empty slots in a hash table.","The number of collisions in a hash table.","The size of the hash table.","A","Load factor in hash tables is the ratio of the number of elements stored in a hash table to the size of the table."));
        questions.add(new Question("What is rehashing in hash tables?","The process of creating a new, larger hash table and copying the elements from the old table to the new table.","The process of deleting all the elements in a hash table.","The process of probing for an empty slot in a hash table.","The process of swapping the values of two elements in a hash table.","A","Rehashing in hash tables is the process of creating a new, larger hash table and copying the elements from the old table to the new table."));
        questions.add(new Question("What is a perfect hash function?","A hash function that maps each key to a unique index in a hash table without any collisions.","A hash function that maps each key to a different index in a hash table with few collisions.","A hash function that maps each key to the same index in a hash table.","A hash function that maps each key to a random index in a hash table.","A","A perfect hash function is a hash function that maps each key to a unique index in a hash table without any collisions."));
        questions.add(new Question("What is a primary clustering in hash tables?","When long chains of elements form at a few indices in a hash table, leading to poor performance.","When the load factor of a hash table is too high.","When the load factor of a hash table is too low.","When all the elements in a hash table are perfectly distributed.","A","Primary clustering in hash tables occurs when long chains of elements form at a few indices, leading to poor performance."));
        questions.add(new Question("What is a secondary clustering in hash tables?","When the probing sequence of an open addressing scheme becomes too predictable, leading to poor performance.","When the load factor of a hash table is too high.","When the load factor of a hash table is too low.","When all the elements in a hash table are perfectly distributed.","A","Secondary clustering in hash tables occurs when the probing sequence of an open addressing scheme becomes too predictable, leading to poor performance."));
        questions.add(new Question("What is the time complexity of average-case operations in a hash table?","O(1)","O(n)","O(log n)","O(n log n)","A","The time complexity of average-case operations in a hash table is O(1)."));
        questions.add(new Question("What is the time complexity of worst-case operations in a hash table?","O(n)","O(1)","O(log n)","O(n log n)","A","The time complexity of worst-case operations in a hash table is O(n)."));
        questions.add(new Question("What is the space complexity of a hash table?","O(n)","O(1)","O(log n)","O(n log n)","A","The space complexity of a hash table is O(n)."));
        questions.add(new Question("What is the main advantage of hash tables over other data structures?","Constant-time insertion, deletion, and retrieval of values.","The ability to store data in a sorted order.","The ability to store arbitrary data types.","The ability to perform multiple operations in a single step.","A","The main advantage of hash tables over other data structures is constant-time insertion, deletion, and retrieval of values."));

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
        viewModel.setHashTablesQuestions(usedQuestions);


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
                viewModel.setHashTablesScore(String.valueOf(score));

                NavHostFragment.findNavController(HashTablesQuizFragment.this)
                        .navigate(R.id.action_hashTablesQuizFragment_to_hashTablesQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(HashTablesQuizFragment.this)
                        .navigate(R.id.action_hashTablesQuizFragment_to_quizMenuFragment);
            }
        });
    }
}