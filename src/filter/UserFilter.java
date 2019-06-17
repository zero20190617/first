package filter;

import pojo.User;
import server.UserServer;
import utlis.JsonUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


public class UserFilter implements Filter {
    private UserServer userServer;
    private List<String> nofilters;

    public UserFilter() {
        this.userServer = new UserServer();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object longin_info = session.getAttribute("LONGIN_INFO");
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        String subs = requestURI.substring(contextPath.length());
        if ((longin_info != null && !"".equals(longin_info)) || nofilters.contains(subs)) {
            chain.doFilter(req, resp);
            return;
        }

        User user = new User();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("AUTOLOGIN_INFO".equals(cookie.getName())) {
                    String userJson = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    user = JsonUtils.jsonToPojo(userJson, User.class);
                }
            }
        }
        if (user != null) {
            if (userServer.islongin(user)) {
                userServer.updatetime(user);
                User selectinfo = userServer.selectUserInfo(user.getUserName());
                session.setAttribute("LONGIN_INFO", selectinfo);
                request.getRequestDispatcher("/all?index=1&number=2").forward(request, response);
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect(request.getContextPath() + "/longin.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/longin.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.nofilters = new ArrayList<>();
        String nofilter = config.getInitParameter("nofilter").trim();
        String[] split = nofilter.split(",");
        for (String s : split) {
            this.nofilters.add(s.trim());
        }

    }
}
