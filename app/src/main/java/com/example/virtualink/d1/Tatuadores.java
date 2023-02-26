package com.example.virtualink.d1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtualink.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tatuadores#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tatuadores extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tatuadores() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Estilos.
     */
    // TODO: Rename and change types and number of parameters
    public static Tatuadores newInstance(String param1, String param2) {
        Tatuadores fragment = new Tatuadores();
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
        View rootView = inflater.inflate(R.layout.fragment_tatuadores, null);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        List<Tatuador> listaTatuador = new ArrayList<Tatuador>();
        listaTatuador.add(new Tatuador("dalmau_tattoo","Blackwork",R.drawable.dalmau_tattoo));
        listaTatuador.add(new Tatuador("angls.ink","Blackwork/Anime",R.drawable.angls_ink));
        listaTatuador.add(new Tatuador("xiaodan9702","Irezumi/Japones",R.drawable.xiaodan9702));
        listaTatuador.add(new Tatuador("nuky_tattoo","Blackwork",R.drawable.nuky_tattoo));
        listaTatuador.add(new Tatuador("gabrielepellerone","Realismo/Color",R.drawable.gabrielepellerone));
        listaTatuador.add(new Tatuador("_harrymckenzie","Ignorant",R.drawable._harrymckenzie));
        listaTatuador.add(new Tatuador("devens.gomes","Realismo/Gris",R.drawable.devens_gomes));
        listaTatuador.add(new Tatuador("dandy_tattoo","Tradicional",R.drawable.dandy_tattoo));
        listaTatuador.add(new Tatuador("gobeletters","Lettering/Blackwork",R.drawable.gobeletters));
        listaTatuador.add(new Tatuador("tonightattoo","Neotradicional/Realismo",R.drawable.tonightattoo));




        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new MyAdapter(getActivity().getApplicationContext(), listaTatuador));

        return rootView;


    }
}