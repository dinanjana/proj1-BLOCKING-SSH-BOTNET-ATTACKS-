/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sshversion2;

/**
 *
 * @author win 8
 */
import java.io.File;
import java.io.IOException;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
 
public class GeoIPReader {
    
    
    
    public ServerLocation getLocation(String ipAddress) {
 
	File file = new File(
	    "C:\\Users\\win 8\\Documents\\NetBeansProjects\\SSH\\src\\sshversion2\\GeoLiteCity.dat");
	return getLocation(ipAddress, file);
 
  }
 
  public ServerLocation getLocation(String ipAddress, File file) {
 
	ServerLocation serverLocation = null;
 
	try {
 
	serverLocation = new ServerLocation();
 
	LookupService lookup = new LookupService(file,LookupService.GEOIP_MEMORY_CACHE);
	Location locationServices = lookup.getLocation(ipAddress);
 
	serverLocation.setCountryCode(locationServices.countryCode);
	serverLocation.setCountryName(locationServices.countryName);
	serverLocation.setRegion(locationServices.region);
	serverLocation.setRegionName(regionName.regionNameByCode(
             locationServices.countryCode, locationServices.region));
	serverLocation.setCity(locationServices.city);
	serverLocation.setPostalCode(locationServices.postalCode);
	serverLocation.setLatitude(String.valueOf(locationServices.latitude));
	serverLocation.setLongitude(String.valueOf(locationServices.longitude));
 
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}
 
	return serverLocation;
 
  }
}
    

