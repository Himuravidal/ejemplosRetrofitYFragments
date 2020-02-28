package com.criss.otrodesafio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView pregunta, categoria, dificultad;


    private String mParam1;
    private String mParam2;
    private Button button;


    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        Log.e("ERROR", "PASA EN EL CONSTRUCTOR");
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
        final View view =  inflater.inflate(R.layout.fragment_first, container, false);
        initializeViews(view);
        Log.e("ERROR", "ON_CREATE_VIEW");

        pregunta.setText(mParam1);
        categoria.setText(mParam2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //pasarAlotro();

                //Estoy haciendo el intent.
                shareWithWhatsApp(v);


            }
        });



        return view;
    }

    private void initializeViews(View view) {
        pregunta = view.findViewById(R.id.questions);
        categoria = view.findViewById(R.id.categoria);
        dificultad = view.findViewById(R.id.dificultad);
        button = view.findViewById(R.id.buttonInFragment1);
    }



    private void pasarAlotro() {
        SecondFragment secondFragment = SecondFragment.newInstance("","");
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, secondFragment, "SECONDTFRAGMENT")
                .addToBackStack("SECONDTFRAGMENT")
                .commit();
    }


    //Este intent lo ocupamos para mostrar los implicitos y explicitos.
    public void shareWithWhatsApp(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "¡Hola! te comparto mi niota obtenida hoy:");
        sendIntent.setType("text/plain");
        // sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }


}
