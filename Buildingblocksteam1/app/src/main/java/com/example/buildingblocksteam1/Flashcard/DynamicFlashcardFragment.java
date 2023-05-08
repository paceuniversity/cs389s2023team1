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
import com.example.buildingblocksteam1.databinding.FragmentDynamicFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DynamicFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentDynamicFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public DynamicFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DynamicFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DynamicFlashcardFragment newInstance(String param1, String param2) {
        DynamicFlashcardFragment fragment = new DynamicFlashcardFragment();
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
        binding = FragmentDynamicFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is dynamic programming?", "Dynamic programming is a technique for solving optimization problems by breaking them down into smaller sub-problems and storing the solutions to those sub-problems to avoid redundant computation."));
        flashcards.add(new Flashcards("What is the difference between dynamic programming and divide and conquer?", "Both dynamic programming and divide and conquer break a problem down into smaller sub-problems, but dynamic programming stores the solutions to sub-problems to avoid redundant computation, while divide and conquer solves the sub-problems independently."));
        flashcards.add(new Flashcards("What is an example of a problem that can be solved with dynamic programming?", "The longest common subsequence problem, which involves finding the longest subsequence that is common to two given sequences, can be solved using dynamic programming."));
        flashcards.add(new Flashcards("What is memoization?", "Memoization is a technique used in dynamic programming where the solutions to sub-problems are stored in a lookup table to avoid recomputing them."));
        flashcards.add(new Flashcards("What is the difference between top-down and bottom-up dynamic programming?", "Top-down dynamic programming involves solving the original problem by recursively solving smaller sub-problems and memoizing their solutions, while bottom-up dynamic programming involves solving sub-problems in order from smallest to largest and storing their solutions as they go."));
        flashcards.add(new Flashcards("What is the time complexity of dynamic programming algorithms?", "The time complexity of dynamic programming algorithms is typically polynomial, although it can depend on the specific problem being solved."));
        flashcards.add(new Flashcards("What is the principle of optimality?", "The principle of optimality states that an optimal solution to a problem can be obtained by combining optimal solutions to its sub-problems."));
        flashcards.add(new Flashcards("What is the difference between dynamic programming and greedy algorithms?", "Dynamic programming breaks a problem down into smaller sub-problems and stores the solutions to those sub-problems, while greedy algorithms make locally optimal choices at each step to find a globally optimal solution."));
        flashcards.add(new Flashcards("What is the difference between dynamic programming and backtracking algorithms?", "Dynamic programming stores the solutions to sub-problems to avoid redundant computation, while backtracking explores all possible solutions and prunes the search tree when a solution is found to be invalid or incomplete."));
        flashcards.add(new Flashcards("What is the difference between dynamic programming and memoization?", "Dynamic programming breaks a problem down into smaller sub-problems and stores the solutions to those sub-problems, while memoization is a technique for storing the solutions to sub-problems to avoid recomputing them."));


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

                NavHostFragment.findNavController(DynamicFlashcardFragment.this)
                        .navigate(R.id.action_dynamicFlashcardFragment_to_flashcardMenuFragment);
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