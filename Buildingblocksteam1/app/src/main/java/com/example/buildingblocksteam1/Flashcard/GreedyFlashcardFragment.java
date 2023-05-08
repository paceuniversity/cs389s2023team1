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
import com.example.buildingblocksteam1.databinding.FragmentGreedyFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GreedyFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GreedyFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentGreedyFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public GreedyFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GreedyFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GreedyFlashcardFragment newInstance(String param1, String param2) {
        GreedyFlashcardFragment fragment = new GreedyFlashcardFragment();
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
        binding = FragmentGreedyFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a greedy algorithm?", "A greedy algorithm is an algorithmic paradigm that follows the problem-solving heuristic of making the locally optimal choice at each stage with the hope of finding a global optimum."));
        flashcards.add(new Flashcards("What is the coin change problem?", "The coin change problem is a classic problem in computer science that asks how many ways there are to make change for a given amount of money using a given set of coins."));
        flashcards.add(new Flashcards("What is the activity selection problem?", "The activity selection problem is a classic problem in computer science that asks how to schedule a set of activities, each with a start time and an end time, so that as many activities as possible can be performed."));
        flashcards.add(new Flashcards("What is the Huffman coding algorithm?", "The Huffman coding algorithm is a compression algorithm that assigns variable-length codes to each symbol in a given set of symbols, with the goal of minimizing the average length of the code."));
        flashcards.add(new Flashcards("What is the Kruskal's algorithm?", "Kruskal's algorithm is a minimum spanning tree algorithm that finds the minimum spanning tree for a connected weighted graph. It operates by sorting the edges by weight and adding them one at a time, while avoiding cycles."));
        flashcards.add(new Flashcards("What is the Prim's algorithm?", "Prim's algorithm is a minimum spanning tree algorithm that finds the minimum spanning tree for a connected weighted graph. It operates by starting with a single vertex and repeatedly adding the cheapest edge that connects an already visited vertex to an unvisited vertex."));
        flashcards.add(new Flashcards("What is the interval scheduling problem?", "The interval scheduling problem is a classic problem in computer science that asks how to schedule a set of intervals, each with a start time and an end time, so that as many intervals as possible can be performed without overlapping."));
        flashcards.add(new Flashcards("What is the knapsack problem?", "The knapsack problem is a classic problem in computer science that asks how to maximize the value of items that can be placed in a knapsack with a limited weight capacity."));
        flashcards.add(new Flashcards("What is the job sequencing problem?", "The job sequencing problem is a classic problem in computer science that asks how to schedule a set of jobs, each with a deadline and a profit, so that the total profit is maximized."));
        flashcards.add(new Flashcards("What is the Dijkstra's algorithm?", "Dijkstra's algorithm is a shortest path algorithm that finds the shortest path between a given source vertex and all other vertices in a weighted graph. It operates by iteratively selecting the vertex with the smallest tentative distance and relaxing its neighboring vertices."));
        flashcards.add(new Flashcards("What is the fractional knapsack problem?", "The fractional knapsack problem is a variation of the knapsack problem where items can be taken in fractional amounts, with the goal of maximizing the total value of items taken while staying within the weight capacity of the knapsack."));
        flashcards.add(new Flashcards("What is the minimum cost spanning tree problem?", "The minimum cost spanning tree problem is a classic problem in computer science that asks how to find a spanning tree of a connected, weighted graph that has the minimum possible total edge weight."));
        flashcards.add(new Flashcards("What is the set cover problem?", "The set cover problem is a classic problem in computer science that asks how to cover a given set of elements with a minimum number of sets."));
        flashcards.add(new Flashcards("What is the traveling salesman problem?", "The traveling salesman problem is a classic problem in computer science that asks how to find the shortest possible route that visits a given set of cities and returns to the starting city."));
        flashcards.add(new Flashcards("What is the activity scheduling problem?", "The activity scheduling problem is a classic problem in computer science that asks how to schedule a set of activities, each with a start time and an end time, so that the maximum number of activities can be performed without overlapping."));
        flashcards.add(new Flashcards("What is the bin packing problem?", "The bin packing problem is a classic problem in computer science that asks how to pack a set of items of different sizes into a minimum number of bins of a fixed size."));
        flashcards.add(new Flashcards("What is the job shop scheduling problem?", "The job shop scheduling problem is a classic problem in computer science that asks how to schedule a set of jobs, each with a set of operations, on a set of machines, with the goal of minimizing the total time needed to complete all the jobs."));



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

                NavHostFragment.findNavController(GreedyFlashcardFragment.this)
                        .navigate(R.id.action_greedyFlashcardFragment_to_flashcardMenuFragment);
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