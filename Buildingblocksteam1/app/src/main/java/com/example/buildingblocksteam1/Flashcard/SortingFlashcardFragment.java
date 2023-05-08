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
import com.example.buildingblocksteam1.databinding.FragmentSortingFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SortingFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SortingFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentSortingFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public SortingFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SortingFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SortingFlashcardFragment newInstance(String param1, String param2) {
        SortingFlashcardFragment fragment = new SortingFlashcardFragment();
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
        binding = FragmentSortingFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a sorting algorithm?", "A sorting algorithm is an algorithm that arranges a list of elements into a specific order."));
        flashcards.add(new Flashcards("What is a stable sorting algorithm?", "A stable sorting algorithm maintains the relative order of equal elements in the input list after sorting."));
        flashcards.add(new Flashcards("What is an unstable sorting algorithm?", "An unstable sorting algorithm does not guarantee to maintain the relative order of equal elements in the input list after sorting."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of bubble sort?", "The worst-case time complexity of bubble sort is O(n^2)."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of selection sort?", "The worst-case time complexity of selection sort is O(n^2)."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of insertion sort?", "The worst-case time complexity of insertion sort is O(n^2)."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of merge sort?", "The worst-case time complexity of merge sort is O(n log n)."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of quicksort?", "The worst-case time complexity of quicksort is O(n^2), but it can be improved to O(n log n) with good pivot selection and partitioning."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of heapsort?", "The worst-case time complexity of heapsort is O(n log n)."));
        flashcards.add(new Flashcards("What is the worst-case time complexity of radix sort?", "The worst-case time complexity of radix sort is O(dn), where d is the number of digits in the largest element in the input list."));
        flashcards.add(new Flashcards("What is the best sorting algorithm for small lists?", "Insertion sort is often the best sorting algorithm for small lists because of its simplicity and low overhead."));
        flashcards.add(new Flashcards("What is the best sorting algorithm for large lists?", "Merge sort or heapsort are often the best sorting algorithms for large lists because of their O(n log n) time complexity."));
        flashcards.add(new Flashcards("What is an in-place sorting algorithm?", "An in-place sorting algorithm sorts the input list by rearranging the elements within the list without requiring additional space proportional to the size of the input list."));
        flashcards.add(new Flashcards("What is an out-of-place sorting algorithm?", "An out-of-place sorting algorithm sorts the input list by creating a new, sorted list that is separate from the original input list."));
        flashcards.add(new Flashcards("What is a sorting algorithm?", "A sorting algorithm is a method of arranging elements in a list or array in a specific order."));
        flashcards.add(new Flashcards("What is the time complexity of Bubble Sort?", "The time complexity of Bubble Sort is O(n^2)."));
        flashcards.add(new Flashcards("What is the time complexity of Selection Sort?", "The time complexity of Selection Sort is O(n^2)."));
        flashcards.add(new Flashcards("What is the time complexity of Insertion Sort?", "The time complexity of Insertion Sort is O(n^2)."));
        flashcards.add(new Flashcards("What is the time complexity of Merge Sort?", "The time complexity of Merge Sort is O(n log n)."));
        flashcards.add(new Flashcards("What is the time complexity of Quick Sort?", "The time complexity of Quick Sort is O(n log n) on average, but O(n^2) in the worst case."));
        flashcards.add(new Flashcards("What is the time complexity of Heap Sort?", "The time complexity of Heap Sort is O(n log n)."));
        flashcards.add(new Flashcards("What is the time complexity of Counting Sort?", "The time complexity of Counting Sort is O(n+k), where k is the range of the input."));
        flashcards.add(new Flashcards("What is the time complexity of Radix Sort?", "The time complexity of Radix Sort is O(d(n+k)), where d is the number of digits in the largest number and k is the range of the input."));


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

                NavHostFragment.findNavController(SortingFlashcardFragment.this)
                        .navigate(R.id.action_sortingFlashcardFragment_to_flashcardMenuFragment);
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