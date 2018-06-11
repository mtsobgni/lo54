package test.fr.utbm.lo54.servlet;

import fr.utbm.lo54.servlet.RegistrationServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

/** 
* RegistrationServlet Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 11, 2018</pre> 
* @version 1.0 
*/ 
public class RegistrationServletTest extends Mockito {

@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: doPost(HttpServletRequest request, HttpServletResponse response) 
* 
*/ 
@Test
public void testDoPost() throws Exception {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);

    when(request.getParameter("username")).thenReturn("me");
    when(request.getParameter("password")).thenReturn("secret");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(writer);

    new RegistrationServlet().doPost(request, response);

    verify(request, atLeast(1)).getParameter("username");
    writer.flush(); // it may not have been flushed yet...
    assertTrue(stringWriter.toString().contains("My expected string"));
} 

/** 
* 
* Method: doGet(HttpServletRequest request, HttpServletResponse response) 
* 
*/ 
@Test
public void testDoGet() throws Exception { 
//TODO: Test goes here... 
} 


} 
