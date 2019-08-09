package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
/*
 * 1. Dao객체가 필요 - 직접 생성하지 않고 getter를 이용해서 가져온다
 * 2. 다른 Controller에서 공유하여 사용할 수 있도록 자신의 객체를 생성하고 리턴하는 메소드
 */

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> memberList = null;
		try {
			memberList = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

}
