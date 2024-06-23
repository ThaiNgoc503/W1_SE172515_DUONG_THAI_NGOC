
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Account;
import model.Category;
import model.Product;
import model.dao.ProductDAO;

@MultipartConfig
@WebServlet(name = "AddNewProductServlet", urlPatterns = {"/AddNewProductServlet"})
public class AddNewProductServlet extends HttpServlet {

    private final String ADD_PRODUCT_PAGE = "addProduct.jsp";
    private final String UPLOAD_DIRECTORY = "D:\\Project\\WEB\\WorkShop1_1\\web\\images\\sanPham";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productId = request.getParameter("txtProductId");
        String productName = request.getParameter("txtProductName");
        String brief = request.getParameter("txtBrief");
        String priceStr = request.getParameter("nPrice");
        String discountStr = request.getParameter("nDiscount");
        String unit = request.getParameter("txtUnit");
        String account = request.getParameter("txtAccount");
        String typeIdStr = request.getParameter("nTypeId");
        int price = Integer.parseInt(priceStr);
        int discount = Integer.parseInt(discountStr);
        int typeId = Integer.parseInt(typeIdStr);

        Part filePart = request.getPart("fImage");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uniqueFileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        Path savePath = Paths.get(UPLOAD_DIRECTORY + File.separator + uniqueFileName);

        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, savePath);
        } catch (FileAlreadyExistsException e) {
            uniqueFileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            savePath = Paths.get(UPLOAD_DIRECTORY + File.separator + uniqueFileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, savePath);
            }
        }

        String pathSave = "/images/sanPham/" + uniqueFileName;

        String url = ADD_PRODUCT_PAGE;
        try {
            ProductDAO dao = new ProductDAO();
            String errorAddProduct = "";
            if (dao.checkExitId(productId)) {
                errorAddProduct += "Product id đã tồn tại";
            } else if (productId.trim().length() > 10) {
                errorAddProduct += "Ký tự phải nhỏ hơn hoặc bằng 10";
            }

            Product p = new Product(productId.toUpperCase(), productName, pathSave, brief, typeId, account, unit, price, discount);

            int result = dao.insertRec(p);
            if (result > 0) {
                request.setAttribute("scAddProduct", "Thêm sản phẩm thành công");
            } else {
                request.setAttribute("errorAddProduct", "Thêm sản phẩm thất bại");
            }
            request.setAttribute("errorAddPr", errorAddProduct);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
