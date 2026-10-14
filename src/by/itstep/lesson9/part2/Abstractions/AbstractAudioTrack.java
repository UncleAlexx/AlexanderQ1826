package by.itstep.lesson9.part2.Abstractions;

import by.itstep.lesson9.part2.Common.Podcast;
import by.itstep.lesson9.part2.Common.Song;
import by.itstep.lesson9.part2.Enums.Rating;
import by.itstep.lesson9.part2.Interfaces.AudioTrack;
import by.itstep.lesson9.part2.Common.Song;

import java.util.Objects;

public abstract class AbstractAudioTrack
        implements AudioTrack, Comparable<AbstractAudioTrack>  {
    private final String title;
    private final String artist;
    private final String genre;
    private final int duration;

    private final static int DEFAULT_DURATION = 60;

    private Rating rating;

    public AbstractAudioTrack(String title, String artist, int duration, String genre, Rating rating) {
        this.title = title;
        this.artist = artist;
        this.duration = positiveOrDefault(duration, DEFAULT_DURATION);
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public Rating getRating() {
        return rating;
    }

    private int  positiveOrDefault(int tValue, int defaultValue) {
        return  tValue > 0  ? tValue : defaultValue;
    }

    @Override
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", DEFAULT_DURATION=" + DEFAULT_DURATION +
                ", rating=" + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAudioTrack that = (AbstractAudioTrack) o;
        return duration == that.duration && Objects.equals(title, that.title) && Objects.equals(artist, that.artist) &&
                Objects.equals(genre, that.genre) && rating == that.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, genre, duration, DEFAULT_DURATION, rating);
    }

    @Override
    public int compareTo(AbstractAudioTrack other) {
        return currentIfNotZero(currentIfNotZero(
               currentIfNotZero(currentIfNotZero(title.compareTo(other.title), artist.compareTo(other.artist)),
               Integer.compare(duration, other.duration)),
               genre.compareTo(other.genre)),
               rating.compareTo(other.rating));
    }

    private int currentIfNotZero(int current, int next) {
        return current != 0 ? current : next;
    }
}
