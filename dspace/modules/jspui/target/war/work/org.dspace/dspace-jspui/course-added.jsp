<%@ taglib uri="http://www.dspace.org/dspace-tags.tld" prefix="dspace" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.dspace.content.Mycourses" %>
<%@ page import="org.dspace.eperson.EPerson" %>
<%@ page import="org.dspace.content.Collection" %>
<%@ page import="org.dspace.content.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page import="org.dspace.handle.dao.impl.HandleDAOImpl" %>
<%@ page import="org.dspace.handle.Handle" %>
<%@ page import="org.dspace.content.dao.impl.MetadataValueDAOImpl" %>
<%@ page import="org.dspace.content.MetadataValue" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>


<%@ page import="org.dspace.content.service.ItemService" %>
<%@ page import="org.dspace.content.*"%>
<%@ page import="org.dspace.core.Utils" %>
<%@ page import="org.dspace.content.factory.ContentServiceFactory" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>


<%--
  	out.println("course added");
	
	File file1 = new File("/home/dspace/dspace-6.2-src-release/dspace-jspui/src/main/webapp/handle1.txt");
        try {
            file1.mkdirs();
            file1.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }	
	File file2 = new File("/home/dspace/dspace-6.2-src-release/dspace-jspui/src/main/webapp/meta1.txt");
        try {
            file2.mkdirs();
            file2.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }	

	PrintWriter writer1 = new PrintWriter(file1, "UTF-8");
	PrintWriter writer2 = new PrintWriter(file2, "UTF-8");
	



	List<Handle> han=(List<Handle>)request.getAttribute("handle");
	for(Handle h: han)
	{
	
	writer1.println(h.getHandle());
	writer1.println(h.getDSpaceObject().getID());
	}


	List<MetadataValue> mt=(List<MetadataValue>)request.getAttribute("mt");
	for(MetadataValue m: mt)
	{
		
		writer2.println(m.getValue());
		writer2.println(m.getDSpaceObject().getID());
	}

	writer1.close();
	writer2.close();
--%>
<%--
	String r=(String)request.getAttribute("r");
	//Integer r=Integer.parseInt(request.getAttribute("r"));
	out.println(r);
--%>

<%--
	String[] coll_id=(String[])request.getAttribute("coll_id");
	String str=(String)request.getAttribute("str");
	
	out.println(str);
--%>
<%--
	List<Integer> a=(List<Integer>)request.getAttribute("a");
	for(Integer i : a)
		out.println(i);
--%>
<%--
	List<Double> rating=(List<Double>)request.getAttribute("rating");

	out.println(rating.size());
	for(Double i : rating)
		out.println(i);
	
--%>
<dspace:layout titlekey="jsp.community-list.title">
<%--
	  List<Item> items=(List<Item>)request.getAttribute("items");   
	
	ItemService itemService = ContentServiceFactory.getInstance().getItemService();
--%>
<%--	for (int i = 0; i < items.size(); i++)
	{
		List<MetadataValue> dcv = itemService.getMetadata(items.get(i), "dc", "title", null, Item.ANY);
		String displayTitle = "Untitled";
		if (dcv != null)
		{
			if (dcv.size() > 0)
			{
				displayTitle = Utils.addEntities(dcv.get(0).getValue());
			}
		}
--%>
<ul class="media-list">
<li class="media well">
<div class="media-body"><h4 class="media-heading" ><a href="<%= request.getContextPath() %>/handle/<%= items.get(i).getHandle() %>"><%= displayTitle %></a><h4></div>
</li>
</ul>
<% --} --%>
 <p>&nbsp;</p>
<%--
	List<String> items=(List<String>)request.getAttribute("items"); 
	for(String i: items) 
		out.println(i+"hello");
	
--%>







</dspace:layout>












