package com.example.kbega.Dox;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.kbega.Data;
import com.example.kbega.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IzmDox#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IzmDox extends Fragment {
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IzmDox() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IzmDox.
     */
    // TODO: Rename and change types and number of parameters
    public static IzmDox newInstance(String param1, String param2) {
        IzmDox fragment = new IzmDox();
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

    Data data = new Data();;
    Doxod doxod = new Doxod();;
    int start, stop;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("????", "+++++++++++++++");
        view = inflater.inflate(R.layout.fragment_izm_dox, container, false);
        Log.i("????", "+++++++++++++++");
        ImageButton closeBut = view.findViewById(R.id.closeButt);
        Button returnOK = view.findViewById(R.id.returnOK);

        Log.i("????", "+++++++++++++++");
        EditText nameEdit, priceEdit, potokEdit, vznosEdit, ipotekaEdit;
        nameEdit = view.findViewById(R.id.nameEdit);
        priceEdit = view.findViewById(R.id.priceEdit);
        potokEdit = view.findViewById(R.id.potokEdit);
        vznosEdit = view.findViewById(R.id.vznosEdit);
        ipotekaEdit = view.findViewById(R.id.ipotekaEdit);




        int key = doxod.idDox;
        start = key*5-5;
        stop = key*5;
        int k = 0;
        for(int i = start; i < stop; i++){
            switch (k){
                case 0: nameEdit.setText(data.dataTimeNedv.get(i));
                case 1: priceEdit.setText(data.dataTimeNedv.get(i));
                case 2: potokEdit.setText(data.dataTimeNedv.get(i));
                case 3: vznosEdit.setText(data.dataTimeNedv.get(i));
                default:ipotekaEdit.setText(data.dataTimeNedv.get(i));
            }
            k++;
        }
        Log.i("????", "+++++++++++++++");


        closeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_izmDox_to_doxChek);
            }
        });

        returnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mass = new String[5];
                mass[0] = String.valueOf(nameEdit.getText());
                mass[1] = String.valueOf(priceEdit.getText());
                mass[2] = String.valueOf(potokEdit.getText());
                mass[3] = String.valueOf(vznosEdit.getText());
                mass[4] = String.valueOf(ipotekaEdit.getText());
                update(mass);
                Navigation.findNavController(view).navigate(R.id.action_izmDox_to_doxChek);

            }
        });
        return view;
    }
    private void update(String[] mass){
        int k = 0;
        for(int i = start; i < stop; i++){
            data.dataTimeNedv.set(i,mass[k]);
            k++;
        }
    }
}