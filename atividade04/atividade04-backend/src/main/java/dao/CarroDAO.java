package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Carro;

public class CarroDAO {
	private static final Map<Integer, Carro> userMap = new HashMap<Integer, Carro>();
    private static int i = 2;
 
    static {
        initCarros();
    }
 
    private static void initCarros() {
        Carro carro1 = new Carro(1, "Corola", "Toyota", "2020", "27/10/2020");
       

        userMap.put(carro1.getId(), carro1);
        
    }
 
    public static Carro getCarro(int id) {
        return userMap.get(id);
    }
 
//    public static Carro getCarrBylogin(String login) {
//        List<User> list = getAllUsers();
// 
//        for (User user : list) {
//            if (user.getLogin().equals(login)) {
//                return user;
//            }
//        }
// 
//        return null;
//    }
 
    public static Carro addCarro(String nome, String marca, String anoModelo, String dataVenda) {
        Carro carro = new Carro(i, nome, marca, anoModelo, dataVenda);
        userMap.put(carro.getId(), carro);
        i++;
        return carro;
    }
 
    public static Carro updateCarro(int id, String nome, String marca, String anoModelo, String dataVenda) {
        Carro carro = new Carro(id,nome, marca, anoModelo, dataVenda);
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
