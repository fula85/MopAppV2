package be.ehb.mopappv2.model;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface JokeDao {

    @Insert
    void insertJoke(Joke nJoke);

    @Delete
    void deleteJoke(Joke nJoke);

    @Query("SELECT * FROM Joke")
    List<Joke> selectAllJokes();

    @Query("SELECT * FROM Joke WHERE id = :id")
    Joke selectJokeByID(long id);

}
