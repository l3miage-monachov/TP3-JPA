package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    public AlbumEntity getAlbumEntity(String name){

        return albumRepository.findById(name).orElseThrow();
    }

    public AlbumEntity createAlbumEntity(AlbumEntity albumEntity){

        albumEntity.builder()
                .title(albumEntity.getTitle())
                .releaseDate(albumEntity.getReleaseDate())
                .songEntities(albumEntity.getSongEntities())
                .artistEntity(albumEntity.getArtistEntity())
                .build();
        return albumRepository.save(albumEntity);

    }

    public AlbumEntity updateAlbum(String title, AlbumEntity albumEntity){
        AlbumEntity exalbumEntity = albumRepository.findById(title).orElseThrow();
        exalbumEntity.setTitle(albumEntity.getTitle());
        exalbumEntity.setReleaseDate(albumEntity.getReleaseDate());
        exalbumEntity.setArtistEntity(albumEntity.getArtistEntity());
        exalbumEntity.setSongEntities(albumEntity.getSongEntities());
        return albumRepository.save(exalbumEntity);
    }

    public void deleteAlbum(String title){

        albumRepository.deleteById(title);
    }
}
