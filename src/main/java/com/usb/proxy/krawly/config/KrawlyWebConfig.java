package com.usb.proxy.krawly.config;

import com.sun.deploy.security.CertificateHostnameVerifier;
import com.usb.proxy.krawly.util.SSLUtil;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.Endpoint;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml" })
public class KrawlyWebConfig {

    public static final String SERVICE_SOAP_ULR = "/soap";

    @Bean
    public LoggingInInterceptor logInbound() {
        return new LoggingInInterceptor();
    }
    @Bean
    public LoggingOutInterceptor logOutbound() {
        return new LoggingOutInterceptor();
    }

    @Bean(destroyMethod = "shutdown")
    @DependsOn({"logInbound", "logOutbound"})
    public SpringBus cxf(LoggingInInterceptor inLog, LoggingOutInterceptor outLog) {
        SpringBus bus = new SpringBus();
        bus.getInInterceptors().add(inLog);
        bus.getInFaultInterceptors().add(inLog);
        bus.getOutInterceptors().add(outLog);
        bus.getOutFaultInterceptors().add(outLog);
        bus.getFeatures().add(new LoggingFeature());

        return bus;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
    }

    ///services
    @Bean
    public Endpoint soapGenericController(SpringBus cxfBus, ApplicationContext appContext) {
        return createSoapService(cxfBus, appContext.getBean("generic"), /*SERVICE_SOAP_ULR +*/ "/generic");
    }

    @Bean
    public Endpoint soapAuthController(SpringBus cxfBus, ApplicationContext appContext) {
        return createSoapService(cxfBus, appContext.getBean("auth"), "/auth");
    }



    public Endpoint createSoapService(Bus cxfBus, Object service, String url) {
        EndpointImpl endpoint = new EndpointImpl(cxfBus, service);
        endpoint.setAddress(url);
        List<Feature> features = new ArrayList<>();
        features.add(new LoggingFeature());
        endpoint.setFeatures(features);
        endpoint.getInInterceptors().add(new LoggingInInterceptor());
        endpoint.getInFaultInterceptors().add(new LoggingInInterceptor());
        endpoint.getOutInterceptors().add(new LoggingOutInterceptor());
        endpoint.getOutFaultInterceptors().add(new LoggingOutInterceptor());

        endpoint.publish();

        if (endpoint.getService() != null) {
            endpoint.getService().getInInterceptors().add(new LoggingInInterceptor());
            endpoint.getService().getInFaultInterceptors().add(new LoggingInInterceptor());
            endpoint.getService().getOutInterceptors().add(new LoggingOutInterceptor());
            endpoint.getService().getOutFaultInterceptors().add(new LoggingOutInterceptor());
        }

        return endpoint;
    }

    @Bean
    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException {
        SSLUtil.turnOffSslChecking();
        RestTemplate rt = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

        return rt;
    }

}
