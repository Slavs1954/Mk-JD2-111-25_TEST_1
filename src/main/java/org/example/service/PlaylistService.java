package org.example.service;

import org.example.dto.Playlist;
import org.example.service.api.IPlaylistService;
import org.example.storage.PlaylistStorageRam;
import org.example.storage.api.IPlaylistStorage;

import java.util.*;

public class PlaylistService implements IPlaylistService {

    private static final IPlaylistStorage storage = new PlaylistStorageRam();

    @Override
    public void add(Playlist playlist) {
        //VALIDATION
        this.storage.add(playlist);
    }

    @Override
    public Playlist getPlaylist(String sessionID) {
        for (Playlist playlist : storage.getAll()) {
            if (Objects.equals(playlist.getSessionID(), sessionID)) {
                return playlist;
            }
        }
        return null;
    }
}
