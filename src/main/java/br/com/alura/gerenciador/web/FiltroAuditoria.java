package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter("/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		String usuarioLogado = "<deslogado>";
		
		HttpSession sessao = req.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario != null) {
			usuarioLogado = usuario.getEmail();
		}
//		Cookie cookie = new Cookies(req.getCookies()).getUsuadioLogado();
//		if (cookie != null) {
//			usuarioLogado = cookie.getValue();
//			cookie.setMaxAge(10 * 60);
//			resp.addCookie(cookie);
//		}
		
		System.out.println(usuarioLogado + " requisitou " + uri);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {	
	}
	
	private Cookie getUsuarioLogado(HttpServletRequest request) {
		
		Cookie cookie = new Cookies(request.getCookies()).getUsuadioLogado();;
		if (cookie != null)
			return cookie;
		
		return null;
	}
}
