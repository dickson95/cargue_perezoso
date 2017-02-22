/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esteban.controller;

import com.esteban.model.Viaje;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
@WebServlet(name = "ViajesController", urlPatterns = {"/Viajes"})
public class ViajesController extends HttpServlet {

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
        String dias_S = request.getParameter("dias_trabajo");
        Map casos = new TreeMap();
        boolean errores = false;
        System.out.println("dias: " + dias_S.trim().isEmpty());
        if (dias_S.trim().isEmpty()) {
            System.out.println("No Hay dias escritos");
            errores = true;
        } else {
            System.out.println("Hay dias escritos");
            int dias = Integer.parseInt(dias_S);
            if ((dias > 0 && dias < 501)) {
                for (int i = 0; i < dias; i++) {
                    Viaje viaje = new Viaje();
                    String num_elementos_S = request.getParameter("num_elemets[" + i + "]");
                    if (num_elementos_S.trim().isEmpty()) {
                        System.out.println("No hay elementos o algun elemento escrito");
                        errores = true;
                    } else {
                        int num_elementos = Integer.parseInt(num_elementos_S);
                        List pesos = new ArrayList();
                        if (num_elementos > 0 && num_elementos < 101) {
                            for (int j = 0; j < num_elementos; j++) {
                                String peso_S = request.getParameter("num_elemets[" + i + "][" + j + "]");
                                if (peso_S.trim().isEmpty()) {
                                    System.out.println("No hay peso o pesos");
                                    errores = true;
                                } else {
                                    int peso = Integer.parseInt(peso_S);
                                    if (num_elementos > 0 && num_elementos < 101) {
                                        pesos.add(peso);
                                    } else {
                                        errores = true;
                                    }
                                }
                            }
                            if(!errores){
                                int num_viajes = viaje.numero_max_viajes(pesos);
                                casos.put("Caso # " + (i + 1) + "", Integer.toString(num_viajes));
                            }
                        } else {
                            errores = true;
                        }
                    }
                }
            } else {
                errores = true;
            }
        }

        System.out.println(casos);

        if (errores) {
            request.setAttribute("errores", errores);
        } else {
            request.setAttribute("casos", casos);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
