package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.Playlist;
import org.example.service.PlaylistService;
import org.example.service.api.IPlaylistService;

import java.io.IOException;

@WebServlet(urlPatterns = "/playlist")
public class PlaylistServlet extends HttpServlet {
    private final IPlaylistService service = new PlaylistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var params = req.getParameterNames();


        if (service.getPlaylist(req.getSession().getId()) == null) {
            service.add(new Playlist(req.getSession().getId()));
        }

        while (params.hasMoreElements()) {
            String param = params.nextElement();

            if(param.equals("email")) {
                req.getSession().setAttribute("email", req.getParameter(param));
            }

            if (param.equals("addTrack")) {
                service.getPlaylist(req.getSession().getId()).addTrack(req.getParameter(param));
            }
            if (param.equals("delTrack")) {
                service.getPlaylist(req.getSession().getId()).deleteTrack(req.getParameter(param));
            }


        }
        resp.sendRedirect(req.getContextPath() + "/content");
    }
}
