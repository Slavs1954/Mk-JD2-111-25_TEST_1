package org.example.controller;

import org.example.service.PlaylistService;
import org.example.service.api.IPlaylistService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/content")
public class ContentServlet extends HttpServlet {

    private final IPlaylistService service = PlaylistService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        var writer = resp.getWriter();
        if (service.getPlaylist(req.getSession().getId()) == null)
        {
            writer.write("<h1>ERROR UNKNOWN USER</h1>");
            return;
        }

        writer.write("<html><body>");
        writer.write("saved email:" + req.getSession().getAttribute("email") + "<br>");
        writer.write("<h1>Your Playlist<h1><h1><ul>");
        for(String track : service.getPlaylist(req.getSession().getId()).getTracks()) {
            writer.write("<li>" + track + "</li>");
        }

        writer.write("</ul></body></html>");
    }
}
