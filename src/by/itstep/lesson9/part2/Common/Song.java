package by.itstep.lesson9.part2.Common;

import by.itstep.lesson9.part2.Abstractions.AbstractAudioTrack;
import by.itstep.lesson9.part2.Enums.Rating;

import java.util.Objects;

public final class Song extends AbstractAudioTrack {
    public String album;

    public Song(String title, String artist, int duration, String genre, Rating rating, String album) {
        super(title, artist, duration, genre, rating);
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Song song = (Song) o;
        return Objects.equals(album, song.album);
    }

    @Override
    public int compareTo(AbstractAudioTrack other) {
        int superComparison = super.compareTo(other);
        if(other instanceof Song otherSong) {
            return superComparison == 0? album.compareTo(otherSong.album) : superComparison;
        }
        return superComparison;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), album);
    }

    @Override
    public String toString() {
        return  "Song{" +
                super.toString() +
                "\nalbum='" + album + '\'' +
                '}';
    }
}
