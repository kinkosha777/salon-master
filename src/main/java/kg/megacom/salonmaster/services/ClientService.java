package kg.megacom.salonmaster.services;

import kg.megacom.salonmaster.models.dto.ClientDto;

public interface ClientService {

    ClientDto save (ClientDto clientDto);
    ClientDto findByClientId(Long id);
}
