package com.example.buildingblocksteam1.dataStructuresLectures;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentQueuesLectureBinding;
import com.example.buildingblocksteam1.databinding.FragmentStacksLectureBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StacksLectureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StacksLectureFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentStacksLectureBinding binding;

    public StacksLectureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StacksLectureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StacksLectureFragment newInstance(String param1, String param2) {
        StacksLectureFragment fragment = new StacksLectureFragment();
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
        binding = FragmentStacksLectureBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StacksLectureFragment.this)
                        .navigate(R.id.action_stacksLectureFragment_to_data_structure_activity2);
            }
        });


    }
}