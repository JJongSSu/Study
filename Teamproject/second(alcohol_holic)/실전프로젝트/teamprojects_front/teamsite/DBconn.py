import cx_Oracle
import os

# 한글지원방법
os.putenv('NLS_LANG', '.UTF8')


# 함수 정의
def connect():
    # 라이브러리 연결
    cx_Oracle.init_oracle_client(lib_dir=r"C:\oracle\instantclient_21_8")

    con_ip = 'project-db-stu.ddns.net:1524/xe'
    con_id = 'alchol'
    con_pw = 'holic'

    # 연결에 필요한 기본 정보(유저, 비밀번호, 데이터베이스 서버 주소)
    connection = cx_Oracle.connect(con_id, con_pw, con_ip)
    cursor = connection.cursor()
    cursor.execute("""
        select *
        from 전통주DB
        """)

    for list in cursor:
        print(list)

    cursor.close()
    connection.close()

# 함수 실행
connect()