package kz.iitu.taskrestphoenix.service;

import kz.iitu.taskrestphoenix.model.ObjectRequest;

import java.util.List;

public interface ObjectRequestService {

    ObjectRequest create(ObjectRequest objectRequest);

    ObjectRequest update(ObjectRequest objectRequest);

    ObjectRequest getById(Long id);

    void delete(Long id);

    List<ObjectRequest> getAll();


}
