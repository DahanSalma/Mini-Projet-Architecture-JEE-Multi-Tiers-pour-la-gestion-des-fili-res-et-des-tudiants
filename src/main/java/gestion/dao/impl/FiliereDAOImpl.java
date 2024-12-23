package gestion.dao.impl;

import gestion.dao.ConnectionTool;
import gestion.dao.FiliereDAO;
import gestion.entites.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class FiliereDAOImpl implements FiliereDAO {

    private Connection connection = ConnectionTool.getConnexion();

    @Override
    public boolean saveOrUpdate(Filiere f) {

        if(f.getId() != null && this.getById(f.getId()) != null)
            return this.update(f);

        return this.create(f);
    }

    @Override
    public boolean create(Filiere f) {

        if(this.connection == null)
            return false;

        try {
            PreparedStatement ps = this.connection.prepareStatement
                    ("insert into filiere (code, libelle) values (?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, f.getCode());
            ps.setString(2, f.getLibelle());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next())
                f.setId(rs.getInt(1));

            rs.close();
            ps.close();

            System.out.println("filiere bien ajout�e ...");
            return true;

        }catch(Exception ex) {
            System.out.println("Pb lors de l ajout de la filiere ...");
        }

        return false;
    }

    @Override
    public boolean update(Filiere f) {

        if(this.connection == null)
            return false;

        try {
            PreparedStatement ps = this.connection.prepareStatement
                    ("update filiere set code =?, libelle = ? where id = ? ");

            ps.setString(1, f.getCode());
            ps.setString(2, f.getLibelle());
            ps.setInt(3, f.getId());

            ps.executeUpdate();

            ps.close();

            System.out.println("filiere bien mdf ...");
            return true;

        }catch(Exception ex) {
            System.out.println("Pb lors de la mdf de la filiere ...");
        }

        return false;
    }

    @Override
    public boolean delete(Filiere f) {

        if(this.connection == null)
            return false;

        try {
            PreparedStatement ps = this.connection.prepareStatement
                    ("delete from filiere where id = ? ");

            ps.setInt(1, f.getId());

            ps.executeUpdate();

            ps.close();

            System.out.println("filiere bien supprim�e ...");
            return true;

        }catch(Exception ex) {
            System.out.println("Pb lors de la mdf de la filiere ...");
        }

        return false;
    }

    @Override
    public Filiere getById(int id) {

        if(this.connection == null)
            return null;

        try {
            PreparedStatement ps = this.connection.prepareStatement
                    ("select * from filiere where id = ? ");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Filiere filiere = null;

            if(rs.next())
            {
                filiere = new Filiere();

                filiere.setId(rs.getInt(1));;
                filiere.setCode(rs.getString(2));
                filiere.setLibelle(rs.getString(3));
            }

            rs.close();
            ps.close();

            return filiere;

        }catch(Exception ex) {

            System.out.println("Pb lors de getById de filiere ...");
            return null;
        }
    }

    @Override
    public List<Filiere> getAll() {

        if(this.connection == null)
            return null;

        try {
            PreparedStatement ps = this.connection.prepareStatement
                    ("select * from filiere ");


            ResultSet rs = ps.executeQuery();
            List<Filiere> filieres = new ArrayList<Filiere>();

            while(rs.next())
            {
                Filiere filiere = new Filiere();

                filiere.setId(rs.getInt(1));;
                filiere.setCode(rs.getString(2));
                filiere.setLibelle(rs.getString(3));

                filieres.add(filiere);
            }

            rs.close();
            ps.close();

            return filieres;

        }catch(Exception ex) {

            System.out.println("Pb lors de getAll de filiere ...");
            return null;
        }

    }

    @Override
    public List<String> getAllFields() {

        if(this.connection == null)
            return null;

        try {
            PreparedStatement ps = this.connection.prepareStatement
                    ("select * from filiere ");


            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            List<String> fields = new ArrayList<String>();

            for(int i=1; i<= rsmd.getColumnCount(); i++) {
                fields.add(rsmd.getColumnName(i));
            }

            rs.close();
            ps.close();

            return fields;

        }catch(Exception ex) {

            System.out.println("Pb lors de getFields de filiere ...");
            return null;
        }
    }
}
