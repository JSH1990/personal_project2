package board;

import java.sql.Connection;
import java.sql.Date;
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
		Connection cnn=null;
		Statement stmt=null;
		String query = "SELECT \r\n" + 
				"	`num`,\r\n" + 
				"    `title`,\r\n" + 
				"    `writer`,\r\n" + 
				"    `content`,\r\n" + 
				"    `regdate`,\r\n" + 
				"    `cnt`\r\n" + 
				"FROM \r\n" + 
				"    `board`\r\n" + 
				"ORDER BY \r\n" +
				"    `regdate` DESC;\r\n" + 
				"";
		ResultSet rs=null;
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		try {
			cnn = ju.getConnection();
			stmt = cnn.createStatement();
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
			if(cnn !=null) {
				try {
					cnn.close();
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


			//작성하기


			//수정하기


			//삭제하기


		}
}
