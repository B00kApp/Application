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

import com.mahdirahmani8.myapplication.AudioBookLanguage;
import com.mahdirahmani8.myapplication.LanguageActivity;
import com.mahdirahmani8.myapplication.Model.Item;
import com.mahdirahmani8.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AudioBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Item> itemList ;

    public AudioBookAdapter(Context context, List<Item> itemList  ) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent ,false);
        return new AudioBookAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Bind Data
        AudioBookAdapter.ItemViewHolder myviewHolder = (AudioBookAdapter.ItemViewHolder) holder;
        myviewHolder.item.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_anim));
        myviewHolder.name.setText(itemList.get(position).getName());


        myviewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AudioBookLanguage.class);
                intent.putExtra("ID",itemList.get(position).getId());
                intent.putExtra("NAME",itemList.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView name,field;
        RelativeLayout item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_id);
            item = (RelativeLayout) itemView.findViewById(R.id.relative_id);
        }
    }

    public void filterList(List<Item> filterList){

        itemList = filterList;
        notifyDataSetChanged();
    }
}
