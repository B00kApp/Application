package com.mahdirahmani8.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.Adopter.AR;
import com.mahdirahmani8.myapplication.Adopter.AR_AU;
import com.mahdirahmani8.myapplication.Adopter.AudioBookAdapter;
import com.mahdirahmani8.myapplication.Adopter.FA_Audio;
import com.mahdirahmani8.myapplication.Adopter.GR;
import com.mahdirahmani8.myapplication.Adopter.GR_AU;
import com.mahdirahmani8.myapplication.Adopter.SP;
import com.mahdirahmani8.myapplication.Adopter.SP_AU;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Item;
import com.mahdirahmani8.myapplication.Model.ar;
import com.mahdirahmani8.myapplication.Model.fa;
import com.mahdirahmani8.myapplication.Model.gr;
import com.mahdirahmani8.myapplication.Model.sp;

import java.util.List;

public class ForiegnFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    AudioBookAdapter partAdopter;
    String Lan;
    FA_Audio FA;
    com.mahdirahmani8.myapplication.Adopter.GR_AU GR;
    AR_AU AR;
    SP_AU SP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_home,container,false);

        setupView(getLAN());

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void setupView(String lan){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DataBase db  = new DataBase(getActivity());


        if (lan.hashCode() == 3259) {   // fa
            List<fa> items = db.getFA();
            FA = new FA_Audio(getContext(), items);
            recyclerView.setAdapter(FA);

        } else if (lan.hashCode() == 3246 ) {  // sp
            List<sp> items = db.getSP();
            SP = new SP_AU(getContext(), items);
            recyclerView.setAdapter(SP);

        } else if (lan.hashCode() == 3307) {  // gr
            List<gr> items = db.getGR();
            GR = new GR_AU(getContext(), items);
            recyclerView.setAdapter(GR);

        } else if (lan.hashCode() == 3121) {  // ar
            List<ar> items = db.getAR();
            AR = new AR_AU(getContext(), items);
            recyclerView.setAdapter(AR);

        } else {
            List<Item> items = db.getItems();
            partAdopter = new AudioBookAdapter(getContext(), items);
            recyclerView.setAdapter(partAdopter);
        }

    }

    private String getLAN() {
        DataBase db = new DataBase(getContext());
        return db.lanValue();
    }

}
