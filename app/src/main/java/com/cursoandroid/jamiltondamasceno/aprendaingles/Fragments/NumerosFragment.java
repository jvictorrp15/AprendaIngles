package com.cursoandroid.jamiltondamasceno.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cursoandroid.jamiltondamasceno.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonUm, buttonDois, buttonTres,
            buttonQuatro, buttonCinco, buttonSeis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonUm = view.findViewById(R.id.buttonUm);
        buttonDois = view.findViewById(R.id.buttonDois);
        buttonTres = view.findViewById(R.id.buttonTres);
        buttonQuatro = view.findViewById(R.id.buttonQuatro);
        buttonCinco = view.findViewById(R.id.buttonCinco);
        buttonSeis = view.findViewById(R.id.buttonSeis);

        //Aplica eventos de click
        buttonUm.setOnClickListener(this);
        buttonDois.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonQuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
        buttonSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch ( view.getId() ){
            case R.id.buttonUm :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one );
                tocarSom();
                break;
            case R.id.buttonDois :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two );
                tocarSom();
                break;
            case R.id.buttonTres :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three );
                tocarSom();
                break;
            case R.id.buttonQuatro :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four );
                tocarSom();
                break;
            case R.id.buttonCinco :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five );
                tocarSom();
                break;
            case R.id.buttonSeis :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six );
                tocarSom();
                break;
        }

    }

    public void tocarSom(){
        if ( mediaPlayer != null ){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
