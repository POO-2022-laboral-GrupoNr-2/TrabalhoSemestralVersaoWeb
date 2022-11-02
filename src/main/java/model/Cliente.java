package model;

import java.sql.Date;

public class Cliente {
	private String nome, apelido, genero, email, numeroDeBI, contacto;
	private String nacionalidade, dataCheckout, dataCheckin, tipoQuarto;
	private Date dataEntradaPrevista ;
	private Double preco;
	private Double consumo = 0.0;
	private Double total = 0.0;
	private Integer id;
	private Integer nrQuarto;

	public Cliente(String nome, String apelido, String genero, String email, String numeroDeBI, String contacto,
			String nacionalidade, String dataCheckout, String dataCheckin, String tipoQuarto, Double preco,
			Double consumo, Double total, Integer id, Integer nrQuarto) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.genero = genero;
		this.email = email;
		this.numeroDeBI = numeroDeBI;
		this.contacto = contacto;
		this.nacionalidade = nacionalidade;
		this.dataCheckout = dataCheckout;
		this.dataCheckin = dataCheckin;
		this.tipoQuarto = tipoQuarto;
		this.preco = preco;
		this.consumo = consumo;
		this.total = total;
		this.id = id;
		this.nrQuarto = nrQuarto;
	}

	public Date getDataEntradaPrevista() {
		return dataEntradaPrevista;
	}

	public void setDataEntradaPrevista(Date dataEntradaPrevista) {
		this.dataEntradaPrevista = dataEntradaPrevista;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroDeBI() {
		return numeroDeBI;
	}

	public void setNumeroDeBI(String numeroDeBI) {
		this.numeroDeBI = numeroDeBI;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(String dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public String getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(String dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNrQuarto() {
		return nrQuarto;
	}

	public void setNrQuarto(Integer nrQuarto) {
		this.nrQuarto = nrQuarto;
	}

}
