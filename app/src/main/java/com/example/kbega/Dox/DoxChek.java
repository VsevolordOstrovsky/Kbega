package com.example.kbega.Dox;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kbega.Data;
import com.example.kbega.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoxChek#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoxChek extends Fragment {
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DoxChek() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoxChek.
     */
    // TODO: Rename and change types and number of parameters
    public static DoxChek newInstance(String param1, String param2) {
        DoxChek fragment = new DoxChek();
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


    Data data;
    Doxod doxod;
    LinearLayout nameB, priceB, potokB, vznosB, ipotekaB, btnSell;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dox_chek, container, false);
        doxod = new Doxod();

        ImageButton closeBut = view.findViewById(R.id.closeBut);





        nameB = view.findViewById(R.id.nameB);
        priceB = view.findViewById(R.id.priceB);
        potokB = view.findViewById(R.id.potokB);
        vznosB = view.findViewById(R.id.vznosB);
        ipotekaB = view.findViewById(R.id.ipotekaB);
        btnSell = view.findViewById(R.id.btnSell);



        String name = "", price = "", potok = "", vznos = "", ipoteka = "";



        int count = 0;
        int idCount = 1;
        for(int i = 0; i < data.dataTimeNedv.size(); i++){
            count++;

            switch (count){
                case 1: name = data.dataTimeNedv.get(i);
                case 2: price = data.dataTimeNedv.get(i);
                case 3: ipoteka = data.dataTimeNedv.get(i);
                case 4: vznos = data.dataTimeNedv.get(i);
                case 5: potok = data.dataTimeNedv.get(i);
                default: ;

            }



            if(count == 5){
                TextView dText = new TextView(getContext());
                TextView aText = new TextView(getContext());
                TextView bText = new TextView(getContext());
                TextView cText = new TextView(getContext());
                TextView eText = new TextView(getContext());
                TextView fText = new TextView(getContext());
                ImageButton sell = new ImageButton(getContext());
                ImageButton izm = new ImageButton(getContext());
                LinearLayout btnIzm = new LinearLayout(getContext());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, pxToDP(50));
                params.weight = 1.0f;
                params.gravity = Gravity.CENTER;



                dText.setLayoutParams(params);
                aText.setLayoutParams(params);
                bText.setLayoutParams(params);
                cText.setLayoutParams(params);
                eText.setLayoutParams(params);
                fText.setLayoutParams(params);
                btnIzm.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

                sell.setLayoutParams(new ViewGroup.LayoutParams(pxToDP(100),pxToDP(50)));
                sell.setImageResource(R.drawable.dollar);
                sell.setBackgroundResource(0);
                izm.setLayoutParams(new ViewGroup.LayoutParams(pxToDP(100),pxToDP(50)));
                izm.setImageResource(R.drawable.pen);
                izm.setBackgroundResource(0);

                sell.setId(idCount);
                idCount++;


                btnSell.addView(btnIzm);
                btnIzm.addView(sell);
                btnIzm.addView(izm);



                dText.setGravity(Gravity.CENTER);
                dText.setTextColor(R.color.secText);
                dText.setTextSize(24);

                aText.setGravity(Gravity.CENTER);
                aText.setTextColor(R.color.secText);
                aText.setTextSize(24);

                bText.setGravity(Gravity.CENTER);
                bText.setTextColor(R.color.secText);
                bText.setTextSize(24);

                cText.setGravity(Gravity.CENTER);
                cText.setTextColor(R.color.secText);
                cText.setTextSize(24);

                eText.setGravity(Gravity.CENTER);
                eText.setTextColor(R.color.secText);
                eText.setTextSize(24);


                dText.setText(name);
                nameB.addView(dText);


                aText.setText(price);
                priceB.addView(aText);

                bText.setText(potok);
                potokB.addView(bText);

                cText.setText(vznos);
                vznosB.addView(cText);

                eText.setText(ipoteka);
                ipotekaB.addView(eText);

                sell.setOnClickListener(onClickListenerSELL);



                count = 0;
            }


        }






        closeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_doxChek_to_vnutrKrug);
            }
        });





        return view;
    }

    private int pxToDP(int pixels){
        float dip = (float)pixels;
        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );
        return (int)px;
    }
    private View.OnClickListener onClickListenerSELL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            doxod.idDox = view.getId();
            Log.i("IDDDDDDDDDD", String.valueOf(doxod.idDox));
            Navigation.findNavController(view).navigate(R.id.action_doxChek_to_sellDox);
            Log.i("IDDDDDDDDDD", String.valueOf(doxod.idDox));
        }
    };
    private View.OnClickListener onClickListenerIzm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            doxod.idDox = view.getId();
            Log.i("IDDDDDDDDDD", String.valueOf(doxod.idDox));
            Navigation.findNavController(view).navigate(R.id.action_doxChek_to_sellDox);
            Log.i("IDDDDDDDDDD", String.valueOf(doxod.idDox));
        }
    };
}