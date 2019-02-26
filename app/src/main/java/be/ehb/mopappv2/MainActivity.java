package be.ehb.mopappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import be.ehb.mopappv2.model.Joke;
import be.ehb.mopappv2.model.JokeDatabase;
import be.ehb.mopappv2.utilities.JokeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Welke container, recyclerview
        rvJokes = findViewById(R.id.rv_jokes);
        //welke data, uit dao
        List<Joke> items = JokeDatabase.getInstance(getApplicationContext()).getJokeDAO().selectAllJokes();
        //adapter, hoe moet alles opgevuld worden
        JokeAdapter jokeAdapter = new JokeAdapter(items);
        //welke layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        //alles samenvoegen
        rvJokes.setAdapter(jokeAdapter);
        rvJokes.setLayoutManager(gridLayoutManager);

    }

    /*menu*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mi_add :
                Intent intent = new Intent(getApplicationContext(), AddJokeActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
