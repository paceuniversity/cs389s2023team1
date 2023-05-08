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
import com.example.buildingblocksteam1.databinding.FragmentArraysFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArraysFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArraysFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentArraysFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public ArraysFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArraysFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArraysFlashcardFragment newInstance(String param1, String param2) {
        ArraysFlashcardFragment fragment = new ArraysFlashcardFragment();
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
        binding = FragmentArraysFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is an array list?", "A data structure that stores a collection of elements in contiguous memory locations, similar to an array. However, an array list can dynamically resize itself (i.e. grow or shrink) as elements are added or removed."));
        flashcards.add(new Flashcards("What is the difference between an array and an array list?", "An array has a fixed size, which is determined when it is created and cannot be changed. An array list, on the other hand, can grow or shrink dynamically as elements are added or removed."));
        flashcards.add(new Flashcards("What is the time complexity of accessing an element in an array list?", "O(1), since elements are stored in contiguous memory locations and can be accessed directly using an index."));
        flashcards.add(new Flashcards("What is the time complexity of inserting an element at the beginning of an array list?", "O(n), where n is the number of elements in the list, since all existing elements must be shifted one position to make room for the new element."));
        flashcards.add(new Flashcards("What is the time complexity of inserting an element at the end of an array list?", "O(1) on average, since the array list can be resized if necessary to accommodate the new element. However, in the worst-case scenario (i.e. when the array is full), the time complexity can be O(n), where n is the number of elements in the list, since all existing elements must be copied to a new, larger array."));
        flashcards.add(new Flashcards("What is the time complexity of deleting an element from an array list?", "O(n), where n is the number of elements in the list, since all existing elements after the deleted element must be shifted one position to fill the gap left by the deleted element."));
        flashcards.add(new Flashcards("What is the capacity of an array list?", "The maximum number of elements that an array list can store before it needs to be resized. The capacity is typically greater than or equal to the number of elements in the list."));
        flashcards.add(new Flashcards("What is the load factor of an array list?", "The ratio of the number of elements in the list to the capacity of the list. The load factor is used to determine when the array list needs to be resized to accommodate additional elements."));
        flashcards.add(new Flashcards("What is the amortized time complexity of appending n elements to an array list?", "O(n), since each element can be appended in O(1) time on average (assuming a load factor less than 1), and the array list may need to be resized at most O(log n) times."));
        flashcards.add(new Flashcards("What is the advantage of using an array list over a linked list?", "Array lists offer constant-time random access to elements (i.e. accessing elements by index), whereas linked lists require O(n) time to access an element at a specific index."));
        flashcards.add(new Flashcards("What is the disadvantage of using an array list over a linked list?", "Inserting or deleting an element in the middle of an array list requires shifting all existing elements to fill the gap, which can be O(n) time-consuming. Linked lists, on the other hand, can insert or delete elements in constant time (assuming the position of the element is known)."));
        flashcards.add(new Flashcards("What is the initial capacity of an array list?", "The initial capacity is the number of elements that an array list can store before it needs to be resized. The default initial capacity is 10, but it can be specified when creating an array list."));
        flashcards.add(new Flashcards("What is the difference between the size and the capacity of an array list?", "The size of an array list is the number of elements that it currently contains, whereas the capacity is the maximum number of elements that it can hold before it needs to be resized."));
        flashcards.add(new Flashcards("What is the time complexity of searching for an element in an array list?", "O(n), since all elements must be checked in the worst case."));
        flashcards.add(new Flashcards("What is the time complexity of sorting an array list?", "O(n log n), using most standard sorting algorithms such as quicksort, mergesort, or heapsort."));
        flashcards.add(new Flashcards("What is the time complexity of iterating over all elements in an array list using a for-each loop?", "O(n), since each element is visited once."));
        flashcards.add(new Flashcards("What is the difference between an iterator and a list iterator?", "An iterator is a Java interface that provides a way to access elements in a collection one by one, and can only move forward. A list iterator is a Java interface that extends the iterator interface and provides additional methods for bidirectional traversal (i.e. moving both forward and backward)."));
        flashcards.add(new Flashcards("What is the time complexity of adding n elements to the end of an array list using the addAll() method?", "O(n), assuming the array list has enough capacity to accommodate all elements. If the array list needs to be resized, the time complexity can be O(n log n), as each resize operation takes O(n) time."));



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

                NavHostFragment.findNavController(ArraysFlashcardFragment.this)
                        .navigate(R.id.action_arraysFlashcardFragment_to_flashcardMenuFragment);
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