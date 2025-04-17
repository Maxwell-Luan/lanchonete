package com.lanchonete.megalanches.entities.enums;

public enum StatusPedido {
	
	PAGO(1),
	PENDENTE(2),
	CANCELADO(3);
	
	private int codigo;

	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	public static StatusPedido valueOf(int codigo) {
		for(StatusPedido value : StatusPedido.values()) {
			if(value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
