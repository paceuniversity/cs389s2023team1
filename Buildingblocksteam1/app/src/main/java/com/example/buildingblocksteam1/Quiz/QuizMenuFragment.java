package com.example.buildingblocksteam1.Quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentFirstBinding;
import com.example.buildingblocksteam1.databinding.FragmentQuizMenuBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizMenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentQuizMenuBinding binding;

    public QuizMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizMenuFragment newInstance(String param1, String param2) {
        QuizMenuFragment fragment = new QuizMenuFragment();
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

        binding = FragmentQuizMenuBinding.inflate(inflater, container, false);

        return binding.getRoot();
        //return inflater.inflate(R.layout.fragment_quiz_menu, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonLinkedList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_linkedListQuizFragment);
            }
        });
        binding.buttonArrays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_arraysQuizFragment);
            }
        });
        binding.buttonStacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_stacksQuizFragment);
            }
        });
        binding.buttonQueues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_queuesQuizFragment);
            }
        });
        binding.buttonTrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_treesQuizFragment);
            }
        });
        binding.buttonGraphs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_graphsQuizFragment);
            }
        });
        binding.buttonHashTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_hashTablesQuizFragment);
            }
        });
        binding.buttonHeaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_heapsQuizFragment);
            }
        });
        binding.buttonSorting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_sortingQuizFragment);
            }
        });
        binding.buttonSearching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_searchingQuizFragment);
            }
        });
        binding.buttonGreedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_greedyQuizFragment);
            }
        });
        binding.buttonDivideConquer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_divideAndConquerQuizFragment);
            }
        });
        binding.buttonDynamicProgramming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_dynamicQuizFragment);
            }
        });
        binding.buttonBacktracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_backtrackingQuizFragment);
            }
        });
        binding.buttonBruteForce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_bruteForceQuizFragment);
            }
        });

        binding.buttonQuizScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_quizScoresFragment);
            }
        });
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(QuizMenuFragment.this)
                        .navigate(R.id.action_quizMenuFragment_to_FirstFragment);
            }
        });
    }
}