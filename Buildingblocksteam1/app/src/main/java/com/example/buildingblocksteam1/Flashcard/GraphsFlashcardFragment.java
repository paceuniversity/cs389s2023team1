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
import com.example.buildingblocksteam1.databinding.FragmentGraphsFlashcardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraphsFlashcardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphsFlashcardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentGraphsFlashcardBinding binding;
    private ArrayList<Flashcards> flashcards = new ArrayList<Flashcards>();
    private int counter;
    private boolean side; // 0 is front, 1 is back

    public GraphsFlashcardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GraphsFlashcardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GraphsFlashcardFragment newInstance(String param1, String param2) {
        GraphsFlashcardFragment fragment = new GraphsFlashcardFragment();
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
        binding = FragmentGraphsFlashcardBinding.inflate(inflater, container, false);

        flashcards.add(new Flashcards("What is a graph?", "A graph is a data structure used to represent a set of objects, where some pairs of objects are connected by links called edges."));
        flashcards.add(new Flashcards("What are the two main components of a graph?", "The two main components of a graph are vertices (or nodes) and edges."));
        flashcards.add(new Flashcards("What is a directed graph?", "A directed graph is a graph where each edge is directed from one vertex to another."));
        flashcards.add(new Flashcards("What is an undirected graph?", "An undirected graph is a graph where each edge is bidirectional."));
        flashcards.add(new Flashcards("What is a weighted graph?", "A weighted graph is a graph where each edge is assigned a weight or cost."));
        flashcards.add(new Flashcards("What is a path in a graph?", "A path in a graph is a sequence of vertices connected by edges."));
        flashcards.add(new Flashcards("What is a cycle in a graph?", "A cycle in a graph is a path that starts and ends at the same vertex."));
        flashcards.add(new Flashcards("What is a connected graph?", "A connected graph is a graph where there is a path between any two vertices."));
        flashcards.add(new Flashcards("What is a complete graph?", "A complete graph is a graph where every vertex is connected to every other vertex."));
        flashcards.add(new Flashcards("What is a spanning tree?", "A spanning tree is a tree that connects all the vertices in a graph without any cycles."));
        flashcards.add(new Flashcards("What is a minimum spanning tree?", "A minimum spanning tree is a spanning tree of a weighted graph that has the minimum possible total edge weight."));
        flashcards.add(new Flashcards("What is a topological sort?", "A topological sort is a linear ordering of the vertices in a directed acyclic graph (DAG) such that for every directed edge (u, v), vertex u comes before vertex v in the ordering."));
        flashcards.add(new Flashcards("What is the difference between a graph and a tree?", "A graph is a collection of nodes and edges that can be directed or undirected and can contain cycles, while a tree is a connected acyclic graph."));
        flashcards.add(new Flashcards("What is the degree of a vertex in a graph?", "The degree of a vertex in a graph is the number of edges incident to it."));
        flashcards.add(new Flashcards("What is an adjacency matrix?", "An adjacency matrix is a matrix that represents a graph, where the entry in row i and column j is 1 if there is an edge from vertex i to vertex j, and 0 otherwise."));
        flashcards.add(new Flashcards("What is an adjacency list?", "An adjacency list is a list that represents a graph, where each vertex is associated with a list of its neighbors."));
        flashcards.add(new Flashcards("What is depth-first search?", "Depth-first search is a graph traversal algorithm that visits each vertex in a graph recursively, going as deep as possible along each branch before backtracking."));
        flashcards.add(new Flashcards("What is breadth-first search?", "Breadth-first search is a graph traversal algorithm that visits each vertex in a graph by exploring all the neighbors at the current level before moving on to the next level."));
        flashcards.add(new Flashcards("What is Dijkstra's algorithm?", "Dijkstra's algorithm is a shortest path algorithm that finds the shortest path between a starting vertex and all other vertices in a weighted graph."));
        flashcards.add(new Flashcards("What is the Bellman-Ford algorithm?", "The Bellman-Ford algorithm is a shortest path algorithm that can handle negative edge weights in a directed graph."));
        flashcards.add(new Flashcards("What is the Floyd-Warshall algorithm?", "The Floyd-Warshall algorithm is an all-pairs shortest path algorithm that finds the shortest path between all pairs of vertices in a weighted graph."));
        flashcards.add(new Flashcards("What is the traveling salesman problem?", "The traveling salesman problem is a well-known NP-hard problem that seeks to find the shortest possible route that visits every city in a given list exactly once and then returns to the starting city."));
        flashcards.add(new Flashcards("What is a bipartite graph?", "A bipartite graph is a graph where the vertices can be divided into two disjoint sets such that no two vertices within the same set are adjacent."));
        flashcards.add(new Flashcards("What is a clique in a graph?", "A clique in a graph is a set of vertices where every vertex is connected to every other vertex in the set."));
        flashcards.add(new Flashcards("What is a cut in a graph?", "A cut in a graph is a partition of the vertices into two disjoint sets, where some edges go between the two sets and some edges stay within each set."));
        flashcards.add(new Flashcards("What is a planar graph?", "A planar graph is a graph that can be drawn on a plane without any edges crossing."));

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

                NavHostFragment.findNavController(GraphsFlashcardFragment.this)
                        .navigate(R.id.action_graphsFlashcardFragment_to_flashcardMenuFragment);
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