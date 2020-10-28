package main;

import java.util.ArrayList;

public class SigninDao {
	private ArrayList<Signin> signins;

	public SigninDao() {
		signins= new ArrayList<>();
	}

	public void insertSignin(Signin s) {
		signins.add(s);
	}
}
