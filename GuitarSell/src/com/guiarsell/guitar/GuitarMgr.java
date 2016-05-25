package com.guiarsell.guitar;

import java.util.List;




public class GuitarMgr {
	private static GuitarMgr mgr = null;
	
	private static GuitarDAO dao = new GuitarMySQLDAO(); 
	
	private GuitarMgr() {}
	
	public static GuitarMgr getInstance() {
		if(mgr == null) {
			mgr = new GuitarMgr();
		}
		return mgr;
	}
	public List<Guitar> getGuitars() {
		return dao.getGuitars();
	}

}
