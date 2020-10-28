package main;

import java.util.ArrayList;

public class MemberDao {
	private ArrayList<Member> members;
	
	public MemberDao() {
		members= new ArrayList<>();
	}
	
	public void insertMember(Member m) {
		members.add(m);
	}
	
	public Member getMemberById(String mtargetId) {
	
	}
	public Member getMemberBypassword(String mtargetpassword) {
		
	}
	
}
