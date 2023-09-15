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

public class BoardDao{
	private JdbcUtil ju;

	public BoardDao() {
		ju = JdbcUtil.getInstance();
	}

	//전체조회
	public List<BoardVo> selectAll(){
		Connection conn = null;
		Statement stmt = null;
		String query = "select `num`, `title`, `writer`, `content`, `regdate`, `cnt` from board1";
		ResultSet rs = null;
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();

		try {
			conn=ju.getConnection();
			stmt = conn.createStatement();
			rs=stmt.executeQuery(query);

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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn !=null) {
				try {
					conn.close();
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
	}

	//한개조회
	public BoardVo selectOne(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select `num`, `title`, `writer`, `content`, `regdate`, `cnt` from board1 where `num` = ?"; 
		ResultSet rs = null;
		BoardVo vo = null;

		try {
			conn=ju.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();


			if(rs.next()) {
				vo = new BoardVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(pstmt !=null) {
				try {
					pstmt.close();
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
		}return vo;

	}

	//작성하기
	public int insert(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into board1 (title, writer, content, regdate, cnt) values (?, ?, ?, now(), 0)";
		int ret = -1;

		try {
			conn=ju.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());

			ret = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			if(conn !=null) {
				try {
					conn.close();
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
	}
	
	//수정하기
	public int update(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "update `board1` set `title` = ? , `content` = ? where `num` = ?";
		int ret = -1;
		
		try {
			conn=ju.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
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
	}
	
	//삭제하기
	public int delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "delete from `board1` where `num` = ?";
		int ret = -1;
		
		try {
			conn=ju.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, num);
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
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
	}
	}

