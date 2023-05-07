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

        flashcards.add(new Flashcards("What is a linked list?", "A data structure consisting of a sequence of nodes, where each node contains a value and a reference (or 'pointer') to the next node in the sequence."));
        flashcards.add(new Flashcards("What is the difference between an array and a linked list?", "An array has a fixed size and stores its elements in contiguous memory locations, whereas a linked list can divideAndConquerally grow or shrink and stores its elements in non-contiguous memory locations."));
        flashcards.add(new Flashcards("What is a node in a linked list?", "A single element in a linked list, containing a value and a reference (or 'pointer') to the next node in the sequence."));
        flashcards.add(new Flashcards("What is a singly linked list?", "A linked list where each node has a reference to only the next node in the sequence."));
        flashcards.add(new Flashcards("What is a doubly linked list?", "A linked list where each node has references to both the next and previous nodes in the sequence."));
        flashcards.add(new Flashcards("What is a circular linked list?", "A linked list where the last node in the sequence has a reference to the first node (forming a circle), or where a singly linked list has its last node pointing back to the first node."));
        flashcards.add(new Flashcards("What is a linked list traversal?", "The process of visiting each node in a linked list in a specific order (e.g. starting from the first node and moving to the last node)."));
        flashcards.add(new Flashcards("What is a linked list insertion?", "The process of adding a new node to a linked list at a specific position (e.g. at the beginning, end, or middle of the sequence)."));
        flashcards.add(new Flashcards("What is a linked list deletion?", "The process of removing a node from a linked list at a specific position (e.g. at the beginning, end, or middle of the sequence)."));
        flashcards.add(new Flashcards("What are some advantages of using a linked list over an array?", "Linked lists can divideAndConquerally grow or shrink, insert or delete elements at constant time complexity (in certain cases), and use only the memory required for their elements (unlike divideAndConquer, which may have unused memory if their size is larger than the number of elements they store)."));
        flashcards.add(new Flashcards("What are some disadvantages of using a linked list over an array?", "Linked lists have slower random access time (since accessing an element in a linked list requires traversing the list from the beginning), and may use more memory overall due to the overhead of storing the references between nodes."));
        flashcards.add(new Flashcards("What is a linked list cycle?", "A situation where a linked list contains a cycle, or loop, where some node in the sequence points back to an earlier node (instead of pointing to the next node). This can cause problems in certain algorithms that traverse the list (such as infinite loops or incorrect results)."));
        flashcards.add(new Flashcards("What is a sentinel node in a linked list?", "A special node that is added to the beginning (or end) of a linked list to act as a 'dummy' node that simplifies certain operations (such as insertion and deletion at the beginning of the list). The sentinel node does not contain a value and its next (or prev) reference points to the first (or last) 'real' node in the sequence."));
        flashcards.add(new Flashcards("What is a skip list?", "A data structure that is similar to a linked list, but also includes 'levels' of pointers that allow for faster traversal and search operations. Skip lists are often used to implement efficient set and map data structures."));
        flashcards.add(new Flashcards("What is a self-referential structure?", "A data structure that contains a reference to itself (either directly or indirectly through other structures). Linked lists are an example of a self-referential structure, since each node contains a reference to another node (which may be the same node)."));
        flashcards.add(new Flashcards("What is a tail pointer?", "A pointer that points to the last node in a linked list, or NULL if the list is empty. A tail pointer can be used to optimize certain operations on a linked list (such as appending new nodes to the end of the list)."));
        flashcards.add(new Flashcards("What is a head pointer?", "A pointer that points to the first node in a linked list, or NULL if the list is empty. A head pointer can be used to traverse the list from beginning to end."));
        flashcards.add(new Flashcards("What is a null-terminated linked list?", "A linked list where the last node in the sequence has a null reference (i.e. points to NULL) instead of a reference to the next node. This is a common convention in C and C++ programming languages."));
        flashcards.add(new Flashcards("What is a sentinel-based linked list?", "A linked list that uses a sentinel node (see earlier card) to simplify certain operations. The sentinel node can be used to eliminate special cases when dealing with an empty list or the first/last node in the sequence."));
        flashcards.add(new Flashcards("What is the time complexity of searching for an element in a linked list?", "O(n), where n is the number of nodes in the list. This is because each node must be checked in order until the desired element is found (or the end of the list is reached)."));
        flashcards.add(new Flashcards("What is the time complexity of inserting an element at the beginning of a linked list?", "O(1), since the new node can be inserted directly at the beginning of the list by updating the head pointer (and possibly the tail pointer, if the list was empty)."));
        flashcards.add(new Flashcards("What is the time complexity of inserting an element at the end of a linked list?", "O(1) if a tail pointer is used, since the new node can be appended directly to the end of the list by updating the tail pointer. Otherwise, O(n), where n is the number of nodes in the list, since each node must be visited in order to find the last node in the sequence."));
        flashcards.add(new Flashcards("What is the time complexity of deleting an element from a linked list?", "O(n), where n is the number of nodes in the list (worst-case), since each node must be visited in order to find the node to be deleted. However, if the node to be deleted is known (e.g. by its index or value), the time complexity can be reduced to O(1) or O(n) in certain cases."));

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