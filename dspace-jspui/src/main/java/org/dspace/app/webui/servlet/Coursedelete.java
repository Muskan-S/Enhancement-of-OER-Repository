package org.dspace.app.webui.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dspace.app.webui.util.JSPManager;
import org.dspace.app.webui.util.UIUtil;
import org.dspace.authenticate.factory.AuthenticateServiceFactory;
import org.dspace.authenticate.service.AuthenticationService;
import org.dspace.authorize.AuthorizeException;
import org.dspace.core.ConfigurationManager;
import org.dspace.core.Context;
import org.dspace.eperson.Mycourse;
import org.dspace.eperson.dao.MycourseDAO;
import org.dspace.eperson.dao.impl.MycourseDAOImpl;
import org.dspace.services.SessionService;
import org.dspace.services.sessions.SessionRequestServiceImpl;
import org.hibernate.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;

import org.dspace.eperson.MycourseServiceImpl;
import org.dspace.eperson.service.MycourseService;
import org.dspace.content.Collection;
import org.dspace.eperson.EPerson;
import org.dspace.eperson.factory.EPersonServiceFactory;
import org.dspace.handle.factory.HandleServiceFactory;
import org.dspace.handle.service.HandleService;
import org.dspace.content.DSpaceObject;
import org.dspace.core.LogManager;
import org.apache.commons.lang.StringEscapeUtils;
import static java.lang.System.out;
import org.dspace.authorize.service.AuthorizeService;
import org.dspace.authorize.factory.AuthorizeServiceFactory;
import org.dspace.app.webui.servlet.MycoursesServlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.mail.smtp.SMTPAddressFailedException;

import java.sql.SQLException;
import java.util.*;

public class Coursedelete extends DSpaceServlet 
{
	private static final Logger log = Logger.getLogger(HandleServlet.class);
    	//protected transient MycourseService mycourseService = EPersonServiceFactory.getInstance().getMycourseService();
	AuthorizeService authorizeService=AuthorizeServiceFactory.getInstance().getAuthorizeService();
	HandleService handleService = HandleServiceFactory.getInstance().getHandleService();
	protected void doDSGet(Context context, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException,
            SQLException, AuthorizeException
	{
         	//UUID c=UUID.fromString(request.getParameter("collection_id"));
		//UUID e=UUID.fromString(request.getParameter("eperson_id"));
		//request.setAttribute("cid",c);
		//request.setAttribute("eid",e);
		
		//MycoursesDAO mdao = new MycoursesDAO();
		
		//Session session=HibernateUtil.getSessionFactory().openSession();
		//session.beginTransaction();
		//SessionRequestServiceImpl s=new SessionRequestServiceImpl();
		//Session session=s.getCurrentSession();


		/*MycoursesDAO mycoursesDAO = new MycoursesDAO();

		Mycourses m =mycoursesDAO.create(context,new Mycourses());
		m.setcollection_id(c);
		m.seteperson_id(e);
		mycoursesDAO.save(context,m);*/

		
		String handle=request.getParameter("collection");
		//EPerson e=(EPerson)request.getParameter("eperson");

		
		/*
		String path = request.getPathInfo();
		out.println(path);
		log.info(LogManager.getHeader(context, "invalid_id", "path=" + path));
		//if (path == null)
		//JSPManager.showJSP(request, response,
                //        "/course-added.jsp");

		if (path != null)
		{
		    // substring(1) is to remove initial '/'
		    log.info(LogManager.getHeader(context, "invalid_id", "path=" + path));
		    int slash = path.indexOf('/');
		    path = path.substring(slash);
		    try
		    {
		        // Extract the Handle
		        int firstSlash = path.indexOf('/');
		        int secondSlash = path.indexOf('/', firstSlash + 1);

		        if (secondSlash != -1)
		        {
		            // We have extra path info
		            handle = path.substring(0, secondSlash);
		            extraPathInfo = path.substring(secondSlash);
		        }
		        else
		        {
		            // The path is just the Handle
		            handle = path;
		        }
		    }
		    catch (NumberFormatException nfe)
		    {
		        // Leave handle as null
		    }
		}*/
		DSpaceObject dso = null;
		if (handle != null)
		{
		    dso = handleService.resolveToObject(context, handle);
		   // log.info(LogManager.getHeader(context, "invalid_id", "path=" + path));
		}

		
		if (dso == null)
		{
		 	//log.info(LogManager.getHeader(context, "invalid_id", "path=" + path));
		       // JSPManager.showInvalidIDError(request, response, StringEscapeUtils.escapeHtml(path), -1);
			JSPManager.showJSP(request, response,"/register/forgot-password.jsp");
		    return;
		}
		MycourseDAOImpl mycourseDAO=new MycourseDAOImpl();
		Collection c = (Collection) dso;
		
		EPerson e=context.getCurrentUser();
		if(e != null)
    
        	{
			
		    	
				mycourseDAO.deleteByCollectionAndEPerson(context, c, e);

				log.info(LogManager.getHeader(context, "unsubscribe",
				        "eperson_id=" + e.getID() + ",collection_id="
				                + c.getID()));
		    	MycoursesServlet m = new MycoursesServlet();
			m.doDSGet(context,request,response);
        // Forward to main mydspace page
	//JSPManager.showJSP(request, response, "/mycourses.jsp");
        	}
	}

	protected void doDSPost(Context context, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException,
            SQLException, AuthorizeException
	{
		//protected transient EPersonService personService = EPersonServiceFactory.getInstance().getEPersonService();
	 	
	 //  	Eperson e = personService.findByEmail(context, "abc@localhost");
		
		JSPManager.showJSP(request, response,
                        "/register/forgot-password.jsp");
	}
}
