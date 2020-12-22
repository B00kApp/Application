package com.mahdirahmani8.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.Adopter.AudioAdopter;
import com.mahdirahmani8.myapplication.Adopter.BookAdopter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Audio;
import com.mahdirahmani8.myapplication.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    RecyclerView RecyclerAudio;
    EditText editText;
    BookAdopter bookAdopter;
    ImageView search_btn;
    AudioAdopter audioAdopter;
    List<Book> bookList;
    List<Audio> audioList;
    TextView txt_AB, txt_S, S_bg;
    private RelativeLayout RelativeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.search_fragment, container, false);

        setUpViews();
        setData();
        Lan();
        showBackground();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable text) {

                if (text.toString().trim().isEmpty()) {

                    showBackground();

                } else {

                    if (text.toString().trim().length() > 3) {
                        filter(text.toString().trim());
                        hiddenBackground();
                    }

                }
            }
        });


        return view;
    }

    private void Lan() {
        DataBase db = new DataBase(getContext());
        String str = db.lanValue();

        if (str != null && str.hashCode() == 3259) {   // fa

            editText.setHint("جستجو ...");
            txt_S.setText("داستان");
            txt_AB.setText("کتاب صوتی");
            S_bg.setText("... چیزی را جستجو کنید ...");
            editText.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        } else if (str != null && str.hashCode() == 3246) {   //sp

            txt_AB.setText("audio libro");
            txt_S.setText("Historia");
            S_bg.setText("... Busca algo ...");
            editText.setHint("Buscar ...");

        } else if (str != null && str.hashCode() == 3307) {   // gr

            txt_S.setText("Geschichte");
            txt_AB.setText("Hörbuch");
            S_bg.setText("... nach etwas suchen ...");
            editText.setHint("Suche ...");
        } else if (str != null && str.hashCode() == 3121) {    // ar

            txt_AB.setText("کتاب صوتی");
            txt_S.setText("قصة");
            S_bg.setText("... ابحث عن شيء ...");
            editText.setHint("بحث ...");
            editText.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        } else {    //en

            txt_S.setText("Story");
            txt_AB.setText("Audio Book");
            S_bg.setText("... Search for something ...");

        }


    }

    //  ================   Search   =========================


    private void filter(String s) {
        List<Book> filterBook = new ArrayList<>();
        List<Audio> filterAudio = new ArrayList<>();

        // Audio Search

        for (Audio audio : audioList) {
            if (audio.getName().toLowerCase().contains(s.toLowerCase()) && audio.getName() != null) {
                filterAudio.add(audio);
            }
        }


        audioAdopter.filterList(filterAudio);


//        Book Search
        for (Book book : bookList) {
            if (book.getName().toLowerCase().contains(s.toLowerCase()) && book.getName() != null) {
                filterBook.add(book);
            }
        }

        bookAdopter.filterList(filterBook);


    }

    private void setUpViews() {
        RelativeLayout = (RelativeLayout) view.findViewById(R.id.search_BG);
        editText = (EditText) view.findViewById(R.id.search_ED_id);
        search_btn = (ImageView) view.findViewById(R.id.Search_btn_id);
        recyclerView = (RecyclerView) view.findViewById(R.id.R_Search_ID);
        txt_AB = (TextView) view.findViewById(R.id.txt_AB);
        txt_S = (TextView) view.findViewById(R.id.txt_S);
        S_bg = (TextView) view.findViewById(R.id.SEARCH_bg);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerAudio = (RecyclerView) view.findViewById(R.id.Rec_Search_Audio_id);
        RecyclerAudio.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void setData() {

        DataBase db = new DataBase(getActivity());

        bookList = db.getBooks();
        bookAdopter = new BookAdopter(getActivity(), bookList, "");

        audioList = db.getAudio();
        audioAdopter = new AudioAdopter(getActivity(), audioList);

        recyclerView.setAdapter(bookAdopter);
        RecyclerAudio.setAdapter(audioAdopter);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void showBackground() {

        RelativeLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        RecyclerAudio.setVisibility(View.GONE);
        txt_AB.setVisibility(View.GONE);
        txt_S.setVisibility(View.GONE);
    }

    private void hiddenBackground() {
        RelativeLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        RecyclerAudio.setVisibility(View.VISIBLE);
        txt_AB.setVisibility(View.VISIBLE);
        txt_S.setVisibility(View.VISIBLE);
    }


}
