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
import com.example.buildingblocksteam1.databinding.FragmentHeapsFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeapsFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeapsFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentHeapsFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public HeapsFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeapsFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeapsFlashcardFragment newInstance(String param1, String param2) {
        HeapsFlashcardFragment fragment = new HeapsFlashcardFragment();
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
        binding = FragmentHeapsFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a heap?", "A heap is a binary tree-based data structure that is used to represent a priority queue."));
        flashcards.add(new Flashcards("What is a binary heap?", "A binary heap is a heap in which the tree is a complete binary tree and where the value of each node is greater than or equal to the values of its children."));
        flashcards.add(new Flashcards("What is a min heap?", "A min heap is a binary heap in which the value of each node is less than or equal to the values of its children."));
        flashcards.add(new Flashcards("What is a max heap?", "A max heap is a binary heap in which the value of each node is greater than or equal to the values of its children."));
        flashcards.add(new Flashcards("What is the heap property?", "The heap property is the property that in a binary heap, the value of each node is greater than or equal to the values of its children."));
        flashcards.add(new Flashcards("What is the root of a heap?", "The root of a heap is the node with the highest (in a max heap) or lowest (in a min heap) value."));
        flashcards.add(new Flashcards("What is the height of a heap?", "The height of a heap is the maximum number of edges in a path from the root to a leaf node."));
        flashcards.add(new Flashcards("What is the parent of a node in a heap?", "The parent of a node in a heap is the node in the position floor((i - 1) / 2), where i is the index of the node in the array representing the heap."));
        flashcards.add(new Flashcards("What is the left child of a node in a heap?", "The left child of a node in a heap is the node in the position 2i + 1, where i is the index of the node in the array representing the heap."));
        flashcards.add(new Flashcards("What is the right child of a node in a heap?", "The right child of a node in a heap is the node in the position 2i + 2, where i is the index of the node in the array representing the heap."));
        flashcards.add(new Flashcards("What is heapify?", "Heapify is the process of restoring the heap property in a binary heap."));
        flashcards.add(new Flashcards("What is heap sort?", "Heap sort is a sorting algorithm that uses a binary heap to sort an array."));
        flashcards.add(new Flashcards("What is the time complexity of heap sort?", "The time complexity of heap sort is O(n log n)."));
        flashcards.add(new Flashcards("What is heap insert?", "Heap insert is the process of adding a new element to a heap."));
        flashcards.add(new Flashcards("What is the time complexity of heap insert?", "The time complexity of heap insert is O(log n)."));
        flashcards.add(new Flashcards("What is heap delete?", "Heap delete is the process of removing the root element from a heap."));
        flashcards.add(new Flashcards("What is the time complexity of heap delete?", "The time complexity of heap delete is O(log n)."));
        flashcards.add(new Flashcards("What is the difference between a heap and a binary search tree?", "A heap is a binary tree-based data structure used to represent a priority queue, whereas a binary search tree is a binary tree-based data structure used for efficient searching and sorting."));
        flashcards.add(new Flashcards("What is a heap priority queue?", "A heap priority queue is a priority queue implemented using a heap."));
        flashcards.add(new Flashcards("What is a d-ary heap?", "A d-ary heap is a heap in which each node has at most d children."));
        flashcards.add(new Flashcards("What is a Fibonacci heap?", "A Fibonacci heap is a heap data structure that allows for efficient insertions, deletions, and find-min operations."));
        flashcards.add(new Flashcards("What is a binomial heap?", "A binomial heap is a heap data structure that is used to implement priority queues and offers faster insertions and deletions than a binary heap."));
        flashcards.add(new Flashcards("What is a pairing heap?", "A pairing heap is a heap data structure that is used to implement priority queues and offers faster insertions and deletions than a binary heap."));


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

                NavHostFragment.findNavController(HeapsFlashcardFragment.this)
                        .navigate(R.id.action_heapsFlashcardFragment_to_flashcardMenuFragment);
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