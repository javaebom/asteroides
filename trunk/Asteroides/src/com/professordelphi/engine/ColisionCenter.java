package com.professordelphi.engine;

import java.util.ArrayList;

public class ColisionCenter {
	private ArrayList<Colidivel> lista;
	
	public ColisionCenter() {
		
	}
	
	public void notifica(){
		
	}
	
	public void verifica(){
		for (int i = 0; i < getLista().size(); i++) {
			for (int j = 0; j < getLista().size(); j++) {
				
			}
		}
	}
	
	public ArrayList<Colidivel> getLista(){
		if (lista==null) {
			lista = new ArrayList<Colidivel>();
		}
		return lista;
	}
	
	public static void main(String[] args) {
		int lista[] = new int[10];
		for (int i = 0; i < lista.length; i = i + 1) {
			lista[i]  = i * 2 ;
		}
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}

}
