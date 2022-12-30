<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<!-- 자바스크립트 파일 연결 -->
<script src="./js/pwdCheck.js"></script> <!-- ./ webbapp를 의미(현재 디렉토리) -->
<script src="./js/change_email.js"></script>
<script src="./js/juminCheck.js"></script>
<script src="./js/idCheck.js"></script>

<!-- CSS 적용 -->
<style>
   .title { margin:40px 30px 30px 30px; }
   .container { width:900px; }
   .right { float:right; }
   .red { color: red; }
   tbody.tbody>tr { display:table; width:900px; }
   tbody.tbody>tr>td:nth-child(1) {
      width:16%; vertical-align:middle;
      display:table-cell;
      text-align:center;
   }
   tbody.tbody>tr>td:nth-child(2) { width:100%}
   #detailAddress::placeholder { color:blue; }
</style>
</head>
<body>
   <form name="memberForm" method="POST" action="member_control.jsp">
      <input type="hidden" name="action" value="insert"/>
      <div align="center">
         <h1 class="title">회원가입</h1>
         <div class="container">
            <div class="right"><span class="red">*</span>필수입력항목</div>
            <table border="2">
               <thead>
                  <tr>
                     <th colspan="2" border="0" bgcolor="orange">회원 기본 정보</th>
                  </tr>
               </thead>
               <tbody class="tbody">
                  <tr>
                     <td>아이디<span class="red">*</span></td>
                     <td>
                        <input type="text" name="mem_id"
                               placeholder="6자 이상의 영문자 숫자"
                               required autofocus />
                        <input type="button" value="ID중복확인" onclick="idCheck(mem_id.value)"/>    
                     </td>
                  </tr>
                  <tr>                     
                     <td>비밀번호<span class="red">*</span></td>
                     <td>
                        <input type="password" name="mem_passwd" id="pwd1"
                               maxlength="12" minlength="8"
                               required />
                        <span>8~12자리의 영문 대소문자와 숫자, 특수문자만 입력</span>       
                     </td>
                  </tr>
                  <tr>                     
                     <td>비밀번호확인<span class="red">*</span></td>
                     <td>
                        <input type="password" name="mem_repasswd" id="pwd2"
                               maxlength="12" minlength="8"
                               required onchange="pwdCheck();"/>&nbsp;<b><span id="same" style="font-size: 14px;"></span></b>                           
                     </td>
                  </tr>
                  <tr>
                     <td>이름<span class="red">*</span></td>
                     <td>
                        <input type="text" name="mem_name" required/>
                     </td>
                  </tr>
                  <tr>
                     <td>닉네임<span class="red">*</span></td>
                     <td>
                        <input type="text" name="mem_nickname" required/>
                     </td>
                  </tr>
                  <tr>
                     <td>이메일<span class="red">*</span></td>
                     <td>
                        <input type="text" name="mem_email_id" 
                               id="email_id"/>@
                        <input type="text" name="mem_email_domain"
                               id="email_add"/> 
                        <select name="email_sel" id="email_sel"
                                style="font-size:16px; height:30px;"
                                onchange="change_email();">
                           <option value="">직접선택</option> 
                           <option value="naver.com">naver.com</option>  
                           <option value="hanmail.net">hanmail.net</option>  
                           <option value="gmail.com">gmail.com</option>  
                           <option value="nate.com">nate.com</option> 
                           <option value="kakao.com">kakao.com</option> 
                           <option value="korea.com">korea.com</option>
                           <option value="dreamwiz.com">dreamwiz.com</option>  
                        </select>                      
                     </td>
                  </tr>
                  <tr>
                     <td>주민번호<span class="red">*</span></td>
                     <td>
                        <input type="text" name="mem_num1" maxlength="6"
                               onkeyup="if(this.value.length == 6) memberForm.mem_num2.focus();"/>-
                        <input type="text" name="mem_num2" maxlength="7"/>
                        <input type="button" value="주민번호 정상 유무 체크"
                               onclick="juminCheck(mem_num1.value, mem_num2.value)"/>
                     </td>
                  </tr>
                  <tr>
                     <td>휴대폰번호<span class="red">*</span></td>
                     <td>
                        <input type="tel" name="mem_phone" maxlength="13"
                               pattern="010-[0-9]{4}-[0-9]{4}" required />
                     </td>
                  </tr>
                  <tr>
                     <td>성별</td>
                     <td>
                        <input type="radio" name="mem_gender" 
                               value="남성" checked/>남성&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="mem_gender" 
                               value="여성"/>여성       
                     </td>
                  </tr>
                  <tr>
                     <td>생년월일<span class="red">*</span></td>
                     <td>
                        <script>
                           var today = new Date();
                           var toyear = parseInt(today.getFullYear()); //2022
                           var start = toyear - 15;
                           var end = toyear - 80;
                           
                           document.write("<select name=mem_Birthday1>");
                           for(i=start; i>=end; i--) {
                              document.write("<option value='"+i+"'>"+i);
                           }
                           document.write("</select>년");
                           
                           //[해결 문제] 여러분이 월과 일 소스 코딩 해결요!!
                           document.write("<select name=mem_Birthday2>");
                           for(i=1; i<=12; i++) {
                              document.write("<option value='"+i+"'>"+i);
                           }
                           document.write("</select>월");
                           
                           document.write("<select name=mem_Birthday3>");
                           for(i=1; i<=31; i++) {
                              document.write("<option value='"+i+"'>"+i);
                           }
                           document.write("</select>일");                           
                        </script>
                     </td>
                  </tr>
                  <tr>
                     <td>직업<span class="red">*</span></td>
                     <td>
                        <select name="mem_job">
                           <option value="">직업선택</option>
                           <option value="웹프로그래머">웹프로그래머</option>
                           <option value="회사원">회사원</option>
                           <option value="공무원">공무원</option>
                           <option value="학생">학생</option>
                           <option value="기타">기타</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <td>주소<span class="red">*</span></td>
                     <td>
                        <div class="inputArea">
                        <p>
                           <input type="text" name="zipCode" id="postcode"
                                  placeholder="우편번호"/>
                           <input type="button" onclick="execDaumPostcode()"
                                  value="우편번호 찾기"/>       
                        </p>
                        <p>
                           <input type="text" name="userAddr1" id="address"
                                  size="100" placeholder="주소"/>
                           <br>
                           <input type="text" name="userAddr3" id="extraAddress"
                                  size="48" 
                                  placeholder="참고항목(도로명인 경우: 지역 동이름과 아파트 이름)"/>
                           <input type="text" name="userAddr2" id="detailAddress"
                                  size="45"
                                  placeholder="상세주소(아파트 동호수 또는 빌딩이름 입력요!)"/>              
                        </p>                        
                     </td>
                  </tr>
                  <tr>
                     <td colspan="2">
                        <input type="submit" 
                           value="회원가입 등록"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="다시쓰기"/>   
                     </td>
                  </tr>
               </tbody>
            </table>
         </div>
      </div>
   </form>
</body>
</html>