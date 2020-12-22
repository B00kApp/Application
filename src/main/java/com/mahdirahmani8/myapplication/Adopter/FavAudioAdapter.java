package com.mahdirahmani8.myapplication.Adopter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.AudioBook;
import com.mahdirahmani8.myapplication.ContentActivity;
import com.mahdirahmani8.myapplication.Model.Audio;
import com.mahdirahmani8.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavAudioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Audio> personList;


    public FavAudioAdapter(Context context, List<Audio> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Bind Data
        ItemViewHolder myviewHolder  = (ItemViewHolder) holder;
        myviewHolder.name.setText(personList.get(position).getName());


        myviewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AudioBook.class);
                intent.putExtra("ID", personList.get(position).getId());
                intent.putExtra("NAME", personList.get(position).getName());
                intent.putExtra("DISC",personList.get(position).getDisc());
//                intent.putExtra("IMAGE", personList.get(position).getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView name , part;
        CardView item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (CircleImageView) itemView.findViewById(R.id.Image_ID);
            name = (TextView) itemView.findViewById(R.id.name_id);
            item = (CardView) itemView.findViewById(R.id.profile_id);
        }
    }

}
