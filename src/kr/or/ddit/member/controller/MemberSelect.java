package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/MemberSelect")
public class MemberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelect() {
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청시 전송되는 데이터를 받아온다.	
		// DB를 이용하영 CRUD 처리한다.		
		// 처리한 결과를 클라이언트로 응답한다.	
		// 응답타입은 json object 배열로 한다.
		
		IMemberService service = MemberServiceImpl.getInstance();
		List<MemberVO> memberList = service.selectAll();
		
		// CRUD의 결과값 list를 view페이지로 보낸다.
		// 보내는 방법 
		// 1. redirect : 요청했던 page로 response가 나가므로 데이터는 사라지고 view단으로 새로운 request와 response가 재요청한다.
		// 2. forward : server 내부에서 page를 이동하므로 request에서 입력한 데이터를 response를 공유한다.
		// 결과값 list를 request에 저장한다.
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher disp = request.getRequestDispatcher("/0809/memberList.jsp");
		
		disp.forward(request, response);
		
		
	}

}
