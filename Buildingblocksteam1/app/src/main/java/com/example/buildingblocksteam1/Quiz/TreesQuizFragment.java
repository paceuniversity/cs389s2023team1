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
import com.example.buildingblocksteam1.databinding.FragmentTreesQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TreesQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TreesQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentTreesQuizBinding binding;
    private SharedViewModel viewModel;

    public TreesQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TreesQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TreesQuizFragment newInstance(String param1, String param2) {
        TreesQuizFragment fragment = new TreesQuizFragment();
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

        binding = FragmentTreesQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getTreesScore().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        questions.add(new Question("What is a binary tree?", "A tree data structure where each node has at most two children.", "A tree data structure where each node has at most three children.", "A tree data structure where each node has at most four children.", "A tree data structure where each node has at most five children.", "A", "A binary tree is a tree data structure where each node has at most two children."));
        questions.add(new Question("What is a binary search tree?", "A binary tree where the left subtree of a node contains only nodes with keys less than the node's key, and the right subtree contains only nodes with keys greater than the node's key.", "A binary tree where the left subtree of a node contains only nodes with keys greater than the node's key, and the right subtree contains only nodes with keys less than the node's key.", "A binary tree where each node has at most two children.", "A binary tree where the height of the left subtree is equal to the height of the right subtree.", "A", "A binary search tree is a binary tree where the left subtree of a node contains only nodes with keys less than the node's key, and the right subtree contains only nodes with keys greater than the node's key."));
        questions.add(new Question("What is a balanced binary tree?", "A binary tree where the height of the left and right subtrees of any node differ by at most one.", "A binary tree where the left subtree of a node contains only nodes with keys less than the node's key, and the right subtree contains only nodes with keys greater than the node's key.", "A binary tree where each node has at most two children.", "A binary tree where the height of the left subtree is equal to the height of the right subtree.", "A", "A balanced binary tree is a binary tree where the height of the left and right subtrees of any node differ by at most one."));
        questions.add(new Question("What is a complete binary tree?", "A binary tree where all levels except possibly the last are completely filled, and all nodes are as far left as possible.", "A binary tree where the left subtree of a node contains only nodes with keys less than the node's key, and the right subtree contains only nodes with keys greater than the node's key.", "A binary tree where each node has at most two children.", "A binary tree where the height of the left subtree is equal to the height of the right subtree.", "A", "A complete binary tree is a binary tree where all levels except possibly the last are completely filled, and all nodes are as far left as possible."));
        questions.add(new Question("What is the maximum number of children that a node can have in a binary tree?", "1", "2", "3", "4", "B", "A binary tree is a tree in which each node can have at most two children, so the maximum number of children a node can have is 2."));
        questions.add(new Question("What is a preorder traversal of a binary tree?", "Visiting the left subtree, then the right subtree, then the root.", "Visiting the root, then the left subtree, then the right subtree.", "Visiting the left subtree, then the root, then the right subtree.", "Visiting the right subtree, then the left subtree, then the root.", "B", "In a preorder traversal of a binary tree, we visit the root first, then recursively traverse the left subtree, and finally recursively traverse the right subtree."));
        questions.add(new Question("What is the height of a tree?", "The number of edges in the longest path from the root to a leaf node.", "The number of nodes in the tree.", "The number of edges in the shortest path from the root to a leaf node.", "The number of subtrees in the tree.", "A", "The height of a tree is defined as the number of edges in the longest path from the root to a leaf node."));
        questions.add(new Question("What is the time complexity of searching for a key in a binary search tree?", "O(log n)", "O(n)", "O(n^2)", "O(1)", "A", "The time complexity of searching for a key in a binary search tree is O(log n), where n is the number of nodes in the tree."));
        questions.add(new Question("What is a balanced binary tree?", "A binary tree in which the left subtree of a node contains only nodes with keys less than the node's key, and the right subtree contains only nodes with keys greater than the node's key.", "A binary tree in which the height of the left and right subtrees of every node differ by at most 1.", "A binary tree in which the root has no children.", "A binary tree in which all nodes have at most one child.", "B", "A balanced binary tree is a binary tree in which the height of the left and right subtrees of every node differ by at most 1."));
        questions.add(new Question("What is the time complexity of finding an element in a binary search tree?", "O(1)", "O(log n)", "O(n)", "O(n^2)", "B", "The time complexity of finding an element in a binary search tree is O(log n), where n is the number of nodes in the tree."));
        questions.add(new Question("What is a binary heap?", "A binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.", "A binary tree in which the key of each node is greater than or equal to the keys of its children.", "A complete binary tree in which every parent node has a value less than or equal to any of its children.", "A tree-like data structure in which each node has a key greater than or equal to its parent.", "C", "A binary heap is a complete binary tree in which every parent node has a value less than or equal to any of its children."));
        questions.add(new Question("What is a tree in data structures?", "A hierarchical data structure consisting of nodes connected by edges.", "A linear data structure consisting of nodes connected by pointers.", "A data structure that contains a collection of elements.", "A graph-like data structure consisting of nodes and edges.", "A", "A tree is a hierarchical data structure consisting of nodes connected by edges."));
        questions.add(new Question("What is an AVL tree?", "A balanced binary search tree where the height of the left and right subtrees of any node differ by at most one.", "A binary tree where the left subtree of a node contains only nodes with keys less than the node's key, and the right subtree contains only nodes with keys greater than the node's key.", "A binary tree where each node has at most two children.", "A binary tree where the height of the left subtree is equal to the height of the right subtree.", "A", "An AVL tree is a balanced binary search tree where the height of the left and right subtrees of any node differ by at most one."));
        questions.add(new Question("What is the maximum number of children a node can have in a binary tree?", "0", "1", "2", "3", "C", "A binary tree is a tree where each node has at most two children. Therefore, the maximum number of children a node can have in a binary tree is 2."));

        questions.add(new Question("What is the difference between a complete binary tree and a full binary tree?", "A complete binary tree has all levels filled, while a full binary tree has all nodes filled except for the last level.", "A complete binary tree has all nodes filled except for the last level, while a full binary tree has all levels filled.", "A complete binary tree has only one child for each node, while a full binary tree can have one or two children for each node.", "There is no difference between a complete binary tree and a full binary tree.", "A", "A complete binary tree has all levels filled, meaning that every level except possibly the last level is completely filled, while a full binary tree has all nodes filled except for the last level."));

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
        viewModel.setTreesQuestions(usedQuestions);


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
                viewModel.setTreesScore(String.valueOf(score));

                NavHostFragment.findNavController(TreesQuizFragment.this)
                        .navigate(R.id.action_treesQuizFragment_to_treesQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(TreesQuizFragment.this)
                        .navigate(R.id.action_treesQuizFragment_to_quizMenuFragment);
            }
        });
    }
}