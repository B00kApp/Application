package com.mahdirahmani8.myapplication.Adopter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mahdirahmani8.myapplication.AudioBook;
import com.mahdirahmani8.myapplication.Model.Audio;
import com.mahdirahmani8.myapplication.Model.Book;
import com.mahdirahmani8.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AudioAdopter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    List<Audio> audioList;

    public AudioAdopter (Context context , List<Audio> audioList ){
        this.context = context;
        this.audioList = audioList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_activity ,parent, false);
        return new AudioAdopter.ItemViewHolder(view);


    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AudioAdopter.ItemViewHolder itemViewHolder = (AudioAdopter.ItemViewHolder) holder;
        itemViewHolder.item.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_anim));
        itemViewHolder.textView.setText(audioList.get(position).getName());

        Glide.with(context).load(audioList.get(position).getImage()).override(59,59).into(itemViewHolder.imageView);

        // On Click
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AudioBook.class);
                intent.putExtra("ID",audioList.get(position).getId());
                intent.putExtra("NAME",audioList.get(position).getName());
                intent.putExtra("DISC",audioList.get(position).getDisc());
                intent.putExtra("ISONE",audioList.get(position).getIsone());
                intent.putExtra("FAV",audioList.get(position).getFav());
                intent.putExtra("IMAGE",audioList.get(position).getImage());
                intent.putExtra("LAN",audioList.get(position).getLan());
//                intent.putExtra("PART",audioList.get(position).getPart());

                context.startActivity(intent);

            }
        });


    }


    @Override
    public int getItemCount() {
        return audioList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView textView;
        RelativeLayout item;

        public ItemViewHolder(@NonNull View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.name_id);
            item = (RelativeLayout) view.findViewById(R.id.Rel_book_id);
            imageView = (CircleImageView) view.findViewById(R.id.image_id);

        }
    }



    public void filterList (List<Audio> filterList){
        audioList = filterList;
        notifyDataSetChanged();
    }

}
