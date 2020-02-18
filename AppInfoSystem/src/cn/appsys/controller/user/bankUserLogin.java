package cn.appsys.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.dao.backend_userMapper;
import cn.appsys.pojo.backend_user;

@Controller
@RequestMapping("/bankuser")
public class bankUserLogin {
    
	@Autowired
	backend_userMapper mapper;
	
	@RequestMapping("/login")
	public String login(HttpSession session,backend_user backend_user,HttpServletRequest request){
		if(mapper.findUser(backend_user)==null){
	    	 request.setAttribute("error", "�û������������");
	    	 return "jsp/backendlogin";
	     }
	     session.setAttribute("userSession", mapper.findUser(backend_user));
		return "jsp/backend/main";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
	     session.removeAttribute("userSession");
		return "index";
	}
}
