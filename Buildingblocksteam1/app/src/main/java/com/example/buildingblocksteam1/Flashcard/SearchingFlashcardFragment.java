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
import com.example.buildingblocksteam1.databinding.FragmentSearchingFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchingFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchingFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentSearchingFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public SearchingFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchingFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchingFlashcardFragment newInstance(String param1, String param2) {
        SearchingFlashcardFragment fragment = new SearchingFlashcardFragment();
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
        binding = FragmentSearchingFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a linear search?", "A linear search is a searching algorithm that checks each element in a list or array until the target element is found or the end of the list is reached."));
        flashcards.add(new Flashcards("What is a binary search?", "A binary search is a searching algorithm that works by dividing a sorted array or list into two halves and searching the target element in either the left half or the right half, eliminating half of the remaining elements at each step."));
        flashcards.add(new Flashcards("What is a jump search?", "A jump search is a searching algorithm that works by jumping ahead a fixed number of steps in a sorted array or list until the target element is found or the end of the block is passed, then performing a linear search on the block."));
        flashcards.add(new Flashcards("What is an interpolation search?", "An interpolation search is a searching algorithm that works by estimating the position of the target element based on its value and the distribution of values in the array or list, then performing a binary search on the estimated position."));
        flashcards.add(new Flashcards("What is a breadth-first search (BFS)?", "A breadth-first search (BFS) is a searching algorithm that traverses a graph or tree by exploring all the vertices or nodes at the current level before moving to the next level."));
        flashcards.add(new Flashcards("What is a depth-first search (DFS)?", "A depth-first search (DFS) is a searching algorithm that traverses a graph or tree by exploring as far as possible along each branch before backtracking."));
        flashcards.add(new Flashcards("What is a heuristic search?", "A heuristic search is a searching algorithm that uses a heuristic function to evaluate the distance or cost from the current state to the goal state and guides the search towards the optimal solution."));
        flashcards.add(new Flashcards("What is an A* search?", "An A* search is a heuristic search algorithm that uses a combination of the actual cost from the start state and the heuristic cost to the goal state to guide the search towards the optimal solution."));
        flashcards.add(new Flashcards("What is a best-first search?", "A best-first search is a searching algorithm that selects the most promising node or vertex based on a heuristic function and expands it first."));
        flashcards.add(new Flashcards("What is a beam search?", "A beam search is a searching algorithm that expands only a fixed number of the most promising nodes or vertices at each level and discards the rest, reducing the memory requirements but sacrificing completeness and optimality."));
        flashcards.add(new Flashcards("What is an exponential search?", "An exponential search is an algorithm that performs a binary search on an exponentially increasing sequence of indices until a value greater than or equal to the target value is found, and then performs a binary search in the subarray between the previous and current indices to find the target value."));


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

                NavHostFragment.findNavController(SearchingFlashcardFragment.this)
                        .navigate(R.id.action_searchingFlashcardFragment_to_flashcardMenuFragment);
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