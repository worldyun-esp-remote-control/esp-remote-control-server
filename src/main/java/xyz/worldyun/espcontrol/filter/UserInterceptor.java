package xyz.worldyun.espcontrol.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import xyz.worldyun.espcontrol.common.exception.MyException;
import xyz.worldyun.espcontrol.common.util.JwtInfo;
import xyz.worldyun.espcontrol.common.util.JwtUtils;
import xyz.worldyun.espcontrol.common.util.UserDetail;
import xyz.worldyun.espcontrol.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String method = request.getMethod();
        if (method.equals("OPTIONS")){
            return true;
        }
        try {
            JwtInfo info = JwtUtils.getMemberIdByJwtToken(request);
            User user =new User();
            user.setUserName(info.getUserName());
            user.setId(info.getId());
            UserDetail.setUserDetail(user);
        }catch (Exception e){
            throw new MyException( 28004, "未登录");
        }
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserDetail.removeUserDetail();
    }

    List<Integer> getRoles(Integer role){
        List<Integer> roles = new ArrayList<>();
        roles.add(role);
        return roles;
    }

}
