package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity getSong(String name){
        return songRepository.findById(name).orElseThrow();
    }

    public SongEntity create(SongEntity songEntity){
        return songRepository.save(songEntity);
    }

    public SongEntity update(String name, SongEntity songEntity){
        SongEntity exSong = songRepository.findById(name).orElseThrow();
        exSong.setDuration(songEntity.getDuration());
        exSong.setTitle(songEntity.getTitle());
        exSong.setAlbumEntity(songEntity.getAlbumEntity());
        exSong.setArtistEntity(songEntity.getArtistEntity());
        return songRepository.save(exSong);
    }

    public void delete(String name){
        songRepository.deleteById(name);
    }

    public SongEntity getSongInInterval(Duration dureeMin, Duration durremax){
        return songRepository.findSongEntityByDurationBetween(dureeMin,durremax);
    }
}
