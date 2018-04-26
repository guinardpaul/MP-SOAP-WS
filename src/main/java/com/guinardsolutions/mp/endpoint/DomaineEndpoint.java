/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guinardsolutions.mp.endpoint;

import com.guinardsolutions.mp.entities.Domaine;
import com.guinardsolutions.mp.gs_ws.AddDomaineRequest;
import com.guinardsolutions.mp.gs_ws.AddDomaineResponse;
import com.guinardsolutions.mp.gs_ws.DeleteDomaineRequest;
import com.guinardsolutions.mp.gs_ws.DeleteDomaineResponse;
import com.guinardsolutions.mp.gs_ws.DomaineInfo;
import com.guinardsolutions.mp.gs_ws.GetAllDomainesRequest;
import com.guinardsolutions.mp.gs_ws.GetAllDomainesResponse;
import com.guinardsolutions.mp.gs_ws.GetDomaineByIdRequest;
import com.guinardsolutions.mp.gs_ws.GetDomaineByIdResponse;
import com.guinardsolutions.mp.gs_ws.GetMainDomainesByCycleRequest;
import com.guinardsolutions.mp.gs_ws.GetMainDomainesByCycleResponse;
import com.guinardsolutions.mp.gs_ws.GetMainDomainesRequest;
import com.guinardsolutions.mp.gs_ws.GetMainDomainesResponse;
import com.guinardsolutions.mp.gs_ws.GetSousDomainesRequest;
import com.guinardsolutions.mp.gs_ws.GetSousDomainesResponse;
import com.guinardsolutions.mp.gs_ws.ServiceStatus;
import com.guinardsolutions.mp.gs_ws.UpdateDomaineRequest;
import com.guinardsolutions.mp.gs_ws.UpdateDomaineResponse;
import com.guinardsolutions.mp.service.DomaineService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Paul
 */
@Endpoint
public class DomaineEndpoint {

    private static final String NAMESPACE_URI = "http://guinardsolutions.com/mp/gs_ws";

    private DomaineService domaineService;

    /**
     *
     * @param domaineService
     */
    @Autowired
    public DomaineEndpoint(DomaineService domaineService) {
        this.domaineService = domaineService;
    }

