# Playlist servlet
## Supported atributes
### doPost
- email - set email on your playlist
- addTrack - add track to your playlist
### doDelete
- delTrack - remove track from your playlist
## Supported urls
- /playlist - apply attributes here (email, addTrack, delTrack)
- /content - gets the content of your playlist
## Other info
The playlist is tied to your sessionID. If it changes the playlist changes too
