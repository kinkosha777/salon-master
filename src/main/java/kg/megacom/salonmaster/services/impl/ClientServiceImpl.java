package kg.megacom.salonmaster.services.impl;

import kg.megacom.salonmaster.controllers.Mappers.ClientMapper;
import kg.megacom.salonmaster.dao.ClientRepository;
import kg.megacom.salonmaster.exceptions.ClientNotFound;
import kg.megacom.salonmaster.models.Client;
import kg.megacom.salonmaster.models.dto.ClientDto;
import kg.megacom.salonmaster.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        client.setPin((long) ((Math.random() * (9999 - 1000)) + 1000));
        client = clientRepository.save(client);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto findByClientId(Long id) {
        return ClientMapper.INSTANCE.toClientDto(clientRepository.findById(id).orElseThrow(()-> new ClientNotFound("Клиент не найден!")));
    }
}
