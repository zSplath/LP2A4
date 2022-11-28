package br.com.caelum.mvc.logica;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Logica {
    String executa(HttpServletRequest req,               HttpServletResponse res) throws Exception;
}
