package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylist(String name){
        return playlistRepository.findById(name).orElseThrow();
    }

    public PlaylistEntity createPlaylistEntity(PlaylistEntity playlistEntity){

        return playlistRepository.save(playlistEntity);


    }

    public PlaylistEntity updatePlaylistEntity(String name, PlaylistEntity playlistEntity){
        PlaylistEntity explaylist = playlistRepository.findById(name).orElseThrow();
        explaylist.setName(playlistEntity.getName());
        explaylist.setDescription(playlistEntity.getDescription());
        explaylist.setTotalDuration(playlistEntity.getTotalDuration());
        explaylist.setSongEntities(playlistEntity.getSongEntities());
        return playlistRepository.save(explaylist);


    }

    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }
}
