package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.buu.meeting.biz.MeetingBiz;
import edu.buu.meeting.entity.SearchMeeting;

@WebServlet("/NotificationsSvl")
public class NotificationsSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public NotificationsSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingBiz biz = new MeetingBiz();
		HttpSession session = request.getSession();
		int empid = (Integer) session.getAttribute("employeeid");
		List<SearchMeeting> futurelist = biz.viewMyFutureMeeting(empid);
		request.setAttribute("futurelist", futurelist);
		List<SearchMeeting> canclelist = biz.viewMyCancleMeeting(empid);
		request.setAttribute("canclelist", canclelist);
		request.getRequestDispatcher("notifications.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
