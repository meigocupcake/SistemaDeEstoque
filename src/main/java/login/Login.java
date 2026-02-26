/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import connection.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author 015.509576
 */
// ctrl+espaço p atalho
//servidor
@WebServlet("/login")
public class Login extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    
    //enviando - pego a função e reconheça como (request)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("users");
        String senha = request.getParameter("passw");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try(var con = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM users WHERE username= ?  AND pass= ?";
        }catch(Exception e){
        }
        
        if("admin".equals(usuario) && "1234".equals(senha)){
            response.sendRedirect("login.html");
            // out.println("<h2>Login realizado!</h2>");
        } else {
                out.println("<h2>Usuário ou senha incorreto!");
            }
        
    }
}
