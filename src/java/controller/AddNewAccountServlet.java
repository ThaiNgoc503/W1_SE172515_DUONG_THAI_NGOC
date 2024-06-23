/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.AccountDAO;
import model.Account;

/**
 *
 * @author thai.ngoc
 */
@WebServlet(name = "AddNewAccountServlet", urlPatterns = {"/AddNewAccountServlet"})
public class AddNewAccountServlet extends HttpServlet {

    private final String ADD_NEW_ACCOUNT_PAGE = "addAccount.jsp";

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String account = request.getParameter("txtAccount");
        String password = request.getParameter("txtPassword");
        String lastname = request.getParameter("txtLastName");
        String firstname = request.getParameter("txtFirstName");
        String bithdaytmp = request.getParameter("dBirthday");
        String gendertmp = request.getParameter("rdGender");
        String phone = request.getParameter("txtPhone");
        String isUseTmp = request.getParameter("ckbIsUse");
        String roleInSystemTmp = request.getParameter("slRole");
        Date birthday = Date.valueOf(bithdaytmp);

        int roleInSystem = Integer.parseInt(roleInSystemTmp);
        String url = ADD_NEW_ACCOUNT_PAGE;
        boolean gender = "male".equalsIgnoreCase(gendertmp);
        boolean isUse = isUseTmp != null && isUseTmp.equalsIgnoreCase("ON");
        String baoloi = "";
        try {
            System.out.println(lastname + " " + firstname);
            AccountDAO dao = new AccountDAO();

            if (dao.checkExit(account)) {
                baoloi += "Tài Khoản đã tồn tại";
            } else if (account.isEmpty() && account == null) {
                baoloi += "Tài Khoản không được để trống";
            }

            Account a = new Account(account, password, lastname, firstname, birthday, gender, phone, isUse, roleInSystem);
            int rs = dao.insertRec(a);

            if (rs > 0) {
                request.setAttribute("scAddNewAccount", "Thêm Tài Khoản Thành Công");
            }
            request.setAttribute("baoLoiNewAccount", baoloi);
            

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
