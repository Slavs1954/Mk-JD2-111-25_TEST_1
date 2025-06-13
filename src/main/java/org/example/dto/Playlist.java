package org.example.dto;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<String> tracks;
    private final String sessionID;

    public Playlist(String sessionID) {
        this.sessionID = sessionID;
        this.tracks = new ArrayList<>();
    }

    public List<String> getTracks() {
        return tracks;
    }

    public String getSessionID() {
        return sessionID;
    }
    public boolean addTrack(String track) {
        return tracks.add(track);
    }
    public boolean deleteTrack(String track) {
        return tracks.remove(track);
    }
}
