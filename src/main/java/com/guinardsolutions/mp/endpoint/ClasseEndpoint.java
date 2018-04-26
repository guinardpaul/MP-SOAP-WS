/**
 *
 */
package com.guinardsolutions.mp.endpoint;

import com.guinardsolutions.mp.entities.Classe;
import com.guinardsolutions.mp.gs_ws.AddClasseRequest;
import com.guinardsolutions.mp.gs_ws.AddClasseResponse;
import com.guinardsolutions.mp.gs_ws.ClasseInfo;
import com.guinardsolutions.mp.gs_ws.DeleteClasseRequest;
import com.guinardsolutions.mp.gs_ws.DeleteClasseResponse;
import com.guinardsolutions.mp.gs_ws.GetAllClassesRequest;
import com.guinardsolutions.mp.gs_ws.GetAllClassesResponse;
import com.guinardsolutions.mp.gs_ws.GetClasseByIdRequest;
import com.guinardsolutions.mp.gs_ws.GetClasseByIdResponse;
import com.guinardsolutions.mp.gs_ws.ServiceStatus;
import com.guinardsolutions.mp.gs_ws.UpdateClasseRequest;
import com.guinardsolutions.mp.gs_ws.UpdateClasseResponse;
import com.guinardsolutions.mp.service.ClasseService;
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
public class ClasseEndpoint {

    private static final String NAMESPACE_URI = "http://guinardsolutions.com/mp/gs_ws";

    private ClasseService classeService;

    /**
     * Instantiate ClasseEndpoint
     *
     * @param classeService
     */
    @Autowired
    public ClasseEndpoint(ClasseService classeService) {
        this.classeService = classeService;
    }

    /**
     * GetAllClasses
     *
     * @param request
     * @return GetAllClassesResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClassesRequest")
    @ResponsePayload
    public GetAllClassesResponse getClasses(@RequestPayload GetAllClassesRequest request) {
        GetAllClassesResponse response = new GetAllClassesResponse();
        List<Classe> classes = classeService.getAllClasses();
        List<ClasseInfo> classesInfo = new ArrayList<>();

        for (Classe c : classes) {
            ClasseInfo ci = new ClasseInfo();
            BeanUtils.copyProperties(c, ci);
            classesInfo.add(ci);
        }
        response.getClasseInfos().addAll(classesInfo);
        return response;
    }

    /**
     * GetClasseById
     *
     * @param request
     * @return GetClasseByIdResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClasseByIdRequest")
    @ResponsePayload
    public GetClasseByIdResponse getOneClasse(@RequestPayload GetClasseByIdRequest request) {
        GetClasseByIdResponse response = new GetClasseByIdResponse();
        Classe classe = new Classe();
        classe = classeService.getOneClasse(request.getClasseId());
        ClasseInfo classeInfo = new ClasseInfo();
        BeanUtils.copyProperties(classe, classeInfo);

        response.setClasseInfo(classeInfo);
        return response;
    }

    /**
     * AddClasse
     *
     * @param request
     * @return AddClasseResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addClasseRequest")
    @ResponsePayload
    public AddClasseResponse saveClasse(@RequestPayload AddClasseRequest request) {
        AddClasseResponse response = new AddClasseResponse();
        // Set value of classeInfo from AddClasseRequest
        ClasseInfo classeInfo = new ClasseInfo();
        classeInfo.setName(request.getName());
        classeInfo.setCycle(request.getCycle());
        // Copy properties to Classe Object
        Classe classe = new Classe();
        BeanUtils.copyProperties(classeInfo, classe);
        // Get value of Classe Object from service and copy it to classeInfo
        classe = classeService.saveClasse(classe);
        BeanUtils.copyProperties(classe, classeInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Classe saved successfully");
        response.setServiceStatus(ss);
        response.setClasseInfo(classeInfo);
        return response;
    }

    /**
     * UpdateClasse
     *
     * @param request
     * @return UpdateClasseResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateClasseRequest")
    @ResponsePayload
    public UpdateClasseResponse updateClasse(@RequestPayload UpdateClasseRequest request) {
        UpdateClasseResponse response = new UpdateClasseResponse();
        // Set value of classeInfo from UpdateClasseRequest
        ClasseInfo classeInfo = new ClasseInfo();
        classeInfo.setId(request.getClasseInfo().getId());
        classeInfo.setName(request.getClasseInfo().getName());
        classeInfo.setCycle(request.getClasseInfo().getCycle());
        // Copy properties to Classe Object
        Classe classe = new Classe();
        BeanUtils.copyProperties(classeInfo, classe);
        // Get value of Classe Object from service and copy it to classeInfo
        classe = classeService.updateClasse(classe);
        BeanUtils.copyProperties(classe, classeInfo);

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Classe updated successfully");
        response.setServiceStatus(ss);
        response.setClasseInfo(classeInfo);
        return response;
    }

    /**
     * DeleteClasse
     *
     * @param request
     * @return DeleteClasseResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClasseRequest")
    @ResponsePayload
    public DeleteClasseResponse deleteClasse(@RequestPayload DeleteClasseRequest request) {
        DeleteClasseResponse response = new DeleteClasseResponse();
        classeService.deleteClasse(request.getClasseId());

        ServiceStatus ss = new ServiceStatus();
        ss.setStatusCode(Integer.toString(HttpStatus.OK.value()));
        ss.setMessage("Classe deleted successfully");
        response.setServiceStatus(ss);
        return response;
    }

}