    /**
     * GetAllDomaines
     *
     * @param request
     * @return GetAllDomainesResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllDomainesRequest")
    @ResponsePayload
    public GetAllDomainesResponse getAllDomaines(@RequestPayload GetAllDomainesRequest request) {
        GetAllDomainesResponse response = new GetAllDomainesResponse();
        List<DomaineInfo> domainesInfos = new ArrayList<>();
        List<Domaine> domaines = domaineService.getAllDomaines();

        for (Domaine d : domaines) {
            DomaineInfo di = new DomaineInfo();
            BeanUtils.copyProperties(d, di);
            domainesInfos.add(di);
        }
        response.getDomaineInfos().addAll(domainesInfos);
        return response;
    }

    /**
     * GetDomaineById
     *
     * @param request
     * @return GetDomaineByIdResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDomaineByIdRequest")
    @ResponsePayload
    public GetDomaineByIdResponse getOneDomaine(@RequestPayload GetDomaineByIdRequest request) {
        GetDomaineByIdResponse response = new GetDomaineByIdResponse();
        DomaineInfo domaineInfo = new DomaineInfo();
        Domaine domaine = domaineService.getOneDomaine(request.getDomaineId());
        BeanUtils.copyProperties(domaine, domaineInfo);

        response.setDomaineInfo(domaineInfo);
        return response;
    }

    /**
     * GetMainDomaines
     *
     * @param request
     * @return GetMainDomainesResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMainDomainesRequest")
    @ResponsePayload
    public GetMainDomainesResponse getMainDomaines(@RequestPayload GetMainDomainesRequest request) {
        GetMainDomainesResponse response = new GetMainDomainesResponse();
        List<DomaineInfo> domainesInfos = new ArrayList<>();
        List<Domaine> domaines = domaineService.getMainDomaines();

        for (Domaine d : domaines) {
            DomaineInfo di = new DomaineInfo();
            BeanUtils.copyProperties(d, di);
            domainesInfos.add(di);
        }
        response.getDomaineInfos().addAll(domainesInfos);
        return response;
    }

    /**
     * GetMainDomainesByCycle
     *
     * @param request
     * @return GetMainDomainesByCycleResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMainDomainesByCycleRequest")
    @ResponsePayload
    public GetMainDomainesByCycleResponse getMainDomainesByCycle(@RequestPayload GetMainDomainesByCycleRequest request) {
        GetMainDomainesByCycleResponse response = new GetMainDomainesByCycleResponse();
        List<DomaineInfo> domainesInfos = new ArrayList<>();
        List<Domaine> domaines = domaineService.getMainDomainesByCycle(request.getCycle());

        for (Domaine d : domaines) {
            DomaineInfo di = new DomaineInfo();
            BeanUtils.copyProperties(d, di);
            domainesInfos.add(di);
        }
        response.getDomaineInfos().addAll(domainesInfos);
        return response;
    }

    /**
     * GetSousDomaines
     *
     * @param request
     * @return GetSousDomainesResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSousDomainesRequest")
    @ResponsePayload
    public GetSousDomainesResponse getSousDomaines(@RequestPayload GetSousDomainesRequest request) {
        GetSousDomainesResponse response = new GetSousDomainesResponse();
        List<Domaine> domaines = domaineService.getSousDomaines(request.getDomaineId());
        List<DomaineInfo> domaineInfos = new ArrayList<>();

        for (Domaine d : domaines) {
            DomaineInfo di = new DomaineInfo();
            BeanUtils.copyProperties(d, di);
            domaineInfos.add(di);
        }

        response.getDomaineInfos().addAll(domaineInfos);
        return response;
    }

    /**
     * AddDomaine
     *
     * @param request
     * @return AddDomaineResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addDomaineRequest")
    @ResponsePayload
    public AddDomaineResponse addDomaine(@RequestPayload AddDomaineRequest request) {
        AddDomaineResponse response = new AddDomaineResponse();
        Domaine domaine = new Domaine();
        DomaineInfo domaineInfo = new DomaineInfo();
        domaineInfo.setRef(request.getRef());
        domaineInfo.setDescription(request.getDescription());
        domaineInfo.setCycle(request.getCycle());
        domaineInfo.setAbstractDomaine(request.getAbstractDomaine());

        BeanUtils.copyProperties(domaineInfo, domaine);
        domaine = domaineService.saveDomaine(domaine);

        BeanUtils.copyProperties(domaine, domaineInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Domaine saved successfully");

        response.setServiceStatus(ss);
        response.setDomaineInfo(domaineInfo);
        return response;
    }

    /**
     * UpdateDomaine
     *
     * @param request
     * @return UpdateDomaineResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateDomaineRequest")
    @ResponsePayload
    public UpdateDomaineResponse updateDomaine(@RequestPayload UpdateDomaineRequest request) {
        UpdateDomaineResponse response = new UpdateDomaineResponse();
        Domaine domaine = new Domaine();
        DomaineInfo domaineInfo = request.getDomaineInfo();

        BeanUtils.copyProperties(domaineInfo, domaine);
        domaine = domaineService.updateDomaine(domaine);

        BeanUtils.copyProperties(domaine, domaineInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Domaine updated successfully");

        response.setServiceStatus(ss);
        response.setDomaineInfo(domaineInfo);
        return response;
    }

    /**
     * DeleteDomaine
     *
     * @param request
     * @return DeleteDomaineResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteDomaineRequest")
    @ResponsePayload
    public DeleteDomaineResponse deleteDomaine(@RequestPayload DeleteDomaineRequest request) {
        DeleteDomaineResponse response = new DeleteDomaineResponse();

        domaineService.deleteDomaine(request.getDomaineId());

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Domaine deleted successfully");

        response.setServiceStatus(ss);
        return response;
    }

}
