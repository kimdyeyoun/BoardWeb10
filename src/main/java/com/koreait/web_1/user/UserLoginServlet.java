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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");//프론트에 name ="uid"
        String upd = req.getParameter("upd");//프론트에 name ="upd"

        UserVO vo = new UserVO();
        vo.setUid(uid);//값을 담는 과정
        vo.setUpd(upd);

        int result = UserDAO.login(vo);

        if (result == 1){
            vo.setUpd(null);//보안
            HttpSession session = req.getSession();
            //세션 생성
            session.setAttribute("loginUser", vo);
            //setAttribute(String name, Object value), 세션에 값 저장하기 세션이 유지되는 동안 저장된다.

            res.sendRedirect("/board/list");
            return;
        }

        String err = null;

        switch (result){
            case 0:
                err = "로그인 실패";
                break;
            case 2:
                err = "존재하지않는 아이디 입니다.";
                break;
            case 3:
                err = "비밀번호가 다릅니다.";
                break;
        }
        req.setAttribute("errMsg", err);
        doGet(req, res);//같은클래스인 UserLoginService 접근할 수 있다.
    }
}
