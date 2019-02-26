package be.ehb.mopappv2.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Joke {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private  String jokeText;
    private Date publishDate;

    public Joke() {
    }

    //Room gebruikt enkel default constructor
    //Andere mag Room negeren maar kunnen wij nog in code gebruiken
    @Ignore
    public Joke(String jokeText, Date publishDate) {
        this.jokeText = jokeText;
        this.publishDate = publishDate;
    }

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
