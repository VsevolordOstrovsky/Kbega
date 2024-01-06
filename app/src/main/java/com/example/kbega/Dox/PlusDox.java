package com.example.kbega.Dox;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kbega.Data;
import com.example.kbega.R;
import com.example.kbega.VnutrKrug;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlusDox#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlusDox extends Fragment {
    View view;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public PlusDox() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlusDox.
     */
    // TODO: Rename and change types and number of parameters
    public static PlusDox newInstance(String param1, String param2, String param3) {
        PlusDox fragment = new PlusDox();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    private Doxod doxod;
    private  VnutrKrug vnutrKrug;
    LinearLayout vvod;
    private String[] znach = {"0","0","0","0","0"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_plus_dox, container, false);

        Bundle bundle = new Bundle();
        Data data = new Data();
        doxod = new Doxod();

        vnutrKrug = new VnutrKrug();
        Intent intent = new Intent();
        Button houseTow = view.findViewById(R.id.houseTow);
        Button houseThree = view.findViewById(R.id.houseThree);
        Button flat = view.findViewById(R.id.flat);
        Button pleksFore = view.findViewById(R.id.pleksFore);
        Button pleksEight = view.findViewById(R.id.pleksEight);
        Button flatHouse = view.findViewById(R.id.flatHouse);
        Button dupleks = view.findViewById(R.id.dupleks);
        Button buizness = view.findViewById(R.id.buizness);

        Button vnutKrug = view.findViewById(R.id.vnutKrug);
        EditText price = view.findViewById(R.id.price);
        EditText forstVz = view.findViewById(R.id.firstVz);
        EditText ipoteka = view.findViewById(R.id.ipoteka);
        EditText moneyRiver = view.findViewById(R.id.moneyRiver);
        vvod = view.findViewById(R.id.vvod);
        vvod.setX(-10000);




        houseTow.setOnClickListener(onClickListener);
        houseThree.setOnClickListener(onClickListener);
        flat.setOnClickListener(onClickListener);
        pleksFore.setOnClickListener(onClickListener);
        pleksEight.setOnClickListener(onClickListener);
        flatHouse.setOnClickListener(onClickListener);
        dupleks.setOnClickListener(onClickListener);
        buizness.setOnClickListener(onClickListener);

        Toast toast = Toast.makeText(getContext(),
                "Заполните все поля", Toast.LENGTH_SHORT);

        vnutKrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price.getText().toString().equals("") || forstVz.getText().toString().equals("") || ipoteka.getText().toString().equals("") || moneyRiver.getText().toString().equals("")){

                    toast.show();
                }else{

                    znach[1] = price.getText().toString();
                    znach[2] = ipoteka.getText().toString();
                    znach[3] = forstVz.getText().toString();
                    znach[4] = moneyRiver.getText().toString();
                    Log.i("Seva", "88888888888888888888888888888888888");
                    doxod.setZnachF(znach);
                    Log.i("Seva", "99999999999999999999999999999999999");



                    Navigation.findNavController(view).navigate(R.id.action_plusDox_to_vnutrKrug);
                }
            }
        });


        return view;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            vvod.setX(0);

            Button b = (Button) view;
            String str = b.getText().toString();
            znach[0] = str;
        }
    };


}