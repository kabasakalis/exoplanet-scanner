package org.kabasakalis.endpoints;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.kabasakalis.restclient.CountriesApi;
import org.kabasakalis.restclient.Country;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/country")
public class CountriesEndpoint {

  @Inject
  @RestClient
  CountriesApi countriesApi;


  @GET
  @Path("/name/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Set<Country> name(@PathParam String name) {
    return countriesApi.getByName(name);
  }
}
