/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hammingcodage.Fonction;
import hammingcodage.Partition;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miantsa Zo Rajaonera
 */
public class Traitementhamming extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Traitementhamming</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Traitementhamming at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String message = request.getParameter("message");
        request.setAttribute("message", message);
        int n = Integer.parseInt(request.getParameter("n"));
        request.setAttribute("n", n);
        int erreur = Integer.parseInt(request.getParameter("erreur"));
        request.setAttribute("erreur", erreur);
        try {
            Fonction f = new Fonction(message, ""+n, ""+erreur);
            
            System.out.println("ito ilay izy = "+n+" de le ray "+erreur);
            
            
            Partition p = f.getPartition(n);
            request.setAttribute("partition", p);
            
            String bytevalue = f.getBytes(message);
            request.setAttribute("bytevalue", bytevalue);
            
            Vector<String> code = f.getCode(message, n);
            request.setAttribute("code", code);
            
            String[][] hamming = f.getHammingCode();
            String[][] erreur1 = f.erreurhasard(hamming);
            
            Vector<String> mothamming = f.affhamming(hamming);
            request.setAttribute("mothamming", mothamming);
            
            Vector<String> messagemute = f.affhamming(erreur1);
            request.setAttribute("messagemute", messagemute);
            
            Vector<Vector<Integer>> positionerreur = new Vector<>();
            for(int i=0;i<erreur1.length;i++){
                Vector<Integer> list = f.getPositionErreur(erreur1[i],n);
                positionerreur.add(list);
            }
            request.setAttribute("positionerreur", positionerreur);
            
            String[][][] correction = f.getCorrection(erreur1);
            String[][] hammingcorrige = correction[0];
            String[][] codecorrige = correction[1];
            
            Vector<String> mothammingcorrige = f.affhamming(hammingcorrige);
            request.setAttribute("mothammingcorrige", mothammingcorrige);
            
            Vector<String> motcodecorrige = f.affhamming(codecorrige);
            request.setAttribute("motcodecorrige", motcodecorrige);
            
            String codefinal = "";
            for(int i=0;i<motcodecorrige.size();i++){
                codefinal += motcodecorrige.elementAt(i);
            }
            
            String messagerecu = f.getMessage(codefinal);
            request.setAttribute("messagerecu", messagerecu);
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Traitementhamming.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
