package com.example.buildingblocksteam1.Quiz;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.buildingblocksteam1.Question;
import com.example.buildingblocksteam1.R;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.buildingblocksteam1.SharedViewModel;
import com.example.buildingblocksteam1.databinding.FragmentGraphsQuizBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraphsQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphsQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentGraphsQuizBinding binding;
    private SharedViewModel viewModel;

    public GraphsQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GraphsQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GraphsQuizFragment newInstance(String param1, String param2) {
        GraphsQuizFragment fragment = new GraphsQuizFragment();
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
        // *** Creates the viewModel that allows data transfer between fragments
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentGraphsQuizBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getGraphsScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                // Update UI with the new data
            }
        });

        // *** Gets the resources

        Resources res = getResources();
        int regularColor = res.getColor(R.color.regular_text);
        int buttonColor = res.getColor(R.color.button_text);

        // *** Creates the list of questions
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("What is a graph data structure?","A set of vertices connected by edges.","A set of vertices without edges.","A set of edges without vertices.","A set of data organized in a tree-like structure.","A","A graph is a data structure consisting of a set of vertices (or nodes) connected by edges."));
        questions.add(new Question("What is an edge in a graph?","A connection between two vertices.","A single vertex in a graph.","A subset of vertices in a graph.","A branch in a tree structure.","A","An edge is a connection between two vertices in a graph."));
        questions.add(new Question("What is a weighted graph?","A graph in which each edge has a numerical weight assigned to it.","A graph in which all edges have the same weight.","A graph in which the vertices have a numerical weight assigned to them.","A graph in which there are no edges between vertices.","A","A weighted graph is a graph in which each edge has a numerical weight assigned to it."));
        questions.add(new Question("What is a directed graph?","A graph in which the edges have a direction.","A graph in which the edges do not have a direction.","A graph in which all vertices are connected to each other.","A graph in which all vertices have the same degree.","A","A directed graph (or digraph) is a graph in which the edges have a direction."));
        questions.add(new Question("What is an undirected graph?","A graph in which the edges do not have a direction.","A graph in which the edges have a direction.","A graph in which all vertices are connected to each other.","A graph in which all vertices have the same degree.","A","An undirected graph is a graph in which the edges do not have a direction."));
        questions.add(new Question("What is a path in a graph?","A sequence of edges that connect a sequence of vertices.","A single vertex in a graph.","A subset of vertices in a graph.","A branch in a tree structure.","A","A path in a graph is a sequence of edges that connect a sequence of vertices."));
        questions.add(new Question("What is a cycle in a graph?","A path that starts and ends at the same vertex.","A single vertex in a graph.","A subset of vertices in a graph.","A branch in a tree structure.","A","A cycle in a graph is a path that starts and ends at the same vertex."));
        questions.add(new Question("What is a connected graph?","A graph in which there is a path between any two vertices.","A graph in which all edges have the same weight.","A graph in which all vertices have the same degree.","A graph in which there are no edges between vertices.","A","A connected graph is a graph in which there is a path between any two vertices."));
        questions.add(new Question("What is a disconnected graph?","A graph in which there is no path between some pairs of vertices.","A graph in which all edges have the same weight.","A graph in which all vertices have the same degree.","A graph in which there are no edges between vertices.","A","A disconnected graph is a graph in which there is no path between some pairs of vertices."));
        questions.add(new Question("What is a spanning tree?","A subgraph of a graph that contains all the vertices and is a tree.","A subgraph of a graph that contains only the vertices with odd degree.","A subgraph of a graph that contains only the vertices with even degree.","A subgraph of a graph that does not contain any edges.","A","A spanning tree of a graph is a subgraph that contains all the vertices and is a tree."));
        questions.add(new Question("What is a directed graph?","A graph where the edges have a specific direction, usually represented with arrows.","A graph where all nodes are connected to each other.","A graph where the edges have weights.","A graph where there are no cycles.","A","A directed graph is a graph where the edges have a specific direction, usually represented with arrows."));
        questions.add(new Question("What is an undirected graph?","A graph where the edges do not have a specific direction.","A graph where all nodes are connected to each other.","A graph where the edges have weights.","A graph where there are no cycles.","A","An undirected graph is a graph where the edges do not have a specific direction."));
        questions.add(new Question("What is a weighted graph?","A graph where the edges have a numerical value assigned to them.","A graph where all nodes are connected to each other.","A graph where the edges have a specific direction.","A graph where there are no cycles.","A","A weighted graph is a graph where the edges have a numerical value assigned to them."));
        questions.add(new Question("What is a cycle in a graph?","A path in a graph that starts and ends at the same node.","A path in a graph that connects all nodes together.","A path in a graph with the smallest total weight.","A path in a graph with the largest total weight.","A","A cycle in a graph is a path that starts and ends at the same node."));
        questions.add(new Question("What is a connected graph?","A graph where there is a path between every pair of nodes.","A graph where all nodes have the same degree.","A graph where the edges form a cycle.","A graph where all edges have the same weight.","A","A connected graph is a graph where there is a path between every pair of nodes."));
        questions.add(new Question("What is a disconnected graph?","A graph where there are two or more components that are not connected to each other.","A graph where all nodes have the same degree.","A graph where the edges form a cycle.","A graph where all edges have the same weight.","A","A disconnected graph is a graph where there are two or more components that are not connected to each other."));
        questions.add(new Question("What is a spanning tree of a graph?","A subgraph that is a tree and connects all nodes of the original graph.","A subgraph where every node has the same degree.","A subgraph where the edges form a cycle.","A subgraph where all edges have the same weight.","A","A spanning tree of a graph is a subgraph that is a tree and connects all nodes of the original graph."));
        questions.add(new Question("What is a minimum spanning tree of a graph?","A spanning tree with the smallest total weight.","A spanning tree with the largest total weight.","A spanning tree where all edges have the same weight.","A spanning tree with the most nodes.","A","A minimum spanning tree of a graph is a spanning tree with the smallest total weight."));
        questions.add(new Question("What is Dijkstra's algorithm?","A greedy algorithm that finds the shortest path between a source node and all other nodes in a weighted graph.","An algorithm that finds all cycles in a graph.","An algorithm that finds the minimum spanning tree of a graph.","An algorithm that finds the largest connected component in a graph.","A","Dijkstra's algorithm is a greedy algorithm that finds the shortest path between a source node and all other nodes in a weighted graph."));
        questions.add(new Question("What is a cycle in a graph?","A path that starts and ends at the same vertex.","A path that visits all the vertices exactly once.","A path that visits each edge exactly once.","A path that does not contain any repeated vertices.","A","A cycle in a graph is a path that starts and ends at the same vertex, forming a closed loop."));

        questions.add(new Question("What is a bipartite graph?","A graph in which the vertices can be divided into two disjoint sets such that all edges connect a vertex in one set to a vertex in the other set.","A graph that has no cycles.","A graph in which every vertex has the same degree.","A graph in which the vertices are arranged in a circular fashion.","A","A bipartite graph is a graph in which the vertices can be divided into two disjoint sets such that all edges connect a vertex in one set to a vertex in the other set."));

        questions.add(new Question("What is a complete graph?","A graph in which every pair of distinct vertices is connected by an edge.","A graph in which all the vertices have the same degree.","A graph in which every vertex has degree 1.","A graph in which all the vertices are connected in a straight line.","A","A complete graph is a graph in which every pair of distinct vertices is connected by an edge."));

        questions.add(new Question("What is a weighted graph?","A graph in which each edge has an associated value, or weight.","A graph in which the vertices are arranged in a circle.","A graph in which every vertex has the same degree.","A graph that has no cycles.","A","A weighted graph is a graph in which each edge has an associated value, or weight."));

        questions.add(new Question("What is a minimum spanning tree?","A spanning tree of a weighted graph that has the minimum possible total weight.","A spanning tree of a graph that has the maximum possible total weight.","A tree in which every vertex has degree 1.","A tree in which all the vertices are arranged in a straight line.","A","A minimum spanning tree is a spanning tree of a weighted graph that has the minimum possible total weight."));

        questions.add(new Question("What is a maximum flow in a network flow problem?","The maximum amount of flow that can be sent from the source vertex to the sink vertex, subject to capacity constraints.","The minimum amount of flow that can be sent from the source vertex to the sink vertex, subject to capacity constraints.","The maximum amount of flow that can be sent from any vertex to any other vertex, subject to capacity constraints.","The minimum amount of flow that can be sent from any vertex to any other vertex, subject to capacity constraints.","A","The maximum flow in a network flow problem is the maximum amount of flow that can be sent from the source vertex to the sink vertex, subject to capacity constraints."));

        // *** Shuffles the questions Array List
        Collections.shuffle(questions, new Random());


        // *** Add the questions as radio buttons into the view
        LinearLayout root = binding.linearLayout;
        ArrayList<Question> usedQuestions = new ArrayList<Question>();
        for (int i = 0; i < 10; i++) {
            TextView text = new TextView(this.getContext());
            if (i == 0) {
                text.setText("" + (i+1) + ". " + questions.get(i).getQuestion());
            }
            else {
                text.setText("\n" + (i+1) + ". " + questions.get(i).getQuestion());
            }
            text.setTextColor(regularColor);
            root.addView(text);

            RadioGroup radioGroup = new RadioGroup(this.getContext());


            ArrayList<String> answers = questions.get(i).getAnswerList();
            Collections.shuffle(answers, new Random());
            for (int j = 0; j < 4; j++) {
                RadioButton radioButton = new RadioButton(this.getContext());
                radioButton.setText(answers.get(j));
                radioButton.setButtonTintList(ColorStateList.valueOf(regularColor));
                radioButton.setTextColor(regularColor);
                if (radioButton.getText().equals(questions.get(i).getAnswer())) {
                    radioButton.setTag("true");
                }
                radioButton.setText("" + (char)(j+65) + ". " + answers.get(j));
                radioGroup.addView(radioButton);
            }

            root.addView(radioGroup);

            usedQuestions.add(questions.get(i));
        }
        Button submit = binding.buttonSubmit;
        root.removeView(submit);
        root.addView(submit);
        viewModel.setGraphsQuestions(usedQuestions);


        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;
                LinearLayout root = binding.linearLayout;
                for (int i = 0; i < root.getChildCount(); i++) {
                    View child = root.getChildAt(i);
                    if (child instanceof RadioGroup) {
                        RadioGroup radioGroup = (RadioGroup) child;
                        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                        RadioButton selectedRadioButton = radioGroup.findViewById(selectedRadioButtonId);
                        if (selectedRadioButton != null) {
                            if (selectedRadioButton.getTag() != null) {
                                String tag = (String) selectedRadioButton.getTag();
                                if (tag.equals("true")) {
                                    score += 10;
                                    // The correct radio button is selected
                                }
                            }
                        }
                    }
                }
                viewModel.setGraphsScore(String.valueOf(score));

                NavHostFragment.findNavController(GraphsQuizFragment.this)
                        .navigate(R.id.action_graphsQuizFragment_to_graphsQuizResultFragment);
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(GraphsQuizFragment.this)
                        .navigate(R.id.action_graphsQuizFragment_to_quizMenuFragment);
            }
        });
    }
}