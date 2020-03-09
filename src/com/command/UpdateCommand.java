package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frontController.ICommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class UpdateCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = null;
		
		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO) session.getAttribute("info");
		String email = info.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = MemberDAO.getDAO();
		int cnt = dao.update(dto);
		if(cnt>0) {
			session.setAttribute("info", dto);
		}
		
		moveURL = "main.jsp";
		return moveURL;
		
	}

}
