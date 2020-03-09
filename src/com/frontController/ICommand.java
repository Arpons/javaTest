package com.frontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	// 인터페이스 안에서 디폴트 메서드를 사용하여 일반 메서드를 사용할 수 있다.
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
