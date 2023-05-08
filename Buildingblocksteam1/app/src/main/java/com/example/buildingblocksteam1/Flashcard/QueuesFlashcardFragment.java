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
import com.example.buildingblocksteam1.databinding.FragmentQueuesFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QueuesFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QueuesFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentQueuesFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public QueuesFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QueuesFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QueuesFlashcardFragment newInstance(String param1, String param2) {
        QueuesFlashcardFragment fragment = new QueuesFlashcardFragment();
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
        binding = FragmentQueuesFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a queue?", "A queue is a linear data structure that stores elements in a first-in, first-out (FIFO) manner."));
        flashcards.add(new Flashcards("What are the two primary operations of a queue?", "The two primary operations of a queue are enqueue (adding an element to the back of the queue) and dequeue (removing an element from the front of the queue)."));
        flashcards.add(new Flashcards("What is a circular queue?", "A circular queue is a variant of a queue in which the last element points to the first element, enabling the queue to be used in a circular manner."));
        flashcards.add(new Flashcards("What is a priority queue?", "A priority queue is a type of queue that assigns a priority to each element and removes elements from the queue based on their priority."));
        flashcards.add(new Flashcards("What are the two types of priority queues?", "The two types of priority queues are min priority queue (the element with the smallest priority value is removed first) and max priority queue (the element with the largest priority value is removed first)."));
        flashcards.add(new Flashcards("What is a double-ended queue (deque)?", "A double-ended queue (deque) is a linear data structure that allows for insertion and removal of elements from both the front and the back of the queue."));
        flashcards.add(new Flashcards("What is a blocking queue?", "A blocking queue is a queue that blocks when attempting to dequeue an element if the queue is empty, or when attempting to enqueue an element if the queue is full."));
        flashcards.add(new Flashcards("What is a concurrent queue?", "A concurrent queue is a thread-safe queue that can be accessed by multiple threads simultaneously."));
        flashcards.add(new Flashcards("What is a bounded queue?", "A bounded queue is a queue with a limited size that cannot be exceeded."));
        flashcards.add(new Flashcards("What is a priority queue?", "A priority queue is a type of queue that assigns a priority to each element and removes elements from the queue based on their priority."));
        flashcards.add(new Flashcards("What are the two types of priority queues?", "The two types of priority queues are min priority queue (the element with the smallest priority value is removed first) and max priority queue (the element with the largest priority value is removed first)."));
        flashcards.add(new Flashcards("What is a blocking queue?", "A blocking queue is a queue that blocks when attempting to dequeue an element if the queue is empty, or when attempting to enqueue an element if the queue is full."));
         flashcards.add(new Flashcards("What is a priority blocking queue?", "A priority blocking queue is a priority queue that blocks when attempting to dequeue an element if the queue is empty, or when attempting to enqueue an element if the queue is full."));
        flashcards.add(new Flashcards("What is a dequeuing strategy?", "A dequeuing strategy is a set of rules or algorithms used to determine which element should be dequeued from a queue or priority queue."));
        flashcards.add(new Flashcards("What is a double-ended priority queue?", "A double-ended priority queue is a data structure that combines the features of a priority queue and a double-ended queue, allowing elements to be inserted and removed from both ends of the queue and prioritized based on a given priority value."));


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

                NavHostFragment.findNavController(QueuesFlashcardFragment.this)
                        .navigate(R.id.action_queuesFlashcardFragment_to_flashcardMenuFragment);
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