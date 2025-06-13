package org.example.service.api;

import org.example.dto.Playlist;

public interface IPlaylistService {
    void add(Playlist playlist);
    Playlist getPlaylist(String sessionID);
}
