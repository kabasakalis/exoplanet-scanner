package org.kabasakalis.restclient;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/v2")
@RegisterRestClient(configKey="country-api",baseUri = "https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?format=json&table={table}")
public interface ExoplanetApi {

  @GET
  @Path("/table/{name}")
  @Produces("application/json")
  Set<Exoplanet> getByName(@QueryParam String table);
}
