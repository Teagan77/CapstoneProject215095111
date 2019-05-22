package org.randall.teagan.Controllers.TripController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Factory.TripBuilders.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RouteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/route";

    @Test
    public void a_create() {

        String startLoc = "CapeTown";
        String endLoc = "Belville";
        String routeName = "BZ304";
        String routeID = "215095111";

        Route route = RouteBuilder.getRoute(startLoc,endLoc,routeName, routeID);
        ResponseEntity<Route> postResponse = restTemplate.postForEntity(baseURL + "/create", route, Route.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Route route = restTemplate.getForObject(baseURL + "/route/" + id, Route.class);

        restTemplate.put(baseURL + "/routes/" + id, route);
        Route updatedRoute = restTemplate.getForObject(baseURL + "/update/" + id, Route.class);
        assertNotNull(updatedRoute);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Route route = restTemplate.getForObject(baseURL + "/routes/" + id, Route.class);
        assertNotNull(route);
        restTemplate.delete(baseURL + "/routes/" + id);
        try {
            route = restTemplate.getForObject(baseURL + "/delete/" + id, Route.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Route readRoute = restTemplate.getForObject(baseURL + "/read/215095111", Route.class);
        System.out.println(readRoute.toString());
        assertNotNull(readRoute);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}