package com.example.mahe.shareplay;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MAHE on 6/17/2016.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {

    //SparseBooleanArray mCheckStates;


    private ArrayList<Song> songs;




    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,artist;
        public CheckBox checkBox;





        public MyViewHolder(View view){
            super(view);
            title=(TextView)view.findViewById(R.id.song_title);
            artist=(TextView)view.findViewById(R.id.song_artist);
            checkBox=(CheckBox)view.findViewById(R.id.checkBox);


        }
    }





    public SongAdapter(ArrayList<Song> theSongs){
        songs=theSongs;


    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout,parent,false);



        return new MyViewHolder(itemView);


    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Song song=songs.get(position);

        holder.title.setText(song.getTitle());
        holder.artist.setText(song.getArtist());

        holder.checkBox.setChecked(song.getIsSelected());
        holder.checkBox.setTag(song);


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Song song = (Song) cb.getTag();

                song.setSelected(cb.isChecked());
                songs.get(position).setSelected(cb.isChecked());
            }
        });







    }


    @Override
    public int getItemCount() {
        return songs.size();
    }







    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }







    public ArrayList<Song> getSongList() {
        return songs;
    }


}