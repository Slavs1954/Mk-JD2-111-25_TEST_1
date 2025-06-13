package org.example.storage.api;

import org.example.dto.Playlist;

import java.util.List;

public interface IPlaylistStorage {
    void add(Playlist playlist);
    List<Playlist> getAll();
}
