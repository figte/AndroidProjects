package com.doctordocplus.espotifai;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bryam Soto on 03/06/2017.
 */

public class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder>{

    private ArrayList<Musica> data;

    public MusicaAdapter(ArrayList<Musica> data) {
        this.data = data;
    }

    @Override
    public MusicaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MusicaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_musica, parent, false));
    }

    @Override
    public void onBindViewHolder(MusicaViewHolder holder, int position) {
        Musica musica = data.get(position);
        holder.imgMusica.setImageResource(musica.getImagen());
        holder.tvNombre.setText(musica.getNombre());
        holder.tvArtista.setText(musica.getArtista());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MusicaViewHolder extends RecyclerView.ViewHolder{

        ImageView imgMusica;
        TextView tvNombre;
        TextView tvArtista;

        public MusicaViewHolder(View itemView) {
            super(itemView);
            imgMusica = (ImageView) itemView.findViewById(R.id.img_musica);
            tvNombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            tvArtista = (TextView) itemView.findViewById(R.id.tv_artista);
        }
    }
}