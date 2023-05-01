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
import com.example.buildingblocksteam1.databinding.FragmentLinkedListQuizResultBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LinkedListQuizResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinkedListQuizResultFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SharedViewModel viewModel;
    private FragmentLinkedListQuizResultBinding binding;

    public LinkedListQuizResultFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LinkedListQuizResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinkedListQuizResultFragment newInstance(String param1, String param2) {
        LinkedListQuizResultFragment fragment = new LinkedListQuizResultFragment();
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
        binding = FragmentLinkedListQuizResultBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Call a method on the SharedViewModel
        viewModel.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String data) {
                binding.linkedlistResult.setText((viewModel.getData().getValue() + "%"));
                binding.seekBar.setProgress(Integer.parseInt(viewModel.getData().getValue()) / 10);
            }
        });
        return binding.getRoot();

        //return inflater.inflate(R.layout.fragment_linked_list_quiz_result, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LinkedListQuizResultFragment.this)
                        .navigate(R.id.action_linkedListQuizResultFragment_to_feedbackLinkedlistFragment);
            }
        });


    }
}