package cn.sm1234.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sm1234.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/login")
	public String login(User user,String rememberMe,HttpServletRequest request,Model model) {
//		使用shiro进行登陆
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
		if(rememberMe!=null && rememberMe.equals("1")) {//对于checkbox，如果没有选中，默认值是null! 后面的rememberMe.equals("1")应该可以去掉？
			token.setRememberMe(true);//与filterMap.put("/index","user");构成组合。判断页面是否使用了记住我。
		}
		try {
			subject.login(token);
//			登陆成功
			User dbuser = (User)subject.getPrincipal();
			request.getSession().setAttribute("username", dbuser.getName());
			return "redirect:/index";
			
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "用户名不存在");
			return "login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "密码错误");
			return "login";
		}
	}
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();//删除shiro的session会员信息
		return "redirect:/toLogin";
	}
}
