package com.doctordocplus.espotifai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMusicas;
    private GridLayoutManager glm;
    private MusicaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMusicas = (RecyclerView) findViewById(R.id.rv_musicas);

        glm = new GridLayoutManager(this, 2);
        rvMusicas.setLayoutManager(glm);
        adapter = new MusicaAdapter(dataSet());
        rvMusicas.setAdapter(adapter);
    }

    private ArrayList<Musica> dataSet() {
        ArrayList<Musica> data = new ArrayList<>();
        data.add(new Musica("Radioactive", "Imagine Dragons", R.drawable.img_imagine_dragons));
        data.add(new Musica("Radioactive", "Imagine Dragons", R.drawable.img_imagine_dragons));
        data.add(new Musica("Radioactive", "Imagine Dragons", R.drawable.img_imagine_dragons));
        data.add(new Musica("Radioactive", "Imagine Dragons", R.drawable.img_imagine_dragons));
        data.add(new Musica("Radioactive", "Imagine Dragons", R.drawable.img_imagine_dragons));
        data.add(new Musica("Radioactive", "Imagine Dragons", R.drawable.img_imagine_dragons));
        return data;
    }
}