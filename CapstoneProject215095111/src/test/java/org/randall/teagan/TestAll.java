package org.randall.teagan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.randall.teagan.Controllers.CustomerController.CustomerControllerTest;
import org.randall.teagan.Controllers.EmployeeController.*;
import org.randall.teagan.Controllers.MembershipController.FullMemberControllerTest;
import org.randall.teagan.Controllers.MembershipController.InternationalMemberControllerTest;
import org.randall.teagan.Controllers.MembershipController.MemControllerTest;
import org.randall.teagan.Controllers.MembershipController.StudentMemControllerTest;
import org.randall.teagan.Controllers.TripController.PassengerControllerTest;
import org.randall.teagan.Controllers.TripController.RouteControllerTest;
import org.randall.teagan.Controllers.TripController.TripControllerTest;
import org.randall.teagan.Controllers.VehicleController.CityLinerControllerTest;
import org.randall.teagan.Controllers.VehicleController.MidibusControllerTest;
import org.randall.teagan.Controllers.VehicleController.MinibusControllerTest;
import org.randall.teagan.Controllers.VehicleController.VehicleControllerTest;
import org.randall.teagan.Domain.CustomerTest;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilderTest;
import org.randall.teagan.Factory.EmployeeBuilders.*;
import org.randall.teagan.Factory.MembershipBuilders.*;
import org.randall.teagan.Factory.TripBuilders.PassengerBuilderTest;
import org.randall.teagan.Factory.TripBuilders.RouteBuilderTest;
import org.randall.teagan.Factory.TripBuilders.TripBuilderTest;
import org.randall.teagan.Factory.VehicleBuilders.*;
import org.randall.teagan.Repositories.Implementation.CustomerRepositoryImplTest.CustomerRepositoryImplTest;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest.*;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImplTest.*;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImplTest.PassengerRepositoryImplTest;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImplTest.RouteRepositoryImplTest;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImplTest.TripRepositoryImplTest;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpTest.*;
import org.randall.teagan.Services.ServiceImplementation.CustomerServicesImpl.CustomerServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.*;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.FullTimeMemberServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.InternationalMemberServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.MemberServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.StudentMemberServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.TripServiceImpl.PassengerServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.TripServiceImpl.RouteServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.TripServiceImpl.TripServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.CitylinerServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.MidibusServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.MiniBusServiceImplTest;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.VehicleServiceImplTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        CustomerTest.class,
        CustBuilderTest.class,
        DriverBuilderTest.class,
        EmpAddressBuilderTest.class,
        EmpBuilderTest.class,
        EmpContactBuilderTest.class,
        EmpPayslipBuilderTest.class,
        EmpPosBuilderTest.class,
        IssueStaffBuilderTest.class,
        ManagerBuilderTest.class,
        MechanicBuilderTest.class,
        TaskBuilderTest.class,
        FullTimeMemberBuilderTest.class,
        InternationalMemBuilderTest.class,
        MembershipBuilderTest.class,
        MemTypeBuilderTest.class,
        StudentMemberBuilderTest.class,
        PassengerBuilderTest.class,
        RouteBuilderTest.class,
        TripBuilderTest.class,
        BusTypeBuilderTest.class,
        CitylinerBuilderTest.class,
        MidibusBuilderTest.class,
        MinibusBuilderTest.class,
        VehicleBuilderTest.class,
        CustomerRepositoryImplTest.class,
        DriverRepositoryImplTest.class,
        EmpAddressRepositoryImplTest.class,
        EmpContactRepositoryImplTest.class,
        EmployeeRepositoryImplTest.class,
        EmpPayslipRepositoryImplTest.class,
        EmpPositionRepositoryImplTest.class,
        IssueStaffRepositoryImplTest.class,
        ManagerRepositoryImplTest.class,
        MechanicRepositoryImplTest.class,
        TaskRepositoryImplTest.class,
        FullMemRepositoryImplTest.class,
        InternationalMemRepositoryImplTest.class,
        MembershipRepositoryImplTest.class,
        MemberTypeRepositoryImplTest.class,
        StudentMembershipRepositoryImplTest.class,
        PassengerRepositoryImplTest.class,
        RouteRepositoryImplTest.class,
        TripRepositoryImplTest.class,
        CityLinerRepositoryImplTest.class,
        MidibusRepositoryImplTest.class,
        MinibusRepositoryImplTest.class,
        VehicleRepositoryImplTest.class,
        VehicleTypeRepositoryImplTest.class,
        CustomerServiceImplTest.class,
        DriverServiceImplTest.class,
        EmpPayslipServiceImplTest.class,
        EmpServiceImplTest.class,
        IssueStaffServiceImplTest.class,
        ManagerServiceImplTest.class,
        MechanicServiceImplTest.class,
        TaskServiceImplTest.class,
        FullTimeMemberServiceImplTest.class,
        InternationalMemberServiceImplTest.class,
        MemberServiceImplTest.class,
        StudentMemberServiceImplTest.class,
        PassengerServiceImplTest.class,
        RouteServiceImplTest.class,
        TripServiceImplTest.class,
        CitylinerServiceImplTest.class,
        MidibusServiceImplTest.class,
        MiniBusServiceImplTest.class,
        VehicleServiceImplTest.class,
        CustomerControllerTest.class,
//        DriverControllerTest.class,
//        EmployeeControllerTest.class,
//        EmpPayslipControllerTest.class,
//        IssueStaffControllerTest.class,
//        ManagerControllerTest.class,
//        MechanicControllerTest.class,
//        TaskControllerTest.class,
//        FullMemberControllerTest.class,
//        InternationalMemberControllerTest.class,
//        MemControllerTest.class,
//        StudentMemControllerTest.class,
//        PassengerControllerTest.class,
//        RouteControllerTest.class,
//        TripControllerTest.class,
//        CityLinerControllerTest.class,
//        MidibusControllerTest.class,
//        MinibusControllerTest.class,
//        VehicleControllerTest.class,
})
public class TestAll {
}
