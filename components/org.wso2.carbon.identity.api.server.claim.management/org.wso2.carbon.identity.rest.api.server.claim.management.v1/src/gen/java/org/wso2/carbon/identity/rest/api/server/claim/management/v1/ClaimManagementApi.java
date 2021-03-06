/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.rest.api.server.claim.management.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.*;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.ClaimManagementApiService;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.factories.ClaimManagementApiServiceFactory;

import io.swagger.annotations.ApiParam;

import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.ErrorDTO;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.ClaimDialectReqDTO;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.ExternalClaimReqDTO;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.LocalClaimReqDTO;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.ClaimDialectResDTO;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.ExternalClaimResDTO;
import org.wso2.carbon.identity.rest.api.server.claim.management.v1.dto.LocalClaimResDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/claim-dialects")


@io.swagger.annotations.Api(value = "/claim-dialects", description = "the claim-dialects API")
public class ClaimManagementApi  {

   @Autowired
   private ClaimManagementApiService delegate;

    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a claim dialect.", notes = "Add a new claim dialect.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Item Created."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response addClaimDialect(@ApiParam(value = "claim dialect to add."  ) ClaimDialectReqDTO claimDialect)
    {
    return delegate.addClaimDialect(claimDialect);
    }
    @POST
    @Path("/{dialect-id}/claims")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add an external claim.", notes = "Add a new external claim.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Item Created."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found."),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response addExternalClaim(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId,
    @ApiParam(value = "External claim to add."  ) ExternalClaimReqDTO externalClaim)
    {
    return delegate.addExternalClaim(dialectId,externalClaim);
    }
    @POST
    @Path("/local/claims")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a local claim.", notes = "Add a new claim.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Item Created."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response addLocalClaim(@ApiParam(value = "Local claim to add."  ) LocalClaimReqDTO localClaim)
    {
    return delegate.addLocalClaim(localClaim);
    }
    @DELETE
    @Path("/{dialect-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete a claim dialect.", notes = "Delete a claim dialect by claim id.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response deleteClaimDialect(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId)
    {
    return delegate.deleteClaimDialect(dialectId);
    }
    @DELETE
    @Path("/{dialect-id}/claims/{claim-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete an external claim.", notes = "Delete a claim by dialect id and claim id.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response deleteExternalClaim(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId,
    @ApiParam(value = "Id of the claim.",required=true ) @PathParam("claim-id")  String claimId)
    {
    return delegate.deleteExternalClaim(dialectId,claimId);
    }
    @DELETE
    @Path("/local/claims/{claim-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete a local claim.", notes = "Delete a claim by claim id.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response deleteLocalClaim(@ApiParam(value = "Id of the claim.",required=true ) @PathParam("claim-id")  String claimId)
    {
    return delegate.deleteLocalClaim(claimId);
    }
    @GET
    @Path("/{dialect-id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve claim dialect.", notes = "Retrieve a claim dialect matching the given dialect id.", response = ClaimDialectResDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Requested claim dialect."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response getClaimDialect(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId)
    {
    return delegate.getClaimDialect(dialectId);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve claim dialects.", notes = "Retrieve claim dialects.", response = ClaimDialectResDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Claim dialects."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error."),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Not Implemented.") })

    public Response getClaimDialects(@ApiParam(value = "maximum number of records to return") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "number of records to skip for pagination") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "Condition to filter the retrival of records.") @QueryParam("filter")  String filter,
    @ApiParam(value = "Define the order how the retrieved records should be sorted.") @QueryParam("sort")  String sort)
    {
    return delegate.getClaimDialects(limit,offset,filter,sort);
    }
    @GET
    @Path("/{dialect-id}/claims/{claim-id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve external claim.", notes = "Retrieve an external claim matching the given dialect id and claim id.", response = ExternalClaimResDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Requested claim."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response getExternalClaim(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId,
    @ApiParam(value = "Id of the claim.",required=true ) @PathParam("claim-id")  String claimId)
    {
    return delegate.getExternalClaim(dialectId,claimId);
    }
    @GET
    @Path("/{dialect-id}/claims")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve external claims.", notes = "Retrieve External claims.", response = ExternalClaimResDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "External claims."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error."),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Not Implemented.") })

    public Response getExternalClaims(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId,
    @ApiParam(value = "maximum number of records to return") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "number of records to skip for pagination") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "Condition to filter the retrival of records.") @QueryParam("filter")  String filter,
    @ApiParam(value = "Define the order how the retrieved records should be sorted.") @QueryParam("sort")  String sort)
    {
    return delegate.getExternalClaims(dialectId,limit,offset,filter,sort);
    }
    @GET
    @Path("/local/claims/{claim-id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve local claim.", notes = "Retrieve a local claim matching the given claim id.", response = LocalClaimResDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Requested claim."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response getLocalClaim(@ApiParam(value = "Id of the claim.",required=true ) @PathParam("claim-id")  String claimId)
    {
    return delegate.getLocalClaim(claimId);
    }
    @GET
    @Path("/local/claims")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve local claims.", notes = "Retrieve local claims.", response = LocalClaimResDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Local claims."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error."),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Not Implemented.") })

    public Response getLocalClaims(@ApiParam(value = "Define only the required attributes to be sent in the response object.") @QueryParam("attributes")  String attributes,
    @ApiParam(value = "maximum number of records to return") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "number of records to skip for pagination") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "Condition to filter the retrival of records.") @QueryParam("filter")  String filter,
    @ApiParam(value = "Define the order how the retrieved records should be sorted.") @QueryParam("sort")  String sort)
    {
    return delegate.getLocalClaims(attributes,limit,offset,filter,sort);
    }
    @PUT
    @Path("/{dialect-id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update a claim dialect.", notes = "Update a claim dialect.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response updateClaimDialect(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId,
    @ApiParam(value = "Updated claim dialect."  ) ClaimDialectReqDTO claimDialect)
    {
    return delegate.updateClaimDialect(dialectId,claimDialect);
    }
    @PUT
    @Path("/{dialect-id}/claims/{claim-id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update an external claim.", notes = "Update an external claim.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response updateExternalClaim(@ApiParam(value = "Id of the claim dialect.",required=true ) @PathParam("dialect-id")  String dialectId,
    @ApiParam(value = "Id of the claim.",required=true ) @PathParam("claim-id")  String claimId,
    @ApiParam(value = "Updated external claim."  ) ExternalClaimReqDTO externalClaim)
    {
    return delegate.updateExternalClaim(dialectId,claimId,externalClaim);
    }
    @PUT
    @Path("/local/claims/{claim-id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update a local claim.", notes = "Update a local claim.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request."),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized."),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Resource Forbidden."),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists."),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.") })

    public Response updateLocalClaim(@ApiParam(value = "Id of the claim.",required=true ) @PathParam("claim-id")  String claimId,
    @ApiParam(value = "Updated local claim."  ) LocalClaimReqDTO localClaim)
    {
    return delegate.updateLocalClaim(claimId,localClaim);
    }
}

