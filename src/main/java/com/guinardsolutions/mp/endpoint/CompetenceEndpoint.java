/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guinardsolutions.mp.endpoint;

import com.guinardsolutions.mp.entities.Competence;
import com.guinardsolutions.mp.gs_ws.AddCompetenceRequest;
import com.guinardsolutions.mp.gs_ws.AddCompetenceResponse;
import com.guinardsolutions.mp.gs_ws.CompetenceInfo;
import com.guinardsolutions.mp.gs_ws.DeleteCompetenceRequest;
import com.guinardsolutions.mp.gs_ws.DeleteCompetenceResponse;
import com.guinardsolutions.mp.gs_ws.GetAllCompetencesByCycleRequest;
import com.guinardsolutions.mp.gs_ws.GetAllCompetencesByCycleResponse;
import com.guinardsolutions.mp.gs_ws.GetAllCompetencesByDomaineRequest;
import com.guinardsolutions.mp.gs_ws.GetAllCompetencesByDomaineResponse;
import com.guinardsolutions.mp.gs_ws.GetAllCompetencesRequest;
import com.guinardsolutions.mp.gs_ws.GetAllCompetencesResponse;
import com.guinardsolutions.mp.gs_ws.GetCompetenceByIdRequest;
import com.guinardsolutions.mp.gs_ws.GetCompetenceByIdResponse;
import com.guinardsolutions.mp.gs_ws.ServiceStatus;
import com.guinardsolutions.mp.gs_ws.UpdateCompetenceRequest;
import com.guinardsolutions.mp.gs_ws.UpdateCompetenceResponse;
import com.guinardsolutions.mp.service.CompetenceService;
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
public class CompetenceEndpoint {

    private static final String NAMESPACE_URI = "http://guinardsolutions.com/mp/gs_ws";

    private CompetenceService competenceService;

    public CompetenceEndpoint(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCompetencesRequest")
    @ResponsePayload
    public GetAllCompetencesResponse getAllCompetences(@RequestPayload GetAllCompetencesRequest request) {
        GetAllCompetencesResponse response = new GetAllCompetencesResponse();
        List<CompetenceInfo> competenceInfos = new ArrayList<>();
        List<Competence> competences = competenceService.getAllCompetences();

        for (Competence c : competences) {
            CompetenceInfo ci = new CompetenceInfo();
            BeanUtils.copyProperties(c, ci);
            competenceInfos.add(ci);
        }
        response.getCompetenceInfos().addAll(competenceInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCompetencesByDomaineRequest")
    @ResponsePayload
    public GetAllCompetencesByDomaineResponse getAllCompetencesByDomaine(@RequestPayload GetAllCompetencesByDomaineRequest request) {
        GetAllCompetencesByDomaineResponse response = new GetAllCompetencesByDomaineResponse();
        List<CompetenceInfo> competenceInfos = new ArrayList<>();
        List<Competence> competences = competenceService.getAllCompetencesByDomaine(request.getDomaineId());

        for (Competence c : competences) {
            CompetenceInfo ci = new CompetenceInfo();
            BeanUtils.copyProperties(c, ci);
            competenceInfos.add(ci);
        }
        response.getCompetenceInfos().addAll(competenceInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCompetencesByCycleRequest")
    @ResponsePayload
    public GetAllCompetencesByCycleResponse getAllCompetencesByCycle(@RequestPayload GetAllCompetencesByCycleRequest request) {
        GetAllCompetencesByCycleResponse response = new GetAllCompetencesByCycleResponse();
        List<CompetenceInfo> competenceInfos = new ArrayList<>();
        List<Competence> competences = competenceService.getAllCompetencesByCycle(request.getCycle());

        for (Competence c : competences) {
            CompetenceInfo ci = new CompetenceInfo();
            BeanUtils.copyProperties(c, ci);
            competenceInfos.add(ci);
        }
        response.getCompetenceInfos().addAll(competenceInfos);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompetenceByIdRequest")
    @ResponsePayload
    public GetCompetenceByIdResponse getOneCompetence(@RequestPayload GetCompetenceByIdRequest request) {
        GetCompetenceByIdResponse response = new GetCompetenceByIdResponse();
        CompetenceInfo competenceInfo = new CompetenceInfo();
        Competence competence = competenceService.getOneCompetence(request.getCompetenceId());

        BeanUtils.copyProperties(competence, competenceInfo);

        response.setCompetenceInfo(competenceInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCompetenceRequest")
    @ResponsePayload
    public AddCompetenceResponse addCompetences(@RequestPayload AddCompetenceRequest request) {
        AddCompetenceResponse response = new AddCompetenceResponse();
        CompetenceInfo competenceInfo = new CompetenceInfo();
        competenceInfo.setRef(request.getRef());
        competenceInfo.setDescription(request.getDescription());
        competenceInfo.setCycle(request.getCycle());
        competenceInfo.setAbstractDomaine(request.getAbstractDomaine());

        Competence competence = new Competence();
        BeanUtils.copyProperties(competenceInfo, competence);

        competence = competenceService.saveCompetence(competence);
        BeanUtils.copyProperties(competence, competenceInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Competence saved successfully");

        response.setServiceStatus(ss);
        response.setCompetenceInfo(competenceInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCompetenceRequest")
    @ResponsePayload
    public UpdateCompetenceResponse updateCompetences(@RequestPayload UpdateCompetenceRequest request) {
        UpdateCompetenceResponse response = new UpdateCompetenceResponse();
        CompetenceInfo competenceInfo = request.getCompetenceInfo();

        Competence competence = new Competence();
        BeanUtils.copyProperties(competenceInfo, competence);

        competence = competenceService.updateCompetence(competence);
        BeanUtils.copyProperties(competence, competenceInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Competence updated successfully");

        response.setServiceStatus(ss);
        response.setCompetenceInfo(competenceInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCompetenceRequest")
    @ResponsePayload
    public DeleteCompetenceResponse deleteCompetences(@RequestPayload DeleteCompetenceRequest request) {
        DeleteCompetenceResponse response = new DeleteCompetenceResponse();

        competenceService.deleteCompetence(request.getCompetenceId());

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Competence deleted successfully");

        response.setServiceStatus(ss);
        return response;
    }

}
