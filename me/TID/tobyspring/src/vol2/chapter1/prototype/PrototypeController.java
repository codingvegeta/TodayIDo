//package vol2.chapter1.prototype;
//
//import org.springframework.beans.factory.ObjectFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.stereotype.Controller;
//
//import javax.inject.Provider;
//
//
//@Controller
//public class PrototypeController
//{
//    @Autowired
//    ObjectFactory<ServiceRequest> objectFactory;
//    @Autowired
//    ServiceRequestFactory serviceRequestFactory;
//    @Autowired
//    Provider<ServiceRequest> serviceRequestProvider;
//
//    public void serviceRequestFormSubmit(MockHttpServletRequest request)
//    {
//        ServiceRequest serviceRequest = objectFactory.getObject();
//        //
//    }
//
//    public void serviceRequestFormSubmit2(MockHttpServletRequest request)
//    {
//        ServiceRequest serviceFactory = serviceRequestFactory.getServiceFactory();
//        //
//    }
//}
