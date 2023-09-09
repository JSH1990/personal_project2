package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;

public class BoardDao {
	private JdbcUtil ju;

	public BoardDao() {
		ju = JdbcUtil.getInstance();
	}

	//전체 조회하기
	public List<BoardVo> selectAll(){
		Connection con=null;
		Statement stmt=null;
		String query = "select num, title, writer, content, regdate, cnt FROM board1 ORDER BY regdate DESC;";
		ResultSet rs=null;
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		try {
			con = ju.getConnection();
			stmt = con.createStatement();
			stmt.execute(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				BoardVo vo = new BoardVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
				ls.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}return ls;

			//하나만 조회하기
	}
	

			//작성하기
	public int insert(BoardVo vo) {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query = "insest into board1 (title, writer, content, regdate, cnt) values (?, ?, ?, now(), 0) ";
		int ret = -1;
		
		try {
			con = ju.getConnection();
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}return ret;
		
			//수정하기


			//삭제하기


		}
}
