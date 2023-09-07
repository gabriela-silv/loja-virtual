package entities;

public class Produto {
	String nome;
	int codigo;
	int quantidade_estoque;

	public Produto(String nome, int codigo, int quantidade_estoque) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.quantidade_estoque = quantidade_estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	@Override
	public String toString() {
		return nome + " (cód: " + codigo + " | estoque:" + quantidade_estoque + ")";
	}
	
}
