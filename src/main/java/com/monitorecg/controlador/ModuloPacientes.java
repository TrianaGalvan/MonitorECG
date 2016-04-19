/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador;

import com.monitorecg.entities.aux.TablaHistorial;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.impl.PacienteDAOImpl;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ModuloPacientes extends HttpServlet {

    private PacienteDAOImpl pdi = new PacienteDAOImpl();
    private CardiologoDAOImpl cdi = new CardiologoDAOImpl();
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
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if(accion.equals("BuscarPaciente")){
            buscarPaciente(request,response);
        }else if(accion.equals("Historial")){
            mostrarHistorial(request,response);
        }else if(accion.equals("Informacion")){
            mostrarPerfilPaciente(request,response);
        }

    }
    
    private void buscarPaciente(HttpServletRequest request, HttpServletResponse response) {
        String filtro = request.getParameter("filtro");
        String valorFiltro = request.getParameter("valor-filtro");
        Charset.forName("UTF-8").encode(valorFiltro);
        Paciente paciente = new Paciente();
        List<Paciente> pacientes = new ArrayList<Paciente>();
        if(filtro.equals("Nombre")){
            String[] valores = valorFiltro.split(" ");  
            if(valores.length == 3){
                paciente.setNombre(valores[0]);
                paciente.setApellidoPaterno(valores[1]);
                paciente.setApellidoMaterno(valores[2]);
            }else if(valores.length == 4){
                String nombre = valores[0] + " "+ valores[1];
                paciente.setNombre(nombre);
                paciente.setApellidoPaterno(valores[1]);
                paciente.setApellidoMaterno(valores[2]);
            }
            pacientes = pdi.obtenerPacientePorNombre(paciente);
        }else if(filtro.contains("Correo")){
            paciente.setCorreo(valorFiltro);
            Paciente p = pdi.obtenerPacientePorCorreo(paciente);
            if(p != null){
                pacientes.add(p);
            }
        }else if(filtro.equals("CURP")){
            paciente.setCurp(valorFiltro);
            pacientes = pdi.obtenerPacientePorCURP(paciente);
        }
        
        //verificar si existen pacientes 
        if(pacientes.size() != 0){
            request.getSession().setAttribute("pacientes",pacientes);
        }else{
            request.getSession().setAttribute("msj-buscar-paciente", "No se enconctraron coincidencias");
        }
        
        
        try {
            response.sendRedirect("perfil/Pacientes.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ModuloPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
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

        //BUSCAR PACIENTE

    private void mostrarPerfilPaciente(HttpServletRequest request, HttpServletResponse response) {
           //eliminar los pacientes de la sesion 
           request.getSession().removeAttribute("pacientes");
           
           String id = request.getParameter("idp");
           Paciente p = new Paciente();
           p.setIdPaciente(Integer.parseInt(id));
           p = pdi.obtenerPaciente(p);
           request.getSession().setAttribute("paciente", p);
        try {
            response.sendRedirect("perfil/Informacion.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ModuloPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarHistorial(HttpServletRequest request, HttpServletResponse response) {
         //eliminar los pacientes de la sesion 
        request.getSession().removeAttribute("pacientes");

        String id = request.getParameter("idp");
        Paciente p = new Paciente(); 
        p.setIdPaciente(Integer.parseInt(id));
        List<Object[]> items = pdi.obtenerTablaPruebas(p);
        List<TablaHistorial> pruebas = new ArrayList<TablaHistorial>();
        
        for (Object[] elemento : items) {
            TablaHistorial e = new TablaHistorial();
            Date fecha = (Date) elemento[8];
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String hora = sdf.format(fecha);
            e.setHora(hora);
            e.setFecha((Date) elemento[1]);
            e.setEstatus((Integer)elemento[2]);
            e.setIdPrueba((Integer)elemento[6]);
            e.setIdPaciente((Integer)elemento[5]);
            e.setIdReporte((Integer)elemento[7]);
            pruebas.add(e);
        }
        request.getSession().setAttribute("pruebas", pruebas);
        try {
            response.sendRedirect("perfil/Historial.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ModuloPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
