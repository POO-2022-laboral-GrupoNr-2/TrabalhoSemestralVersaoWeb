package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	/** Modulo de conexao **/
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/rufrago?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String senha = "";

	/* Metodo de conexao */
	private Connection conectar() {
		Connection conexao = null;
		try {

			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, senha);
			return conexao;

		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}

	public void testarConexao() {

		try {
			Connection con = conectar();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD CREAT */

	public void gravarReserva(Cliente c) {

		Connection conexao = null; // A conexao e a que nos permite obter a conexao com a base de dados
		PreparedStatement ps = null; // O PreparedStatement permite com que possamos fazeer algumas manipulacoes nas
										// tabelas da base de dados

		String sql = "insert into clientes(nome,nacionalidade,telefone,email,genero,checkin,nrquarto, consumo, total, checkout,status)"
				+ "value(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			conexao = conectar();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getNacionalidade());
			ps.setString(3, c.getContacto());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getGenero());
			ps.setString(6, c.getDataCheckin());
			ps.setInt(7, c.getNrQuarto());
			ps.setDouble(8, c.getConsumo());
			ps.setDouble(9, c.getTotal());
			ps.setString(10, c.getDataCheckout());
			ps.setString(11, "reserva");

			ps.execute();
			conexao.close();
		} catch (SQLException e) {

			System.out.println(e);

		}
	}

	public void mudarStatus(int id) {
		String sql = "update quartos set status='Reservado' where quartos_id = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao tentar mudar status" + e);

		}

	}

	public ArrayList<Quarto> resgatarQuarto() {
		ArrayList<Quarto> quarto = null;
		String sql = "select * from quartos";
		Connection conexao = null;
		PreparedStatement ps = null;
		try {
			conexao = conectar();
			ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {

				quarto = new ArrayList<>();
				while (rs.next()) {
					Quarto q = new Quarto();
					q.setNumero(rs.getInt(1));
					q.setTipo(rs.getString(2));
					q.setDescricao(rs.getString(3));
					q.setPreco(rs.getDouble(4));
					q.setStatus(rs.getString(5));

					quarto.add(q);

				}
				conexao.close();
			}
		} catch (SQLException e) {

			System.out.println("Erro ao Listar Quarto" + e);

		}

		return quarto;
	}

	// metodo com base de dado real
	// IDCELULARCHECKINCHECKOUTCONSUMOEMAILEndereçoGENERONACIONALIDADENOMENrBIQUARTOVALOR
	public void salvarReserva(Cliente c) {

		Connection conexao = null; // A conexao e a que nos permite obter a conexao com a base de dados
		PreparedStatement ps = null; // O PreparedStatement permite com que possamos fazeer algumas manipulacoes nas
										// tabelas da base de dados

		String sql = "insert into reservas(CELULAR,CHECKIN,CHECKOUT,CONSUMO,EMAIL,GENERO,NACIONALIDADE,NOME,NrBI,QUARTO,VALOR)"
				+ "value(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			conexao = conectar();
			ps = conexao.prepareStatement(sql);
			ps.setString(8, c.getNome());
			ps.setInt(10, c.getNrQuarto());
			ps.setString(1, c.getContacto());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getGenero());
			ps.setString(2, c.getDataCheckin());
			ps.setString(7, c.getNacionalidade());
			ps.setString(9, c.getNumeroDeBI());
			ps.setDouble(4, c.getConsumo());
			ps.setDouble(11, c.getTotal());
			ps.setString(3, c.getDataCheckout());
			// ps.setInt(12, c.getId());

			ps.execute();
			conexao.close();
		} catch (SQLException e) {

			System.out.println(e);

		}
	}

	public ArrayList<Integer> pegarIds() {

		String sql = "select * from reservas";
		ArrayList<Integer> ids = new ArrayList<>();
		;

		try {

			Connection conexao = conectar();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ids.add(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return ids;

	}

	public int gerarId(ArrayList<Integer> ids) {
		int id;
		int aleatoro = (int) (1 + Math.random() * (100 - 1));

		int cont = 0;

		for (int i = 0; i < ids.size(); i++) {

			if (aleatoro == ids.get(i)) {
				cont++;

			}

		}

		if (cont > 0) {
			return gerarId(ids);
		} else {
			id = aleatoro;
			return id;
		}

	}

}
