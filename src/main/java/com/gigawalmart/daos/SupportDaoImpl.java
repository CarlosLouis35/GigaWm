package com.gigawalmart.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gigawalmart.models.Support;

public class SupportDaoImpl implements SupportDao {
	private Connection connection;

	public SupportDaoImpl(Connection connection) {

		this.connection = connection;
	}

	@Override
	public void addSupportTicket(Support support) {
		try (PreparedStatement statement = connection.prepareStatement(
				"insert into support (tech_reftag, tech_name, customer_name, support_desc, supportprice, supportdate ) values (?, ?, ?, ?, ?, current_timestamp)")) {
			statement.setString(1, support.getReftag());
			statement.setString(2, support.getTechname());
			statement.setString(3, support.getCustomername());
			statement.setString(4, support.getSupportdesc());
			statement.setFloat(5, support.getSupportprice());
			statement.setString(6,support.getDatetime());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void updateSupportTicket(Support support) {
		try (PreparedStatement statement = connection.prepareStatement(
				"update support set tech_reftag = ? , tech_name = ?, customer_name = ?, support_desc = ?, supportprice = ?")) {
			statement.setString(1, support.getReftag());
			statement.setString(2, support.getTechname());
			statement.setString(3, support.getCustomername());
			statement.setString(4, support.getSupportdesc());
			statement.setFloat(5, support.getSupportprice() > 0 ? support.getSupportprice() : null);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void deleteSupportTicket(int s_id) {
		try (PreparedStatement statement = connection.prepareStatement("delete from support where support_id=?")) {
			statement.setInt(1, s_id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Support getSupportTicketById(int s_id) {
		Support support = null;

		try (PreparedStatement statement = connection.prepareStatement("select * from support where support_id = ?")) {
			statement.setInt(1, s_id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {

					String reftag = rs.getString("tech_reftag");
					String techname = rs.getString("tech_name");
					String customername = rs.getString("customer_name");
					String suportdesc = rs.getString("support_desc");
					Float supportprice = rs.getFloat("supportprice");
					String supportdate = rs.getString("supportdate");

					support = new Support(s_id, reftag, techname, customername, suportdesc, supportprice, supportdate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return support;
	}

	public List<Support> getSupportRegistry() {
		List<Support> supportreg = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement("select * from support")) {

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					int s_id = rs.getInt("support_id");
					String reftag = rs.getString("tech_reftag");
					String techname = rs.getString("tech_name");
					String customername = rs.getString("customer_name");
					String suportdesc = rs.getString("support_desc");
					Float supportprice = rs.getFloat("supportprice");
					String supportdate = rs.getString("supportdate");

					Support support = new Support(s_id, reftag, techname, customername, suportdesc, supportprice,
							supportdate);

					supportreg.add(support);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supportreg;
	}
}
