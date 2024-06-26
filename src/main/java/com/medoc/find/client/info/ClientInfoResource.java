package com.medoc.find.client.info;

import com.medoc.find.client.dao.entity.ClientEntity;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientInfoResource {

    private final ClientInfoService clientInfoService;

    public ClientInfoResource(final ClientInfoService clientInfoService) {
        this.clientInfoService = clientInfoService;
    }

  /*  @RequestMapping("/fetch")
    @GetMapping
    public ClientInfoDTO getclient() {
        System.out.println(clientInfoService);
        return clientInfoService.getClient(null);
    }
*/

    @RequestMapping("")
    @GetMapping
    public String welcome() {
        return "welcome in client medoc";
    }

    @RequestMapping("/find/with")
    @GetMapping
    public List<ClientEntity> getclientByCretiria(final ClientInfoCriteriaRequest clientInfoCriteriaRequest) {
        return clientInfoService.getfromQuery(clientInfoCriteriaRequest);
    }


    @RequestMapping("/newClient")
    @PostMapping
    public ResponseEntity<ClientEntity> save
            (@RequestBody ClientInfoDTO client) {
        ClientEntity clientEntity = clientInfoService.save(client);
        return ResponseEntity.ok(clientEntity);
    }


    @RequestMapping("/delete")
    @DeleteMapping
    public Boolean deleteAll() {
        clientInfoService.deleteAll();
        return true;
    }

    @RequestMapping("/deleteByID")
    @DeleteMapping
    public boolean deleteByID(@RequestParam(name = "id") Long id) {
        clientInfoService.deleteClient(id);
        return true;
    }

    @RequestMapping("/delete/{id}")
    @DeleteMapping
    public int deleteByIDWithPathParam(@PathVariable(name = "id") Long id) {
        return clientInfoService.deleteClient(id);
    }

    @RequestMapping("/getClientByID")
    @GetMapping

    public ResponseEntity<ClientInfoDTO> getByID(@RequestParam(name = "id") Long id) {
        System.out.println(id);
        ClientInfoDTO dto= clientInfoService.getByID(id);
        return ResponseEntity.ok(dto);
    }

    @RequestMapping("/getAll")
    @GetMapping
    public List<ClientInfoDTO> getAll(){
         return  clientInfoService.getAll();
    }

    @RequestMapping("/update")
    @PutMapping
    public boolean updateclient(@RequestParam(name= "id") Long id,@RequestBody ClientInfoDTO client ){
        clientInfoService.update(id,client);
        return true;
    }
}
