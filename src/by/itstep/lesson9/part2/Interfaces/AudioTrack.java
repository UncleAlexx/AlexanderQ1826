package by.itstep.lesson9.part2.Interfaces;

import by.itstep.lesson9.part2.Enums.Rating;

public interface AudioTrack {
    String getTitle();
    String getArtist();
    int getDuration();
    String getGenre();
    Rating getRating();
    void setRating(Rating rating);
}
