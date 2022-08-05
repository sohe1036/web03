package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shop.common.JDBCConnection;
import com.shop.common.QuestionVO;

public class QuestionDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql ="";
	int cnt = 0;
	
	//qna목록
	public ArrayList<QuestionVO> getQuestionList() {
		ArrayList<QuestionVO> qna = null;
		try {
			conn= JDBCConnection.getConnection();
			sql = "select qno,qtitle,qcontent,to_char(qdate,'yyyy-MM-dd')as qdate,u_id,ano,acontent,to_char(adate,'yyyy-MM-dd') as adate from question order by qno desc ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			qna = new ArrayList<QuestionVO>();
			while(rs.next()) {
				QuestionVO qvo = new QuestionVO();
				if(rs.getString("acontent")!=null) {
				qvo.setQno(rs.getInt("qno"));
				qvo.setQtitle(rs.getString("qtitle"));
				qvo.setQcontent(rs.getString("qcontent"));
				qvo.setQdate(rs.getString("qdate"));
				qvo.setAno(rs.getInt("ano"));
				qvo.setAcontent(rs.getString("acontent"));
				qvo.setU_id(rs.getString("u_id"));
				qvo.setAdate(rs.getString("adate"));
				} else {
					qvo.setQno(rs.getInt("qno"));
					qvo.setQtitle(rs.getString("qtitle"));
					qvo.setQcontent(rs.getString("qcontent"));
					qvo.setQdate(rs.getString("qdate"));
					qvo.setU_id(rs.getString("u_id"));
				}
				qna.add(qvo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		
		return qna;
	}
	
	public QuestionVO getQuestion(int qno) {
		QuestionVO question = new QuestionVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select qno,qtitle,qcontent,to_char(qdate,'yyyy-MM-dd')as qdate,u_id,ano,acontent,to_char(adate,'yyyy-MM-dd') as adate from question where qno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("acontent")!=null) {
					question.setQno(rs.getInt("qno"));
					question.setQtitle(rs.getString("qtitle"));
					question.setQcontent(rs.getString("qcontent"));
					question.setQdate(rs.getString("qdate"));
					question.setAno(rs.getInt("ano"));
					question.setAcontent(rs.getString("acontent"));
					question.setU_id(rs.getString("u_id"));
					question.setAdate(rs.getString("adate"));
					} else {
						question.setQno(rs.getInt("qno"));
						question.setQtitle(rs.getString("qtitle"));
						question.setQcontent(rs.getString("qcontent"));
						question.setQdate(rs.getString("qdate"));
						question.setU_id(rs.getString("u_id"));
					}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return question;
	}
	
	//답글달기
	public int answerAdd(QuestionVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "update question set ano=?,acontent=?,adate=sysdate where qno=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAno());
			pstmt.setString(2, vo.getAcontent());
			pstmt.setInt(3, vo.getQno());
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	//질문하기
	public int addQuestion(QuestionVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into question (qno, qtitle, qcontent, qdate, u_id) values(seq_question.nextval,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getQtitle());
			pstmt.setString(2, vo.getQcontent());
			pstmt.setString(3, vo.getU_id());
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
}
