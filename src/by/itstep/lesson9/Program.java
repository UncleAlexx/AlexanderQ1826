package by.itstep.lesson9;

import by.itstep.lesson9.part1.TextAnalyzer;
import by.itstep.lesson9.part2.Common.Song;
import by.itstep.lesson9.part2.Common.Playlist;
import by.itstep.lesson9.part2.Common.Podcast;
import by.itstep.lesson9.part2.Enums.Rating;
import by.itstep.lesson9.part2.Enums.SortOrder;
import java.util.stream.IntStream;

public class Program {
    static void main() {

        TextAnalyzer analyzer = new TextAnalyzer("аргентина манит негра");

        int[]  allLetters = IntStream.concat(IntStream.concat(IntStream.rangeClosed('а','е'), IntStream.of('ё')),
                IntStream.rangeClosed('ж', 'я')).toArray();

        var lettersCounts = analyzer.getEachLetterCount();

        StringBuilder sb = new StringBuilder();

        sb.append("Частота букв: ");

        for (int i = 0; i < lettersCounts.length;i++) {
            if(lettersCounts[i] != 0){
                sb.append(String.format("%s: %s, ", (char)allLetters[i], lettersCounts[i]));
            }
        }

        System.out.printf("""
                        Количество слов: %s
                        Самое длинное слов: %s
                        %s
                        Текст с перевернутыми словами: %s
                        Текст является палиндромом: %s\n""", analyzer.getWordsCount(), analyzer.getTheLongestWord(),
                sb.delete(sb.length() - 2, sb.length()).toString(), analyzer.reverseEachWord(), analyzer.isPhrasePolyndrome()?
                "Да": "Нет");

        Playlist playlist = new Playlist(new Song("Imagine", "John Lennon", 183,
                "Rock", Rating.FIVE, "Imagine"),
                new Song("Bohemian Rhapsody", "Queen", 354,
                "Rock", Rating.FIVE, "A Night at the Opera"),
                 new Song("Billie Jean", "Michael Jackson", 294,
                "Pop", Rating.FOUR, "Thriller"),
                new Podcast("Java Today", "OpenJDK", 45,
                "Technology", Rating.FIVE, "Alice"),
                new Podcast("The Daily", "The New York Times", 25,
                "News", Rating.FOUR, "Michael Barbaro"),
                new Podcast("Science Friday", "Science Friday", 60,
                "Science", Rating.THREE, "Ira Flatow"));
        Podcast podcast1 = new Podcast("Java Today", "OpenJDK", 45,
                "Technology", Rating.FIVE, "Alice");
        Podcast podcast2 = new Podcast("The Daily", "The New York Times", 25,
                "News", Rating.FOUR, "Michael Barbaro");
        Song song1 = new Song("Imagine", "John Lennon", 183,
                "Rock", Rating.FIVE, "Imagine");
        Song song2 = new Song("Bohemian Rhapsody", "Queen", 354,
                "Rock", Rating.FIVE, "A Night at the Opera");

        playlist.addTrack(podcast1);
        playlist.addTrack(podcast2);
        playlist.addTrack(song1);

        System.out.println(playlist.getTracksByGenre("Rock").toString());
        System.out.println(playlist.searchByArtist("John Lennon").toString());
        System.out.println(playlist.searchByTitle("imagine").toString());
        System.out.println(playlist.getCount());
        System.out.println(playlist.removeTrack(podcast1));
        System.out.println(playlist.getCount());
        System.out.println("playlist.getTotalDuration() = " + playlist.getTotalDuration());
        System.out.println(playlist.toString());
        playlist.SortByRating(SortOrder.ASC);
        System.out.println(playlist.toString());
        playlist.SortByRating(SortOrder.DESC);
        System.out.println(playlist.toString());
    }
}
