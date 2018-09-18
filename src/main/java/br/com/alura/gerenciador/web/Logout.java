package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
//		Cookie cookie = new Cookies(req.getCookies()).getUsuadioLogado();
//		if (cookie != null) {
//			cookie.setMaxAge(0);
//			resp.addCookie(cookie);
//		}
		
		HttpSession sessao = req.getSession();
		sessao.removeAttribute("usuarioLogado");
//		sessao.invalidate();
		
//		PrintWriter writer = resp.getWriter();
//		writer.println("<html><body>Usuário deslogado com sucesso.</body></html>");
		
		return "/WEB-INF/paginas/logout.html";
	}
}