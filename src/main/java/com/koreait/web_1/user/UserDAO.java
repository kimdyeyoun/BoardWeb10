package com.koreait.web_1.user;

import com.koreait.web_1.model.BoardVO;
import com.koreait.web_1.model.UserVO;
import com.koreait.web_1.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static int login(UserVO param){
        String sql = "SELECT iuser, upd, nm FROM t_user WHERE uid = ?";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getUid());//sql uid = param.getUid() = return uid;
            rs = ps.executeQuery();

            if(rs.next()){
                String dbUpd = rs.getString("upd");//dbUpd에 데이터베이스에 담긴 upd정보를 넘기는 과정
                if (dbUpd.equals(param.getUpd())){ //dbUpd와 UserLogin에서 작업한 setUpd에 담긴 정보와 비교
                    param.setIuser(rs.getInt("iuser")); //로그인에 성공했다면 uid값에담긴 iuser 설렉트
                    param.setNm(rs.getString("nm")); //위와동일
                    return 1;//로그인 성공
                }else {
                    return 3;//비밀번호 값이 다름
                }
            }else {
                return 2; //아이디 없음 비밀번호 존재
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps, rs);
        }
        return 0; // 아이디 비밀번호 둘다 존재 하지않음
    }

    public static int join(UserVO param){
        String sql = "INSERT INTO t_user(uid, upd, nm, gender) VALUE (?, ?, ?, ?)";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getUid());
            ps.setString(2, param.getUpd());
            ps.setString(3, param.getNm());
            ps.setInt(4, param.getGender());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps);
        }
        return 0;
    }
}
