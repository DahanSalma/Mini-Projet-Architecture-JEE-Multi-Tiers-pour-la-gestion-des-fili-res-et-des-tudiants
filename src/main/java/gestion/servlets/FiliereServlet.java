package gestion.servlets;

import gestion.beans.FiliereBean;
import gestion.dao.FiliereDAO;
import gestion.dao.impl.FiliereDAOImpl;
import gestion.entites.Filiere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/filiere/*")
public class FiliereServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        FiliereDAO filierDao = new FiliereDAOImpl();
        FiliereBean filiereBean = (FiliereBean)req.getSession().getAttribute("filiereBean");

        if(req.getRequestURI().contains("save"))
        {
            filiereBean.getFiliere().setCode(req.getParameter("code"));
            filiereBean.getFiliere().setLibelle(req.getParameter("libelle"));

            filierDao.saveOrUpdate(filiereBean.getFiliere());

            filiereBean.setModifyContext(false);
            filiereBean.setFiliere(new Filiere());
        }

        if(req.getRequestURI().contains("modifyContext"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            filiereBean.setFiliere(filierDao.getById(id));
            filiereBean.setModifyContext(true);
        }

        if(req.getRequestURI().contains("delete"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            filierDao.delete(filierDao.getById(id));
        }

        resp.sendRedirect("../");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
