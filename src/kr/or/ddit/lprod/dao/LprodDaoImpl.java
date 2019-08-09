package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.sqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao {
	private SqlMapClient client;
	private static ILprodDao dao;
	
	public LprodDaoImpl() {
		client = sqlMapClientFactory.getSqlMapClient();
	}
	
	public static ILprodDao getInstance() {
		if(dao==null) dao = new LprodDaoImpl();
		return dao;
	}
	
	@Override
	public List<LprodVO> getAll() throws SQLException {
		return client.queryForList("lprod.getAll");
	}

}
