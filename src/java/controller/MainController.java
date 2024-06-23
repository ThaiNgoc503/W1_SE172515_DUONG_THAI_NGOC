/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thai.ngoc
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String ADD_NEW_ACCOUNT_CONTROLLER = "AddNewAccountServlet";
    private final String ADD_NEW_CATEGORY_CONTROLLER = "AddNewCategoryServlet";
    private final String PROCESS_REQUEST_CONTROLLER = "processRequestServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";
    private final String SHOW_LIST_SERVLET = "ShowListServlet";
    private final String SHOW_LIST_CATEGORY_SERVLET = "ShowListCategotyServlet";
    private final String DELETE_ACCOUNT = "DeleteAcountServlet";
    private final String DELETE_CATEGORY_SERVLET = "DeleteCategoryServlet";
    private final String SHOW_LIST_PRODUCT_SEVRLET = "ShowListProductServlet";
    private final String HOME_SERVLET = "HomeServlet";
    private final String HOME_BEFORE_SERVLET = "HomeNotLoginServlet";
    private final String UPDATE_ACCOUNT_SERVLET = "UpdateAccountServlet";
    private final String UPDATE_CATEGORY_SERVLET = "UpdateCategoryServlet";
    private final String DELETE_NEW_PRODUCT_SERVLET = "DeleteProductServlet";

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
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {
            if (button == null) {
                url = PROCESS_REQUEST_CONTROLLER;
            } else if (button.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (button.equals("Registration")) {
                url = ADD_NEW_ACCOUNT_CONTROLLER;
            } else if (button.equals("Save")) {
                url = ADD_NEW_CATEGORY_CONTROLLER;
            } else if (button.equals("Logout")) {
                url = LOGOUT_SERVLET;
            } else if (button.equals("List Account")) {
                url = SHOW_LIST_SERVLET;
            } else if (button.equals("List Category")) {
                url = SHOW_LIST_CATEGORY_SERVLET;
            } else if (button.equals("Delete")) {
                url = DELETE_ACCOUNT;
            } else if (button.equals("DeletCategory")) {
                url = DELETE_CATEGORY_SERVLET;
            } else if (button.equals("List Products")) {
                url = SHOW_LIST_PRODUCT_SEVRLET;
            } else if (button.equals("Home")) {
                url = HOME_SERVLET;
            } else if (button.equals("HOME")) {
                url = HOME_BEFORE_SERVLET;
            } else if (button.equals("Update Account")) {
                url = UPDATE_ACCOUNT_SERVLET;
            } else if (button.equals("updateCategory")) {
                url = UPDATE_CATEGORY_SERVLET;
            } else if (button.equals("DeleteProduct")) {
                url = DELETE_NEW_PRODUCT_SERVLET;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
