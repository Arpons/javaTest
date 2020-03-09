package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontController.ICommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class JoinCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String moveURL = null;
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = MemberDAO.getDAO();
		dao.join(dto);
		
		moveURL = "main.jsp";
		
		return moveURL;
	}

}
