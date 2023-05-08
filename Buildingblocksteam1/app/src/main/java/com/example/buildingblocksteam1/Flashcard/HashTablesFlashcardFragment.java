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
import com.example.buildingblocksteam1.databinding.FragmentHashTablesFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HashTablesFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HashTablesFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentHashTablesFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public HashTablesFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HashTablesFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HashTablesFlashcardFragment newInstance(String param1, String param2) {
        HashTablesFlashcardFragment fragment = new HashTablesFlashcardFragment();
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
        binding = FragmentHashTablesFlashcardBinding.inflate(inflater, container, false);


        flashcards.add(new Flashcards("What is a hash table?", "A hash table is a data structure that maps keys to values using a hash function to compute an index into an array of buckets or slots."));
        flashcards.add(new Flashcards("What is a hash function?", "A hash function is a function that takes in a key and returns an index into an array of buckets or slots in a hash table."));
        flashcards.add(new Flashcards("What is collision resolution?", "Collision resolution is the process of dealing with two or more keys that map to the same index in a hash table."));
        flashcards.add(new Flashcards("What is chaining?", "Chaining is a collision resolution technique in which each bucket in a hash table contains a linked list of elements that hash to that bucket."));
        flashcards.add(new Flashcards("What is open addressing?", "Open addressing is a collision resolution technique in which each bucket in a hash table can hold only one element, and collisions are resolved by probing for an open bucket."));
        flashcards.add(new Flashcards("What is a load factor?", "The load factor of a hash table is the ratio of the number of elements stored in the table to the number of buckets."));
        flashcards.add(new Flashcards("What is rehashing?", "Rehashing is the process of increasing the size of a hash table and then copying all of the elements from the old table to the new table using a new hash function."));
        flashcards.add(new Flashcards("What is a perfect hash function?", "A perfect hash function is a hash function that maps each key to a unique index in a hash table with no collisions."));
        flashcards.add(new Flashcards("What is probing?", "Probing is the process of searching for an open slot in a hash table by examining other slots in the table."));
        flashcards.add(new Flashcards("What is linear probing?", "Linear probing is a probing technique in which the search for an open slot in a hash table proceeds sequentially through the table until an open slot is found."));
        flashcards.add(new Flashcards("What is quadratic probing?", "Quadratic probing is a probing technique in which the search for an open slot in a hash table proceeds by adding successive squares to the hash value until an open slot is found."));
        flashcards.add(new Flashcards("What is double hashing?", "Double hashing is a probing technique in which the search for an open slot in a hash table proceeds by hashing the key a second time with a different hash function and using the result to step through the table."));


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

                NavHostFragment.findNavController(HashTablesFlashcardFragment.this)
                        .navigate(R.id.action_hashTablesFlashcardFragment_to_flashcardMenuFragment);
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