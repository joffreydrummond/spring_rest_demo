package com.bnj.restaurant.controller;

import com.bnj.restaurant.entity.Customer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

// returns list of customers

@OpenAPIDefinition(
    info = @Info(title = "Customer API V1"),
    servers = {@Server(url = "http://localhost:8080")})
public interface CustomerOperation {

  @RequestMapping("/v1/customers")
  @Operation(
      summary = "Returns a list of customers",
      description = "Returns a list of customers",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "A list of customers is returned",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Customer.class))),
        @ApiResponse(
            responseCode = "400",
            description = "The request parameters are invalid",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(
            responseCode = "404",
            description = "The page you are looking for is not found. What did you do.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error Occurred",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
      },
          parameters = {
                  @Parameter(
                          name = "customer_id",
                          allowEmptyValue = false,
                          required = false,
                          description = "The model name (i.e, 'WRANGLER')"),
                  @Parameter(
                          name = "trim",
                          allowEmptyValue = false,
                          required = false,
                          description = "The trim level (i.e, 'Sport')")
          })
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> getCustomers();
}
