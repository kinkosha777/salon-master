package kg.megacom.salonmaster.controllers;

import kg.megacom.salonmaster.models.dto.ClientDto;
import kg.megacom.salonmaster.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/save-client")
    public ClientDto save(@RequestBody ClientDto clientDto){
        return clientService.save(clientDto);
    }
}
