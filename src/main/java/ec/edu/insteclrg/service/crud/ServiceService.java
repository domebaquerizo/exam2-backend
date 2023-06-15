package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import ec.edu.insteclrg.domain.Service;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.persistence.ServiceRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@org.springframework.stereotype.Service
public class ServiceService extends GenericCrudServiceImpl<Service, ServicioDTO>{
	
	@Autowired
	private ServiceRepository repository;

	//Acortador de codigo 
	//sin el map toca instanciar la clase Service y enviar datos dentro de todos sus atributos
	private ModelMapper modelMapper = new ModelMapper();

	
	@Override
	public Optional<Service> find(ServicioDTO dto) {
		return repository.findById(dto.getId()); 
	}

	@Override
	public ServicioDTO mapToDto(Service domain) {
		return modelMapper.map(domain, ServicioDTO.class);
	}

	@Override
	public Service mapToDomain(ServicioDTO dto) {
		return modelMapper.map(dto, Service.class);
	}	
}
