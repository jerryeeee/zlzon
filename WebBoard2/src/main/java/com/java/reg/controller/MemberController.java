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

	// @Controller 라고 작성된 클래스의 메소드는 항상 리턴이 존재한다
	// void : 시스템이 자동으로 mapping된 경로에서 jsp를 찾아준다
	// String : return을 작성을 하여 수동으로 경로를 지정해야 한다
	
	
	// 현재 메소드는 하는일(특별한 로직)없이 매핑만 하는 경우
//	@RequestMapping(value = {"userJoin.do", "userLogin.do"})
//	public void userJoin() {
//		System.out.println("호출");
//		//  /user/userJoin 경로에 있는 jsp를 찾아준다
//	}
	
	// @PathVariable = {url}
	// url 주소중에 {}로 감싸면 하나의 변수처럼 파라미터값처럼 사용을 할수있는데
	// 사용하기 위해서는 @PathVariable 써야한다.
	// @PathVariable가 { } 안에 있는 변수명을 가진 값을 가져와준다
	// 그래서 {}안에 있는 변수명과 String 파라미터명은 동일
	
	// 시스템 진행상황상 제일 마지막 실행 된다.
	@RequestMapping(value = "{url}.do")
	public String userJoin(@PathVariable String url) {
		System.out.println("호출");
		return "/user/"+url;
	}
	
	

		
	
	@Autowired
	private MemberSerivce memberSerivce;
	
	
	@RequestMapping(value="userInsert.do")
	public ModelAndView userInsert(MemberVO vo) {
		System.out.println("/userInsert.do 호출");
		
		int result = memberSerivce.userInsert(vo);
		
		String message = "가입되지 않았습니다.";
		
		if(result > 0) {
			message = vo.getUserName()+ " 님 가입 축하드립니다";
		}
		
		// model 단점은 값만 옮길수있고, 화면은 옮길수가 없다
		// String return을 작성해야 했었다.
		
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
			System.out.println("[ "+result.getUserId()+ " ] 로그인 접속");
			
			session.setAttribute("sessionTime", new Date().toLocaleString());
			session.setAttribute("userId", result.getUserId());
			session.setAttribute("userPass", result.getUserPass());
			session.setAttribute("userName", result.getUserName());
		}
		return "/user/login_ok";
	}
	
	
	
	
	@RequestMapping(value="/idCheck.do", produces = "application/text; charset=utf8")
	@ResponseBody // 화면이 전환되지 않고 비동기통신이 가능하도록 하는 어노테이션
	public String idCheck(MemberVO vo) {
		
		MemberVO resultVO = memberSerivce.idCheck_Login(vo);
		String result="ID가 사용가능합니다";
		if(resultVO != null)  result="중복된 ID입니다";
		return result;
	}
	
	
	
	
	
	
	@RequestMapping(value="login_ok.do")
	public String memberInfo() {
		System.out.println("memberInfo() 호출");
		return "/user/memberInfo";
	}
	
	
	
//	redirect:/getBoardList.do
	
	
	
	
	
	
	
	@RequestMapping(value="/test.do")
	public void test() {
		System.out.println("/test요청");
	}
}
