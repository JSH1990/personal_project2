package board;

import java.sql.Date;

public class main {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		dao.selectOne(1);
	}
}
