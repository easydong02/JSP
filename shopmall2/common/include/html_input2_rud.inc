<!--  // file = "../../common/include/html_input2_rud.inc" -->

  <tr>
   <th><span class="mmsg_red">*</span>비밀번호</th>
   <td><input type="password" name="cust_pw" size="11" maxlength="10" readonly>
       <span class="msg_blue">(영,숫자 10자리이내)</span></td>
  </tr>
  <tr>
   <th><span class="mmsg_red">*</span> 이 &nbsp; 름 &nbsp; &nbsp;</th>
   <td><input type="text" name="cust_name" size="15" maxlength="15" readonly></td>
  </tr>
  <tr>
   <th><span class="mmsg_red">*</span>전화번호</th>
   <td><select name="tel_no_gubun" disabled>
               <option selected value="">서비스 구분</option>
               <option value="010">010</option>
               <option value="011">011</option>
               <option value="016">016</option>
               <option value="017">017</option>
               <option value="018">018</option>
               <option value="019">019</option>
       </select>-
       <input type="text" name="tel_no_guk" size="5" maxlength="4" readonly>-
       <input type="text" name="tel_no_seq" size="5" maxlength="4" readonly></td>
  </tr>
  <tr>
   <th><span class="mmsg_red">*</span> 주 &nbsp; 소 &nbsp; &nbsp;</th>
   <td><input type="text" name="cust_addr" size="60" maxlength="60" readonly></td>
  </tr>
  <tr>
   <th>성 &nbsp; 별 &nbsp; </th>
   <td><input type="radio" name="cust_gender" value="M" disabled>남자 &nbsp
       <input type="radio" name="cust_gender" value="F" disabled>여자</td>
  </tr>
  <tr>
   <th>이 메 일</th>
   <td><input type="text" name="cust_email_1" size="15" maxlength="10" readonly>@
       <input type="text" name="cust_email_2" size="20" maxlength="20" readonly></td>
  </tr>