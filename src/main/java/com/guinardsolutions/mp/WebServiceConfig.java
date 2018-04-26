package com.guinardsolutions.mp;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "mp-ws")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection collectionSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MpWsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://guinardsolutions.com/mp/gs_ws");
        wsdl11Definition.setSchemaCollection(collectionSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema classesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/classes.xsd"));
    }

    @Bean
    public XsdSchema elevesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/eleves.xsd"));
    }

    @Bean
    public XsdSchema abstractDomainesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/abstractDomaines.xsd"));
    }

    @Bean
    public XsdSchema domainesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/domaines.xsd"));
    }

    @Bean
    public XsdSchema competencesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/competences.xsd"));
    }

    @Bean
    public XsdSchema resultatsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/resultats.xsd"));
    }

    @Bean
    public XsdSchemaCollection getXsdCollection() {
        return new XsdSchemaCollection() {

            @Override
            public XsdSchema[] getXsdSchemas() {
                return new XsdSchema[]{
                    classesSchema(), elevesSchema(),
                    abstractDomainesSchema(), domainesSchema(),
                    competencesSchema(), resultatsSchema()
                };
            }

            @Override
            public XmlValidator createValidator() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
