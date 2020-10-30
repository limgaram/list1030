package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberDao {
	private ArrayList<Member> members;
	private int no = 1;

	public MemberDao() {
		members = new ArrayList<>();
	}

	public void insertMember(Member m) {
		m.setId(no);
		no++;
		m.setRegDate(getCurrentDate());

		members.add(m);
	}

	private static String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Date time = new Date();
		String time1 = format1.format(time);

		return time1;
	}

	public Member getMemberByloginId(String mtargetId) {
		for (int i = 0; i < members.size(); i++) {
			int id = members.get(i).getId();
			String str = members.getLoginId();
			if (str.equals(mtargetId)) {
				return members.get(id);
			}
		}

		return null;
	}

	public Member getMemberByloginPw(String mtargetPw) {

	}
}
