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
import com.example.buildingblocksteam1.databinding.FragmentHeapsQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeapsQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeapsQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentHeapsQuizBinding binding;
    private SharedViewModel viewModel;

    public HeapsQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeapsQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeapsQuizFragment newInstance(String param1, String param2) {
        HeapsQuizFragment fragment = new HeapsQuizFragment();
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

        binding = FragmentHeapsQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getHeapsScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is a heap?", "A data structure that maintains a set of elements in a sorted order.", "A data structure that maintains a set of elements in a random order.", "A data structure that maintains a set of elements in a LIFO order.", "A data structure that maintains a set of elements in a FIFO order.", "A", "A heap is a data structure that maintains a set of elements in a sorted order."));
        questions.add(new Question("What is a max-heap?", "A heap where the largest element is at the root.", "A heap where the smallest element is at the root.", "A heap where the elements are in a random order.", "A heap where the elements are in a LIFO order.", "A", "A max-heap is a heap where the largest element is at the root."));
        questions.add(new Question("What is a min-heap?", "A heap where the smallest element is at the root.", "A heap where the largest element is at the root.", "A heap where the elements are in a random order.", "A heap where the elements are in a LIFO order.", "A", "A min-heap is a heap where the smallest element is at the root."));
        questions.add(new Question("What is the height of a complete binary tree with N nodes?", "log N", "N", "2N", "N/2", "log N", "The height of a complete binary tree with N nodes is log N."));
        questions.add(new Question("What is the height of a binary heap with N elements?", "log N", "N", "2N", "N/2", "log N", "The height of a binary heap with N elements is log N."));
        questions.add(new Question("Which of the following operations is not supported by a heap?", "Insertion of a new element.", "Deletion of the minimum element.", "Deletion of the maximum element.", "Updating an existing element.", "D", "Updating an existing element is not supported by a heap. A heap only allows for insertions and deletions of elements."));
        questions.add(new Question("What is the time complexity to insert a new element into a binary heap with N elements?", "O(1)", "O(log N)", "O(N)", "O(N log N)", "B", "Inserting a new element into a binary heap with N elements has a time complexity of O(log N)."));
        questions.add(new Question("What is the time complexity to find the minimum element in a min-heap with N elements?", "O(1)", "O(log N)", "O(N)", "O(N log N)", "A", "Finding the minimum element in a min-heap with N elements has a time complexity of O(1), as the minimum element is always at the root of the heap."));
        questions.add(new Question("What is the time complexity to find the maximum element in a max-heap with N elements?", "O(1)", "O(log N)", "O(N)", "O(N log N)", "A", "Finding the maximum element in a max-heap with N elements has a time complexity of O(1), as the maximum element is always at the root of the heap."));
        questions.add(new Question("What is the time complexity to delete the minimum element from a min-heap with N elements?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "Deleting the minimum element from a min-heap with N elements has a time complexity of O(log N)."));
        questions.add(new Question("What is the time complexity to delete the maximum element from a max-heap with N elements?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "Deleting the maximum element from a max-heap with N elements has a time complexity of O(log N)."));
        questions.add(new Question("What is a heapify operation?", "A procedure to construct a heap from a set of unordered elements.", "A procedure to delete an element from a heap.", "A procedure to search for a specific element in a heap.", "A procedure to insert a new element into a heap.", "A", "A heapify operation is a procedure to construct a heap from a set of unordered elements."));
        questions.add(new Question("What is the time complexity of the heapify operation to build a heap from N elements?", "O(N)", "O(N log N)", "O(log N)", "O(N^2)", "B", "The time complexity of the heapify operation to build a heap from N elements is O(N log N)."));
        questions.add(new Question("What is the time complexity of the heapsort algorithm?", "O(N)", "O(N log N)", "O(log N)", "O(N^2)", "B", "The time complexity of the heapsort algorithm is O(N log N)."));
        questions.add(new Question("What is the space complexity of the heapsort algorithm?", "O(1)", "O(N)", "O(log N)", "O(N log N)", "A", "The space complexity of the heapsort algorithm is O(1), as it can be done in-place."));
        questions.add(new Question("What is a binary heap?", "A heap where each node has at most two children.", "A heap where each node has at most one child.", "A heap where each node has an arbitrary number of children.", "A heap where each node has three children.", "A", "A binary heap is a heap where each node has at most two children."));
        questions.add(new Question("What is a d-ary heap?", "A heap where each node has at most d children.", "A heap where each node has at most d-1 children.", "A heap where each node has at most d+1 children.", "A heap where each node has an arbitrary number of children.", "A", "A d-ary heap is a heap where each node has at most d children."));
        questions.add(new Question("What is the advantage of using a d-ary heap over a binary heap?", "A d-ary heap has a smaller height for a given number of elements.", "A d-ary heap has a larger height for a given number of elements.", "A d-ary heap has a faster insert operation than a binary heap.", "A d-ary heap has a faster delete operation than a binary heap.", "A", "The advantage of using a d-ary heap over a binary heap is that a d-ary heap has a smaller height for a given number of elements."));
        questions.add(new Question("What is a Fibonacci heap?", "A heap that is used for computing Fibonacci numbers.", "A heap where each node has at most two children.", "A heap that has a constant time complexity for decrease-key operations.", "A heap that uses a Fibonacci sequence to determine its structure.", "C", "A Fibonacci heap is a heap that has a constant time complexity for decrease-key operations."));
        questions.add(new Question("What is a binomial heap?", "A heap where each node has at most two children.", "A heap where each node has an arbitrary number of children.", "A heap that is represented as a set of binary trees.", "A heap where the keys are represented as binary numbers.", "C", "A binomial heap is a heap that is represented as a set of binary trees."));
        questions.add(new Question("What is the time complexity of the merge operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the merge operation for binomial heaps is O(1)."));
        questions.add(new Question("What is a leftist heap?", "A heap that is used for computing left rotations.", "A heap where the left subtree is always taller than the right subtree.", "A heap that always stores the minimum element at the leftmost node.", "A heap that is represented as a binary tree.", "B", "A leftist heap is a heap where the left subtree is always taller than the right subtree."));
        questions.add(new Question("What is the time complexity of the insert operation for leftist heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for leftist heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for leftist heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for leftist heaps is O(log N)."));
        questions.add(new Question("What is a skew heap?", "A heap where each node has at most two children.", "A heap where the left subtree is always taller than the right subtree.", "A heap that always stores the minimum element at the leftmost node.", "A heap that uses right rotations instead of left rotations.", "D", "A skew heap is a heap that uses right rotations instead of left rotations."));
        questions.add(new Question("What is the time complexity of the insert operation for skew heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for skew heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for skew heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for skew heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for skew heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for skew heaps is O(log N)."));
        questions.add(new Question("What is a pairing heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap that is used for computing pairs of elements.", "C", "A pairing heap is a heap that uses a pairing technique to combine nodes."));
        questions.add(new Question("What is the time complexity of the insert operation for pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for pairing heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for pairing heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the merge operation for pairing heaps is O(1)."));
        questions.add(new Question("What is a rank-pairing heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap where nodes are ordered by rank and stored in a doubly-linked list.", "D", "A rank-pairing heap is a heap where nodes are ordered by rank and stored in a doubly-linked list."));
        questions.add(new Question("What is the time complexity of the insert operation for rank-pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for rank-pairing heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for rank-pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for rank-pairing heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for rank-pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for rank-pairing heaps is O(log N)."));
        questions.add(new Question("What is a radix heap?", "A heap where nodes are ordered by rank and stored in a doubly-linked list.", "A heap where the keys are represented as binary numbers.", "A heap that uses a radix sort to order the elements.", "A heap where the keys are represented as decimal numbers.", "B", "A radix heap is a heap where the keys are represented as binary numbers."));
        questions.add(new Question("What is the time complexity of the insert operation for radix heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for radix heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for radix heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "C", "The time complexity of the delete-min operation for radix heaps is O(N log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for radix heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "B", "The time complexity of the merge operation for radix heaps is O(N)."));
        questions.add(new Question("What is a binomial heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap where the keys are represented as binary numbers.", "B", "A binomial heap is a heap that is represented as a binary tree."));
        questions.add(new Question("What is the time complexity of the insert operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the insert operation for binomial heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "B", "The time complexity of the delete-min operation for binomial heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for binomial heaps is O(log N)."));
        questions.add(new Question("What is a Fibonacci heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap that uses Fibonacci numbers to balance the tree.", "D", "A Fibonacci heap is a heap that uses Fibonacci numbers to balance the tree."));
        questions.add(new Question("What is the time complexity of the insert operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for Fibonacci heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for Fibonacci heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the decrease-key operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the decrease-key operation for Fibonacci heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the merge operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the merge operation for Fibonacci heaps is O(1)."));
        questions.add(new Question("What is a skew heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap that has the property that the left subtree is always larger than the right subtree.", "B", "A skew heap is a heap that is represented as a binary tree."));
        questions.add(new Question("What is the time complexity of the merge operation for radix heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "B", "The time complexity of the merge operation for radix heaps is O(N)."));
        questions.add(new Question("What is a binomial heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap where the keys are represented as binary numbers.", "B", "A binomial heap is a heap that is represented as a binary tree."));
        questions.add(new Question("What is the time complexity of the insert operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the insert operation for binomial heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "B", "The time complexity of the delete-min operation for binomial heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for binomial heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for binomial heaps is O(log N)."));
        questions.add(new Question("What is a Fibonacci heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap that uses Fibonacci numbers to balance the tree.", "D", "A Fibonacci heap is a heap that uses Fibonacci numbers to balance the tree."));
        questions.add(new Question("What is the time complexity of the insert operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for Fibonacci heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for Fibonacci heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the decrease-key operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the decrease-key operation for Fibonacci heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the merge operation for Fibonacci heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the merge operation for Fibonacci heaps is O(1)."));
        questions.add(new Question("What is a skew heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap that has the property that the left subtree is always larger than the right subtree.", "B", "A skew heap is a heap that is represented as a binary tree."));
        questions.add(new Question("What is the time complexity of the insert operation for skew heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the insert operation for skew heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for skew heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for skew heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for skew heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for skew heaps is O(log N)."));
        questions.add(new Question("What is a pairing heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap where the keys are represented as binary numbers.", "C", "A pairing heap is a heap that uses a pairing technique to combine nodes."));
        questions.add(new Question("What is the time complexity of the insert operation for pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for pairing heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for pairing heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for pairing heaps is O(log N)."));
        questions.add(new Question("What is a rank-pairing heap?", "A heap where each node has at most two children.", "A heap that is represented as a binary tree.", "A heap that uses a pairing technique to combine nodes.", "A heap where each node has a rank that is equal to the length of its right spine.", "D", "A rank-pairing heap is a heap where each node has a rank that is equal to the length of its right spine."));
        questions.add(new Question("What is the time complexity of the insert operation for rank-pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "D", "The time complexity of the insert operation for rank-pairing heaps is O(1)."));
        questions.add(new Question("What is the time complexity of the delete-min operation for rank-pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the delete-min operation for rank-pairing heaps is O(log N)."));
        questions.add(new Question("What is the time complexity of the merge operation for rank-pairing heaps?", "O(log N)", "O(N)", "O(N log N)", "O(1)", "A", "The time complexity of the merge operation for rank-pairing heaps is O(log N)."));

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
        viewModel.setHeapsQuestions(usedQuestions);


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
                viewModel.setHeapsScore(String.valueOf(score));

                NavHostFragment.findNavController(HeapsQuizFragment.this)
                        .navigate(R.id.action_heapsQuizFragment_to_heapsQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(HeapsQuizFragment.this)
                        .navigate(R.id.action_heapsQuizFragment_to_quizMenuFragment);
            }
        });
    }
}