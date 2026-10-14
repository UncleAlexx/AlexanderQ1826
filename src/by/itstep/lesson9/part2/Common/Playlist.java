package by.itstep.lesson9.part2.Common;

import by.itstep.lesson9.part2.Enums.SortOrder;
import by.itstep.lesson9.part2.Interfaces.AudioTrack;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class Playlist {
    private final ArrayList<AudioTrack> songs;

    private static final Function<AudioTrack, String> TITLE_SELECTOR = x -> x.getTitle();
    private static final Function<AudioTrack, String> ARTIST_SELECTOR = x -> x.getArtist();
    private static final Function<AudioTrack, String> GENRE_SELECTOR = x -> x.getGenre();
    private static final BiFunction<String,String, Boolean> EQUALS = String::equals;
    private static final BiFunction<String,String, Boolean> EQUALS_IGNORE_CASE = String::equalsIgnoreCase;
    private static final StringBuilder toStringBuilder = new StringBuilder();

    public Playlist(AudioTrack... tracks) {
        this.songs = new ArrayList<>(List.of(tracks));
    }

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public AudioTrack addTrack(AudioTrack track) {
        if(track != null)
            songs.add(track);
        return track;
    }

    public int getCount() {
        return songs.size();
    }

    public AudioTrack removeTrack(AudioTrack track)
    {
        if(track != null)
            songs.remove(track);
        return  track;
    }

    public void SortByRating(SortOrder order){
        songs.sort(new Comparator<AudioTrack>() {
            @Override
            public int compare(AudioTrack one, AudioTrack other) {
                return one.getRating().compareTo(other.getRating()) * order.value;
            }
        });
    }

    public List<AudioTrack> searchByTitle(String title){
        return tracksByKey(TITLE_SELECTOR, title, true);
    }

    public List<AudioTrack> searchByArtist(String artist) {
        return tracksByKey(ARTIST_SELECTOR, artist, true);
    }

    public List<AudioTrack> getTracksByGenre(String genre) {
        return tracksByKey(GENRE_SELECTOR, genre, false);
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (AudioTrack song : songs) {
            if(song != null)
                totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    private List<AudioTrack> tracksByKey(Function<AudioTrack, String> keySelector, String value, boolean ignoreCase){

        ArrayList<AudioTrack> tracks = new ArrayList<>();
        for (var audioTrack : songs){
            if(audioTrack != null && (ignoreCase? EQUALS_IGNORE_CASE : EQUALS).apply(keySelector.apply(audioTrack), value)){
                tracks.add(audioTrack);
            }
        }
        return  tracks;
    }

    @Override
    public String toString() {
        toStringBuilder.delete(0, toStringBuilder.length());
        for (AudioTrack song : songs) {
            toStringBuilder.append(song.toString());
            toStringBuilder.append('\n');
        }
        return toStringBuilder.toString();
    }
}
