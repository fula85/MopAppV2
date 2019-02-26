package be.ehb.mopappv2.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(version = 1, entities = {Joke.class}, exportSchema = false)
@TypeConverters({Convertor.class})
public abstract class JokeDatabase extends RoomDatabase {

    private static JokeDatabase instance;

    public static JokeDatabase getInstance(Context context) {
        if(instance == null){
            instance = createDatabase(context);
        }
        return instance;
    }

    private static JokeDatabase createDatabase(Context context) {
       return Room.databaseBuilder(context, JokeDatabase.class, "jokes.db")
               .allowMainThreadQueries()
               .build();
    }

    public  abstract JokeDao getJokeDAO();

}
