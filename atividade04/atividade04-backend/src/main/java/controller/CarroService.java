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
				Carro carro = CarroDAO.getCarro(Integer.parseInt(params[1]));

				if (carro != null) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("id", carro.getId());
					jsonObject.put("nome", carro.getNome());
					jsonObject.put("marca", carro.getMarca());
					jsonObject.put("anoModelo", carro.getAnoModelo());
					jsonObject.put("anoFabricacao", carro.getAnoFabricao());
					jsonObject.put("dataVenda", carro.getDataVenda());

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(jsonObject.toString());
					response.getWriter().flush();
				}
				return;
			}
		}

		// GET BY MARCA
		if (request.getParameter("marca") != null) {

			List<Carro> carros = CarroDAO.getCarroByMarca(request.getParameter("marca"));
			try {
				JSONArray jArray = new JSONArray();

				for (Carro carro : carros) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("id", carro.getId());
					jsonObject.put("nome", carro.getNome());
					jsonObject.put("marca", carro.getMarca());
					jsonObject.put("anoModelo", carro.getAnoModelo());
					jsonObject.put("anoFabricacao", carro.getAnoFabricao());
					jsonObject.put("dataVenda", carro.getDataVenda());

					jArray.put(jsonObject);
				}

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(jArray.toString());
				response.getWriter().flush();
			} catch (Exception e) {

			}
			return;
		}

		// GET BY QUANTIDADE
		if (request.getParameter("quantidade") != null) {
			
			List<Carro> carros = CarroDAO.getCarroByQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			
			try {
				JSONArray jArray = new JSONArray();

				for (Carro carro : carros) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("id", carro.getId());
					jsonObject.put("nome", carro.getNome());
					jsonObject.put("marca", carro.getMarca());
					jsonObject.put("anoModelo", carro.getAnoModelo());
					jsonObject.put("anoFabricacao", carro.getAnoFabricao());
					jsonObject.put("dataVenda", carro.getDataVenda());

					jArray.put(jsonObject);
				}

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(jArray.toString());
				response.getWriter().flush();
			} catch (Exception e) {

			}
			return;
		}

		// GET ALL
		List<Carro> list = CarroDAO.getAllCarros();

		try {
			JSONArray jArray = new JSONArray();

			for (Carro carro : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", carro.getId());
				jsonObject.put("nome", carro.getNome());
				jsonObject.put("marca", carro.getMarca());
				jsonObject.put("anoModelo", carro.getAnoModelo());
				jsonObject.put("anoFabricacao", carro.getAnoFabricao());
				jsonObject.put("dataVenda", carro.getDataVenda());

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

		Carro carro = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			carro = CarroDAO.addCarro(jsonObject.getString("nome"), jsonObject.getString("marca"),
					jsonObject.getString("anoModelo"), jsonObject.getString("anoFabricacao"),
					jsonObject.getString("dataVenda"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", carro.getId());
			jsonObject.put("nome", carro.getNome());
			jsonObject.put("marca", carro.getMarca());
			jsonObject.put("anoModelo", carro.getAnoModelo());
			jsonObject.put("anoFabricacao", carro.getAnoFabricao());
			jsonObject.put("dataVenda", carro.getDataVenda());

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

				Carro carro = null;
				JSONObject jsonObject = null;

				try {
					// Request
					jsonObject = new JSONObject(jb.toString());
					carro = CarroDAO.updateCarro(Integer.parseInt(params[1]), jsonObject.getString("nome"),
							jsonObject.getString("marca"), jsonObject.getString("anoModelo"),
							jsonObject.getString("anoFabricacao"), jsonObject.getString("dataVenda"));

					// Response
					jsonObject.put("id", carro.getId());
					jsonObject.put("nome", carro.getNome());
					jsonObject.put("marca", carro.getMarca());
					jsonObject.put("anoModelo", carro.getAnoModelo());
					jsonObject.put("anoFabricacao", carro.getAnoFabricao());
					jsonObject.put("dataVenda", carro.getDataVenda());

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
