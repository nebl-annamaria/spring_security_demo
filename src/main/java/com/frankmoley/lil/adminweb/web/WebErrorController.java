package com.frankmoley.lil.adminweb.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class WebErrorController implements ErrorController {

	private final ErrorAttributes errorAttributes;

	public WebErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@GetMapping("/error")
	public String getErrorPage(HttpServletRequest request, Model model) {
		WebRequest webRequest = new ServletWebRequest(request);
		Map<String, Object> errors = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

		Object statusObj = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		int statusCode = (statusObj != null) ? Integer.parseInt(statusObj.toString()) : 500;

		String errorText;
		if (statusCode == HttpStatus.NOT_FOUND.value()) {
			errorText = "The page you are looking for cannot be found.";
		} else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
			errorText = "You are not authorized to access the requested page.";
		} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
			errorText = "You don't have permission to access this page.";
		} else {
			errorText = "Something went wrong. Please try again later.";
		}

		model.addAttribute("errorCode", statusCode);
		model.addAttribute("errorText", errorText);
		model.addAttribute("timestamp", errors.get("timestamp"));
		model.addAttribute("path", errors.get("path"));

		return "error";
	}

	public String getErrorPath() {
		return "/error";
	}
}
