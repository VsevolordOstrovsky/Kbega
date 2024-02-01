package com.example.kbega;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kbega.Dox.Doxod;
import com.example.kbega.Dox.PlusDox;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VnutrKrug#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VnutrKrug extends Fragment{
    private View view;
    Proff proff = new Proff();
    private Doxod doxod;
    private Profession profession;
    private PlusDox plusDox;
    private Data data;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    public String mParam1;
    private String mParam2;
    private String[] mParam3;

    public VnutrKrug() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VnutrKrug.
     */
    // TODO: Rename and change types and number of parameters
    public static VnutrKrug newInstance(String param1, String param2, String[] param3) {
        VnutrKrug fragment = new VnutrKrug();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putStringArray(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getStringArray(ARG_PARAM3);
        }
    }

    private TextView salary;
    private TextView passDox;
    private TextView  obDox;
    private TextView  obRas;
    private TextView  potok;
    private TextView salaryDox;
    private TextView div_proc;



    public int ob_Ras = 0;
    public int d_Potok = 0;
    private int[] proffZnach;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_vnutr_krug, container, false);
        LinearLayout lPassDox = view.findViewById(R.id.lPassDox);



        profession = new Profession();
        plusDox = new PlusDox();
        data = new Data();

        Bundle bundle = new Bundle();
        doxod  = new Doxod();

        proffZnach = proff.getName(data.getName());









        Button plusDox = view.findViewById(R.id.plus_Dox);
        Button chekNidv = view.findViewById(R.id.chekNidv);
        salary = view.findViewById(R.id.salary);
        salaryDox = view.findViewById(R.id.salaryDox);
        passDox = view.findViewById(R.id.passDox);
        obDox = view.findViewById(R.id.obDox);
        obRas = view.findViewById(R.id.obRas);
        potok = view.findViewById(R.id.potok);
        div_proc = view.findViewById(R.id.div_proc);

        Log.i("RRR", "??????????????????????????????????????????????");









        salary.setText(String.valueOf(proffZnach[0]));
        salaryDox.setText(String.valueOf(proffZnach[0]));





        update();


        plusDox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString(ARG_PARAM1,ARG_PARAM1);
                Navigation.findNavController(view).navigate(R.id.action_vnutrKrug_to_plusDox,bundle);
            }
        });

        chekNidv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_vnutrKrug_to_doxChek);
            }
        });

        lPassDox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_vnutrKrug_to_doxChek);
            }
        });





        return view;
    }

    private void update(){
        doxod.update();

        passDox.setText(String.valueOf(doxod.pass_Dox));
        div_proc.setText(String.valueOf(doxod.pass_Dox));

        obDox.setText(String.valueOf(doxod.ob_Dox));

        ob_Ras = 0;
        for(int i = 1; i < 7;i++){
            ob_Ras+=proffZnach[i];
        }
        obRas.setText(String.valueOf(ob_Ras));

        d_Potok = doxod.ob_Dox-ob_Ras;
        potok.setText(String.valueOf(d_Potok));



    }

}