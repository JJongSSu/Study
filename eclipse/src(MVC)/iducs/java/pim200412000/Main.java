package iducs.java.pim200412000;

import iducs.java.pim200412000.controller.MemberController;

public class Main {

    public static void main(String[] args) {
        MemberController memberController = new MemberController();
        memberController.dispatch();
    }
}
