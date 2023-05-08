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
import com.example.buildingblocksteam1.databinding.FragmentDivideAndConquerFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DivideAndConquerFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DivideAndConquerFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentDivideAndConquerFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public DivideAndConquerFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DivideAndConquerFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DivideAndConquerFlashcardFragment newInstance(String param1, String param2) {
        DivideAndConquerFlashcardFragment fragment = new DivideAndConquerFlashcardFragment();
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
        binding = FragmentDivideAndConquerFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is the divide and conquer algorithm?", "The divide and conquer algorithm is a problem-solving technique that involves breaking a problem down into smaller sub-problems, solving those sub-problems independently, and then combining their solutions to solve the original problem."));
        flashcards.add(new Flashcards("What are some common problems that can be solved using the divide and conquer algorithm?", "Problems that involve searching, sorting, merging, and analyzing data can often be solved using the divide and conquer algorithm."));
        flashcards.add(new Flashcards("What is the basic idea behind the divide and conquer algorithm?", "The basic idea behind the divide and conquer algorithm is to break a problem down into smaller sub-problems that are easier to solve, and then to combine the solutions to those sub-problems to solve the original problem."));
        flashcards.add(new Flashcards("What is the time complexity of the divide and conquer algorithm?", "The time complexity of the divide and conquer algorithm depends on the size of the problem and the cost of dividing and combining sub-problems. In general, it has a time complexity of O(n log n) for sorting and searching problems, and O(n^2) for some optimization and enumeration problems."));
        flashcards.add(new Flashcards("What are some common techniques for improving the performance of the divide and conquer algorithm?", "Some common techniques for improving the performance of the divide and conquer algorithm include: 1) using parallel processing to divide and conquer sub-problems concurrently, 2) using dynamic programming to avoid solving the same sub-problems repeatedly, and 3) using heuristics to guide the division and combination of sub-problems."));
        flashcards.add(new Flashcards("What are some drawbacks of using the divide and conquer algorithm?", "Some drawbacks of using the divide and conquer algorithm include: 1) the overhead of dividing and combining sub-problems, 2) the possibility of encountering numerical instabilities and round-off errors, and 3) the need to carefully choose the division and combination criteria to ensure correctness and efficiency."));
        flashcards.add(new Flashcards("What are some common applications of the divide and conquer algorithm?", "Some common applications of the divide and conquer algorithm include: 1) sorting and searching algorithms such as merge sort and quicksort, 2) numerical algorithms such as FFT and matrix multiplication, and 3) optimization algorithms such as branch and bound and gradient descent."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and dynamic programming?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while dynamic programming breaks a problem down into smaller sub-problems and reuses the solutions to those sub-problems to solve the original problem more efficiently."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and brute force?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while brute force algorithms try all possible solutions without any optimization or pruning."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and backtracking?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while backtracking algorithms explore all possible solutions and backtrack when a solution is found to be invalid or incomplete."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and greedy algorithms?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while greedy algorithms make locally optimal choices at each step to find a globally optimal solution."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and recursion?", "Divide and conquer algorithms often use recursion to divide a problem down into smaller sub-problems and solve those sub-problems independently, but recursion can be used for other types of algorithms as well."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and parallel algorithms?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while parallel algorithms use multiple processors or threads to solve sub-problems concurrently."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and map-reduce algorithms?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while map-reduce algorithms divide a large problem into many smaller sub-problems and solve them in parallel on a distributed system."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and dynamic programming?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while dynamic programming breaks a problem down into smaller sub-problems and reuses the solutions to those sub-problems to solve the original problem more efficiently."));
        flashcards.add(new Flashcards("What is the difference between divide and conquer and memoization?", "Divide and conquer algorithms break a problem down into smaller sub-problems and solve those sub-problems independently, while memoization is a technique for storing the solutions to sub-problems to avoid recomputing them."));


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

                NavHostFragment.findNavController(DivideAndConquerFlashcardFragment.this)
                        .navigate(R.id.action_divideAndConquerFlashcardFragment_to_flashcardMenuFragment);
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