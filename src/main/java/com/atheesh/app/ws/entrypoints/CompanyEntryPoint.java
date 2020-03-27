package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.CompanyRequest;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("company")
public class CompanyEntryPoint {

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public String getAllActiveCompanies() {
        return "All active companies will be received.";
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/all")
    public String getAllCompanies() {
        return "All companies will be received.";
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public String getCompanyById(@PathParam("id") Integer id) {
        return "company will be received.";
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public String save() {
        return "company will be saved.";
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public String update(@PathParam("id") int id, CompanyRequest companyRequest) {
        return "company will be updated.";
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id) {
        return true;
    }


}
