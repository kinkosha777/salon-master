package kg.megacom.salonmaster.controllers.Mappers;

import kg.megacom.salonmaster.models.Client;
import kg.megacom.salonmaster.models.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientDto clientDto);
    ClientDto toClientDto(Client client);

    List<Client> toClient(List<ClientDto> clientDtos);
    List<ClientDto> toClientDtos(List<Client> clients);
}
