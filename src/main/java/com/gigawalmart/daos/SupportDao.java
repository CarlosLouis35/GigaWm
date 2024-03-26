package com.gigawalmart.daos;

import java.util.List;

import com.gigawalmart.models.Support;

public interface SupportDao {

	void addSupportTicket(Support support);
	
	void updateSupportTicket(Support support);
	
	void deleteSupportTicket(int s_id);
	
	Support getSupportTicketById(int s_id);
	
	List<Support> getSupportRegistry();

	
	
	
}
