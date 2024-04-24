package kz.iitu.taskrestphoenix.service;

import kz.iitu.taskrestphoenix.dto.ObjectRequestDto;
import kz.iitu.taskrestphoenix.model.ObjectRequest;
import kz.iitu.taskrestphoenix.repository.ObjectRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ObjectRequestServiceImpl implements ObjectRequestService{

    private final ObjectRequestRepository objectRequestRepository;

    @Autowired
    public ObjectRequestServiceImpl(ObjectRequestRepository objectRequestRepository) {
        this.objectRequestRepository = objectRequestRepository;
    }


    @Override
    public ObjectRequest create(ObjectRequest objectRequest) {
        ObjectRequest objectRequest1 = objectRequestRepository.save(objectRequest);

        log.info("IN create - objectRequest: {} succesfully created", objectRequest1);

        return objectRequest1;
    }

    @Override
    public ObjectRequest update(ObjectRequest objectRequest) {

        ObjectRequest objectRequest1 = objectRequestRepository.save(objectRequest);

        log.info("IN update - objectRequest: {} succesfully updated", objectRequest1);

        return objectRequest1;

    }

    @Override
    public ObjectRequest getById(Long id) {

        ObjectRequest objectRequest = objectRequestRepository.findById(id).orElse(null);

        if(objectRequest == null){
            log.warn("IN getById - no objectRequest found by id: {}", id);
            return null;
        }

        log.info("IN getById - objectRequest: {} found by id: {}", objectRequest);

        return objectRequest;

    }

    @Override
    public void delete(Long id) {

        objectRequestRepository.deleteById(id);
        log.info("IN delete - objectRequest with id: {} succesfully deleted", id);

    }

    @Override
    public List<ObjectRequest> getAll() {

        List<ObjectRequest> objectRequests = objectRequestRepository.findAll();
        log.info("IN getAll - {} objectRequests found", objectRequests.size());
        return objectRequests;

    }
}
