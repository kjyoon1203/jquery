package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.sqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
/*
 * 1. Mapper에 접근하기 위해서 SqlMapClient객체가 필요 - 싱글톤 이용
 * 2. 자신의 Dao객체를 다른 서비스에서 공유하여 사용할 수 있도록 생성 -> 자신의 객체를 return시켜주는 메소드 정의
 */
public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient client;
	private static IMemberDao dao;
	
	public MemberDaoImpl() {
		client = sqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDao getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public List<MemberVO> selectAll() throws SQLException {
		return client.queryForList("member.selectAll");
	}

}
