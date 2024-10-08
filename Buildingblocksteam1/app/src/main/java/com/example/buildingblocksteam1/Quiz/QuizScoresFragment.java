package com.example.buildingblocksteam1.Quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.SharedViewModel;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizScoresBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizScoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizScoresFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentQuizScoresBinding binding;
    private SharedViewModel viewModel;

    public QuizScoresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizScoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizScoresFragment newInstance(String param1, String param2) {
        QuizScoresFragment fragment = new QuizScoresFragment();
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
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuizScoresBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getLinkedListScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonLinkedList.setText(("LinkedList Quiz Score: " + viewModel.getLinkedListScore().getValue() + "%"));
            }
        });
        viewModel.getStacksScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonStacks.setText(("Stacks Quiz Score: " + viewModel.getStacksScore().getValue() + "%"));
            }
        });
        viewModel.getArraysScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonArrays.setText(("Arrays Quiz Score: " + viewModel.getArraysScore().getValue() + "%"));
            }
        });
        viewModel.getQueuesScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonQueues.setText(("Queues Quiz Score: " + viewModel.getQueuesScore().getValue() + "%"));
            }
        });
        viewModel.getTreesScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonTrees.setText(("Trees Quiz Score: " + viewModel.getTreesScore().getValue() + "%"));
            }
        });
        viewModel.getGraphsScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonGraphs.setText(("Graphs Quiz Score: " + viewModel.getGraphsScore().getValue() + "%"));
            }
        });
        viewModel.getHashTablesScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonHashTables.setText(("HashTables Quiz Score: " + viewModel.getHashTablesScore().getValue() + "%"));
            }
        });
        viewModel.getHeapsScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonHeaps.setText(("Heaps Quiz Score: " + viewModel.getHeapsScore().getValue() + "%"));
            }
        });
        viewModel.getSortingScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonSorting.setText(("Sorting Quiz Score: " + viewModel.getSortingScore().getValue() + "%"));
            }
        });
        viewModel.getSearchingScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonSearching.setText(("Searching Quiz Score: " + viewModel.getSearchingScore().getValue() + "%"));
            }
        });
        viewModel.getGreedyScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonGreedy.setText(("Greedy Quiz Score: " + viewModel.getGreedyScore().getValue() + "%"));
            }
        });
        viewModel.getDivideAndConquerScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonDivideConquer.setText(("DivideAndConquer Quiz Score: " + viewModel.getDivideAndConquerScore().getValue() + "%"));
            }
        });
        viewModel.getDynamicScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonDynamicProgramming.setText(("Dynamic Quiz Score: " + viewModel.getDynamicScore().getValue() + "%"));
            }
        });
        viewModel.getBacktrackingScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonBacktracking.setText(("Backtracking Quiz Score: " + viewModel.getBacktrackingScore().getValue() + "%"));
            }
        });
        viewModel.getBruteForceScore().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.buttonBruteForce.setText(("BruteForce Quiz Score: " + viewModel.getBruteForceScore().getValue() + "%"));
            }
        });



        return binding.getRoot();

        //return inflater.inflate(R.layout.fragment_quiz_scores, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizScoresFragment.this)
                        .navigate(R.id.action_quizScoresFragment_to_quizMenuFragment);
            }
        });
    }
}