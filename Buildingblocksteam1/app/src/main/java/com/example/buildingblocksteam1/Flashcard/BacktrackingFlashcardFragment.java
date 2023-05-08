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
import com.example.buildingblocksteam1.databinding.FragmentBacktrackingFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BacktrackingFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BacktrackingFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentBacktrackingFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public BacktrackingFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BacktrackingFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BacktrackingFlashcardFragment newInstance(String param1, String param2) {
        BacktrackingFlashcardFragment fragment = new BacktrackingFlashcardFragment();
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
        binding = FragmentBacktrackingFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is backtracking?", "Backtracking is a general algorithmic technique that involves exploring all possible solutions to a problem by building and testing candidate solutions incrementally, and abandoning a candidate as soon as it is determined to be invalid."));
        flashcards.add(new Flashcards("What are some common problems that can be solved using backtracking?", "Problems that involve searching for a solution among a large number of possibilities, such as the traveling salesman problem, the Sudoku puzzle, and the N-queens problem, can often be solved using backtracking."));
        flashcards.add(new Flashcards("What is the basic idea behind the backtracking algorithm?", "The basic idea behind the backtracking algorithm is to recursively build a candidate solution incrementally, by choosing the next possible element from a set of choices, and then checking whether it satisfies the problem constraints. If the candidate solution does not satisfy the constraints, backtrack to the last decision point and try a different choice."));
        flashcards.add(new Flashcards("What are the two types of backtracking?", "The two types of backtracking are: 1) exhaustive backtracking, which involves generating all possible candidates and selecting the best one, and 2) selective backtracking, which involves generating and testing candidates one by one until a valid one is found."));
        flashcards.add(new Flashcards("What is the role of the pruning condition in backtracking?", "The pruning condition is a condition that allows the algorithm to avoid exploring parts of the solution space that cannot possibly lead to a valid solution, by checking whether the current candidate satisfies the constraints before continuing to build it further."));
        flashcards.add(new Flashcards("What is the time complexity of the backtracking algorithm?", "The time complexity of the backtracking algorithm depends on the size of the search space and the pruning condition used. In the worst case, it can be exponential in the size of the problem."));
        flashcards.add(new Flashcards("What is the difference between depth-first search and backtracking?", "Depth-first search is a general algorithmic technique that involves exploring a graph or tree by visiting each node in depth-first order. Backtracking is a specific instance of depth-first search that involves generating and testing candidate solutions to a problem by building them incrementally."));
        flashcards.add(new Flashcards("What is the role of the decision variable in backtracking?", "The decision variable is a variable that represents the current choice being made at each step of the backtracking algorithm. It is used to build the candidate solution incrementally, and to backtrack to the last decision point when a solution cannot be found."));
        flashcards.add(new Flashcards("What is the role of the solution vector in backtracking?", "The solution vector is a vector that stores the current candidate solution being built by the backtracking algorithm. It is updated at each step of the algorithm, and can be used to keep track of the best solution found so far."));
        flashcards.add(new Flashcards("What is the role of the search tree in backtracking?", "The search tree is a tree that represents the sequence of choices made by the backtracking algorithm. Each node in the tree represents a decision point in the algorithm, and each edge represents a possible choice that can be made at that decision point."));
        flashcards.add(new Flashcards("What is the role of the bounding function in backtracking?", "The bounding function is a function that computes an upper bound on the value of the objective function for a partial candidate solution. It is used to prune parts of the search space that cannot possibly lead to a better solution than the best one found so far."));
        flashcards.add(new Flashcards("What is the role of the feasibility function in backtracking?", "The feasibility function is a function that checks whether a partial candidate solution satisfies the constraints of the problem. It is used to prune parts of the search space that cannot possibly lead to a valid solution."));
        flashcards.add(new Flashcards("What is the role of the objective function in backtracking?", "The objective function is a function that computes a value that measures the quality of a candidate solution. It is used to select the best solution found so far, and to prune parts of the search space that cannot possibly lead to a better solution than the best one found so far."));
        flashcards.add(new Flashcards("What are some common techniques for improving the performance of backtracking algorithms?", "Some common techniques for improving the performance of backtracking algorithms include: 1) using a better bounding function to prune the search space more effectively, 2) using dynamic programming to avoid recomputing subproblems, and 3) using heuristic methods to guide the search towards more promising regions of the search space."));


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

                NavHostFragment.findNavController(BacktrackingFlashcardFragment.this)
                        .navigate(R.id.action_backtrackingFlashcardFragment_to_flashcardMenuFragment);
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