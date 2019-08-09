package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	private ILprodDao dao;
	private static ILprodService service;
	
	public LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	
	public static ILprodService getInstance() {
		if(service==null) service = new LprodServiceImpl();
		return service;
	}
	
	@Override
	public List<LprodVO> getAll() {
		List<LprodVO> lprodList = null;
		try {
			lprodList = dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lprodList;
	}

}
