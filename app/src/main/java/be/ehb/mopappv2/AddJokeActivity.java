package be.ehb.mopappv2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import be.ehb.mopappv2.model.Joke;
import be.ehb.mopappv2.model.JokeDatabase;

public class AddJokeActivity extends AppCompatActivity {

    private EditText etJoke;
    private FloatingActionButton fabSave;

    private View.OnClickListener fabSaveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //make the entity
            Joke nJoke = new Joke(etJoke.getText().toString(), new Date());
            //insert into db
            JokeDatabase.getInstance(getApplicationContext()).getJokeDAO().insertJoke(nJoke);
            //go back to main activity
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_joke);

        etJoke = findViewById(R.id.et_joke);
        fabSave = findViewById(R.id.fab_save);
        fabSave.setOnClickListener(fabSaveListener);



    }
}
