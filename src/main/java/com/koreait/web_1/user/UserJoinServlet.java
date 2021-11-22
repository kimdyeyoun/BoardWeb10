package com.koreait.web_1.user;

import com.koreait.web_1.model.BoardVO;
import com.koreait.web_1.model.UserVO;
import com.koreait.web_1.utils.MyUtils;
import org.apache.catalina.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/join");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upd = req.getParameter("upd");
        String nm = req.getParameter("nm");
        int gender = Integer.parseInt(req.getParameter("gender"));

        UserVO vo = new UserVO();
        vo.setUid(uid);
        vo.setUpd(upd);
        vo.setNm(nm);
        vo.setGender(gender);

        int r = UserDAO.join(vo);

        switch (r){
            case 0:
                req.setAttribute("msg", "회원가입에 실패했습니다");
                doGet(req, res);
                break;
            case 1:
                res.sendRedirect("/user/login");
                break;
        }
    }
}
