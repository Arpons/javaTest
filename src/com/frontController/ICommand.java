package com.frontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	// �������̽� �ȿ��� ����Ʈ �޼��带 ����Ͽ� �Ϲ� �޼��带 ����� �� �ִ�.
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
