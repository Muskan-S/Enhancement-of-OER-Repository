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
import org.dspace.content.Item;
import org.dspace.content.service.ItemService;
import org.dspace.content.factory.ContentServiceFactory;
import org.dspace.eperson.factory.EPersonServiceFactory;
import org.dspace.handle.factory.HandleServiceFactory;
import org.dspace.handle.service.HandleService;
import org.dspace.content.DSpaceObject;
import org.dspace.core.LogManager;
import org.apache.commons.lang.StringEscapeUtils;
import static java.lang.System.out;
import org.dspace.app.webui.servlet.MycoursesServlet;
 import java.io.*;
 import java.util.*;



import org.dspace.handle.dao.impl.HandleDAOImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.mail.smtp.SMTPAddressFailedException;

import java.sql.SQLException;
import java.util.*;

public class Courseadd extends DSpaceServlet 
{
	private static final Logger log = Logger.getLogger(HandleServlet.class);
    	//protected transient MycourseService mycourseService = EPersonServiceFactory.getInstance().getMycourseService();
	HandleService handleService = HandleServiceFactory.getInstance().getHandleService();
	ItemService itemService= ContentServiceFactory.getInstance().getItemService();
	protected void doDSGet(Context context, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException,
            SQLException, AuthorizeException
	{
         	//UUID c=UUID.fromString(request.getParameter("collection_id"));
		//UUID e=UUID.fromString(request.getParameter("eperson_id"));
		//request.setAttribute("cid",c);
		//request.setAttribute("eid",e);
		
		


		/*MycoursesDAO mycoursesDAO = new MycoursesDAO();

		Mycourses m =mycoursesDAO.create(context,new Mycourses());
		m.setcollection_id(c);
		m.seteperson_id(e);
		mycoursesDAO.save(context,m);*/
//item id to name
		/*UUID u=UUID.fromString("53894fe9-2e5a-4cc0-a1a6-0fda50fcae49");
		Item i=itemService.find(context,u);		
		request.setAttribute("i",i);*/
		
		//JSPManager.showJSP(request, response,
                  //      "/course-added.jsp");
		

		String handle=request.getParameter("collection");
		

		
		
		DSpaceObject dso = null;
		if (handle != null)
		{
		    dso = handleService.resolveToObject(context, handle);
		  
		}

		
		if (dso == null)
		{
			JSPManager.showJSP(request, response,"/register/forgot-password.jsp");
		    return;
		}
		MycourseDAOImpl mycourseDAO=new MycourseDAOImpl();
		
		Collection c = (Collection) dso;
		/*request.setAttribute("a",rows);
		JSPManager.showJSP(request, response,
                        "/course-added.jsp");*/
		EPerson e=context.getCurrentUser();
		if (e == null)
			JSPManager.showJSP(request, response,
                        "/login/password.jsp");
		else
		{
			if(!(mycourseDAO.findByCollectionAndEPerson(context, e, c) != null))
			{	Mycourse mycourse = mycourseDAO.create(context, new Mycourse());
				mycourse.setCollection(c);
				mycourse.setePerson(e);
				
			}
		

			MycoursesServlet m = new MycoursesServlet();
			m.doDSGet(context,request,response);
  		
		
		
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
