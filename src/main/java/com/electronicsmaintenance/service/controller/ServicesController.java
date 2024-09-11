package com.electronicsmaintenance.service.controller;

import org.springframework.web.bind.annotation.RestController;
import com.electronicsmaintenance.service.api.ServicesApi;
import com.electronicsmaintenance.service.entity.EnumFormaPagamento;
import com.electronicsmaintenance.service.entity.EnumStatusServico;
import com.electronicsmaintenance.service.entity.ServiceEntity;
import com.electronicsmaintenance.service.exception.ResourceNotFoundException;
import com.electronicsmaintenance.service.model.ServiceRequest;
import com.electronicsmaintenance.service.model.ServiceResponse;
import com.electronicsmaintenance.service.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@RestController
public class ServicesController implements ServicesApi {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ResponseEntity<ServiceResponse> createService(ServiceRequest serviceRequest) {
        ServiceEntity serviceEntity = toServiceEntity(serviceRequest);
        ServiceEntity savedService = serviceRepository.save(serviceEntity);
        return ResponseEntity.ok(toServiceResponse(savedService));
    }

    @Override
    public ResponseEntity<Void> deleteService(UUID id) {
        serviceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ServiceResponse>> getAllServices() {
        List<ServiceResponse> allServices = serviceRepository.findAll().stream()
            .map(this::toServiceResponse)
            .toList();
        return ResponseEntity.ok(allServices);
    }

    @Override
    public ResponseEntity<ServiceResponse> getServiceById(UUID id) {
        return serviceRepository.findById(id)
            .map(this::toServiceResponse)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public ResponseEntity<ServiceResponse> updateService(UUID id, ServiceRequest serviceRequest) {
        ServiceEntity existingService = serviceRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());

        ServiceEntity updatedService = toServiceEntity(serviceRequest);
        updatedService.setIdServico(existingService.getIdServico());
        ServiceEntity savedService = serviceRepository.save(updatedService);
        return ResponseEntity.ok(toServiceResponse(savedService));
    }

    private <E extends Enum<E>, F extends Enum<F>> F convertEnum(E sourceEnum, Class<F> targetEnumClass) {
        return Enum.valueOf(targetEnumClass, sourceEnum.name());
    }

    private ServiceEntity toServiceEntity(ServiceRequest request) {
        ServiceEntity entity = new ServiceEntity();
        entity.setNomeCliente(request.getNomeCliente());
        entity.setTelefoneContato(request.getTelefoneContato());
        entity.setEmailContato(request.getEmailContato());
        entity.setTipoEletronico(request.getTipoEletronico());
        entity.setModeloEletronico(request.getModeloEletronico());
        entity.setTipoServico(request.getTipoServico());
        entity.setStatusServico(convertEnum(request.getStatusServico(), EnumStatusServico.class));
        entity.setFormaPagamento(convertEnum(request.getFormaPagamento(), EnumFormaPagamento.class));
        entity.setValorServico(request.getValorServico());
        return entity;
    }

    private ServiceResponse toServiceResponse(ServiceEntity entity) {
        return new ServiceResponse()
            .idServico(entity.getIdServico())
            .nomeCliente(entity.getNomeCliente())
            .telefoneContato(entity.getTelefoneContato())
            .emailContato(entity.getEmailContato())
            .tipoEletronico(entity.getTipoEletronico())
            .modeloEletronico(entity.getModeloEletronico())
            .tipoServico(entity.getTipoServico())
            .statusServico(ServiceResponse.StatusServicoEnum.valueOf(entity.getStatusServico().name()))
            .valorServico(entity.getValorServico())
            .formaPagamento(ServiceResponse.FormaPagamentoEnum.valueOf(entity.getFormaPagamento().name()))
            .dataInsercao(entity.getDataInsercao().atOffset(ZoneOffset.UTC))
            .dataAtualizacao(entity.getDataAtualizacao().atOffset(ZoneOffset.UTC));
    }
}
