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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kbega.Data;
import com.example.kbega.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellDox#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellDox extends Fragment {
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SellDox() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SellDox.
     */
    // TODO: Rename and change types and number of parameters
    public static SellDox newInstance(String param1, String param2) {
        SellDox fragment = new SellDox();
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
    Doxod doxod;
    Data data;
    private int key;
    private EditText sellP;
    private int start, stop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sell_dox, container, false);
        ImageButton returnBtn = view.findViewById(R.id.btnReturn);
        doxod = new Doxod();
        data = new Data();
        key = doxod.idDox;
        int rezult = key*5-4;
        int ipot = key*5-3;

        start = key*5-5;
        stop = key*5;



        TextView priceBuy, tenP, fifteenP, twentyP, textSell;
        textSell = view.findViewById(R.id.textSell);
        priceBuy = view.findViewById(R.id.priceBuy);
        tenP = view.findViewById(R.id.tenP);
        fifteenP = view.findViewById(R.id.fifteenP);
        twentyP = view.findViewById(R.id.twentyP);
        int price = Integer.parseInt(data.dataTimeNedv.get(rezult));
        priceBuy.setText(data.dataTimeNedv.get(rezult));
        int ten, fifteen, twenty;
        ten = price/100*10+price;
        fifteen = price/100*15+price;
        twenty = price/100*20+price;
        tenP.setText(String.valueOf(ten));
        fifteenP.setText(String.valueOf(fifteen));
        twentyP.setText(String.valueOf(twenty));

        textSell.setText("Вы продаёте "+data.dataTimeNedv.get(start));

        LinearLayout plusTen, plusFifteen, plusTwenty;
        plusTen = view.findViewById(R.id.plusTen);
        plusFifteen = view.findViewById(R.id.plusFifteen);
        plusTwenty = view.findViewById(R.id.plusTwenty);
        sellP = view.findViewById(R.id.editTextText);


        Button backOK = view.findViewById(R.id.returnOK);
        plusTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sellP.setText(tenP.getText());
            }
        });
        plusFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sellP.setText(fifteenP.getText());
            }
        });
        plusTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sellP.setText(twentyP.getText());
            }
        });


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_sellDox_to_doxChek );
            }
        });

        backOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int getNumber = Integer.parseInt(sellP.getText().toString());
                int ipoteka = Integer.parseInt(data.dataTimeNedv.get(ipot));
                data.savings += getNumber-ipoteka;
                Log.i("Save", String.valueOf(data.savings));
                removeItems(start,stop);
                Navigation.findNavController(view).navigate(R.id.action_sellDox_to_doxChek);
            }
        });




        return view;
    }

    private void removeItems(int start, int stop){
        for(int i = 0; i < 5; i++){
            data.dataTimeNedv.remove(start);
        }
    }

}