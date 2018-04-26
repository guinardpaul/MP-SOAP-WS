/**
 *
 */
package com.guinardsolutions.mp.endpoint;

import com.guinardsolutions.mp.entities.Eleve;
import com.guinardsolutions.mp.gs_ws.AddEleveRequest;
import com.guinardsolutions.mp.gs_ws.AddEleveResponse;
import com.guinardsolutions.mp.gs_ws.DeleteEleveRequest;
import com.guinardsolutions.mp.gs_ws.DeleteEleveResponse;
import com.guinardsolutions.mp.gs_ws.EleveInfo;
import com.guinardsolutions.mp.gs_ws.GetAllElevesByClasseRequest;
import com.guinardsolutions.mp.gs_ws.GetAllElevesByClasseResponse;
import com.guinardsolutions.mp.gs_ws.GetAllElevesRequest;
import com.guinardsolutions.mp.gs_ws.GetAllElevesResponse;
import com.guinardsolutions.mp.gs_ws.GetEleveByIdRequest;
import com.guinardsolutions.mp.gs_ws.GetEleveByIdResponse;
import com.guinardsolutions.mp.gs_ws.ServiceStatus;
import com.guinardsolutions.mp.gs_ws.UpdateEleveRequest;
import com.guinardsolutions.mp.gs_ws.UpdateEleveResponse;
import com.guinardsolutions.mp.service.EleveService;
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
 * @author Paul
 *
 */
@Endpoint
public class EleveEndpoint {

    private static final String NAMESPACE_URI = "http://guinardsolutions.com/mp/gs_ws";

    private EleveService eleveService;

    /**
     *
     * @param eleveService
     */
    @Autowired
    public EleveEndpoint(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllElevesRequest")
    @ResponsePayload
    public GetAllElevesResponse getAllEleves(@RequestPayload GetAllElevesRequest request) {
        GetAllElevesResponse response = new GetAllElevesResponse();
        List<EleveInfo> elevesInfo = new ArrayList<>();
        List<Eleve> eleves = eleveService.getAllEleves();

        for (Eleve e : eleves) {
            EleveInfo ei = new EleveInfo();
            BeanUtils.copyProperties(e, ei);
            elevesInfo.add(ei);
        }
        response.getEleveInfos().addAll(elevesInfo);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEleveByIdRequest")
    @ResponsePayload
    public GetEleveByIdResponse getOneEleve(@RequestPayload GetEleveByIdRequest request) {
        GetEleveByIdResponse response = new GetEleveByIdResponse();
        EleveInfo eleveInfo = new EleveInfo();
        Eleve eleve = eleveService.getOneEleve(request.getEleveId());
        BeanUtils.copyProperties(eleve, eleveInfo);

        response.setEleveInfo(eleveInfo);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllElevesByClasseRequest")
    @ResponsePayload
    public GetAllElevesByClasseResponse getAllElevesByClasse(@RequestPayload GetAllElevesByClasseRequest request) {
        GetAllElevesByClasseResponse response = new GetAllElevesByClasseResponse();
        List<EleveInfo> elevesInfo = new ArrayList<>();
        List<Eleve> eleves = eleveService.getAllEleveByClasse(request.getClasseId());

        for (Eleve e : eleves) {
            EleveInfo ei = new EleveInfo();
            BeanUtils.copyProperties(e, ei);
            elevesInfo.add(ei);
        }
        response.getEleveInfos().addAll(elevesInfo);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEleveRequest")
    @ResponsePayload
    public AddEleveResponse saveEleve(@RequestPayload AddEleveRequest request) {
        AddEleveResponse response = new AddEleveResponse();
        EleveInfo eleveInfo = new EleveInfo();
        eleveInfo.setFirstname(request.getFirstname());
        eleveInfo.setLastname(request.getLastname());
        eleveInfo.getClasse().addAll(request.getClasse());
        eleveInfo.getResultat().addAll(request.getResultat());

        Eleve eleve = new Eleve();
        BeanUtils.copyProperties(eleveInfo, eleve);
        eleve = eleveService.saveEleve(eleve);
        BeanUtils.copyProperties(eleve, eleveInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Eleve saved successfully");
        response.setServiceStatus(ss);
        response.setEleveInfo(eleveInfo);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEleveRequest")
    @ResponsePayload
    public UpdateEleveResponse updateEleve(@RequestPayload UpdateEleveRequest request) {
        UpdateEleveResponse response = new UpdateEleveResponse();
        EleveInfo eleveInfo = new EleveInfo();
        eleveInfo.setFirstname(request.getEleveInfo().getFirstname());
        eleveInfo.setLastname(request.getEleveInfo().getLastname());
        eleveInfo.getClasse().addAll(request.getEleveInfo().getClasse());
        eleveInfo.getResultat().addAll(request.getEleveInfo().getResultat());

        Eleve eleve = new Eleve();
        BeanUtils.copyProperties(eleveInfo, eleve);
        eleve = eleveService.updateEleve(eleve);
        BeanUtils.copyProperties(eleve, eleveInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Eleve updated successfully");
        response.setServiceStatus(ss);
        response.setEleveInfo(eleveInfo);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEleveRequest")
    @ResponsePayload
    public DeleteEleveResponse deleteEleve(@RequestPayload DeleteEleveRequest request) {
        DeleteEleveResponse response = new DeleteEleveResponse();
        eleveService.deleteEleve(request.getEleveId());

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Eleve deleted successfully");
        response.setServiceStatus(ss);

        return response;
    }

}
