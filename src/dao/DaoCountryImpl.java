package dao;
import Connection.sql.ConnectionDB;
import dto.Country;
import model.DaoCountry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCountryImpl implements DaoCountry {

    private final ConnectionDB db;


    public DaoCountryImpl(){
        db=new ConnectionDB();
    }


    @Override
    public List<Country> query() {
        List<Country> list = new ArrayList<>();
        String sql01 = "SELECT * FROM countries";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps01 = cn.prepareStatement(sql01);
                ResultSet rs = ps01.executeQuery();
                while (rs.next()) {
                    Country country = new Country();
                    country.setCountry_id(rs.getString(1));
                    country.setCountry_name(rs.getString(2));
                    country.setRegion_id(rs.getInt(3));


                    list.add(country);
                }
                cn.close();

            } catch(SQLException e ) {
                e.printStackTrace();
            }
        }



        return list;
    }
    @Override
    public String insert(Country country) {
        String result = null;
        try {
            Connection cn  = db.getConnection();
            CallableStatement cs = cn.prepareCall("{call hr_insert(?, ? )}");
            cs.setString(1, country.getCountry_id());
            cs.setString(2, country.getCountry_name());
           // cs.setInt(3, country.getRegion_id());
            int ctos = cs.executeUpdate();
            cn.close();

            if (ctos == 0) {
                result = "0 filas afectadas.";
            }

        } catch(SQLException e) {
            e.printStackTrace();

        }

        return result;
    }
    @Override
    public String delete(String country_Id) {
        String result = null;


        try {
            Connection cn = db.getConnection();
            CallableStatement cs = cn.prepareCall("{call hr_delete(?)}");

            cs.setString(1,country_Id);

            int ctos = cs.executeUpdate();
            cn.close();

            if (ctos == 0) {
                result = "0 filas afectadas.";
            }
        } catch(SQLException e)  {
            e.printStackTrace();
            //result = e.getMessage();
        }

        return result;
    }
    @Override
    public String update(Country country) {
        String result = null;

        try {
            Connection cn = db.getConnection();
            CallableStatement cs = cn.prepareCall("{call sp_update(?, ?, ?)}");

            cs.setString(1, country.getCountry_id());
            cs.setString(2, country.getCountry_name());
            cs.setInt(3, country.getRegion_id());


            int ctos = cs.executeUpdate();
            cn.close();

            if (ctos == 0) {
                result = "0 filas afectadas.";
            }
        } catch(SQLException e)  {
            result = e.getMessage();
        }

        return result;
    }

    @Override
    public Country get(String country_id) {
        Country country = new Country();

        try {
            Connection cn = db.getConnection();
            CallableStatement cs = cn.prepareCall("{call sp_get(?)}");

            cs.setString(1, country_id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                country.setCountry_id(rs.getString(1));
                country.setCountry_name(rs.getString(3));
                country.setRegion_id(rs.getInt(2));
            }

            cn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return country;
    }


}
