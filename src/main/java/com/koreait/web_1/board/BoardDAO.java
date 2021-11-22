package com.koreait.web_1.board;

import com.koreait.web_1.model.BoardVO;
import com.koreait.web_1.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class BoardDAO {
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static List<BoardVO> selBoardList(){
        List<BoardVO> list = new ArrayList();
        String sql = "SELECT A.iboard, A.title, A.rdt, B.nm AS writerNm  FROM t_board A " +
                "INNER JOIN t_user B ON A.writer = B.iuser ORDER BY iboard DESC";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setRdt(rs.getString("rdt"));
                vo.setWriterNm(rs.getString("writerNm"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps, rs);
        }
        return list;
    }

    public static BoardVO selBoard(BoardVO param){
        BoardVO vo = null;
        String sql = "SELECT A.iboard, A.title, A.ctnt, A.rdt, A.mdt, B.nm AS writerNm FROM t_board A " +
                "INNER JOIN t_user B ON A.writer = B.iuser WHERE A.iboard = ?";

        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            rs = ps.executeQuery();

            if(rs.next()){
                vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setWriterNm(rs.getString("writerNm"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setRdt(rs.getString("rdt"));
                vo.setMdt(rs.getString("mdt"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(con, ps);
        }
        return vo;
    }
}
