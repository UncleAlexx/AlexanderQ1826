package by.itstep.lesson9.part2.Common;

import by.itstep.lesson9.part2.Abstractions.AbstractAudioTrack;
import by.itstep.lesson9.part2.Enums.Rating;

import java.util.Objects;

public final class Podcast extends AbstractAudioTrack {

    public String host;

    public Podcast(String title, String artist, int duration, String genre, Rating rating, String host) {
        super(title, artist, duration, genre, rating);
        this.host = host;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)){
            return false;
        }
        Podcast podcast = (Podcast) o;
        return Objects.equals(host, podcast.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), host);
    }

    public int compareTo(AbstractAudioTrack other) {
        int superComparison = super.compareTo(other);

        if(other instanceof Podcast otherPodcast) {
            return superComparison == 0? host.compareTo(otherPodcast.host) : superComparison;
        }
        return superComparison;
    }

    @Override
    public String toString() {
        return  "Podcast{" +
                super.toString() +
                "\nhost='" + host + '\'' +
                '}';
    }
}
