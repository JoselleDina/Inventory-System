package ac.za.cput.controller.equipment;

import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.factory.equipment.FurnitureTypeFactory;
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
import org.springframework.web.bind.annotation.*;

//JodiSmit
import java.util.Set;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FurnitureTypeControllerTest {

    private static FurnitureType furnitureType = FurnitureTypeFactory.createFurnitureType("CupBoard", 5, "black");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/furnitureType/";



    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<FurnitureType> postResponse = restTemplate.postForEntity(url, furnitureType, FurnitureType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        furnitureType = postResponse.getBody();
        assertEquals(furnitureType.getFurnitureTypeId(), postResponse.getBody().getFurnitureTypeId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + furnitureType.getFurnitureTypeId();
        System.out.println(url);
        ResponseEntity<FurnitureType> responseEntity = restTemplate.getForEntity(url, FurnitureType.class);
        assertEquals(furnitureType.getFurnitureTypeId(), responseEntity.getBody().getFurnitureTypeId());
        System.out.println(responseEntity.getBody());
    }


    @Test
    public void c_update(){
        FurnitureType updated = new FurnitureType.Builder().copy(furnitureType).setFurnitureDescription("Desk").setSize(4).setColor("blue").build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<FurnitureType> postResponse = restTemplate.postForEntity(url, updated, FurnitureType.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
        Assert.assertEquals(furnitureType.getFurnitureTypeId(), postResponse.getBody().getFurnitureTypeId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());

    }

    @Test
    public void d_getAll() {

        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/"+ furnitureType.getFurnitureTypeId();
        System.out.println(url);
        ResponseEntity<FurnitureType> responseEntity = restTemplate.getForEntity(url, FurnitureType.class);
        assertNull(furnitureType.getFurnitureTypeId(), responseEntity.getBody().getFurnitureTypeId());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        restTemplate.delete(url);


    }


}