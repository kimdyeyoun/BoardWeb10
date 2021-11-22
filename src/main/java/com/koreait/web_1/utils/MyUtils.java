package com.koreait.web_1.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyUtils {

    public static void disForward(HttpServletRequest req, HttpServletResponse res, String path) throws ServletException, IOException {
        String path1 = "/WEB-INF/view/" + path + ".jsp";
        req.getRequestDispatcher(path1).forward(req, res);
    }
}
