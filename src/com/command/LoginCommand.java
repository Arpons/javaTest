package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frontController.ICommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LoginCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = null;
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO(email, pw);
		MemberDAO dao = MemberDAO.getDAO();
		MemberDTO info = dao.login(dto);
		if (info != null) {
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
			System.out.println("¼º°ø");
		}
		moveURL = "main.jsp";
		return moveURL;
	}

}
