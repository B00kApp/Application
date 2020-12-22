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
import com.mahdirahmani8.myapplication.ContentActivity;
import com.mahdirahmani8.myapplication.Model.Audio;
import com.mahdirahmani8.myapplication.Model.Book;
import com.mahdirahmani8.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookAdopter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Book> bookList;
    List<Audio> audioList;
    String Lan;

    public BookAdopter (Context context , List<Book> bookList , String Lan){
        this.context = context;
        this.bookList = bookList;
        this.Lan = Lan;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_activity ,parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.item.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_anim));


        itemViewHolder.textView.setText(bookList.get(position).getName());

        Glide.with(context).load(bookList.get(position).getImage()).override(128,128).into(itemViewHolder.imageView);

        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("ID",bookList.get(position).getId());
                intent.putExtra("NAME",bookList.get(position).getName());
                intent.putExtra("DISC",bookList.get(position).getDisc());
                intent.putExtra("IMAGE",bookList.get(position).getImage());
                intent.putExtra("FAB",bookList.get(position).getFav());
                intent.putExtra("LAN",Lan);
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return bookList.size();
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





    public void filterList (List<Book> filterList){

        bookList = filterList;
        notifyDataSetChanged();
    }


}
