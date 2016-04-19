/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador;

import com.monitorecg.entities.aux.TablaElectrocardiogramas;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;
import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.impl.PacienteDAOImpl;
import com.monitorecg.impl.PruebaDAOImpl;
import com.monitorecg.impl.ReporteDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private PruebaDAOImpl pdi = new PruebaDAOImpl();
    private PacienteDAOImpl pai = new PacienteDAOImpl();
    private ReporteDAOImpl rdi = new ReporteDAOImpl();
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
            listarElectrocardiogramas(request, response);
        }
        //VER ECG 
        else if(accion.equals("verECG")){
            verECG(request, response);
        }
        //GUARDAR REPORTE 
        else if(accion.equals("GuadarReporte")){
            guardarRecomendaciones(request, response);
        }
    }

    public void listarElectrocardiogramas(HttpServletRequest request, HttpServletResponse response){
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
            te.setIdReporte((Integer)elemento[7]);
            electrocardiogramas.add(te);
        }

        request.getSession().setAttribute("items",
                electrocardiogramas);
        try {
            response.sendRedirect("perfil/VerElectrocardiogramas.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ModuloElectrocardiogramas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verECG(HttpServletRequest request, HttpServletResponse response){
        //quitar de sesion los items de la tabla electrocardiogramas
        request.removeAttribute("items");
        String redirect = request.getParameter("pag");
        int idPaciente = Integer.parseInt(request.getParameter("idp"));
        int idPrueba = Integer.parseInt(request.getParameter("idm"));
        int idReporte = Integer.parseInt(request.getParameter("idr"));
        //identificadores de paciente y prueba
        request.getSession().setAttribute("idp", idPaciente);
        request.getSession().setAttribute("idpr", idPrueba);
        request.getSession().setAttribute("idr", idReporte);
        //obtener informacion del paciente 
        Paciente p = new Paciente();
        p.setIdPaciente(idPaciente);
        p = pai.obtenerPaciente(p);
        //obtener informacion de la prueba 
        Prueba pr = new Prueba();
        pr.setIdPrueba(idPrueba);
        pr = pdi.obtenerPrueba(pr);

        request.getSession().setAttribute("paciente",p);
        request.getSession().setAttribute("prueba",pr);
        try {
            if(redirect != null){
                response.sendRedirect("perfil/VerElectrocardiogramaHistorial.jsp");
            }else{
                response.sendRedirect("perfil/VerElectrocardiograma.jsp");
            }
        } catch (IOException ex) {
            Logger.getLogger(ModuloElectrocardiogramas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarRecomendaciones(HttpServletRequest request, HttpServletResponse response){
        String estado = request.getParameter("estado");
            int idReporte = (Integer)request.getSession().getAttribute("idr");
            String recomendaciones = request.getParameter("recomendaciones");
            Reporte reporte = new Reporte(); 
            reporte.setIdReporte(idReporte);
            reporte.setRecomendaciones(recomendaciones);
            String msj = "";
            String msjTipo = "";
            boolean res = false;
            if(estado.equals("pendiente")){
                reporte.setEstatus(1);
                res = rdi.modificarRecomendaciones(reporte);
                msjTipo = "pendiente";
                msj = "Tus recomendaciones quedarán pendientes";
            }else if(estado.equals("registrar")){
                reporte.setEstatus(0);
                res = rdi.modificarRecomendaciones(reporte);
                msjTipo = "registrado";
                msj = "Tus recomendaciones fueron guardadas con éxito";
            }
            
            if(res){
                request.getSession().setAttribute("estado", msjTipo);
                request.getSession().setAttribute("msj-recomendaciones", msj);
            }
            else{   
                request.getSession().setAttribute("error-recomendaciones","Ocurrió un error en el sistema al guardar tus recomendacioens");
            }
            listarElectrocardiogramas(request, response);
    }
    
    
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