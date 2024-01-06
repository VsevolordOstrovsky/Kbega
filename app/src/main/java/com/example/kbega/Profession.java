package com.example.kbega;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profession#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profession extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profession() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profession.
     */
    // TODO: Rename and change types and number of parameters
    public static Profession newInstance(String param1, String param2) {
        Profession fragment = new Profession();
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
        View view = inflater.inflate(R.layout.fragment_profession, container, false);

        Bundle bundle = new Bundle();
        Data data = new Data();

        Button medsestra = view.findViewById(R.id.medsestra);
        Button manager = view.findViewById(R.id.manager);
        Button pilot = view.findViewById(R.id.pilot);

        medsestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString(ARG_PARAM1,"medsestra");
                data.name("medsestra");


                Navigation.findNavController(view).navigate(R.id.action_profession_to_vnutrKrug,bundle);

            }
        });
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString(ARG_PARAM1,"manager");
                data.name("manager");
                Navigation.findNavController(view).navigate(R.id.action_profession_to_vnutrKrug, bundle);
            }
        });

        pilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString(ARG_PARAM1,"pilot");
                data.name("pilot");
                Navigation.findNavController(view).navigate(R.id.action_profession_to_vnutrKrug, bundle);
            }
        });
        return view;
    }
}