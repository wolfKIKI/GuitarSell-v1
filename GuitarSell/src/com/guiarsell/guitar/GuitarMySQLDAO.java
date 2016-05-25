package com.guiarsell.guitar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.guiarsell.util.DB;

public class GuitarMySQLDAO implements GuitarDAO {
	
	public List<Guitar> getGuitars(){
		Connection conn = DB.getConn();
		Statement stmt = DB.getStatement(conn);
		String sql = "select * from guitar";
		ResultSet rs = DB.getResultSet(stmt, sql);
		List<Guitar> products = new ArrayList<Guitar>();
		try {
			while (rs.next()) {
				Guitar g = getGuitarFromRs(rs);
				products.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(stmt);
			DB.close(rs);
			DB.close(conn);
		}

		return products;
	}
	private Guitar getGuitarFromRs(ResultSet rs) {
		Guitar g = null;
		try {
			g = new Guitar();
			g.setSerialNumber(rs.getInt("serialNumber"));
			g.setBuilder(rs.getString("builder"));
			g.setPrice(rs.getDouble("price"));
			g.setModel(rs.getString("model"));
			g.setType(rs.getString("type"));;
			g.setBackWood(rs.getString("backWood"));;
			g.setTopWood(rs.getString("topWood"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
}
