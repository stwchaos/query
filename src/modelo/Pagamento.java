package modelo;

import java.time.LocalDate;

public class Pagamento {

	private Integer idPagamento;
	private String formaPagamento;
	private LocalDate data_Pagamento;
	
	public Integer getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public LocalDate getData_Pagamento() {
		return data_Pagamento;
	}
	public void setData_Pagamento(LocalDate data_Pagamento) {
		this.data_Pagamento = data_Pagamento;
	}


}
