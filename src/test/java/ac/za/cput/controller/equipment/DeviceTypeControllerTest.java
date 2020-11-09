package ac.za.cput.controller.equipment;
//JodiSmit
import static org.junit.Assert.*;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeviceTypeControllerTest {

    private static DeviceType deviceType = DeviceTypeFactory.createDeviceType("Printer", 5, "black");
    private static String SECURITY_USERNAME="admin";
    private static String SECURITY_PASSWORD="1234";


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/inventory/deviceType/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<DeviceType> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, deviceType, DeviceType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        deviceType = postResponse.getBody();
        assertEquals(deviceType.getDeviceTypeId(), postResponse.getBody().getDeviceTypeId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + deviceType.getDeviceTypeId();
        System.out.println(url);
        ResponseEntity<DeviceType> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, DeviceType.class);
        System.out.println(responseEntity.getBody());
    }


    @Test
    public void c_update() {
        DeviceType updated = new DeviceType.Builder().copy(deviceType).setDeviceDescription("Tablet").setColor("Brown").setSize(2).build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<DeviceType> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, updated, DeviceType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(deviceType.getDeviceTypeId(), postResponse.getBody().getDeviceTypeId());
        System.out.println(postResponse.getBody());


    }

    @Test
    public void d_getAll() {

        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());
    }


    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + deviceType.getDeviceTypeId();
        System.out.println(url);
        ResponseEntity<DeviceType> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, DeviceType.class);
        assertNull(deviceType.getDeviceTypeId(), responseEntity.getBody().getDeviceTypeId());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        restTemplate.delete(url);


    }

}
