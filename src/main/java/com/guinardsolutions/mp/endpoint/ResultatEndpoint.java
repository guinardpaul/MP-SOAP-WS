/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guinardsolutions.mp.endpoint;

import com.guinardsolutions.mp.entities.Resultat;
import com.guinardsolutions.mp.gs_ws.AddResultatRequest;
import com.guinardsolutions.mp.gs_ws.AddResultatResponse;
import com.guinardsolutions.mp.gs_ws.DeleteResultatRequest;
import com.guinardsolutions.mp.gs_ws.DeleteResultatResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByCompetenceAndTrimestreRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByCompetenceAndTrimestreResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByCompetenceRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByCompetenceResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveAndCompetenceAndTrimestreRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveAndCompetenceAndTrimestreResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveAndCompetenceRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveAndCompetenceResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveAndTrimestreRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveAndTrimestreResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByEleveResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByTrimestreRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsByTrimestreResponse;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsRequest;
import com.guinardsolutions.mp.gs_ws.GetAllResultatsResponse;
import com.guinardsolutions.mp.gs_ws.GetResultatByIdRequest;
import com.guinardsolutions.mp.gs_ws.GetResultatByIdResponse;
import com.guinardsolutions.mp.gs_ws.ResultatInfo;
import com.guinardsolutions.mp.gs_ws.ServiceStatus;
import com.guinardsolutions.mp.gs_ws.UpdateResultatRequest;
import com.guinardsolutions.mp.gs_ws.UpdateResultatResponse;
import com.guinardsolutions.mp.service.ResultatService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
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
public class ResultatEndpoint {

    private static final String NAMESPACE_URI = "http://guinardsolutions.com/mp/gs_ws";

    private ResultatService resultatService;

    public ResultatEndpoint(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsRequest")
    @ResponsePayload
    public GetAllResultatsResponse getAllResultats(@RequestPayload GetAllResultatsRequest request) {
        GetAllResultatsResponse response = new GetAllResultatsResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultats();

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByEleveRequest")
    @ResponsePayload
    public GetAllResultatsByEleveResponse getAllResultatsByEleve(@RequestPayload GetAllResultatsByEleveRequest request) {
        GetAllResultatsByEleveResponse response = new GetAllResultatsByEleveResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByEleve(request.getEleveId());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByCompetenceRequest")
    @ResponsePayload
    public GetAllResultatsByCompetenceResponse getAllResultatsByCompetences(@RequestPayload GetAllResultatsByCompetenceRequest request) {
        GetAllResultatsByCompetenceResponse response = new GetAllResultatsByCompetenceResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByCompetence(request.getCompetenceId());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByTrimestreRequest")
    @ResponsePayload
    public GetAllResultatsByTrimestreResponse getAllResultatsByTrimestre(@RequestPayload GetAllResultatsByTrimestreRequest request) {
        GetAllResultatsByTrimestreResponse response = new GetAllResultatsByTrimestreResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByTrimestre(request.getTrimestre());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByEleveAndCompetenceRequest")
    @ResponsePayload
    public GetAllResultatsByEleveAndCompetenceResponse getAllResultatsByCompetencesAndEleve(@RequestPayload GetAllResultatsByEleveAndCompetenceRequest request) {
        GetAllResultatsByEleveAndCompetenceResponse response = new GetAllResultatsByEleveAndCompetenceResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByEleveAndCompetence(request.getEleveId(), request.getCompetenceId());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByEleveAndCompetenceAndTrimestreRequest")
    @ResponsePayload
    public GetAllResultatsByEleveAndCompetenceAndTrimestreResponse getAllResultatsByCompetencesAndEleveAndTrimestre(@RequestPayload GetAllResultatsByEleveAndCompetenceAndTrimestreRequest request) {
        GetAllResultatsByEleveAndCompetenceAndTrimestreResponse response = new GetAllResultatsByEleveAndCompetenceAndTrimestreResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByEleveAndCompetenceAndTrimestre(request.getEleveId(), request.getCompetenceId(), request.getTrimestre());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByEleveAndTrimestreRequest")
    @ResponsePayload
    public GetAllResultatsByEleveAndTrimestreResponse getAllResultatsByEleveAndTrimestre(@RequestPayload GetAllResultatsByEleveAndTrimestreRequest request) {
        GetAllResultatsByEleveAndTrimestreResponse response = new GetAllResultatsByEleveAndTrimestreResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByEleveAndTrimestre(request.getEleveId(), request.getTrimestre());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResultatsByCompetenceAndTrimestreRequest")
    @ResponsePayload
    public GetAllResultatsByCompetenceAndTrimestreResponse getAllResultatsByCompetenceAndTrimestre(@RequestPayload GetAllResultatsByCompetenceAndTrimestreRequest request) {
        GetAllResultatsByCompetenceAndTrimestreResponse response = new GetAllResultatsByCompetenceAndTrimestreResponse();
        List<ResultatInfo> resultatInfos = new ArrayList<>();
        List<Resultat> resultats = resultatService.getAllResultatsByCompetenceAndTrimestre(request.getCompetenceId(), request.getTrimestre());

        for (Resultat r : resultats) {
            ResultatInfo ri = new ResultatInfo();
            BeanUtils.copyProperties(r, ri);
            resultatInfos.add(ri);
        }
        response.getResultatInfos().addAll(resultatInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getResultatByIdRequest")
    @ResponsePayload
    public GetResultatByIdResponse getOneResultat(@RequestPayload GetResultatByIdRequest request) {
        GetResultatByIdResponse response = new GetResultatByIdResponse();
        ResultatInfo resultatInfo = new ResultatInfo();
        Resultat resultat = resultatService.getOneResultat(request.getResultatId());

        BeanUtils.copyProperties(resultat, resultatInfo);

        response.setResultatInfo(resultatInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addResultatRequest")
    @ResponsePayload
    public AddResultatResponse saveResultat(@RequestPayload AddResultatRequest request) {
        AddResultatResponse response = new AddResultatResponse();
        ResultatInfo resultatInfo = new ResultatInfo();
        resultatInfo.setResult(request.getResult());
        resultatInfo.setCompetence(request.getCompetence());
        resultatInfo.setEleve(request.getEleve());
        resultatInfo.setTrimestre(request.getTrimestre());

        Resultat resultat = new Resultat();
        BeanUtils.copyProperties(resultatInfo, resultat);
        resultat = resultatService.saveResultat(resultat);

        BeanUtils.copyProperties(resultat, resultatInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Resultat saved successfully");

        response.setServiceStatus(ss);
        response.setResultatInfo(resultatInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateResultatRequest")
    @ResponsePayload
    public UpdateResultatResponse updateResultat(@RequestPayload UpdateResultatRequest request) {
        UpdateResultatResponse response = new UpdateResultatResponse();
        ResultatInfo resultatInfo = request.getResultatInfo();

        Resultat resultat = new Resultat();
        BeanUtils.copyProperties(resultatInfo, resultat);
        resultat = resultatService.updateResultat(resultat);

        BeanUtils.copyProperties(resultat, resultatInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Resultat updated successfully");

        response.setServiceStatus(ss);
        response.setResultatInfo(resultatInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteResultatRequest")
    @ResponsePayload
    public DeleteResultatResponse deleteResultat(@RequestPayload DeleteResultatRequest request) {
        DeleteResultatResponse response = new DeleteResultatResponse();

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Resultat deleted successfully");

        response.setServiceStatus(ss);
        return response;
    }

}
