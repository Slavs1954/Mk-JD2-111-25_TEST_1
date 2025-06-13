package org.example.storage;

import org.example.dto.Playlist;
import org.example.storage.api.IPlaylistStorage;

import java.util.ArrayList;
import java.util.List;

public class PlaylistStorageRam implements IPlaylistStorage {
    private final List<Playlist> playlists = new ArrayList<>();

    @Override
    public void add(Playlist playlist) {
        this.playlists.add(playlist);
    }

    @Override
    public List<Playlist> getAll() {
        return this.playlists;
    }
}
