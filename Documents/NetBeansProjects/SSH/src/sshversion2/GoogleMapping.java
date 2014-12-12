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
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.mapsengine.MapsEngine;
import com.google.api.services.mapsengine.MapsEngineRequestInitializer;
import com.google.api.services.mapsengine.model.Feature;
import com.google.api.services.mapsengine.model.FeaturesListResponse;
import com.google.api.services.mapsengine.model.GeoJsonPoint;

import java.io.IOException;

/** Java "Hello, world!" example using the client library */
public class GoogleMapping {

  static final String SAMPLE_TABLE_ID = "12421761926155747447-06672618218968397709";
  static final String PUBLIC_API_KEY = "YOUR_API_KEY_GOES_HERE";

  public static void main(String[] args) throws Exception {
    HttpTransport transport = new NetHttpTransport();
    JsonFactory jsonFactory = new GsonFactory();

    // This request initializer will ensure the API key is sent with every HTTP request.
    MapsEngineRequestInitializer apiKeyInitializer =
        new MapsEngineRequestInitializer(PUBLIC_API_KEY);

    MapsEngine engine = new MapsEngine.Builder(transport, jsonFactory, null)
        .setMapsEngineRequestInitializer(apiKeyInitializer)
        .setApplicationName("Google-MapsEngineSample/1.0")
        .build();

    readFeaturesFromTable(engine);
  }

  public static void readFeaturesFromTable(MapsEngine me) throws IOException {
    // Query the table for offices in WA that are within 100km of Perth.
    FeaturesListResponse featResp =  me.tables().features().list(SAMPLE_TABLE_ID)
        .setVersion("published")
        .setWhere("State='WA' AND ST_DISTANCE(geometry,ST_POINT(115.8589,-31.9522)) < 100000")
        .execute();

    for (Feature feat : featResp.getFeatures()) {
      System.out.println(
          "Properties: " + feat.getProperties().toString() + "\n\t" +
          "Name: " + feat.getProperties().get("Fcilty_nam") + "\n\t" +
          "Geometry Type: " + feat.getGeometry().getType());

      if (feat.getGeometry() instanceof GeoJsonPoint)  {
        GeoJsonPoint point = (GeoJsonPoint) feat.getGeometry();
        System.out.println("\t" +
            "Longitude: " + point.getCoordinates().get(0) + ", " +
            "Latitude: " +  point.getCoordinates().get(1));
      } else {
        System.out.println("Only points are expected in this table!");
        return;
      }
    }
  }
}
