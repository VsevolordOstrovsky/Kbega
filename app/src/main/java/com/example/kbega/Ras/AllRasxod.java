package com.example.kbega.Ras;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kbega.Proff;
import com.example.kbega.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllRasxod#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllRasxod extends Fragment {
    private View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton closeBut;
    private Button plus, minus;
    private TextView countChil, priceChild, rasChild;

    private int[] rasxod = new int[6];

    private int children = 0;

    private Ras ras;
    Proff proff;

    public AllRasxod() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllRasxod.
     */
    // TODO: Rename and change types and number of parameters
    public static AllRasxod newInstance(String param1, String param2) {
        AllRasxod fragment = new AllRasxod();
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
        this.ras = new Ras();
        this.proff = new Proff();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all_rasxod, container, false);

        init();
        plus.setOnClickListener(onClickListener);
        minus.setOnClickListener(onClickListener);

        closeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_allRasxod_to_vnutrKrug);
            }
        });
        return view;
    }

    private void init(){
        closeBut = view.findViewById(R.id.closeButt);
        plus = view.findViewById(R.id.plus);
        minus = view.findViewById(R.id.minus);
        countChil = view.findViewById(R.id.countChild);
        countChil.setText(String.valueOf(children));
        priceChild = view.findViewById(R.id.priceChild);
        priceChild.setText(String.valueOf(ras.num[11]));
        rasChild = view.findViewById(R.id.rasChild);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            String str = b.getText().toString();
            clickOnChil(str);
        }
    };

    private void clickOnChil(String flag){

        if (flag.equals("+") && children < 3) {
            children++;
            ras.rasChild = (Integer.parseInt(priceChild.getText().toString())) * children;
            rasChild.setText(String.valueOf(ras.rasChild));
        }
        if (flag.equals("-") && children > 0) {
            children--;
            ras.rasChild = (Integer.parseInt(priceChild.getText().toString())) * children;
            rasChild.setText(String.valueOf(ras.rasChild));
        }
        countChil.setText(String.valueOf(children));
    }
}