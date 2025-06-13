package org.example.service;

import org.example.controller.PlaylistServlet;
import org.example.dto.Playlist;
import org.example.service.api.IPlaylistService;
import org.example.storage.PlaylistStorageRam;
import org.example.storage.api.IPlaylistStorage;

import java.util.*;

public class PlaylistService implements IPlaylistService {

    private static PlaylistService instance;
    private final IPlaylistStorage storage  = new PlaylistStorageRam();

    private PlaylistService() {

    }

    public static PlaylistService getInstance() {
        if (instance == null) {
            instance = new PlaylistService();
        }
        return instance;
    }
    @Override
    public void add(Playlist playlist) {
        this.storage.add(playlist);
    }

    @Override
    public Playlist getPlaylist(String sessionID) {
        for (Playlist playlist : this.storage.getAll()) {
            if (Objects.equals(playlist.getSessionID(), sessionID)) {
                return playlist;
            }
        }
        return null;
    }
}
