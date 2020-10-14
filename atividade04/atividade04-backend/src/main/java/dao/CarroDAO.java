package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Carro;

public class CarroDAO {
	private static final Map<Integer, Carro> userMap = new HashMap<Integer, Carro>();
    private static int i = 4;
 
    static {
        initCarros();
    }
 
    private static void initCarros() {
        Carro carro1 = new Carro(1, "Toyota", "Corola", "2020", "10/10/2020", "2005");
        Carro carro2 = new Carro(2, "UNO", "Fiat", "2020", "10/10/2020", "2008");
        Carro carro3 = new Carro(3, "Cromado", "Corola", "2020", "10/10/2020", "1999");

        userMap.put(carro1.getId(), carro1);
        userMap.put(carro2.getId(), carro2);
        userMap.put(carro3.getId(), carro3);
        
    }
 
    public static Carro getCarro(int id) {
        return userMap.get(id);
    }
 
    public static List<Carro> getCarroByMarca(String marca) {
        List<Carro> list = getAllCarros();
        List<Carro> carros = new ArrayList<>();
        
        for (Carro carro : list) {
            if (carro.getMarca().equals(marca)) {
                carros.add(carro);
            }
        }
        
        return carros;
    }
    
    public static List<Carro> getCarroByQuantidade(int quantidade) {
        List<Carro> list = getAllCarros();
        List<Carro> carros = new ArrayList<>();
        int i = 0;
        
        for (Carro carro : list) {
            if (i < quantidade) {
                carros.add(carro);
                i++;
            }else {
            	return carros;
            }
        }
 
        return carros;
    }
 
    public static Carro addCarro(String nome, String marca, String anoModelo, String anoFabricacao, String dataVenda) {
        Carro carro = new Carro(i, nome, marca, anoModelo, dataVenda, anoFabricacao);
        userMap.put(carro.getId(), carro);
        i++;
        return carro;
    }
 
    public static Carro updateCarro(int id, String nome, String marca, String anoModelo, String anoFabricacao, String dataVenda) {
        Carro carro = new Carro(id,nome, marca, anoModelo , dataVenda, anoFabricacao);
        userMap.put(carro.getId(), carro);
        return carro;
    }
 
    public static void deleteCarro(int id) {
        if (userMap.containsKey(id)) {
            userMap.remove(id);
        }
    }
 
    public static List<Carro> getAllCarros() {
        return new ArrayList<Carro>(userMap.values());
    }
}
