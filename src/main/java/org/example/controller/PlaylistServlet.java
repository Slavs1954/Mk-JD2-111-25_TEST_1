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
import java.util.Enumeration;

@WebServlet(urlPatterns = "/playlist")
public class PlaylistServlet extends HttpServlet {
    private final IPlaylistService service = PlaylistService.getInstance();

    private boolean ensurePlaylistExists(HttpServletRequest req) {
        if (service.getPlaylist(req.getSession().getId()) == null) {
            service.add(new Playlist(req.getSession().getId()));
            return true;
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ensurePlaylistExists(req);
        resp.sendRedirect(req.getContextPath() + "/content");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> params = req.getParameterNames();


        ensurePlaylistExists(req);
        while (params.hasMoreElements()) {
            String param = params.nextElement();

            if(param.equals("email")) {
                req.getSession().setAttribute("email", req.getParameter(param));
            }

            if (param.equals("track")) {
                service.getPlaylist(req.getSession().getId()).addTrack(req.getParameter(param));
            }
        }
        resp.sendRedirect(req.getContextPath() + "/content");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> params = req.getParameterNames();

        ensurePlaylistExists(req);

        while (params.hasMoreElements()) {
            String param = params.nextElement();

            if (param.equals("track")) {
                service.getPlaylist(req.getSession().getId()).deleteTrack(req.getParameter(param));
            }


        }
        resp.sendRedirect(req.getContextPath() + "/content");
    }

}
