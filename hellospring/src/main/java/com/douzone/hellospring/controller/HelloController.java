package com.douzone.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") 
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2") 
	public String hello(String name, int age) {
		// nickname을 request 안에 파라미터로 넘겨올 수 있음
		// 파라미터는 String으로 받지만, 핸들러한테 자료형을 맞춰 줄 수 있다.
		System.out.println("name: " + name + ", age: " + age);
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	// hello3과 hello4는 모델에 객체 파라미터를 저장하는 방식
	// 무엇을 사용할지는 선택
	@RequestMapping("/hello3") 
	public ModelAndView hello(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello4") 
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}
	
	// HTTP요청의 body 내용으로 매핑하여 클라이언트로 전송
	@ResponseBody
	@RequestMapping("/hello5") 
	public String hello5() {
		return "<h1>Hello Spring<h1>";
	}
	
	@RequestMapping("/hello6") 
	public String hello6() {
		// hello 매핑으로 전달
		return "redirect:/hello";
	}
	
	// spring에서도 servlet과 같은 방식으로 작성할 수 있지만, 권장하지 않음
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
		String name = request.getParameter("name");
		out.write("hello " + name);
	}
}
