/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador;

import com.monitorecg.entities.aux.TablaElectrocardiogramas;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.impl.CardiologoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.TabableView;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ModuloElectrocardiogramas extends HttpServlet {
    private CardiologoDAOImpl impl = new CardiologoDAOImpl();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        
        //LISTAR ELECTROCARDIOGRAMAS
        if(accion.equals("listarElectrocardiogramas")){
            //obtener el id del cardiologo 
            String email = (String)request.getSession().getAttribute("correo");
            Cardiologo cardiologo = new Cardiologo();
            cardiologo.setCorreo(email);
            cardiologo=impl.buscarCardiologoPorCorreo(cardiologo);
            List<Object[]> elementos = impl.obtenerTablaElectrocardiogramas(cardiologo);
            List<TablaElectrocardiogramas> electrocardiogramas = new ArrayList<TablaElectrocardiogramas>();
            for (Object[] elemento : elementos) {
                TablaElectrocardiogramas te = new TablaElectrocardiogramas();
                te.setNombrePaciente((String) elemento[0]);
                te.setFechaReporte((Date) elemento[1]);
                te.setStatus((Integer)elemento[2]);
                te.setApp((String) elemento[3]);
                te.setApm((String) elemento[4]);
                te.setId((Integer)elemento[5]);
                te.setIdPrueba((Integer)elemento[6]);
                electrocardiogramas.add(te);
            }
            
            request.getSession().setAttribute("items",
                    electrocardiogramas);
            response.sendRedirect("perfil/VerElectrocardiogramas.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}