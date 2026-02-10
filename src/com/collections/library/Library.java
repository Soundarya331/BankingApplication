package com.collections.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Member> memberList;

  

    public Library() {
        this.memberList = new ArrayList<>();
    }



	public Member addMember(Member member) {

        String sql = "insert into member(name, number, email) VALUES (?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, member.getName());
            ps.setLong(2, member.getNumber());
            ps.setString(3, member.getEmail());

            ps.execute();
            memberList.add(member);

            System.out.println("Member added successfully");

        } catch (SQLException e) {
            System.err.println("Failed to add member");
            System.err.println(e.getMessage());
        }

        return member;
    }
	
	public void displayMembers() {
		System.out.println("List of members");
		String sql ="select * from member";
		 try (Connection connection = DBUtil.getConnection();
				 Statement st = connection.createStatement();
		 			ResultSet result = st.executeQuery(sql)) {
	
				 
			 		System.out.println("Name        Number          Email ");
			 		while(result.next()) {
			 		String name = result.getString("name");
			 		long number = result.getLong("number");
		 		    String email = result.getString("email");
		 		    
			 		System.out.println(name + "\t" + number +"\t"+ email );
			 		}
					 
		 }
				 catch (SQLException e) {
			            System.err.println("Failed to fetch member");
			            
			        }
		
	}
}
