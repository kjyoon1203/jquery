<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
%>

[
<%
	for(int i=0; i<memberList.size(); i++){
		MemberVO memVO = memberList.get(i);
		if(i>0) out.print(",");
%>
	
	<%-- for문 실행시마다 json object를 생성 --%>
	{
		"name"	: "<%=memVO.getMem_name() %>", 
		"id"	: "<%=memVO.getMem_id() %>",
		"addr"	: "<%=memVO.getMem_add1() + " " + memVO.getMem_add2()%>",
		"hp"	: "<%=memVO.getMem_hp() %>"
	}

<%
	}
%>
]