<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<tr>
<th>비밀번호</th>
<td><input type="password" name="cust_pw" size="11" maxlength="11"></td>
</tr>

<tr>
<th>이름</th>
<td><input type="text" name="cust_name" size="15" maxlength="15"></td>
</tr>

<tr>
<th>전화번호</th>
<td><select name="tel_no_gubun" >
	<option selected value="">서비스 구분</option>
	<option value="010">010</option>
	<option value="011">011</option>
	<option value="016">016</option>
	<option value="017">017</option>
	<option value="019">019</option>

</select>
	<input type="text" name = "tel_no_guk" size="5" maxlength="4">
	<input type="text" name = "tel_no_seq" size="5" maxlength="4">
</td>
</tr>

<tr>
<th>주소</th>
<td><input type="text" name="cust_addr" size="60" maxlength="60"></td>
</tr>

<tr>
<th>성별</th>
<td><input type="radio" name="cust_gender" value="M">남자 &nbsp;&nbsp; 
	<input type="radio" name="cust_gender" value="F">여자
</td>
</tr>

<tr>
<th>이메일</th>
<td><input type="text" name="cust_email_1" size ="15" maxlength="15">@
	<input type="text" name="cust_email_2" size ="20" maxlength="20">
</td>
</tr>

