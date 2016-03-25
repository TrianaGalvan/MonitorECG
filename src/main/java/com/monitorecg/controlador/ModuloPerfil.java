/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador;

import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.impl.CardiologoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ModuloPerfil extends HttpServlet {
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
            String accion =  request.getParameter("accion");
            if(accion.equals("VerPerfil")){
                verPerfil(request,response);
            }
            else if(accion.equals("EditarDatos")){
                
            }else if(accion.equals("GuardarCambios")){
                guardarCambios(request,response);
            }else if(accion.equals("CambiarCotrasena")){
                cambiarContrasena(request,response);
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

    private void verPerfil(HttpServletRequest request, HttpServletResponse response) {
        String correo = (String)request.getSession().getAttribute("correo");
        Cardiologo c = new Cardiologo();
        c.setCorreo(correo);
        c = cdi.buscarCardiologoPorCorreo(c);
        c = cdi.obtenerCardiologo(c);
        request.getSession().setAttribute("cardiologo", c);
        try {
            response.sendRedirect("perfil/VerPerfil.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ModuloPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarCambios(HttpServletRequest request, HttpServletResponse response) {
    
        //verificar el correo
        //Cardiologo cardiologoCorreo = new Cardiologo();
        //cardiologoCorreo.setCorreo(request.getParameter("correo"));
        //cardiologoCorreo = cdi.buscarCorreo(cardiologoCorreo);
        boolean modificacion = false; 
        ///if(cardiologoCorreo != null){
            String id = request.getParameter("idCardiologo");
            Cardiologo c = new Cardiologo();
            c.setIdCardiologo(Integer.parseInt(id));
            c.setNombre(request.getParameter("nombre"));
            c.setApellidoPaterno(request.getParameter("apellidoPaterno"));
            c.setApellidoMaterno(request.getParameter("apellidoMaterno"));
            c.setEdad(Integer.parseInt(request.getParameter("edad")));
            c.setCurp(request.getParameter("curp"));
            c.setTelefono(request.getParameter("telefono"));
            c.setCedula(request.getParameter("cedula"));
            c.setInstituto(request.getParameter("instituto"));
            c.setCorreo(request.getParameter("correo"));
            //obtener el sexo 
            String sexo = request.getParameter("sexo");
            if(sexo.equals("Femenino")){
                c.setSexo("F");
            }else if(sexo.equals("Masculino")){
                c.setSexo("M");
            }else{
                c.setSexo("");
            }
            modificacion = cdi.moficarCardiologoSinContrasena(c);
            if(modificacion){
                request.getSession().setAttribute("msj-guardar-cambios","Tus cambios han sido guardados con éxito");
            }else if(!modificacion){
                request.getSession().setAttribute("msj-error-guardar-cambios","Ocurrió un error, tus datos no fueron guardados");
            }
        /*}else{
            request.getSession().setAttribute("msj-correo-repetido", "El correo ya existe en el sistema");
        }*/
      
         verPerfil(request, response);
        
    }

    private void cambiarContrasena(HttpServletRequest request, HttpServletResponse response) {
        String pass = request.getParameter("contrasena");
        String correo = (String)request.getSession().getAttribute("correo");
        Cardiologo c = new Cardiologo();
        c.setCorreo(correo);
        c = cdi.buscarCardiologoPorCorreo(c);
        c.setContrasena(pass);
        boolean respuesta = cdi.modificarContrasena(c);
        if(respuesta){
            request.getSession().setAttribute("msj-cambio-contrasena", "Tu contrasena fue cambiada con éxito");
        }else if(!respuesta){
            request.getSession().setAttribute("msj-error-cambio-contrasena", "Ocurrió un error en el sistema");
        }
        try {
            response.sendRedirect("perfil/VerPerfil.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ModuloPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
