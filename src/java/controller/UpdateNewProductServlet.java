/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Product;
import model.dao.ProductDAO;

/**
 *
 * @author thai.ngoc
 */
@MultipartConfig
@WebServlet(name = "UpdateNewProductServlet", urlPatterns = {"/UpdateNewProductServlet"})
public class UpdateNewProductServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "D:\\Project\\WEB\\WorkShop1_1\\web\\images\\sanPham";

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
        request.setCharacterEncoding("UTF-8");
        String productId = request.getParameter("txtProductId2");
        String productName = request.getParameter("txtProductName2");
        String brief = request.getParameter("txtProductBrief2");
        String priceStr = request.getParameter("nProductPrice");
        String discountStr = request.getParameter("nProductDis");
        String unit = request.getParameter("txtProductUnit");
        int price = Integer.parseInt(priceStr);
        int discount = Integer.parseInt(discountStr);
        String crPath = request.getParameter("currentImage");
        Part filePart = request.getPart("fileUpload");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uniqueFileName = null;
        Path savePath = null;

        if (fileName != null && !fileName.isEmpty()) {
            uniqueFileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            savePath = Paths.get(UPLOAD_DIRECTORY + File.separator + uniqueFileName);

            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, savePath);
            } catch (FileAlreadyExistsException e) {
                uniqueFileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
                savePath = Paths.get(UPLOAD_DIRECTORY + File.separator + uniqueFileName);
                try (InputStream fileContent = filePart.getInputStream()) {
                    Files.copy(fileContent, savePath);
                }
            }
        }

        String pathSave = "/images/sanPham/" + uniqueFileName;
        if (fileName == null || fileName.isEmpty()) {
            pathSave = crPath;
        }
        String url = "MainController?btAction=List+Products";
        try {
            ProductDAO dao = new ProductDAO();
            Product p = new Product(productId, productName, pathSave, brief, unit, price, discount);
            int result = dao.updateRec(p);
        } finally {
           response.sendRedirect(url);
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
