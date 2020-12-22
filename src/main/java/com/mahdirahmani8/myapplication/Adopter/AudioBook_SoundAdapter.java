package com.mahdirahmani8.myapplication.Adopter;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.ContentActivity;
import com.mahdirahmani8.myapplication.GetAudio;
import com.mahdirahmani8.myapplication.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class AudioBook_SoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<String> links;
    MediaPlayer mediaPlayer;
    String name;

    private AudioManager audioManager;

    // Constructor
    public AudioBook_SoundAdapter(Context context, ArrayList<String> links , String name) {
        this.context = context;
        this.links = links;
        this.name = name;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio, parent, false);
        return new AudioBook_SoundAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AudioBook_SoundAdapter.ItemViewHolder itemViewHolder = (AudioBook_SoundAdapter.ItemViewHolder) holder;

        int Number = position +1 ;
        String Part_Name = Number + " - " + name ;
        itemViewHolder.txt.setText(Part_Name);

        mediaPlayer = new MediaPlayer();

//        String link = links.get(position);

        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GetAudio.class);
                //  Put Extra
                intent.putExtra("POS",position);
                intent.putExtra("LINKS", links );
                intent.putExtra("END",links.size());
                intent.putExtra("NAME",Part_Name);

                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return links.size();
    }


    // Class ItemViewHolder
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button btn_play;
        SeekBar seekBar;
        TextView txt;
        ImageView btn_back;
        ProgressWheel progressWheel;

        public ItemViewHolder(View view) {
            super(view);

            btn_play = (Button) view.findViewById(R.id.PLAY_id);
            progressWheel = (ProgressWheel) view.findViewById(R.id.Progress_id);
            btn_back = (ImageView) view.findViewById(R.id.back_id);
            txt = (TextView) view.findViewById(R.id.Txt_id);
        }

        @Override
        public void onClick(View v) {
        int View_id = v.getId();

        }

    }


}
