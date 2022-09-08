package thebrains.pim;

import thebrains.pim.controller.*;

public class ApplicationMain {
	
	public static void main(String[] args) {	// Application의 시작점
		new MemberController().dispatch();
	}

}
