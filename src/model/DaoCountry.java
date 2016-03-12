package model;

import dto.Country;

import java.util.List;

public interface DaoCountry {

    public List<Country> query();
    public String insert(Country country);
    public String delete(String country_id);
    public String update(Country country);
    public Country get(String country_id);
}
