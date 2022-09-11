package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/shop")
public class Shop extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw =res.getWriter();
		res.setContentType("text/HTML");
		final DecimalFormat df = new DecimalFormat("0.000");
		final DecimalFormat df1 = new DecimalFormat("0");
		try
		{
			double marketPrice=Double.parseDouble(req.getParameter("marketPrice")) ;
			double rs=Double.parseDouble(req.getParameter("rs")) ;
			double inGram=rs*1000/marketPrice;
			req.getRequestDispatcher("shop.html").include(req, res);
			if(inGram>=1000)
			{
				pw.println("<h1 style='text-align:center'>In "+df1.format(rs)+" INR : "+df.format(inGram/1000)+" Kg</h1>");
			}
			else
			{
				pw.println("<h1 style='text-align:center'>In "+df1.format(rs)+" INR : "+df1.format(inGram)+" gm</h1>");
			}
		}
		catch(Exception e)
		{
			req.getRequestDispatcher("shop.html").include(req, res);
			pw.println("<h1 style='text-align:center'>You Entered Wrong Amount</h1>");
		}
		
		
	}
	
}
