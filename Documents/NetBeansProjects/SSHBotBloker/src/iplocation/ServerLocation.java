/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iplocation;

/**
 *
 * @author win 8
 */
public class ServerLocation {
    
    String countryCode;
    String countryName;
    String Region;
    String regionName;
    String city;
    String postalCode;
    float latitude;
    float longtiude;
    
    
    

    void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        //System.out.println("Country code" + countryCode);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    void setCountryName(String countryName) {
        this.countryName = countryName;
        //System.out.println("Country name " + " " +countryName);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setRegion(String region) {
        this.Region = region;
        //System.out.println("Region " + " " + region);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setRegionName(String regionNameByCode) {
        this.regionName = regionNameByCode;
        //System.out.println("Region name by code " + " " + regionNameByCode);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setCity(String city) {
        
        this.city = city;
        //System.out.println("City " + " " + city);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        //System.out.println("Postal code " + " " + postalCode);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLatitude(String valueOf) {
        
        this.latitude = Float.parseFloat(valueOf);
        //System.out.println("Latitude " +" "+ valueOf);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLongitude(String valueOf) {
        
        this.longtiude = Float.parseFloat(valueOf);
        //System.out.println("Longitude " + " " + valueOf);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegion() {
        return Region;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongtiude() {
        return longtiude;
    }
    
}
