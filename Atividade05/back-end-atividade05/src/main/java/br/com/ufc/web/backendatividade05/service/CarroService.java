package br.com.ufc.web.backendatividade05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.backendatividade05.model.Carro;
import br.com.ufc.web.backendatividade05.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
    CarroRepository carroRepository;
    
    public Carro addCarro(Carro newCarro) {
        return carroRepository.save(newCarro);
    }
    
    public boolean removeCarro(Integer id) {
        if(carroRepository.existsById(id)) {
        	carroRepository.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Carro> getCarros() {
        return carroRepository.findAll();
    }
    
    public Carro getCarro(Integer id) {
        return carroRepository.findById(id).get();
    }
    
    public List<Carro> getCarroByQuantity(Integer quantity) {
        return carroRepository.findByQuantity(quantity);
    }
    
    public List<Carro> getCarroByMarca(String marca) {
        return carroRepository.findByMarca(marca);
    }
    
    public Carro updateUser(Integer id,String nome, String marca, String anoFabricacao, String anoModelo, String dataVenda) {
    	Carro carroAux = carroRepository.findById(id).get();
        
        if(carroAux != null) {
        	carroAux.setNome(nome);
        	carroAux.setMarca(marca);
        	carroAux.setAnoFabricacao(anoFabricacao);
        	carroAux.setAnoModelo(anoModelo);
        	carroAux.setDataVenda(dataVenda);
            carroRepository.save(carroAux);         
        }
        
        return carroAux;
    }
}
