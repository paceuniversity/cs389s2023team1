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
import com.example.buildingblocksteam1.databinding.FragmentStacksFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StacksFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StacksFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentStacksFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public StacksFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StacksFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StacksFlashcardFragment newInstance(String param1, String param2) {
        StacksFlashcardFragment fragment = new StacksFlashcardFragment();
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
        binding = FragmentStacksFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a stack?", "A stack is a data structure that follows the Last-In-First-Out (LIFO) principle."));
        flashcards.add(new Flashcards("What are the two primary operations of a stack?", "The two primary operations of a stack are push and pop."));
        flashcards.add(new Flashcards("What is the push operation in a stack?", "The push operation adds an element to the top of the stack."));
        flashcards.add(new Flashcards("What is the pop operation in a stack?", "The pop operation removes the top element from the stack."));
        flashcards.add(new Flashcards("What is the peek operation in a stack?", "The peek operation returns the top element of the stack without removing it."));
        flashcards.add(new Flashcards("What happens when you try to pop an empty stack?", "Trying to pop an empty stack results in a stack underflow error."));
        flashcards.add(new Flashcards("What happens when you try to push an element onto a full stack?", "Trying to push an element onto a full stack results in a stack overflow error."));
        flashcards.add(new Flashcards("What is a common real-world analogy for a stack?", "A common real-world analogy for a stack is a stack of plates."));
        flashcards.add(new Flashcards("What is the time complexity of the push and pop operations in a stack?", "The time complexity of the push and pop operations in a stack is O(1)."));
        flashcards.add(new Flashcards("What is the space complexity of a stack?", "The space complexity of a stack is O(n), where n is the number of elements in the stack."));
        flashcards.add(new Flashcards("What is a stack trace?", "A stack trace is a report of the function call stack at a particular point in time during the execution of a program."));
        flashcards.add(new Flashcards("What is a call stack?", "A call stack is a stack data structure used by a program to keep track of the sequence of function calls."));
        flashcards.add(new Flashcards("What is a recursive function?", "A recursive function is a function that calls itself, either directly or indirectly."));
        flashcards.add(new Flashcards("What is tail recursion?", "Tail recursion is a recursive function call that appears at the end of a function and does not need to be saved on the call stack."));
        flashcards.add(new Flashcards("What is the benefit of using tail recursion?", "Using tail recursion can reduce the amount of memory needed for the call stack and prevent stack overflow errors."));
        flashcards.add(new Flashcards("What is the difference between a stack and a queue?", "A stack follows the Last-In-First-Out (LIFO) principle, while a queue follows the First-In-First-Out (FIFO) principle."));
        flashcards.add(new Flashcards("What is an application of stacks?", "An application of stacks is in the implementation of the undo feature in text editors and other software."));

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

                NavHostFragment.findNavController(StacksFlashcardFragment.this)
                        .navigate(R.id.action_stacksFlashcardFragment_to_flashcardMenuFragment);
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