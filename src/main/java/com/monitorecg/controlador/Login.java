/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador;

import com.monitorecg.dao.CardiologoDAO;
import com.monitorecg.hibernate.entities.Cardiologo;

import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.mail.Mail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class Login extends HttpServlet {

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

        //LOGIN
        if (accion.equals("login")){
            String error = "";
            String destino = "";
            //obtener los parametros 
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            //verificar si existe el usuario 
            Cardiologo car = new Cardiologo();
            car.setCorreo(user);
            car.setContrasena(pass);
            Cardiologo c = impl.loginCardiologo(car);
            if (c != null) {
                //existe el cardiologo 
                HttpSession sesion = request.getSession();
                sesion.setAttribute("user", c.getNombre());
                sesion.setAttribute("correo", c.getCorreo());
                destino = "perfil/Principal.jsp";
                response.sendRedirect(destino);
            } else {
                error = "Usuario o contraseña inválidos";
                destino = "index.jsp";
                request.getSession().setAttribute("error", error);
                response.sendRedirect(destino);
            }
        }
        
        //RECUPERAR CONTRASEÑA
        else if (accion.equals("recuperarContrasena")) {
            String email = request.getParameter("email");
            //verificar si existe el correo del usuario 
            Cardiologo cardiologo = new Cardiologo();
            cardiologo.setCorreo(email);
            Cardiologo c = impl.buscarCardiologoPorCorreo(cardiologo);
            String enviomsj = "";
            String tipoEnvio = "";
            if (c != null) {
                boolean envio = Mail.enviarEmail(email);
                if (envio) {
                    enviomsj = "Se a enviado un correo electrónico a tu cuenta";
                    tipoEnvio = "Exito";
                    HttpSession session = request.getSession();
                    session.setAttribute("email", c.getCorreo());
                } else {
                    enviomsj = "La cuenta de correo no existe";
                    tipoEnvio = "Error";
                }

            } //no se encontro el correo 
            else {
                tipoEnvio = "No Existe";
                enviomsj = "Verifica tu correo electrónico";
            }
            request.getSession().setAttribute("msj-envio", enviomsj);
            request.getSession().setAttribute("tipo-envio", tipoEnvio);
            response.sendRedirect("index.jsp");
        }
        

        //REGISTRARSE
        else if (accion.equals("registrarse")) {
            Cardiologo car = new Cardiologo();
            String msj = "";
            String correo = request.getParameter("correo");
            car.setCorreo(correo);
            Cardiologo cardiologoRespuesta = impl.buscarCorreo(car);
            if (cardiologoRespuesta == null) {
                //campos requeridos
                String nom = request.getParameter("nombre");
                car.setNombre(nom);
                String app = request.getParameter("app");
                car.setApellidoPaterno(app);
                String apm = request.getParameter("apm");
                car.setApellidoMaterno(apm);
                String curp = request.getParameter("curp");
                car.setCurp(curp);
                String cedula = request.getParameter("cedula");
                car.setCedula(cedula);
                String instituto = request.getParameter("instituto");
                car.setInstituto(instituto);
                String con = request.getParameter("contrasena");
                car.setContrasena(con);

                //no obligatorios 
                String tel = request.getParameter("telefono") == null ? "" : request.getParameter("telefono");
                car.setTelefono(tel);
                String edad = request.getParameter("edad") == null ? "0" : request.getParameter("edad");
                car.setEdad(Integer.parseInt(edad));
                String sexo = request.getParameter("sexo") == null ? "" : request.getParameter("sexo");
                if (sexo.equals("Femenino")) {
                    car.setSexo("f");
                } else if (sexo.equals("Masculino")) {
                    car.setSexo("m");
                } else {
                    car.setSexo("");
                }
                if (impl.agregarCardiologo(car)) {
                    msj = "Fuiste registrado correctamente en el sistema";
                    request.getSession().setAttribute("error-registrarse", msj);
                    response.sendRedirect("index.jsp");
                } else {
                    msj = "Ocurrió un error en tu registro";
                    request.getSession().setAttribute("error-registrarse", msj);
                    response.sendRedirect("Registrarse.jsp");
                }
            }
            else{
                msj = "El correo ya se encuentra registrado en el sistema";
                request.getSession().setAttribute("error-registrarse",msj);
                response.sendRedirect("Registrarse.jsp");
            }

        } //CAMBIAR CONTRASENA FORMULARIO
        else if (accion.equals("cambiarContrasena")) {
            String con = request.getParameter("contrasena");
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            Cardiologo cardiologo = new Cardiologo();
            cardiologo.setCorreo(email);
            cardiologo.setContrasena(con);
            boolean respuesta = impl.cambiarContrasena(cardiologo);
            String tipo = "";
            String msj = "";
            if (respuesta) {
                msj = "Tu contraseña fue cambiada";
                tipo = "OK";
            } else {
                msj = "Ocurrió un error";
                tipo = "Error";
            }

            request.getSession().setAttribute("tipoMsj", tipo);
            request.getSession().setAttribute("msj-cambiar-pass", msj);
            request.removeAttribute("email");
            response.sendRedirect("index.jsp");
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
