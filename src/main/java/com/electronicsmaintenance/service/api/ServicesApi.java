package com.electronicsmaintenance.service.api;

import com.electronicsmaintenance.service.model.ServiceRequest;
import com.electronicsmaintenance.service.model.ServiceResponse;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "services", description = "Os serviços da API")
public interface ServicesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /services : Cria um novo serviço
     *
     * @param serviceRequest  (required)
     * @return Serviço criado com sucesso (status code 200)
     *         or Requisição mal formatada (status code 400)
     */
    @Operation(
        operationId = "createService",
        summary = "Cria um novo serviço",
        tags = { "services" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Serviço criado com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Requisição mal formatada", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/services",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ServiceResponse> _createService(
        @Parameter(name = "ServiceRequest", description = "", required = true) @Valid @RequestBody ServiceRequest serviceRequest
    ) {
        return createService(serviceRequest);
    }

    // Override this method
    default  ResponseEntity<ServiceResponse> createService(ServiceRequest serviceRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"formaPagamento\" : \"DINHEIRO\", \"emailContato\" : \"joao.victor15@gmail.com\", \"tipoServico\" : \"Formatação\", \"tipoEletronico\" : \"Notebook\", \"dataAtualizacao\" : \"2024-09-03T12:35:56Z\", \"dataInsercao\" : \"2024-09-03T12:34:56Z\", \"idServico\" : \"a3bb189e-8bf9-3888-9912-ace4e6543002\", \"statusServico\" : \"PENDENTE\", \"modeloEletronico\" : \"Vaio FE15\", \"nomeCliente\" : \"João Victor\", \"telefoneContato\" : \"+55 81 92897-4311\", \"valorServico\" : 149.99 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * DELETE /services/delete/{id} : Deleta um determinado serviço buscando pelo seu IdServico
     *
     * @param id ID do serviço a ser deletado (required)
     * @return Serviço deletado com sucesso (status code 204)
     *         or Serviço não encontrado (status code 404)
     */
    @Operation(
        operationId = "deleteService",
        summary = "Deleta um determinado serviço buscando pelo seu IdServico",
        tags = { "services" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Serviço deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/services/delete/{id}"
    )
    default ResponseEntity<Void> _deleteService(
        @Parameter(name = "id", description = "ID do serviço a ser deletado", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        return deleteService(id);
    }

    // Override this method
    default  ResponseEntity<Void> deleteService(UUID id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    /**
     * GET /services/all : Lista todos os serviços
     *
     * @return Lista todos os serviços encontrados (status code 200)
     */
    @Operation(
        operationId = "getAllServices",
        summary = "Lista todos os serviços",
        tags = { "services" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista todos os serviços encontrados", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ServiceResponse.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/services/all",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ServiceResponse>> _getAllServices(

    ) {
        return getAllServices();
    }

    // Override this method
    default  ResponseEntity<List<ServiceResponse>> getAllServices() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"formaPagamento\" : \"DINHEIRO\", \"emailContato\" : \"joao.victor15@gmail.com\", \"tipoServico\" : \"Formatação\", \"tipoEletronico\" : \"Notebook\", \"dataAtualizacao\" : \"2024-09-03T12:35:56Z\", \"dataInsercao\" : \"2024-09-03T12:34:56Z\", \"idServico\" : \"a3bb189e-8bf9-3888-9912-ace4e6543002\", \"statusServico\" : \"PENDENTE\", \"modeloEletronico\" : \"Vaio FE15\", \"nomeCliente\" : \"João Victor\", \"telefoneContato\" : \"+55 81 92897-4311\", \"valorServico\" : 149.99 }, { \"formaPagamento\" : \"DINHEIRO\", \"emailContato\" : \"joao.victor15@gmail.com\", \"tipoServico\" : \"Formatação\", \"tipoEletronico\" : \"Notebook\", \"dataAtualizacao\" : \"2024-09-03T12:35:56Z\", \"dataInsercao\" : \"2024-09-03T12:34:56Z\", \"idServico\" : \"a3bb189e-8bf9-3888-9912-ace4e6543002\", \"statusServico\" : \"PENDENTE\", \"modeloEletronico\" : \"Vaio FE15\", \"nomeCliente\" : \"João Victor\", \"telefoneContato\" : \"+55 81 92897-4311\", \"valorServico\" : 149.99 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * GET /services/{id} : Obtenha um serviço específico buscando por seu respectivo IdServico
     *
     * @param id ID do serviço a ser obtido (required)
     * @return Serviço encontrado (status code 200)
     *         or Serviço não encontrado (status code 404)
     */
    @Operation(
        operationId = "getServiceById",
        summary = "Obtenha um serviço específico buscando por seu respectivo IdServico",
        tags = { "services" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Serviço encontrado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado",content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/services/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<ServiceResponse> _getServiceById(
        @Parameter(name = "id", description = "ID do serviço a ser obtido", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        return getServiceById(id);
    }

    // Override this method
    default  ResponseEntity<ServiceResponse> getServiceById(UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"formaPagamento\" : \"DINHEIRO\", \"emailContato\" : \"joao.victor15@gmail.com\", \"tipoServico\" : \"Formatação\", \"tipoEletronico\" : \"Notebook\", \"dataAtualizacao\" : \"2024-09-03T12:35:56Z\", \"dataInsercao\" : \"2024-09-03T12:34:56Z\", \"idServico\" : \"a3bb189e-8bf9-3888-9912-ace4e6543002\", \"statusServico\" : \"PENDENTE\", \"modeloEletronico\" : \"Vaio FE15\", \"nomeCliente\" : \"João Victor\", \"telefoneContato\" : \"+55 81 92897-4311\", \"valorServico\" : 149.99 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * PUT /services/update/{id} : Atualiza/altera os dados contidos em um determinado IdServico
     *
     * @param id ID do serviço a ser atualizado/alterado (required)
     * @param serviceRequest  (required)
     * @return Serviço atualizado com sucesso (status code 200)
     *         or Serviço não encontrado (status code 404)
     *         or Requisição mal formatada (status code 400)
     */
    @Operation(
        operationId = "updateService",
        summary = "Atualiza/altera os dados contidos em um determinado IdServico",
        tags = { "services" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Serviço atualizado com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Requisição mal formatada", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/services/update/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ServiceResponse> _updateService(
        @Parameter(name = "id", description = "ID do serviço a ser atualizado/alterado", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id,
        @Parameter(name = "ServiceRequest", description = "", required = true) @Valid @RequestBody ServiceRequest serviceRequest
    ) {
        return updateService(id, serviceRequest);
    }

    // Override this method
    default  ResponseEntity<ServiceResponse> updateService(UUID id, ServiceRequest serviceRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"formaPagamento\" : \"DINHEIRO\", \"emailContato\" : \"joao.victor15@gmail.com\", \"tipoServico\" : \"Formatação\", \"tipoEletronico\" : \"Notebook\", \"dataAtualizacao\" : \"2024-09-03T12:35:56Z\", \"dataInsercao\" : \"2024-09-03T12:34:56Z\", \"idServico\" : \"a3bb189e-8bf9-3888-9912-ace4e6543002\", \"statusServico\" : \"PENDENTE\", \"modeloEletronico\" : \"Vaio FE15\", \"nomeCliente\" : \"João Victor\", \"telefoneContato\" : \"+55 81 92897-4311\", \"valorServico\" : 149.99 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
