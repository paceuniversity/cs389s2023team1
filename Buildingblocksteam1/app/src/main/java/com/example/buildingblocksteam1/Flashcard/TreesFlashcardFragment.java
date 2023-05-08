package com.example.buildingblocksteam1.Flashcard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentTreesFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TreesFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TreesFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentTreesFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public TreesFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TreesFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TreesFlashcardFragment newInstance(String param1, String param2) {
        TreesFlashcardFragment fragment = new TreesFlashcardFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTreesFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a tree data structure?", "A tree is a hierarchical data structure consisting of nodes connected by edges."));
        flashcards.add(new Flashcards("What is a node in a tree?", "A node in a tree represents an element and contains a value and zero or more child nodes."));
        flashcards.add(new Flashcards("What is the root of a tree?", "The root of a tree is the topmost node and has no parent nodes."));
        flashcards.add(new Flashcards("What is a leaf node in a tree?", "A leaf node in a tree is a node with no child nodes."));
        flashcards.add(new Flashcards("What is a binary tree?", "A binary tree is a tree data structure in which each node has at most two children."));
        flashcards.add(new Flashcards("What is a binary search tree?", "A binary search tree is a binary tree in which the left subtree of a node contains only values less than the node's value, and the right subtree contains only values greater than the node's value."));
        flashcards.add(new Flashcards("What is tree traversal?", "Tree traversal is the process of visiting every node in a tree data structure."));
        flashcards.add(new Flashcards("What is inorder traversal?", "Inorder traversal is a type of tree traversal that visits the left subtree, then the current node, and then the right subtree."));
        flashcards.add(new Flashcards("What is preorder traversal?", "Preorder traversal is a type of tree traversal that visits the current node, then the left subtree, and then the right subtree."));
        flashcards.add(new Flashcards("What is postorder traversal?", "Postorder traversal is a type of tree traversal that visits the left subtree, then the right subtree, and then the current node."));
        flashcards.add(new Flashcards("What is a tree?", "A tree is a widely used abstract data type that simulates a hierarchical tree structure, with a set of linked nodes."));
        flashcards.add(new Flashcards("What is a balanced tree?", "A balanced tree is a tree data structure in which the difference between the heights of the left and right subtrees of any node is not greater than a certain value."));
        flashcards.add(new Flashcards("What is a self-balancing binary search tree?", "A self-balancing binary search tree is a binary search tree that automatically keeps itself balanced by performing rotations or other operations."));
        flashcards.add(new Flashcards("What is a B-tree?", "A B-tree is a balanced tree data structure designed to work well on disk or other direct-access storage devices."));
        flashcards.add(new Flashcards("What is a trie?", "A trie is a tree data structure used to store a set of strings or associative arrays, where each node represents a common prefix of some set of strings."));
        flashcards.add(new Flashcards("What is a heap?", "A heap is a specialized tree-based data structure that satisfies the heap property: if A is a parent node of B, then the key (the value) of node A is ordered with respect to the key of node B with the same ordering applying across the entire heap."));
        flashcards.add(new Flashcards("What is a max-heap?", "A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node."));
        flashcards.add(new Flashcards("What is a min-heap?", "A min-heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node."));




        TextView text = binding.text;
        Button flashcard = binding.buttonFlashcard;
        text.setText("1/" + flashcards.size());
        counter = 1;
        flashcard.setText(flashcards.get(counter - 1).getFrontSide());


        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFlashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button flashcard = binding.buttonFlashcard;
                if (side == false) {
                    flashcard.setText(flashcards.get(counter - 1).getBackSide());
                    side = true;
                }
                else {
                    flashcard.setText(flashcards.get(counter - 1).getFrontSide());
                    side = false;
                }
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(TreesFlashcardFragment.this)
                        .navigate(R.id.action_treesFlashcardFragment_to_flashcardMenuFragment);
            }
        });

        binding.backArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button flashcard = binding.buttonFlashcard;
                TextView text = binding.text;
                if (counter > 1) {
                    counter--;
                    side = false;
                    flashcard.setText(flashcards.get(counter - 1).getFrontSide());
                    text.setText("" + counter + "/" + flashcards.size());
                }

            }
        });

        binding.backArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button flashcard = binding.buttonFlashcard;
                TextView text = binding.text;
                if (counter < flashcards.size()) {
                    counter++;
                    side = false;
                    flashcard.setText(flashcards.get(counter - 1).getFrontSide());
                    text.setText("" + counter + "/" + flashcards.size());
                }

            }
        });
    }
}