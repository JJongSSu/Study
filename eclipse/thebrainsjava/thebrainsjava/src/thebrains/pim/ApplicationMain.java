package thebrains.pim;

import thebrains.pim.controller.*; // controller 패키지에 포함된 모든 클래스, .. import함 

public class ApplicationMain {

	public static void main(String[] args) { // Application의 시작점
		new MemberController().dispatch();
		
	}

}
