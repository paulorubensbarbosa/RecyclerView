package com.example.recycleview2.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recycleview2.R;
import com.example.recycleview2.activity.activity.RecyclerItemClickListener;
import com.example.recycleview2.activity.activity.adapter.Adapter;
import com.example.recycleview2.activity.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //Criando um array para armazenar objetos do tipo filme
    private List<Filme> listaFilme = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerFilmes);

        //Criar listagem de filme

        this.criarFilmes();

        //Configurar o adapter
        Adapter adapter = new Adapter( listaFilme );



        //Configurar o RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));


        //Evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilme.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        " " +
                                                filme.getTitulo()+ " " + filme.getAno()+ " " + filme.getGenero(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilme.get( position );
                                Toast.makeText(getApplicationContext(),
                                        "Click Longo: " + filme.getTitulo(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void criarFilmes(){
        Filme filme = new Filme("Meu malvado favorito", "Comédia e Aventura", "2017");
        this.listaFilme.add(filme);

        filme = new Filme ("Spider-Man", "Aventura", "2017");
        this.listaFilme.add(filme);

        filme = new Filme("Os vingadores", "Ação", "2020");
        this.listaFilme.add(filme);

        filme = new Filme("Viuva negra", "Ação", "2022");
        this.listaFilme.add(filme);

        filme = new Filme("X-men", "Ação", "2014");
        this.listaFilme.add(filme);

        filme = new Filme("Os Croods", "Aventura", "2017");
        this.listaFilme.add(filme);

        filme = new Filme("Viva, a vida é uma festa", "Aventura", "2019");
        this.listaFilme.add(filme);

        filme = new Filme("Percy Jackson", "Aventura", "2017");
        this.listaFilme.add(filme);

        filme = new Filme("Deadpol", "Romance", "2019");
        this.listaFilme.add(filme);

        filme = new Filme("Facebook", "Ficção científica", "2018");
        this.listaFilme.add(filme);

        filme = new Filme("Vivendo a vida adoidado", "Comédia", "2015");
        this.listaFilme.add(filme);

        filme = new Filme("Click", "Comédia", "2019");
        this.listaFilme.add(filme);
    }

}
