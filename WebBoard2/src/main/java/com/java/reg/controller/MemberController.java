package com.java.reg.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.reg.domain.MemberVO;
import com.java.reg.service.MemberSerivce;

@Controller
@RequestMapping("/user/")
public class MemberController {

	// @Controller ��� �ۼ��� Ŭ������ �޼ҵ�� �׻� ������ �����Ѵ�
	// void : �ý����� �ڵ����� mapping�� ��ο��� jsp�� ã���ش�
	// String : return�� �ۼ��� �Ͽ� �������� ��θ� �����ؾ� �Ѵ�
	
	
	// ���� �޼ҵ�� �ϴ���(Ư���� ����)���� ���θ� �ϴ� ���
//	@RequestMapping(value = {"userJoin.do", "userLogin.do"})
//	public void userJoin() {
//		System.out.println("ȣ��");
//		//  /user/userJoin ��ο� �ִ� jsp�� ã���ش�
//	}
	
	// @PathVariable = {url}
	// url �ּ��߿� {}�� ���θ� �ϳ��� ����ó�� �Ķ���Ͱ�ó�� ����� �Ҽ��ִµ�
	// ����ϱ� ���ؼ��� @PathVariable ����Ѵ�.
	// @PathVariable�� { } �ȿ� �ִ� �������� ���� ���� �������ش�
	// �׷��� {}�ȿ� �ִ� ������� String �Ķ���͸��� ����
	
	// �ý��� �����Ȳ�� ���� ������ ���� �ȴ�.
	@RequestMapping(value = "{url}.do")
	public String userJoin(@PathVariable String url) {
		System.out.println("ȣ��");
		return "/user/"+url;
	}
	
	

		
	
	@Autowired
	private MemberSerivce memberSerivce;
	
	
	@RequestMapping(value="userInsert.do")
	public ModelAndView userInsert(MemberVO vo) {
		System.out.println("/userInsert.do ȣ��");
		
		int result = memberSerivce.userInsert(vo);
		
		String message = "���Ե��� �ʾҽ��ϴ�.";
		
		if(result > 0) {
			message = vo.getUserName()+ " �� ���� ���ϵ帳�ϴ�";
		}
		
		// model ������ ���� �ű���ְ�, ȭ���� �ű���� ����
		// String return�� �ۼ��ؾ� �߾���.
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("user/userJoin_ok");
		mv.addObject("message", message);
		mv.addObject("result", result);
		return mv;
	}
	
	
	
	
	
	@RequestMapping("login.do")
	public String login(MemberVO vo, HttpSession session) {
		
		MemberVO result = memberSerivce.idCheck_Login(vo);
		
		if(result == null || result.getUserId()==null) {
			return "/user/userLogin";
		}else {
			System.out.println("[ "+result.getUserId()+ " ] �α��� ����");
			
			session.setAttribute("sessionTime", new Date().toLocaleString());
			session.setAttribute("userId", result.getUserId());
			session.setAttribute("userPass", result.getUserPass());
			session.setAttribute("userName", result.getUserName());
		}
		return "/user/login_ok";
	}
	
	
	
	
	@RequestMapping(value="/idCheck.do", produces = "application/text; charset=utf8")
	@ResponseBody // ȭ���� ��ȯ���� �ʰ� �񵿱������ �����ϵ��� �ϴ� ������̼�
	public String idCheck(MemberVO vo) {
		
		MemberVO resultVO = memberSerivce.idCheck_Login(vo);
		String result="ID�� ��밡���մϴ�";
		if(resultVO != null)  result="�ߺ��� ID�Դϴ�";
		return result;
	}
	
	
	
	
	
	
	@RequestMapping(value="login_ok.do")
	public String memberInfo() {
		System.out.println("memberInfo() ȣ��");
		return "/user/memberInfo";
	}
	
	
	
//	redirect:/getBoardList.do
	
	
	
	
	
	
	
	@RequestMapping(value="/test.do")
	public void test() {
		System.out.println("/test��û");
	}
}
