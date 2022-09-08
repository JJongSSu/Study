package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TeamProjectMain {
    public static int s = 1;
    static int p = 2;
    static int q = 3;

    public void main(String[] args) throws SQLException{

        Scanner scanner = new Scanner(System.in);

        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/iphones_datebase";
                
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement(); 

        System.out.println("원하시는 항목을 선택하세요 : 통계(s), 설문(p), 종료(q)");
        System.out.println("-------------------------------------------");
        int answer = Integer.parseInt(scanner.next());

        if (answer == s){
            TeamProjectStatistic statistic = new TeamProjectStatistic(stmt);
            String str = statistic.StatisticFunction();
        }
        else if (answer == p){
            TeamProjectPoll poll = new TeamProjectPoll(stmt);
            String str = poll.PollFunction();
        }
        else if (answer == q){
            System.out.println("감사합니다. 시스템을 종료합니다.");
            return;
        }
        else{
            System.out.println("잘못 입력하셨습니다.");
        }
        
    }
}
