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
import com.example.buildingblocksteam1.databinding.FragmentBruteForceFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BruteForceFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BruteForceFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentBruteForceFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public BruteForceFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BruteForceFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BruteForceFlashcardFragment newInstance(String param1, String param2) {
        BruteForceFlashcardFragment fragment = new BruteForceFlashcardFragment();
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
        binding = FragmentBruteForceFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a brute force algorithm?", "A brute force algorithm is a simple and straightforward approach to solving a problem by trying all possible solutions, without any optimization or pruning."));
        flashcards.add(new Flashcards("What are some common problems that can be solved using brute force?", "Problems that involve searching for a solution among a small number of possibilities, such as finding the maximum or minimum value in an array, can often be solved using brute force."));
        flashcards.add(new Flashcards("What is the basic idea behind the brute force algorithm?", "The basic idea behind the brute force algorithm is to generate all possible candidate solutions to a problem, and then to test each one to see whether it satisfies the problem constraints."));
        flashcards.add(new Flashcards("What is the time complexity of the brute force algorithm?", "The time complexity of the brute force algorithm depends on the size of the search space. In the worst case, it can be exponential in the size of the problem, which makes it impractical for large problems."));
        flashcards.add(new Flashcards("What are some common techniques for improving the performance of brute force algorithms?", "Some common techniques for improving the performance of brute force algorithms include: 1) using pruning conditions to avoid generating invalid candidates, and 2) using heuristics to guide the search towards more promising regions of the search space."));
        flashcards.add(new Flashcards("What are some drawbacks of using brute force algorithms?", "Some drawbacks of using brute force algorithms include: 1) their high time complexity for large problems, 2) their tendency to generate a large number of candidate solutions, and 3) their inability to handle problems with a large number of constraints."));
        flashcards.add(new Flashcards("What is the difference between exhaustive search and brute force?", "Exhaustive search is a general algorithmic technique that involves exploring all possible solutions to a problem, while brute force is a specific instance of exhaustive search that involves trying all possible solutions without any optimization or pruning."));
        flashcards.add(new Flashcards("What are some common applications of brute force algorithms?", "Some common applications of brute force algorithms include: 1) cracking passwords and encryption codes, 2) finding optimal solutions to small-scale optimization problems, and 3) testing whether a hypothesis or conjecture is true by exhaustive enumeration."));
        flashcards.add(new Flashcards("What is the difference between brute force and greedy algorithms?", "Brute force algorithms try all possible solutions without any optimization or pruning, while greedy algorithms make locally optimal choices at each step in the hope of finding a globally optimal solution."));
        flashcards.add(new Flashcards("What is the difference between brute force and dynamic programming?", "Brute force algorithms try all possible solutions without any optimization or pruning, while dynamic programming breaks a problem down into smaller subproblems and reuses the solutions to those subproblems to solve the original problem more efficiently."));
        flashcards.add(new Flashcards("What is the difference between brute force and divide-and-conquer?", "Brute force algorithms try all possible solutions without any optimization or pruning, while divide-and-conquer algorithms break a problem down into smaller subproblems that can be solved independently, and then combine the solutions to those subproblems to solve the original problem."));
        flashcards.add(new Flashcards("What is the difference between brute force and backtracking?", "Brute force algorithms try all possible solutions without any optimization or pruning, while backtracking algorithms incrementally build a candidate solution and backtrack when it is determined that the current path cannot lead to a valid solution."));
        flashcards.add(new Flashcards("What is the difference between brute force and branch and bound?", "Brute force algorithms try all possible solutions without any optimization or pruning, while branch and bound algorithms incrementally build a candidate solution and use lower bounds on the objective function to prune parts of the search space that cannot possibly lead to a better solution than the best one found so far."));


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

                NavHostFragment.findNavController(BruteForceFlashcardFragment.this)
                        .navigate(R.id.action_bruteForceFlashcardFragment_to_flashcardMenuFragment);
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