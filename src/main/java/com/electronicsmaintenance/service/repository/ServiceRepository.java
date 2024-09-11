package com.electronicsmaintenance.service.repository;

import com.electronicsmaintenance.service.entity.ServiceEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, UUID> {

}
