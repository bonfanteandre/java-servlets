package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	public Cookie getUsuadioLogado() {
		
		if (this.cookies != null) {
			for(Cookie cookie : this.cookies) {
				if (cookie.getName().equals("usuario.logado")) {
					return cookie;
				}
			}
			return null;
		}
		return null;
	}
}