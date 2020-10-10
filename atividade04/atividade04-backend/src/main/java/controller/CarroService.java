package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.CarroDAO;
import model.Carro;

@WebServlet("/api/carros/*")
public class CarroService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarroService() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				Carro Carro = CarroDAO.getCarro(Integer.parseInt(params[1]));

				if (Carro != null) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("id", Carro.getId());
					jsonObject.put("nome", Carro.getNome());
					jsonObject.put("marca", Carro.getMarca());
					jsonObject.put("anoModelo", Carro.getAnoModelo());
					jsonObject.put("dataVenda", Carro.getDataVenda());

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(jsonObject.toString());
					response.getWriter().flush();
				}
				return;
			}
		}

//		// GET BY NAME
//		if (request.getParameter("login") != null) {
//			Carro Carro = CarroDAO.getCarroBylogin(request.getParameter("login"));
//
//			if (Carro != null) {
//
//				JSONObject jsonObject = new JSONObject();
//
//				jsonObject.put("id", Carro.getId());
//				jsonObject.put("login", Carro.getLogin());
//				jsonObject.put("password", Carro.getPassword());
//
//				response.setContentType("application/json");
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().print(jsonObject.toString());
//				response.getWriter().flush();
//
//			}
//			return;
//		}

		// GET ALL
		List<Carro> list = CarroDAO.getAllCarros();

		try {
			JSONArray jArray = new JSONArray();

			for (Carro Carro : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", Carro.getId());
				jsonObject.put("nome", Carro.getNome());
				jsonObject.put("marca", Carro.getMarca());
				jsonObject.put("anoModelo", Carro.getAnoModelo());
				jsonObject.put("dataVenda", Carro.getDataVenda());

				jArray.put(jsonObject);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		Carro Carro = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			Carro = CarroDAO.addCarro(jsonObject.getString("nome"), jsonObject.getString("marca"),jsonObject.getString("anoModelo"), jsonObject.getString("dataVenda"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", Carro.getId());
			jsonObject.put("nome", Carro.getNome());
			jsonObject.put("marca", Carro.getMarca());
			jsonObject.put("anoModelo", Carro.getAnoModelo());
			jsonObject.put("dataVenda", Carro.getDataVenda());
			
		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// UPDATE BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				StringBuffer jb = new StringBuffer();
				String line = null;
				try {
					BufferedReader reader = request.getReader();
					while ((line = reader.readLine()) != null)
						jb.append(line);
				} catch (Exception e) {
				}

				Carro Carro = null;
				JSONObject jsonObject = null;

				try {
					// Request
					jsonObject = new JSONObject(jb.toString());
					Carro = CarroDAO.updateCarro(Integer.parseInt(params[1]), jsonObject.getString("nome"),
							jsonObject.getString("marca"), jsonObject.getString("anoModelo"), jsonObject.getString("dataVenda"));

					// Response
					jsonObject.put("id", Carro.getId());
					jsonObject.put("nome", Carro.getNome());
					jsonObject.put("marca", Carro.getMarca());
					jsonObject.put("anoModelo", Carro.getAnoModelo());
					jsonObject.put("dataVenda", Carro.getDataVenda());

				} catch (JSONException e) {
				}

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(jsonObject.toString());
				response.getWriter().flush();
			}
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DELETE BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				CarroDAO.deleteCarro(Integer.parseInt(params[1]));

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().flush();
			}
		}
	}
}
