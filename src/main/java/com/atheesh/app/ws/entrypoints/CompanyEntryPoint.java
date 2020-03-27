package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.model.request.CompanyRequest;
import com.atheesh.app.ws.model.response.CompanyResponse;
import com.atheesh.app.ws.service.CompanyService;
import com.atheesh.app.ws.shared.dto.CompanyDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

@Component
@Path("company")
public class CompanyEntryPoint {

    @Autowired
    CompanyService companyService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/status/{status}")
    public List<CompanyResponse> getAllActiveCompanies(@PathParam("status") Status status) {
        List<CompanyDTO> companyDTOList = companyService.getCompaniesByStatus(status);
        List<CompanyResponse> companyResponseList = new ArrayList<>();

        for(CompanyDTO companyDTO : companyDTOList){
            companyResponseList.add(convertDTOToResponse(companyDTO));
        }
        return companyResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/all")
    public List<CompanyResponse> getAllCompanies() {
        List<CompanyDTO> companyDTOList = companyService.getAllCompanies();
        List<CompanyResponse> companyResponseList = new ArrayList<>();

        for(CompanyDTO companyDTO : companyDTOList){
            companyResponseList.add(convertDTOToResponse(companyDTO));
        }
        return companyResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public CompanyResponse getCompanyById(@PathParam("id") Integer id) {
        CompanyDTO companyDTO = companyService.getCompanyById(id);
        return convertDTOToResponse(companyDTO);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public CompanyResponse save(CompanyRequest companyRequest) {
        CompanyDTO companyDTO = companyService.save(convertRequestToDTO(companyRequest));
        return convertDTOToResponse(companyDTO);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, CompanyRequest companyRequest) {
        return companyService.update(id,convertRequestToDTO(companyRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        companyService.delete(id);
        return true;
    }

    private CompanyResponse convertDTOToResponse(CompanyDTO companyDTO){
        return (CompanyResponse) conversion(companyDTO,new CompanyResponse());
    }

    private CompanyDTO convertRequestToDTO(CompanyRequest companyRequest){
        return (CompanyDTO) conversion(companyRequest, new CompanyDTO());
    }

}
