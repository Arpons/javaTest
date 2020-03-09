package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frontController.ICommand;

public class LogoutCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = null;
		HttpSession session = request.getSession();
		session.removeAttribute("info");
		moveURL = "main.jsp";
		return moveURL;
	}

}
