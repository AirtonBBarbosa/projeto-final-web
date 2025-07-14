package com.gestaofacil.GestaoFacil;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestaofacil.GestaoFacil.model.Usuario;
import com.gestaofacil.GestaoFacil.repository.UsuarioRepository;
import com.gestaofacil.servico.CookieServico;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class Controlador {

	@Autowired
	private UsuarioRepository ur; // Objeto Usuário

	@GetMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		model.addAttribute("email", CookieServico.getCookie(request, "emailUsuario"));
		return "index";
	}

	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}

	@GetMapping("/recursos")
	public String recursos() {
		return "recursos";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/logar")
	public String loginUsuario(Usuario usuario, Model model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Usuario usuariologado = this.ur.login(usuario.getEmail(), usuario.getSenha());
		if (usuariologado != null) {
			CookieServico.setCookie(response, "UsuarioId", String.valueOf(usuariologado.getId()), 3600);
			CookieServico.setCookie(response, "emailUsuario", String.valueOf(usuariologado.getEmail()), 3600);
			return "redirect:/geral";
		}

		model.addAttribute("erro", "Usuário Inválido");
		return "/login";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}

	@GetMapping("/geral")
	public String geral(HttpServletRequest request) throws UnsupportedEncodingException {
		// BLOQUEIA A ROTA E REDIRECIONA PARA O LOGIN
		String id = CookieServico.getCookie(request, "UsuarioId");
		if (id == null) {
			// cookie não existe ou já expirou: força login
			return "redirect:/login";
		}

		return "geral";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastroUsuario(@Valid Usuario usuario, BindingResult result, HttpServletResponse response)
			throws UnsupportedEncodingException {

		if (result.hasErrors()) {
			return "redirect:/cadastro";
		}

		Usuario usuarioSalvo = ur.save(usuario);

		CookieServico.setCookie(response, "UsuarioId", String.valueOf(usuarioSalvo.getId()), 3600);

		CookieServico.setCookie(response, "emailUsuario", String.valueOf(usuarioSalvo.getEmail()), 3600);

		return "redirect:/geral";
	}

	@GetMapping("/relatorios")
	public String relatorios(HttpServletRequest request) throws UnsupportedEncodingException {
		// BLOQUEIA A ROTA E REDIRECIONA PARA O LOGIN
		String id = CookieServico.getCookie(request, "UsuarioId");
		if (id == null) {
			// cookie não existe ou já expirou: força login
			return "redirect:/login";
		}

		return "relatorios";
	}

	@GetMapping("/historico")
	public String historico(HttpServletRequest request) throws UnsupportedEncodingException {
		// BLOQUEIA A ROTA E REDIRECIONA PARA O LOGIN
		String id = CookieServico.getCookie(request, "UsuarioId");
		if (id == null) {
			// cookie não existe ou já expirou: força login
			return "redirect:/login";
		}

		return "historico";
	}

}
